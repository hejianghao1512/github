package com.zucc.hjh.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zucc.hjh.model.*;
import com.zucc.hjh.Dao.UserDao;

/**
 * Servlet implementation class TLoginServlet
 */
public class TLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TLoginServlet() {
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
		String T_username = request.getParameter("T_username");
		String T_password = request.getParameter("T_password");
		UserDao userDao = new UserDao();
		Tuser tuser = userDao.Tlogin(T_username, T_password);
		if(tuser!=null){
			request.getSession().setAttribute("tuser", tuser);
			request.getRequestDispatcher("T_message.jsp").forward(request, response);
		}else{
			request.setAttribute("info", "用户名或密码错误");
			request.getRequestDispatcher("Tlogin.jsp").forward(request, response);
		}
	}

}
