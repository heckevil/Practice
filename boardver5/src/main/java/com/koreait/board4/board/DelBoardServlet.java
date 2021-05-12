package com.koreait.board4.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.board4.MyUtils;
import com.koreait.board4.user.BoardVO;

@WebServlet("/board/del")
public class DelBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int a = MyUtils.getParamInt("no", request);
		int iuser = MyUtils.getLoginUserPK(request);
		
		BoardVO vo = new BoardVO();
		vo.setIboard(a);
		vo.setIuser(iuser);
		
		BoardDAO.delboard(vo);
		
		response.sendRedirect("/board/list");
		

	}

}
