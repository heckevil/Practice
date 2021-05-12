package com.koreait.board4.board;

import java.sql.*;
import java.util.*;

import javax.servlet.http.HttpServletRequest;

import com.koreait.board4.DbUtils;
import com.koreait.board4.user.BoardVO;

public class BoardDAO {
	public static int insBoard(BoardVO param) {
		Connection con = null;
		PreparedStatement ps = null;

		String sql = "insert into t_board " + " (title, ctnt , iuser) " + " values " + " (?,?,?) ";
		try {
			con = DbUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, param.getTitle());
			ps.setString(2, param.getCtnt());
			ps.setInt(3, param.getIuser());

			return ps.executeUpdate();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DbUtils.close(con, ps);
		}

		return 0;

	}

	public static List<BoardVO> selBoardList() {
		List<BoardVO> list = new ArrayList();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		String sql = " SELECT A.iboard, A.title, A.regdt, B.unm " + " FROM t_board A " + " LEFT JOIN t_user B "
				+ " ON A.iuser = B.iuser ";
		try {
			con = DbUtils.getCon();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				int iboard = rs.getInt("iboard");
				String title = rs.getString("title");
				String regdt = rs.getString("regdt");
				String unm = rs.getString("unm");

				BoardVO vo = new BoardVO();
				list.add(vo);
				vo.setIboard(iboard);
				vo.setTitle(title);
				vo.setRegdt(regdt);
				vo.setUnm(unm);

			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DbUtils.close(con, ps, rs);
		}
		return list;
	}

	public static BoardVO selBoard(int a) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select A.iboard, A.title, A.regdt,A.ctnt,B.iuser, B.unm " + " FROM t_board A "
				+ " LEFT JOIN t_user B " + " ON A.iuser = b.iuser " + " where iboard = ?";

		try {
			con = DbUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, a);
			rs = ps.executeQuery();

			if (rs.next()) {

				BoardVO vo = new BoardVO();
				vo.setIboard(rs.getInt("iboard"));
				vo.setCtnt(rs.getString("ctnt"));
				vo.setTitle(rs.getString("title"));
				vo.setUnm(rs.getString("unm"));
				vo.setRegdt(rs.getString("regdt"));
				vo.setIuser(rs.getInt("iuser"));

				System.out.println("iboard : " + rs.getInt("iboard"));
				return vo;
			}

		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			DbUtils.close(con, ps, rs);
		}

		return null;
	}

	public static int delboard(BoardVO vo) {
	
		Connection con = null;
		PreparedStatement ps = null;

		String sql = "delete from t_board where iboard = ? and iuser = ? ";
		try {
			con = DbUtils.getCon();
			ps = con.prepareStatement(sql);

			ps.setInt(1, vo.getIboard());
			ps.setInt(2, vo.getIuser());

			return ps.executeUpdate();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DbUtils.close(con, ps);
		}

		return 0;

	}

	public static int modboard(BoardVO vo) {
		
		Connection con = null;
		PreparedStatement ps = null;

		String sql = "update  t_board set title = ? , ctnt = ? where iboard = ? and iuser= ? ";
		try {
			con = DbUtils.getCon();
			ps = con.prepareStatement(sql);

			ps.setString(1, vo.getTitle());
			ps.setString(2, vo.getCtnt());
			ps.setInt(3, vo.getIboard());
			ps.setInt(4, vo.getIuser());

			return ps.executeUpdate();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DbUtils.close(con, ps);
		}

		return 0;
		
	}

}
