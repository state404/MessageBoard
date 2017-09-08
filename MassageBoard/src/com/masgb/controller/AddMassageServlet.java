package com.masgb.controller;

import java.io.IOException;
import java.util.Date;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.masgb.dao.MassageDAO1;
import com.masgb.dao.UserDAO1;
import com.masgb.model.Massage;
import com.masgb.util.MyTools;
import com.masgb.util.UpAndDown;

/**
 * Servlet implementation class AddMassageServlet
 */
@WebServlet("/addmasg")
@MultipartConfig(maxFileSize = 10 * 1024 *1024)
public class AddMassageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		ServletContext ctx = request.getServletContext();
		String basePath = ctx.getRealPath("/static/upload");
		Map<String, String> map = UpAndDown.upload(basePath, request, response);
		HttpSession session =request.getSession();
		UserDAO1 udao=new UserDAO1();
		MassageDAO1 mdao=new MassageDAO1();
		String username=(String) session.getAttribute("username");
		String title=UpAndDown.getparamter(map, "title");
		String content=UpAndDown.getparamter(map, "content");
		Massage massage=new Massage();
		massage.setContentText(content);
		massage.setPic(UpAndDown.getparamter(map,"photos"));
		Date date = new Date();
		massage.setTime(date.getTime());
		massage.setShowTime(MyTools.getTimeByNum(date.getTime()));
		massage.setUser(udao.findUserByUName(username));
		massage.setTitle(title);
		mdao.insertMasg(massage);
		response.getWriter().println("<script>alert('Message success');</script>") ;
		response.setHeader("refresh", "1;URL=home");
	}

}
