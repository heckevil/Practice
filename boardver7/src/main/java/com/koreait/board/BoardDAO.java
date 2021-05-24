package com.koreait.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.koreait.utils.DbUtils;
import com.koreait.vo.BoardDomain;

public class BoardDAO {
	public static List<BoardDomain> selBoardList() {
		List<BoardDomain> list = new ArrayList();

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		String sql = "SELECT A.iboard,A.iuser, A.title, A.regdt , B.nm as WriterNm from t_board A "
				+ "left JOIN t_user B " + "ON A.iuser = B.iuser ";

		try {
			con = DbUtils.getCon();
			ps = con.prepareStatement(sql);

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
}
