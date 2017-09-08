package com.zucc.hjh.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zucc.hjh.model.*;
import com.zucc.hjh.Dao.UserDao;

/**
 * Servlet implementation class TregServlet
 */
public class TregServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TregServlet() {
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
		String T_num = request.getParameter("T_num");
		String T_name = request.getParameter("T_name");
		System.out.println(T_name);
		String T_class = request.getParameter("T_class");
		String T_sex = request.getParameter("T_sex");
		UserDao userDao = new UserDao();	
		if(T_username!=null&&!T_username.isEmpty()){			
			if(userDao.T_userExist(T_username)){
				Tuser tuser = new Tuser();
				tuser.setT_username(T_username);
				tuser.setT_password(T_password);
				tuser.setT_num(T_num);
				tuser.setT_name(T_name);
				tuser.setT_sex(T_sex);
				userDao.TsaveUser(tuser);
				request.setAttribute("info", "恭喜，注册成功<br>");	
			}else{
				request.setAttribute("info","此用户名已存在");
			}
		}
		request.getRequestDispatcher("Tlogin.jsp").forward(request, response);
	}

}
