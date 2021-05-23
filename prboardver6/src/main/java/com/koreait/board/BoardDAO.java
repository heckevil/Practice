package com.koreait.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.koreait.VO.BoardVO;
import com.koreait.utils.DbUtils;

public class BoardDAO {

	public static List<BoardVO> selboardllist(BoardVO param) {
		List<BoardVO> list = new ArrayList();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		String sql = "SELECT A.iboard, A.title, A.regdt ,A.iuser, B.nm from t_board A "
				+ "inner JOIN t_user B "
				+ "ON A.iuser = B.iuser "
				+ " where A.title like = ?"
				+ "order by iboard desc "
				+ " limit ?, ?";

		try {
			con = DbUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, "%" + param.getSearch() + "%");
			ps.setInt(2, param.getSidx());
			ps.setInt(3, param.getPage());
			rs = ps.executeQuery();

			while (rs.next()) {
				int iboard = rs.getInt("iboard");
				String nm = rs.getString("nm");
				String title = rs.getString("title");
				String regdt = rs.getString("regdt");
				int iuser = rs.getInt("iuser");
				
				BoardVO vo = new BoardVO();
				vo.setNm(nm);
				vo.setIboard(iboard);
				vo.setTitle(title);
				vo.setRegdt(regdt);
				vo.setIuser(iuser);

				list.add(vo);

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DbUtils.close(con, ps, rs);
		}
		return list;
	}
	public static int writeboard(BoardVO vo) {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "INSERT INTO t_board (ctnt,title,iuser) values (?,?,?) ";
		try {
			con = DbUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, vo.getCtnt());
			ps.setString(2, vo.getTitle());
			ps.setInt(3, vo.getIuser());

			return ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DbUtils.close(con, ps);
		}
		return 0;

	}

	public static BoardVO selboard(int no) {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		String sql = "SELECT A.iboard,A.regdt,A.title,A.ctnt,B.nm,B.iuser from t_board A " + "LEFT JOIN t_user B "
				+ "ON A.iuser=B.iuser WHERE iboard = ? ";
		try {
			con = DbUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, no);
			rs = ps.executeQuery();

			if (rs.next()) {

				String title = rs.getString("title");
				int iboard = rs.getInt("iboard");
				String nm = rs.getString("nm");
				String regdt = rs.getString("regdt");
				String ctnt = rs.getString("ctnt");
				int iuser = rs.getInt("iuser");

				BoardVO vo = new BoardVO();
				vo.setIboard(iboard);
				vo.setRegdt(regdt);
				vo.setNm(nm);
				vo.setTitle(title);
				vo.setCtnt(ctnt);
				vo.setIuser(iuser);

				return vo;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DbUtils.close(con, ps, rs);
		}

		return null;
	}

	public static int modboard(BoardVO vo) {
		Connection con = null;
		PreparedStatement ps = null;

		String sql = "update t_board set ctnt= ?, title= ? where iboard= ? and iuser = ?";
		try {
			con = DbUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, vo.getCtnt());
			ps.setString(2, vo.getTitle());
			ps.setInt(3, vo.getIboard());
			ps.setInt(4, vo.getIuser());

			return ps.executeUpdate();
		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			DbUtils.close(con, ps);
		}
		return 0;
	}

	public static int delboard(BoardVO param) {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "delete from t_board where iboard = ? and iuser = ?";
		try {
			con = DbUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, param.getIboard());
			ps.setInt(2, param.getIuser());
	
			
			return ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DbUtils.close(con, ps);
		}
		return 0;

	}
	public static Object getAllpage(BoardVO param) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = "select ceil( count(*)/ ? ) as cnt from iboard "
				+ " where title like = ? ";
		int result = 0;
		
		 try {
			con = DbUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, param.getPage());
			ps.setString(2, "%" + param.getSearch() + "%");
			rs = ps.executeQuery();
			
			if(rs.next()) {
				result = rs.getInt("cnt");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {DbUtils.close(con, ps, rs);}
		return result;
	}

}