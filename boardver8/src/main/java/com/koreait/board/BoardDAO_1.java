package com.koreait.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.koreait.utils.DbUtils;
import com.koreait.vo.BoardDomain;

public class BoardDAO {
	public static List<BoardDomain> selBoardList(BoardDTO param) {
		List<BoardDomain> list = new ArrayList();

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		String sql = "SELECT A.iboard,A.iuser, A.title, A.regdt , B.nm as WriterNm from t_board A "
				+ "left JOIN t_user B " + "ON A.iuser = B.iuser ";

		switch (param.getSearchType()) {
		case 1:// 제목+내용
			sql += String.format("where A.title like '%%s%' or A.ctnt like '%%%s%%'", param.getSearchText(),
					param.getSearchText());
			break;
		case 2:// 제목
			sql += String.format("where A.title like '%%%s%%'", param.getSearchText());
			break;
		case 3:// 내용
			sql += String.format("where A.ctnt like '%%%s%%'", param.getSearchText());
			break;
		case 4:// 글쓴이
			sql += String.format("where B.nm like '%%%s%%'", param.getSearchText());
			break;

		}
		sql += " order by iboard desc " + " limit ? , ? ";

		try {
			con = DbUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, param.getStartIdx());
			ps.setInt(2, param.getRecordCnt());
			rs = ps.executeQuery();

			while (rs.next()) {
				int iboard = rs.getInt("iboard");
				String nm = rs.getString("WriterNm");
				String title = rs.getString("title");
				String regdt = rs.getString("regdt");
				int iuser = rs.getInt("iuser");

				BoardDomain vo = new BoardDomain();
				vo.setWriterNm(nm);
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

	public static int setPagingCnt(BoardDTO param) {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		StringBuilder sb = new StringBuilder();
		sb.append("SELECT CEIL( COUNT(iboard)/ ? )as Cnt").append(" FROM t_board A ");

		if (param.getSearchType() > 0) {
			sb.append("where ");
		}

		switch (param.getSearchType()) {
		case 1:// 제목+내용
			sb.append("A.title like '%").append(param.getSearchText()).append("%' or a.ctnt like '%")
					.append(param.getSearchText()).append("%'");

			break;
		case 2:// 제목
			sb.append("A.title like '%").append(param.getSearchText()).append("%' ");

			break;
		case 3:// 내용
			sb.append("A.ctnt like '%").append(param.getSearchText()).append("%' ");
			break;
		case 4:// 글쓴이
			sb.append("B.nm like '%").append(param.getSearchText()).append("%' ");
			break;

		}

		int result = 0;
		try {
			con = DbUtils.getCon();
			ps = con.prepareStatement(sb.toString());
			ps.setInt(1, param.getRecordCnt());

			rs = ps.executeQuery();
			if (rs.next()) {
				// 첫번째 컬럼.
				result = rs.getInt("Cnt");

			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DbUtils.close(con, ps, rs);
		}
		return result;
	}

	public static BoardDomain selBoard(BoardDTO param) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		String sql = "SELECT A.iuser, A.title,A.ctnt, A.regdt , B.nm as WriterNm from t_board A "
				+ " left JOIN t_user B " + " ON A.iuser = B.iuser " + " where A.iboard = ? ";

		try {
			con = DbUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, param.getIboard());
			rs = ps.executeQuery();
			
			if(rs.next()) {
				int iuser = rs.getInt("iuser");
				int iboard = param.getIboard();
				String title = rs.getString("title");
				String ctnt = rs.getString("ctnt");
				String unm = rs.getString("WriterNm");
				String regdt = rs.getString("regdt");
				
				BoardDomain result = new BoardDomain();
				result.setCtnt(ctnt);
				result.setIboard(iboard);
				result.setIuser(iuser);
				result.setRegdt(regdt);
				result.setTitle(title);
				result.setWriterNm(unm);
				
				return result;
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
