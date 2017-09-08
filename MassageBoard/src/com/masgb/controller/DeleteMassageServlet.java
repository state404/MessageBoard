package com.masgb.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.masgb.dao.MassageDAO1;

/**
 * Servlet implementation class DeleteMassageServlet
 */
@WebServlet("/delmasg")
public class DeleteMassageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MassageDAO1 mdao=new MassageDAO1();
		int id=Integer.parseInt(request.getParameter("id"));
		mdao.delMasgById(id);
		response.getWriter().println("<script>alert('delete success');</script>") ;
		response.setHeader("refresh", "0;URL=home");
	}

}
