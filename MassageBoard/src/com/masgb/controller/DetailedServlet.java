package com.masgb.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.masgb.dao.MassageDAO1;
import com.masgb.model.Massage;

/**
 * Servlet implementation class DetailedServlet
 */
@WebServlet("/detailed")
public class DetailedServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MassageDAO1 mdao=new MassageDAO1();
		int id=Integer.parseInt(request.getParameter("id"));
		Massage massage=mdao.getMassageById(id);
		if(massage.getPic()!=null)
		{
			String[] pics=massage.getPic().split(" ");
			request.setAttribute("pics", pics);
		}
		request.setAttribute("masg", massage);
		request.getRequestDispatcher("view/detail.jsp").forward(request, response);
	}

}
