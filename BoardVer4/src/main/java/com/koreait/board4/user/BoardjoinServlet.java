package com.koreait.board4.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.board4.MyUtils;

@WebServlet("/user/join")
public class BoardjoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		MyUtils.openJSP("user/join", request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uid = request.getParameter("uid");
		String unm = request.getParameter("umn");
		int a = MyUtils.getParamInt("gender", request);
		String pw = request.getParameter("upw");
		UserVO vo = new UserVO();
		vo.setGender(a);
		vo.setUid(uid);
		vo.setPw(pw);
		vo.setUnm(unm);
		UserDAO.joinuser(vo);
		
		response.sendRedirect("/user/login");
	}

}
