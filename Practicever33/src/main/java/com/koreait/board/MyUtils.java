package com.koreait.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyUtils {
	public static void openJSP(String a, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//servlet 이 throws 한거랑 맞춰주면 servlet에서 try/catch 할필요없다
		// 멤버필드, 전역변수가 없다면 그냥 static으로 하자

		String jsp = "/WEB-INF/jsp/" + a + ".jsp";
		request.getRequestDispatcher(jsp).forward(request, response);
		// RequestDispatcher rd = request.getRequestDispatcher(jsp);
		// rd.forward(request, response);
	}

	public static int parseStringToInt(String no) {

		try {
			return Integer.parseInt(no);
		} catch (Exception e) {

			return 0;
		}

	}

	public static int getParamInt(HttpServletRequest request, String no) {
		String strVal = request.getParameter(no);
		int intVal = parseStringToInt(no);
		return intVal;
		
		
	}
}
