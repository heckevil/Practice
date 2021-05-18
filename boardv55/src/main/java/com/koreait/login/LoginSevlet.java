package com.koreait.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.mindrot.jbcrypt.BCrypt;

import com.koreait.VO.UserVO;
import com.koreait.utils.MyUtils;

@WebServlet("/user/login")
public class LoginSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		MyUtils.openJSP("user/login", request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uid = request.getParameter("uid");
		String upw = request.getParameter("upw");
		UserVO param = new UserVO();
		param.setId(uid);
		String errmsg = null;
		UserVO result = UserDAO.selUser(param);

		if (result == null) {
			errmsg = "아이디를 확인하세요";
		} else if (BCrypt.checkpw(upw, result.getPw())) {
			HttpSession hs = request.getSession();
			result.setPw(null);

			hs.setAttribute("loginuser", result);
			response.sendRedirect("/board/list");
			return;
		} else {
			errmsg="비밀번호를 확인하세요";
		}
		request.setAttribute("errmsg", errmsg);
		doGet(request, response);
	}
}
