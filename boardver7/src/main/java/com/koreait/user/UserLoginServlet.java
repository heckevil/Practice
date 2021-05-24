package com.koreait.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.mindrot.jbcrypt.BCrypt;

import com.koreait.vo.ConstVO;
import com.koreait.vo.UserEntity;

/**
 * Servlet implementation class userlogin
 */
@WebServlet("/user/login")
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setAttribute(ConstVO.TITLE, "로그인");
		request.setAttribute(ConstVO.JSP, "user/userlogin");
		String jsp = "/WEB-INF/view/template.jsp";
		request.getRequestDispatcher(jsp).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		String uid = request.getParameter("uid");
		String upw = request.getParameter("upw");
		UserEntity param = new UserEntity();
		param.setId(uid);
		String errmsg = null;
		UserEntity result = UserDAO.selUser(param);

		if (result == null) {
			errmsg = "아이디를 확인하세요";
		} else if (BCrypt.checkpw(upw, result.getPw())) {
			HttpSession hs = request.getSession();
			result.setPw(null);

			hs.setAttribute("loginUser", result);
			response.sendRedirect("/board/boardlist");
			return;
		} else {
			errmsg="비밀번호를 확인하세요";
		}
		request.setAttribute("errmsg", errmsg);
		doGet(request, response);
	
	}

}
