package com.koreait.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.bcel.Const;

import com.koreait.VO.BoardVO;
import com.koreait.VO.ConstVO;
import com.koreait.utils.MyUtils;

@WebServlet("/board/list")
public class boardlistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String search = request.getParameter("search");
		if (search == null) {
			search = "";
		}

		int page = MyUtils.stringToint(ConstVO.PAGE, request);
		int recordCnt = 3;
		int sIdx = (page -1)*recordCnt;
		
		BoardVO param = new BoardVO();
		param.setSidx(sIdx);
		param.setSearch(search);
		param.setPage(recordCnt);
		
		request.setAttribute("totalpage", BoardDAO.getAllpage(param));
		request.setAttribute("list", BoardDAO.selboardllist(param));
		
		MyUtils.openJSP("리스트", "board/list", request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
