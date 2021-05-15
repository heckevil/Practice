package com.house.party;

import java.sql.*;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import com.house.people.PeopleVO;
import com.house.utils.DbUtils;

public class AllListDAO {

	public static List<PeopleVO> selListall() {
		List<PeopleVO> list = new ArrayList();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		String sql = " SELECT A.iuser, A.id, B.dpname, C.hnm FROM all_list A "
				+ " LEFT JOIN depart B "
				+ " ON A.idep = B.idep "
				+ " LEFT JOIN house C "
				+ " ON A.hno = C.hno ";

		try {
			con = DbUtils.getCon();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				String nm = rs.getString("id");
				String dpname = rs.getString("dpname");
				String hnm = rs.getString("hnm");
				int iuser = rs.getInt("iuser");
				PeopleVO vo = new PeopleVO();

				vo.setHnm(hnm);
				vo.setDpname(dpname);
				vo.setNm(nm);
				vo.setIuer(iuser);
				list.add(vo);

			}

		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			DbUtils.close(con, ps, rs);
		}

		return list;
	}

	public static int addList(PeopleVO vo) {

		Connection con = null;
		PreparedStatement ps = null;

		String sql = " INSERT INTO all_list " + " (id,idep,hno) " + " VALUES " + " (?,?,?) ";

		try {
			con = DbUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, vo.getNm());
			ps.setInt(2, vo.getIdep());
			ps.setInt(3, vo.getHouse());

			return ps.executeUpdate();

		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			DbUtils.close(con, ps);
		}

		return 0;
	}

	public static List<PeopleVO> TDselListall() {
		List<PeopleVO> td_list = new ArrayList();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		String sql = " SELECT A.iuser, A.id, B.dpname, C.hnm FROM today_list A "
				+ " LEFT JOIN depart B "
				+ " ON A.idep = B.idep "
				+ " LEFT JOIN house C "
				+ " ON A.hno = C.hno ";

		try {
			con = DbUtils.getCon();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				String nm = rs.getString("id");
				String dpname = rs.getString("dpname");
				String hnm = rs.getString("hnm");
				int iuser = rs.getInt("iuser");
				PeopleVO vo = new PeopleVO();

				vo.setHnm(hnm);
				vo.setDpname(dpname);
				vo.setNm(nm);
				vo.setIuer(iuser);
				td_list.add(vo);

			}

		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			DbUtils.close(con, ps, rs);
		}

		return td_list;
	}

	public static int addTdList(PeopleVO vo) {
		Connection con = null;
		PreparedStatement ps = null;

		String sql = " INSERT INTO today_list " + " (id) " + " VALUES " + " (?) ";

		try {
			con = DbUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, vo.getNm());

			return ps.executeUpdate();

		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			DbUtils.close(con, ps);
		}

		return 0;
	}

}
