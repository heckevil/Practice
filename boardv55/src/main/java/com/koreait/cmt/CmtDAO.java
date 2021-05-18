package com.koreait.cmt;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.koreait.VO.CmtVO;
import com.koreait.utils.DbUtils;

public class CmtDAO {
	public static void insCmt(CmtVO param) {

		Connection con = null;
		PreparedStatement ps = null;

		String sql = "insert into t_board_cmt (iboard,cmt,iuser) values (?,?,?)";

		try {
			con = DbUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, param.getIboard());
			ps.setString(2, param.getCmt());
			ps.setInt(3, param.getIuser());

			ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DbUtils.close(con, ps);
		}

	}

	public static List<CmtVO>  selboardcmt(int no) {
		List<CmtVO> list = new ArrayList();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		String sql = " SELECT A.icmt,A.iuser,A.cmt,A.regdt,B.nm from t_board_cmt A "
				+ "inner JOIN t_user B "
				+ "ON A.iuser = B.iuser WHERE iboard = ? ";

		try {
			con = DbUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, no);
			rs = ps.executeQuery();

			while (rs.next()) {
				CmtVO cmt = new CmtVO();
				int icmt = rs.getInt("icmt");
				int iuser = rs.getInt("iuser");
				String dbcmt = rs.getString("cmt");
				String regdt = rs.getString("regdt");
				String nm = rs.getString("nm");

				cmt.setCmt(dbcmt);
				cmt.setIuser(iuser);
				cmt.setIcmt(icmt);
				cmt.setRegdt(regdt);
				cmt.setNm(nm);


				list.add(cmt);

			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DbUtils.close(con, ps, rs);
		}
		return list;
	}

	public static void delcmt(CmtVO parma) {
		Connection con = null;
		PreparedStatement ps = null;
		
		String sql = " DELETE FROM t_board_cmt "
				+ "WHERE icmt = ? AND iuser = ? ";
		try {
			con = DbUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, parma.getIcmt());
			ps.setInt(2, parma.getIuser());
			
			
		 ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {DbUtils.close(con, ps);}
		
		
	}
}
