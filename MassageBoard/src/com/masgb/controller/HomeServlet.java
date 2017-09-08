package com.masgb.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.masgb.dao.MassageDAO1;
import com.masgb.model.Massage;
import com.masgb.model.Page;
import com.masgb.util.MyTools;

/**
 * Servlet implementation class HomeServlet
 */
@WebServlet("/home")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		HttpSession session =request.getSession();
		if(session.getAttribute("loginState")==null)
		{
			session.setAttribute("loginState", "no");
		}
		MassageDAO1 mdao=new MassageDAO1();
		int nowPage= request.getParameter("nPage")==null? 1:Integer.parseInt(request.getParameter("nPage"));
		int startId=(nowPage-1)*3;
		ArrayList<Massage> list=mdao.splitMassage(3, startId);
		request.setAttribute("mlist", list);
		Page page=MyTools.getPage("home", nowPage,3, mdao.getMassageNum());
		request.setAttribute("page", page);
		request.getRequestDispatcher("view/home.jsp").forward(request, response);
	}


}
