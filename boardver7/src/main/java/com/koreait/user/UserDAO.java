package com.koreait.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.koreait.utils.DbUtils;
import com.koreait.vo.UserEntity;

public class UserDAO {
	public static int selidChk(String uid) {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		String sql = "SELECT iuser FROM t_user WHERE id= ? ";

		int result = 0;
		try {
			con = DbUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, uid.trim());
			rs = ps.executeQuery();

			if (rs.next()) {
				return result = 1;
			}
		} catch (Exception e) {
			// TODO Autos-generated catch block
			e.printStackTrace();
		} finally {
			DbUtils.close(con, ps, rs);
		}
		return result;
	}
	public static UserEntity selUser(UserEntity param) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from t_user where id = ? ";
		try {
			con = DbUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, param.getId());
			rs = ps.executeQuery();

			if (rs.next()) {
				String uid = rs.getString("id");
				String upw = rs.getString("pw");
				String unm = rs.getString("nm");
				int iuser = rs.getInt("iuser");
				
				UserEntity result = new UserEntity();
				result.setId(uid);
				result.setPw(upw);
				result.setNm(unm);
				result.setIuser(iuser);
				
				return result;
				
			}
		} catch (Exception e) {

			e.printStackTrace();
			
		} finally {
			DbUtils.close(con, ps, rs);
		}

		return null;
	}
}