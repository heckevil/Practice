package com.koreait.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/user/idChk")
public class idChkAjaxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	String uid = request.getParameter("uid");
	System.out.println("uid : "+uid);
	int result = UserDAO.selidChk(uid);
	
	PrintWriter pw = response.getWriter();
	pw.append("{\"result\" : ")
	.append(String.valueOf(result))
	.append("}");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
