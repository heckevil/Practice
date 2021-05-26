package com.koreait.cmt;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.utils.MyUtils;
import com.koreait.vo.BoardCmtEntity;

@WebServlet("/board/cmtDelUpd")
public class BoardCmtDelUpd extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// 댓글 삭제
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int icmt = MyUtils.stringToint("icmt", request);
		int iuser = MyUtils.LoginUserPK(request, response);

		BoardCmtEntity param = new BoardCmtEntity();
		param.setIcmt(icmt);
		param.setIuser(iuser);

		int result = BoardCmtDAO.delBoardCmt(param);
		response.getWriter().append("{").append("\"result\" :").append(String.valueOf(result)).append("}").flush();

	}

	// 댓글 수정
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
