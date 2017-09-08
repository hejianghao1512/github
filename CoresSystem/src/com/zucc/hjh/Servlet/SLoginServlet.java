package com.zucc.hjh.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zucc.hjh.Dao.UserDao;
import com.zucc.hjh.model.*;

/**
 * Servlet implementation class SLoginServlet
 */
@WebServlet("/SLoginServlet")
public class SLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String S_username = request.getParameter("S_username");		
		String S_password = request.getParameter("S_password");
		UserDao userDao = new UserDao();
		Suser suser = userDao.Slogin(S_username, S_password);
		if(suser!=null){
			request.getSession().setAttribute("suser", suser);
			request.getRequestDispatcher("message.jsp").forward(request, response);
		}else{
			request.setAttribute("info", "用户名或密码错误");
			request.getRequestDispatcher("message.jsp").forward(request, response);
		}
	}

}
