package com.koreait.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.VO.UserVO;
import com.koreait.utils.MyUtils;

@WebServlet("/user/join")
public class JoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		MyUtils.openJSP("회원가입", "user/join", request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uid = request.getParameter("uid");
		String upw = request.getParameter("upw");
		String unm = request.getParameter("unm");

		int gender = MyUtils.stringToint("gender", request);

		UserVO vo = new UserVO();
		vo.setId(uid);
		vo.setNm(unm);
		vo.setPw(upw);
		vo.setGender(gender);
		
//		int result = UserDAO.join(vo);
		int result = 1;
		
		PrintWriter pw = ((ServletResponse) request).getWriter();
		pw.append(String.format("{ \"result\" : 1 ", result));
	}

}
