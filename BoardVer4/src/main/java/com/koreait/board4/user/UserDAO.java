package com.koreait.board4.user;

import java.sql.*;

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

		String sql = "select * from t_user where uid= ? ";

		try {
			con = DbUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, lg.getUid());
			rs = ps.executeQuery();

			String pw = lg.getPw();

			if (rs.next()) {
				// 아이디가 있는경우
				String pwck = rs.getString("upw");//rs.get~ 은 무조건 rs.next(); 밑에 있어야 오류가 안난다 
				if (pwck.equals(pw)) // 비교대상.equal(원본)
				{
					return 1;
				} else {
					return 3;
				}
			} else {
				// 아이디가 없는 경우
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
