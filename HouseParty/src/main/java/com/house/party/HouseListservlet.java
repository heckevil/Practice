package com.house.party;

import java.io.IOException;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.house.people.PeopleVO;
import com.house.utils.MyUtils;


@WebServlet("/houselist")
public class HouseListservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<PeopleVO> all_list = AllListDAO.selListall();
		request.setAttribute("all_list", all_list);
		MyUtils.openJSP("board/houselist", request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nm = request.getParameter("nm");	
	
// 		스트링->정수
		int hno =MyUtils.stringToint("hno", request);
		int idep=MyUtils.stringToint("idep", request);
		
		PeopleVO vo = new PeopleVO();
		vo.setHouse(hno);
		vo.setNm(nm);
		vo.setIdep(idep);
		System.out.println(vo.getHouse());
		System.out.println(vo.getNm());
		System.out.println(vo.getIdep());
		
		AllListDAO.addList(vo);
		
		response.sendRedirect("/houselist");
	}

}
