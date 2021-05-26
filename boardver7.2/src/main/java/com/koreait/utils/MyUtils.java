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
		int val = parseStringToInt(strval);
		return val;
	}
	public static int parseStringToInt(String val) {
		try {
			int result = Integer.parseInt(val);
			return result;
		} catch(Exception e) {
			return 0;
		}
	}

	public static UserEntity getLoginUser(HttpServletRequest req)
			throws ServletException, IOException {
		if(req == null) { return null; } 
		HttpSession hs = req.getSession();
		return (UserEntity) hs.getAttribute("loginUser");
	}

	public static int LoginUserPK(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		if(req == null) { return 0; }		
		return getLoginUser(req).getIuser();

	}

}
