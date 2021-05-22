package com.koreait.utils;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.koreait.VO.ConstVO;
import com.koreait.VO.UserVO;

public class MyUtils {
	public static void openJSP(String title, String page, HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		//String jsp = "/WEB-INF/view/" + fileNM + ".jsp";
		req.setAttribute(ConstVO.PAGE, page);
		req.setAttribute(ConstVO.TITLE,title);
		
		String jsp = "/WEB-INF/view/templet.jsp";
		req.getRequestDispatcher(jsp).forward(req, res);
	}

	public static int stringToint(String str, HttpServletRequest request) {
		String strval = request.getParameter(str);
		int val = Integer.parseInt(strval);
		return val;
	}

	public static UserVO getLoginUser(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		HttpSession hs = req.getSession();
		UserVO loginuser = (UserVO) hs.getAttribute("loginuser");

		return loginuser;
	}

	public static int LoginUserPK(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		UserVO vo = getLoginUser(req, res);
		int pk = vo.getIuser();
		return pk;

	}

}
