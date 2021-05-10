package com.koreait.board;

import java.sql.*;
import java.util.*;

public class BoardDAO {
	public static List<BoardVO> selboardList() {
		List<BoardVO> list = new ArrayList();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		String sql = "select iboard, title, regdt from t_board ";

		try {
			con = DbUtils.getCon();
			ps = con.prepareStatement(sql);

			rs = ps.executeQuery();

			while (rs.next()) {
				BoardVO vo = new BoardVO();
				list.add(vo);

				String title = rs.getString("title");
				int iboard = rs.getInt("iboard");
				String regdt = rs.getString("regdt");

				vo.setTitle(title);
				vo.setRegdt(regdt);
				vo.setIboard(iboard);

			}

		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			DbUtils.close(con, ps, rs);
		}
		return list;

	}

	public static int insertboard(BoardVO vo) {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = " insert into t_board " + " (title,ctnt) " + " values " + "(?,?) ";

		try {
			con = DbUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, vo.getTitle());
			ps.setString(2, vo.getCtnt());

			return ps.executeUpdate();

		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			DbUtils.close(con, ps);
		}

		return 0;
	};

	public static BoardVO selboard(int a) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select title, ctnt, regdt from t_board where iboard = ? ";
		try {
			con = DbUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, a);
			rs = ps.executeQuery();

			if (rs.next()) {
				BoardVO vo = new BoardVO();

				String title = rs.getString("title");
				String ctnt = rs.getString("ctnt");
				String regdt = rs.getString("regdt");

				vo.setCtnt(ctnt);
				vo.setTitle(title);
				vo.setIboard(a);
				vo.setRegdt(regdt);

				return vo;
			}

		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			DbUtils.close(con, ps, rs);
		}
		return null;

	};

	public static int delboard(int a) {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "delete from t_board where iboard = ? ";
		try {
			con = DbUtils.getCon();
			ps = con.prepareStatement(sql);

			ps.setInt(1, a);

			return ps.executeUpdate();
		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			DbUtils.close(con, ps);
		}
		return 0;
	};

	public static int updateboard(BoardVO vo) {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "update t_board set title = ?, ctnt = ? where iboard = ? ";

		try {
			con = DbUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, vo.getTitle());
			ps.setString(2, vo.getCtnt());
			ps.setInt(3, vo.getIboard());

			return ps.executeUpdate();

		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			DbUtils.close(con, ps);
		}
		return 0;
	};

}
