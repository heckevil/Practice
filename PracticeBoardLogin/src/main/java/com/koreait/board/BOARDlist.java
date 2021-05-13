package com.koreait.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.koreait.VO.BoardVO;
import com.koreait.VO.UserVO;
import com.koreait.utils.MyUtils;

/**
 * Servlet implementation class BOARDlist
 */
@WebServlet("/board/list")
public class BOARDlist extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	HttpSession hs = request.getSession();
	UserVO loginuser = (UserVO) hs.getAttribute("loginuser");
	if(loginuser == null) {
		response.sendRedirect("/user/login");
		return;
	}
	
	
	List<BoardVO> list = BoardDAO.selboardlist();
	request.setAttribute("list", list);

	
	MyUtils.openJSP("board/list", request, response);	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
