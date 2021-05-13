package com.koreait.prboard.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mindrot.jbcrypt.BCrypt;

import com.koreait.VO.UserVO;
import com.koreait.utils.MyUtils;

/**
 * Servlet implementation class JOINservlet
 */
@WebServlet("/user/join")
public class JOINservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		MyUtils.openJSP("user/join", request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uid = request.getParameter("lgid");
		String upw = request.getParameter("lgpw");
		String unm = request.getParameter("lgnm");
		int gender = MyUtils.stringToint("gender", request);
		
		String hasgedpw = BCrypt.hashpw(upw, BCrypt.gensalt());
		
		
		UserVO vo = new UserVO();
		vo.setId(uid);
		vo.setPw(hasgedpw);
		vo.setNm(unm);
		vo.setGender(gender);
		
		UserDAO.joinuser(vo);
		
		response.sendRedirect("login");
		
		
	}

}
