package com.koreait.cmt;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.VO.CmtVO;
import com.koreait.VO.UserVO;
import com.koreait.utils.MyUtils;

@WebServlet("/board/regcmt")
public class CmtRegServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int icmt = MyUtils.stringToint("icmt", request);
		int iboard = MyUtils.stringToint("iboard", request);
		int pk = MyUtils.LoginUserPK(request, response);
		
		CmtVO parma = new CmtVO();
		parma.setIcmt(icmt);
		parma.setIuser(pk);
		
		CmtDAO.delcmt(parma);
		
		response.sendRedirect("/board/detail?no="+iboard);
		
		
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserVO user = MyUtils.getLoginUser(request, response);
		if(user == null){
			response.sendRedirect("/user/login");
			return;
		}
		
		
		String cmt = request.getParameter("cmt");
		int iboard = MyUtils.stringToint("iboard", request);
		int iuser = MyUtils.LoginUserPK(request, response);

		CmtVO param = new CmtVO();
		param.setIboard(iboard);
		param.setCmt(cmt);
		param.setIuser(iuser);

		System.out.println("param.iuser  : "+ param.getIuser());
		
		CmtDAO.insCmt(param);
		response.sendRedirect("/board/detail?no="+iboard);
	}

}
