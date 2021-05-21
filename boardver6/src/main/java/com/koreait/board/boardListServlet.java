package com.koreait.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.VO.BoardVO;
import com.koreait.utils.MyUtils;

@WebServlet("/board/list")
public class boardListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//	페이징 처리
		int page = MyUtils.stringToint("page", request);
		if (page == 0) {
			page = 1;
		}
		String search = request.getParameter("search");
		int recordCnt = 3;
		int sIdx = (page - 1) * recordCnt;
		
		BoardVO param = new BoardVO();
		param.setPage(recordCnt);
		param.setsIdx(sIdx);
		param.setSearch(search);

		request.setAttribute("totalPage", BoardDAO.getAllpage(param));
		request.setAttribute("list", BoardDAO.selboardlist(param));
		MyUtils.openJSP("list", "board/list", request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
