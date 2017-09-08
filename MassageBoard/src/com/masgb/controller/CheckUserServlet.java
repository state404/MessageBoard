package com.masgb.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.masgb.dao.UserDAO1;
import com.masgb.model.User;


/**
 * Servlet implementation class CheckUserServlet
 */
@WebServlet("/checkuser")
public class CheckUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		UserDAO1 udao=new UserDAO1();
		String username=request.getParameter("username");
		User us=udao.findUserByUName(username);
		String checkState="no";
		if(us!=null)
		{
			checkState="yes";
		}
		response.getWriter().write(checkState);
	}

}
