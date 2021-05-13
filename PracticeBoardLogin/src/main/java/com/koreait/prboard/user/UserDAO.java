package com.koreait.prboard.user;

import java.sql.*;

import org.mindrot.jbcrypt.BCrypt;

import com.koreait.VO.UserVO;
import com.koreait.utils.DbUtils;

public class UserDAO {

	public static int joinuser(UserVO vo) {
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

	public static int LoginUser(UserVO vo) {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from t_user where id = ? ";
		try {
			con = DbUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, vo.getId());
			rs = ps.executeQuery();

			if (rs.next()) {
				int iuser = rs.getInt("iuser");
				String nm = rs.getString("nm");

				vo.setIuser(iuser);
				vo.setNm(nm);
				// 로그인 성공 : 1, 아이디 없음 :2, 비번틀림:3, 오류 4
				String dbpw = rs.getString("pw");
				if (BCrypt.checkpw(vo.getPw(), dbpw)) {
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
