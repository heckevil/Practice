package com.koreait.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.koreait.VO.BoardVO;
import com.koreait.utils.DbUtils;

public class BoardDAO {
	public static int getAllpage(BoardVO param) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		String sql = " select ceil(count(*) / ? ) as Cnt from t_board " + " where title like ? ";
		int result = 0;
		try {
			con = DbUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, param.getPage());
			ps.setString(2, "%" + param.getSearch() + "%");
			rs = ps.executeQuery();
			if (rs.next()) {
				result = rs.getInt("cnt");

			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DbUtils.close(con, ps, rs);
		}

		return result;
	}

	public static List<BoardVO> selboardlist(BoardVO param) {
		List<BoardVO> list = new ArrayList();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		String sql = " SELECT A.iboard ,A.title, A.iuser, A.regdt, B.nm " + " FROM t_board A " + " LEFT JOIN t_user B"
				+ " ON A.iuser = B.iuser " + " WHERE title LIKE ? " + " ORDER BY iboard DESC" + " LIMIT ?,? ";

		try {
			con = DbUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, "%" + param.getSearch() + "%");
			ps.setInt(2, param.getsIdx());
			ps.setInt(3, param.getPage());
			rs = ps.executeQuery();

			while (rs.next()) {
				BoardVO vo = new BoardVO();
				vo.setIboard(rs.getInt("iboard"));
				vo.setTitle(rs.getString("title"));
				vo.setNm(rs.getString("nm"));
				vo.setRegdt(rs.getString("regdt"));
				vo.setIuser(rs.getInt("iuser"));

				System.out.println("iboard : " + vo.getIboard());
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

	public static BoardVO selBoard(BoardVO param) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select A.iboard, A.title, A.regdt,A.ctnt,B.iuser, B.unm " + " FROM t_board A "
				+ " LEFT JOIN t_user B " + " ON A.iuser = b.iuser " + " where iboard = ?";

		try {
			con = DbUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, param.getIboard());
			rs = ps.executeQuery();

			if (rs.next()) {

				BoardVO vo = new BoardVO();
				vo.setIboard(rs.getInt("iboard"));
				vo.setCtnt(rs.getString("ctnt"));
				vo.setTitle(rs.getString("title"));
				vo.setNm(rs.getString("unm"));
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

}
