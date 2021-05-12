package com.koreait.board4.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.koreait.board4.MyUtils;

@WebServlet("/user/login")
public class loginSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession hs = request.getSession();
		UserVO LoginUser = (UserVO) hs.getAttribute("LoginUser");
		if (LoginUser != null) {
			response.sendRedirect("/board/list");
			return;
		}

		MyUtils.openJSP("user/login", request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uid = request.getParameter("uid");
		String pw = request.getParameter("upw");
		UserVO lg = new UserVO();
		lg.setUid(uid);
		lg.setPw(pw);

		int result = UserDAO.LoginUser(lg);

		if (result == 1) {
			HttpSession hs = request.getSession();
//			hs.setAttribute("loginSuccess", true);
//			System.out.println("loginSuccess : " + true);
			lg.setPw(null); //보안상 문제로 pw는 null으로 넘긴다.
			
			hs.setAttribute("LoginUser", lg);
			// vo가 가리키는 UserVO객체는 (iuser, uid, umn값을 담고있다)
			// request없이 board/list로 보냄 연결고리가 끊기면서 새로운 request 생성하면서 보냄.
			// 하지만 hs.setAttribute에 담긴 내용은 남아있다.
			response.sendRedirect("/board/list");
			return;
		}
		String errmsg = null;
		switch (result) {
		case 0:
			errmsg = "에러가 발생하였습니다.";
			break;

		case 2:
			errmsg = "아이디를 확인해주세요";
			break;

		case 3:
			errmsg = "비밀번호를 확인해 주세요";
			break;
		// doGet(request,response);
		// response.sendRedirect("login");

		// 결과는 똑같이 login페이지로 가는데 위에는 매소드 호출 했기때문에 request같이 같다
		// 밑에 값은 새로은 주소값으로 이동 이기때문에 새로운 request가 탄생 -> 쿼리스트링으로 값전달
		// response.sendRedirect("login?err=" + result)

		}
		request.setAttribute("errmsg", errmsg);
		doGet(request, response); // doPost의 request랑 똑같음 doPost에서 setAttribute 한거 doGet으로 쓸수있음.
	}

}
