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

@WebServlet("/board/del")
public class DELservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession hs = request.getSession();
		UserVO user = (UserVO) hs.getAttribute("loginuser");
		
		if (user == null) {
			response.sendRedirect("/user/login");
			return;
		}

		int no = MyUtils.stringToint("no", request);
		int pk = MyUtils.LoginUserPK(request, response);
		BoardVO param = new BoardVO();
		param.setIuser(pk);
		param.setIboard(no);
		BoardDAO.delboard(param);
		response.sendRedirect("/board/list");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
