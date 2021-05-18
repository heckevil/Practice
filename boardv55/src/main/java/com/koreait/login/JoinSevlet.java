package com.koreait.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mindrot.jbcrypt.BCrypt;

import com.koreait.VO.UserVO;
import com.koreait.utils.MyUtils;


@WebServlet("/user/join")
public class JoinSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	MyUtils.openJSP("user/Join", request, response);
	}

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String id = request.getParameter("lgid");
	String pw = request.getParameter("lgpw");
	String nm = request.getParameter("lgnm");
	int gender =MyUtils.stringToint("gender", request);
	String hasedupw= BCrypt.hashpw(pw, BCrypt.gensalt());
	
	UserVO vo = new UserVO();
	vo.setGender(gender);
	vo.setId(id);
	vo.setPw(hasedupw);
	vo.setNm(nm);
	
	UserDAO.joinuser(vo);
	response.sendRedirect("/user/login");
			}

}
