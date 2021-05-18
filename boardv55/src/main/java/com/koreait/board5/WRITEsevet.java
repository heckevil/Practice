package com.koreait.board5;

import java.io.IOException;
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
 * Servlet implementation class WRITEsevet
 */
@WebServlet("/board/write")
public class WRITEsevet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession hs = request.getSession();
		UserVO loginuser = MyUtils.getLoginUser(request, response);
		if (loginuser == null) {
			response.sendRedirect("/user/login");
			return;
		}

		MyUtils.openJSP("board/write", request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String title = request.getParameter("title");
		String ctnt = request.getParameter("ctnt");
		int iuser = MyUtils.LoginUserPK(request, response);
		
		BoardVO vo = new BoardVO();
		vo.setCtnt(ctnt);
		vo.setTitle(title);
		vo.setIuser(iuser);
		
		BoardDAO.writeboard(vo);
		
		response.sendRedirect("/board/list");
	}

}
