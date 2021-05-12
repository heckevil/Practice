package com.koreait.board4.user;

import java.sql.*;

import org.mindrot.jbcrypt.BCrypt;

import com.koreait.board4.DbUtils;

public class UserDAO {
	public static int joinuser(UserVO vo) {
		Connection con = null;
		PreparedStatement ps = null;

		String sql = "INSERT INTO t_user " + " (uid,upw,unm,gender) " + " values " + " (?,?,?,?) ";

		try {
			con = DbUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, vo.getUid());
			ps.setString(2, vo.getPw());
			ps.setString(3, vo.getUnm());
			ps.setInt(4, vo.getGender());

			System.out.println("아이디 : " + vo.getUid());
			System.out.println("비밀번호 : " + vo.getPw());
			return ps.executeUpdate();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DbUtils.close(con, ps);
		}
		return 0;
	}

//로그인 성공 : 1, 아이디 틀림 : 2, 비번틀림 : 3, 에러 : 4
	public static int LoginUser(UserVO lg) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		String sql = "select * from t_user where uid = ? "; // 아이디만 띄워도 db에서 한줄 뜬다 -> id가 유니크이기 때문

		try {
			con = DbUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, lg.getUid());
			rs = ps.executeQuery();
			
			String pw = lg.getPw();
			if (rs.next()) {
				int iuser =rs.getInt("iuser");
				String umn = rs.getString("unm");
				lg.setIuser(iuser);
				lg.setUnm(umn);
				
				String pwck = rs.getString("upw");
				if(BCrypt.checkpw(lg.getPw(),pwck)) {
					//Bcrypt.checkpw(삽인된값, 원본값)
//				if (pwck.equals(pw)) {
				return 1;
				} else {
					return 3;
				}

			} else {
				return 2;
			}

		} catch (Exception e) {

			e.printStackTrace();
			return 4;
		} finally {
			DbUtils.close(con, ps, rs);
		}

	}
}
