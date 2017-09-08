package com.zucc.hjh.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zucc.hjh.model.*;
import com.zucc.hjh.Dao.UserDao;

/**
 * Servlet implementation class SLoginServlet
 */
@WebServlet("/SRegServlet")
public class SRegServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public SRegServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String S_username = request.getParameter("S_username");
		String S_password = request.getParameter("S_password");
		String S_num = request.getParameter("S_num");
		String S_name = request.getParameter("S_name");
		String S_class = request.getParameter("S_class");
		String S_sex = request.getParameter("S_sex");
		
		UserDao userDao = new UserDao();	
		if(S_username!=null&&!S_username.isEmpty()){			
			if(userDao.S_userExist(S_username)){
				Suser suser = new Suser();
				suser.setS_username(S_username);
				suser.setS_password(S_password);
				suser.setS_num(S_num);
				suser.setS_name(S_name);
				suser.setS_class(S_class);
				suser.setS_sex(S_sex);
				userDao.SsaveUser(suser);
				request.setAttribute("info", "恭喜，注册成功<br>");	
			}else{
				request.setAttribute("info","此用户名已存在");
			}
		}
		request.getRequestDispatcher("Slogin.jsp").forward(request, response);
	}

}
