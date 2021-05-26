package com.koreait.cmt;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.koreait.utils.DbUtils;
import com.koreait.vo.BoardCmtDomain;
import com.koreait.vo.BoardCmtEntity;

public class BoardCmtDAO {

	public static int insBoardCmt(BoardCmtEntity param) {
		int result = 0;

		Connection con = null;
		PreparedStatement ps = null;

		String sql = " INSERT INTO t_board_cmt " + "(iboard,iuser,cmt) " + " VALUES " + " (?,?,?) ";

		try {
			con = DbUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, param.getIboard());
			ps.setInt(2, param.getIuser());
			ps.setString(3, param.getCmt());

			result = ps.executeUpdate();

			System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbUtils.close(con, ps);
		}

		return result;
	}

	public static List<BoardCmtDomain> selBoardCmtList(BoardCmtEntity param) {
		List<BoardCmtDomain> list = new ArrayList();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		String sql = "select A.icmt, A.cmt, A.regdt, B.iuser, b.nm as writerNm" + " from t_board_cmt A "
				+ " inner join t_user b " + " on a.iuser=b.iuser " + " where A.iboard = ? ";

		try {
			con = DbUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, param.getIboard());
			rs = ps.executeQuery();

			while (rs.next()) {
				BoardCmtDomain vo = new BoardCmtDomain();
				list.add(vo);
				vo.setCmt(rs.getString("cmt"));
				vo.setIcmt(rs.getInt("icmt"));
				vo.setRegdt(rs.getString("Regdt"));
				vo.setIuser(rs.getInt("iuser"));
				vo.setWriterNm(rs.getString("writerNm"));

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	public static int delBoardCmt(BoardCmtEntity param) {

		Connection con = null;
		PreparedStatement ps = null;

		String sql = "delete from t_board_cmt where icmt = ? and iuser = ? ";

		try {
			con = DbUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, param.getIcmt());
			ps.setInt(2, param.getIuser());

			return ps.executeUpdate();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {DbUtils.close(con , ps);} 
		return 0;
	}
}
