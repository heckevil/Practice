package com.koreait.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/mod")
public class BoardModServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String no = request.getParameter("no");
		int a = Integer.parseInt(no);

		BoardVO vo = BoardDAO.selboard(a);
		request.setAttribute("vo", vo);

		String jsp = "/WEB-INF/jsp/mod.jsp";
		request.getRequestDispatcher(jsp).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String title = request.getParameter("title");
		String ctnt = request.getParameter("ctnt");
		String no = request.getParameter("no");
		int a = Integer.parseInt(no);
		
		BoardVO vo = new BoardVO();
		vo.setCtnt(ctnt);
		vo.setTitle(title);
		vo.setIboard(a);

		BoardDAO.updateboard(vo);
		response.sendRedirect("/detail?no=" + a);
	}

}
