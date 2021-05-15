package com.house.party;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.house.people.PeopleVO;
import com.house.utils.MyUtils;

@WebServlet("/houseparty")
public class HousPartyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<PeopleVO> td_list = AllListDAO.TDselListall();
		request.setAttribute("td_list", td_list);
		MyUtils.openJSP("board/houseparty", request, response);
		// String jsp = "/WEB-INF/board/tableCT.jsp";
//		request.getRequestDispatcher(jsp).forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("uid");

		PeopleVO vo = new PeopleVO();
		vo.setNm(id);
		
		AllListDAO.addTdList(vo);
		response.sendRedirect("/houseparty");

	}

}
