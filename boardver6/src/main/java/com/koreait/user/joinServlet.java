package com.koreait.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.utils.MyUtils;


@WebServlet("/user/join")
public class joinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	MyUtils.openJSP("join", "user/join", request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uid = request.getParameter("uid");
		String upw = request.getParameter("upw");
		int gender = MyUtils.stringToint("gender", request);
		String unm = request.getParameter("unm");
		System.out.println("uid  :" + uid);
		
		int result = 0;
		
		PrintWriter pw = response.getWriter();
		pw.append(String.format("{\"result\" :%d}",result));
	}

}
