package com.koreait.board4;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.koreait.board4.user.UserVO;

public class MyUtils {
	public static void openJSP(String fileNm, HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		String jsp = "/WEB-INF/view/" + fileNm + ".jsp";
		req.getRequestDispatcher(jsp).forward(req, res);
	}

	public static int parseStringToInt(String val, HttpServletRequest req) {
		String strVal = req.getParameter("no");

		try {
			return Integer.parseInt(val);
		} catch (Exception e) {
			return 0;
		}
	}

	public static int getParamInt(String key, HttpServletRequest req) {
		String val = req.getParameter(key);
		int intval = Integer.parseInt(val);
		return intval;
	}
	public static UserVO getLoginUser(HttpServletRequest req) {
		if(req == null) {return null;}
		HttpSession hs = req.getSession();
		return (UserVO) hs.getAttribute("LoginUser");
	}

	public static int getLoginUserPK(HttpServletRequest request) {
		UserVO vo = getLoginUser(request);
		
		return vo.getIuser();
	}
}
