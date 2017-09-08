package com.zucc.hjh.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zucc.hjh.Dao.UserDao;

/**
 * Servlet implementation class SUpdateServlet
 */
public class SUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SUpdateServlet() {
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
		String JS_password = request.getParameter("JS_password");
		String NS_password = request.getParameter("NS_password");
		String S_password = request.getParameter("S_password");
		
		UserDao userDao = new UserDao();
		if(NS_password.equals(S_password)&&NS_password!=null&&S_username!=null){
			
			userDao.Supdate(S_username, S_password);
			request.setAttribute("info", "修改成功");
		}
		else{
			request.setAttribute("info", "修改失败");
		}
		request.getRequestDispatcher("S_up.jsp").forward(request, response);
	}

}
