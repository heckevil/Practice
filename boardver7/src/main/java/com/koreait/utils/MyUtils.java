package com.koreait.utils;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.koreait.vo.ConstVO;
import com.koreait.vo.UserEntity;

public class MyUtils {
	public static void openJSP(String title, String jsp, HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		//String jsp = "/WEB-INF/view/" + fileNM + ".jsp";
		req.setAttribute(ConstVO.TITLE,title);
		req.setAttribute(ConstVO.JSP, jsp);
		String temp = "/WEB-INF/view/template.jsp";
		req.getRequestDispatcher(temp).forward(req, res);
	}

	public static int stringToint(String str, HttpServletRequest request) {
		String strval = request.getParameter(str);
		int val = Integer.parseInt(strval);
		return val;
	}

	public static UserEntity getLoginUser(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		HttpSession hs = req.getSession();
		UserEntity loginuser = (UserEntity) hs.getAttribute("loginuser");

		return loginuser;
	}

	public static int LoginUserPK(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		UserEntity vo = getLoginUser(req, res);
		int pk = vo.getIuser();
		return pk;

	}

}
