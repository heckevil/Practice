package com.koreait.board4.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.koreait.board4.MyUtils;
import com.koreait.board4.user.BoardVO;
import com.koreait.board4.user.UserVO;

@WebServlet("/board/write")
public class WriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession hs = request.getSession();

		UserVO LoginUser = (UserVO) hs.getAttribute("LoginUser");
		if (LoginUser == null) {
			response.sendRedirect("/user/login");
			return;
		}

		MyUtils.openJSP("board/write", request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String title = request.getParameter("title");
		String ctnt = request.getParameter("ctnt");
		
//		HttpSession hs = request.getSession();
//		UserVO loginUser = (UserVO) hs.getAttribute("LoginUser");
//		int iuser = loginUser.getIuser();
		
		int iuser = MyUtils.getLoginUserPK(request);
		
		BoardVO vo = new BoardVO();
		vo.setCtnt(ctnt);
		vo.setTitle(title);
		vo.setIuser(iuser);
		
		BoardDAO.insBoard(vo);
		response.sendRedirect("list");
	
	}

}
