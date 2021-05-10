package com.koreait.board;

import java.sql.*;

import java.util.ArrayList;
import java.util.*;

public class BoardBAO {
	public static int insertBoard(BoardVO vo) {
		Connection con = null;
		PreparedStatement ps = null;

		String sql = "INSERT INTO t_board (title, ctnt) " + " VALUES (?, ?)";
		try {
			con = DbUtils.getCon();
			ps = con.prepareStatement(sql);

			ps.setString(1, vo.getTitle());
			ps.setString(2, vo.getCtnt());

			System.out.println(ps.toString());
			return ps.executeUpdate();
		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			DbUtils.close(con, ps);
		}
		return 0;
	}

	public static List<BoardVO> selboardList() {
		List<BoardVO> list = new ArrayList();

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		String sql = "SELECT iboard, title, regdt FROM t_board";

		try {
			con = DbUtils.getCon();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				BoardVO vo = new BoardVO();
				list.add(vo);

				int iboard = rs.getInt("iboard");
				String title = rs.getString("title");
				String regdt = rs.getString("regdt");

				vo.setIboard(iboard);
				vo.setRegdt(regdt);
				vo.setTitle(title);
			}
		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			DbUtils.close(con, ps, rs);
		}
		return list;

	}

	public static BoardVO selboard(int a) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		String sql = "select * from t_board where iboard = ? ";

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

				vo.setIboard(a);
				vo.setTitle(title);
				vo.setCtnt(ctnt);
				vo.setRegdt(regdt);

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
