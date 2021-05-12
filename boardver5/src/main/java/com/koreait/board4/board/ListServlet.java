package com.koreait.board4.board;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.koreait.board4.MyUtils;
import com.koreait.board4.user.BoardVO;
import com.koreait.board4.user.UserVO;

@WebServlet("/board/list")
public class ListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession hs = request.getSession();

		UserVO LoginUser = (UserVO) hs.getAttribute("LoginUser");

		// 로그인이 안되어 있으면 로그인화면 이동
		// 로그인 구별한 분기점이 모를땐 역산해보자! 로그인 안될시~ 부터 하는것
		if (LoginUser == null) {
			response.sendRedirect("/user/login");
			return;
		}
		// response로 보내졌기때문에 request값이 달라져 새로 킨다
		List<BoardVO> list = BoardDAO.selBoardList();
		request.setAttribute("list", list);
		MyUtils.openJSP("board/list", request, response);

		// HttpSession hs = request.getSession();
//	Boolean LoginSuccess = (Boolean) request.getAttribute("loginsuccess");
//		
//	if(LoginSuccess == null || LoginSuccess==false) {
//		System.out.println("loginSuccess : " + LoginSuccess);
//		response.sendRedirect("/user/login");
//		return;
//	}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
