package com.masgb.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.masgb.dao.UserDAO1;
import com.masgb.model.User;


/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		HttpSession session=request.getSession();
		UserDAO1 udao=new UserDAO1();
		String username=request.getParameter("jusername");
		String pwd=request.getParameter("jpwd");
		User us=udao.userLogin(pwd, username);
		String name="no";
		if(us!=null)
		{
			name=username;
			session.setAttribute("loginState","yes");
			session.setAttribute("username",name);
		}
		else
		{
			session.setAttribute("loginState","no");
		}
		response.getWriter().write(name);
	}

}
