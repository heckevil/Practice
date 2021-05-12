package com.koreait.board4.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.board4.MyUtils;
import com.koreait.board4.user.BoardVO;

@WebServlet("/board/mod")
public class ModServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int a = MyUtils.getParamInt("no", request);
		BoardVO vo = BoardDAO.selBoard(a);
		request.setAttribute("vo", vo);
		MyUtils.openJSP("board/mod", request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int iuser = MyUtils.getLoginUserPK(request);
		int no = MyUtils.getParamInt("no", request);
		String title = request.getParameter("title");
		String ctnt = request.getParameter("ctnt");
		BoardVO vo = new BoardVO();
		vo.setCtnt(ctnt);
		vo.setTitle(title);
		vo.setIboard(no);
		vo.setIuser(iuser);
		BoardDAO.modboard(vo);

		response.sendRedirect("detail?no=" + no);

	}

}
