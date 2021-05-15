package com.house.utils;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyUtils {
	public static void openJSP(String fileNM,HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
	String jsp = "/WEB-INF/"+fileNM+".jsp";
	request.getRequestDispatcher(jsp).forward(request, response);
	}

	public static int stringToint(String str, HttpServletRequest request) {
		String strval = request.getParameter(str);
		int intstr = Integer.parseInt(strval);
		return intstr;
	}
}
