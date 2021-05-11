package com.koreait.board4.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.board4.MyUtils;


@WebServlet("/user/login")
public class loginSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MyUtils.openJSP("user/login", request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String 	uid = request.getParameter("uid");
	String pw = request.getParameter("upw");
	UserVO lg = new UserVO();
	lg.setUid(uid);
	lg.setPw(pw);
	
	int result = UserDAO.LoginUser(lg);
	switch(result){
	case 1:
		response.sendRedirect("/board/list");
		break;
	default:
		//doGet(request,response);
		//response.sendRedirect("login");
		
		//결과는 똑같이 login페이지로 가는데 위에는 매소드 호출 했기때문에 request같이 같다
		//밑에 값은 새로은 주소값으로 이동 이기때문에 새로운 request가 탄생 -> 쿼리스트링으로 값전달
		//response.sendRedirect("login?err=" + result)
		break;
	}
	
	}

}
