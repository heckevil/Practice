package com.koreait.cmt;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.koreait.utils.MyUtils;
import com.koreait.vo.BoardCmtDomain;
import com.koreait.vo.BoardCmtEntity;

@WebServlet("/board/cmtInsSel")
public class BoardCmtInsSelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// 리스트
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int iboard = MyUtils.stringToint("iboard", request);

		BoardCmtEntity param = new BoardCmtEntity();
		param.setIboard(iboard);
		List<BoardCmtDomain> list = BoardCmtDAO.selBoardCmtList(param);
		Gson gson = new Gson();
		String json = gson.toJson(list);
		System.out.println("json : " + json);

		response.setCharacterEncoding("UTF-8");
		response.getWriter().append(json);
	}

	// 등록
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int iboard = MyUtils.stringToint("iboard", request);
		String cmt = request.getParameter("cmt");
		int iuser = MyUtils.LoginUserPK(request, response);

		BoardCmtEntity param = new BoardCmtEntity();
		param.setIuser(iuser);
		param.setIboard(iboard);
		param.setCmt(cmt);

		int result = BoardCmtDAO.insBoardCmt(param);
		response.getWriter().append("{").append("\"result\" :").append(String.valueOf(result)).append("}").flush();
	}
}
