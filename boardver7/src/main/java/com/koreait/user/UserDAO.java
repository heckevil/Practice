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
				String profileImg = rs.getString("profileImg");

				UserEntity result = new UserEntity();
				result.setId(uid);
				result.setPw(upw);
				result.setNm(unm);
				result.setIuser(iuser);
				result.setProfileImg(profileImg);

				System.out.println("result pk : " + result.getIuser());
				return result;

			}
		} catch (Exception e) {

			e.printStackTrace();

		} finally {
			DbUtils.close(con, ps, rs);
		}

		return null;
	}

	public static int joinuser(UserEntity vo) {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "INSERT INTO t_user " + " (id,pw,nm,gender) " + " VALUES " + " (?,?,?,?) ";
		try {
			con = DbUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, vo.getId());
			ps.setString(2, vo.getPw());
			ps.setString(3, vo.getNm());
			ps.setInt(4, vo.getGender());

			System.out.println("아이디 : " + vo.getId());
			System.out.println("이름 : " + vo.getNm());
			System.out.println("가입성공!");
			return ps.executeUpdate();
		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			DbUtils.close(con, ps);
		}
		return 0;
	}

	public static int updUser(UserEntity param) {
		Connection con = null;
		PreparedStatement ps = null;
		String updString = null;
		
		String sql = "UPDATE t_user SET ";
		if(param.getPw() != null && !param.getPw().equals("")) {
			sql += " upw = ? ";
			updString = param.getPw();
		} else if(param.getProfileImg() != null && !param.getProfileImg().equals("")) {
			sql += " profileImg = ? ";
			updString = param.getProfileImg();
		}
		sql += " WHERE iuser = ?";

		try {
			con = DbUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, updString);
			ps.setInt(2, param.getIuser());
			return ps.executeUpdate();
		} catch (Exception e) {			
		} finally {
			DbUtils.close(con, ps);
		}
		return 0;
	}
}
