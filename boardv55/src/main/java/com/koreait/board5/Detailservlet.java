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
import com.koreait.cmt.CmtDAO;
import com.koreait.utils.MyUtils;

@WebServlet("/board/detail")
public class Detailservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		int no = MyUtils.stringToint("no", request);
		BoardVO vo =BoardDAO.selboard(no);
		
		request.setAttribute("vo", vo);
		request.setAttribute("cmt",CmtDAO.selboardcmt(no));
		

		MyUtils.openJSP("board/detail", request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
