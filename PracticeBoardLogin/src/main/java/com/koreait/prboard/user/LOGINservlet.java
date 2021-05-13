package com.koreait.prboard.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.koreait.VO.UserVO;
import com.koreait.utils.MyUtils;

@WebServlet("/user/login")
public class LOGINservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		MyUtils.openJSP("user/Login", request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uid = request.getParameter("uid");
		String upw = request.getParameter("upw");

		UserVO vo = new UserVO();
		vo.setId(uid);
		vo.setPw(upw);

		int result = UserDAO.LoginUser(vo);

		if (result == 1) {
			HttpSession hs = request.getSession();
			vo.setPw(null);

			hs.setAttribute("loginuser", vo);

			response.sendRedirect("/board/list");
			return;
	

		}

		String errmsg = null;
		switch (result) {
		case 2:
			errmsg = "아이디를 확인해 주세요";
			break;
		case 3:
			errmsg = "비밀번호를 확인해 주세요";
			break;
		case 4:
			errmsg = "에러";
			break;
		}
		request.setAttribute("errmsg", errmsg);
		doGet(request, response);

	}
}
