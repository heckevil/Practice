package com.koreait.board;

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

@WebServlet("/board/mod")
public class MODsevelt extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int no = MyUtils.stringToint("no", request);
		BoardVO vo = BoardDAO.selboard(no);
		
		UserVO user = MyUtils.getLoginUser(request, response);
		int pk = MyUtils.LoginUserPK(request, response);
		
		if(user == null) {
			response.sendRedirect("/user/login");
			return;
		}
		if (vo.getIuser() != pk) {
			response.sendRedirect("/user/login");
			return;
		}


		request.setAttribute("vo", vo);

		MyUtils.openJSP("board/mod", request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String ctnt = request.getParameter("ctnt");
		String title = request.getParameter("title");
		int no = MyUtils.stringToint("no", request);
		int pk = MyUtils.LoginUserPK(request, response);
		
		BoardVO vo = new BoardVO();
		vo.setCtnt(ctnt);
		vo.setTitle(title);
		vo.setIboard(no);
		vo.setIuser(pk);
		
		BoardDAO.modboard(vo);
		
		response.sendRedirect("/board/list");
	}

}
