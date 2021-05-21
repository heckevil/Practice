package com.koreait.board;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.koreait.VO.BoardVO;
import com.koreait.utils.MyUtils;


@WebServlet("/board/detail")
public class detailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	MyUtils.openJSP("detail", "board/detail", request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	int iboard = MyUtils.stringToint("iboard", request);
	System.out.println("iboard : "+iboard);
	
	BoardVO param = new BoardVO();
	param.setIboard(iboard);
	
	BoardVO result = BoardDAO.selBoard(param);
	PrintWriter pw = response.getWriter();
	Gson gson  = new Gson();
	String json = gson.toJson(result);
	pw.append(json);
	

	
	}

}
