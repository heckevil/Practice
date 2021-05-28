package com.koreait.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mindrot.jbcrypt.BCrypt;

import com.koreait.utils.MyUtils;
import com.koreait.vo.UserEntity;

@WebServlet("/user/join")
public class UserJoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		/*
		 * request.setAttribute(ConstVO.TITLE, "회원가입");
		 * request.setAttribute(ConstVO.PAGE, "user/userjoin"); String jsp =
		 * "/WEB-INF/view/template.jsp";
		 * request.getRequestDispatcher(jsp).forward(request, response);
		 */
		MyUtils.openJSP("회원가입", "user/userjoin", request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("uid");
		String pw = request.getParameter("upw");
		String nm = request.getParameter("unm");
		int gender =MyUtils.stringToint("gender", request);
		String hasedupw= BCrypt.hashpw(pw, BCrypt.gensalt());
		
		UserEntity vo = new UserEntity();
		vo.setGender(gender);
		vo.setId(id);
		vo.setPw(hasedupw);
		vo.setNm(nm);
		
		UserDAO.joinuser(vo);
		response.sendRedirect("/user/login");
	}

}
