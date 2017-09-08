package com.zucc.hjh.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import com.zucc.hjh.Dao.UserDao;

/**
 * Servlet implementation class Update
 */
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
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
		String JT_password = request.getParameter("JT_password");
		String NT_password = request.getParameter("NT_password");
		String T_password = request.getParameter("T_password");
		
		UserDao userDao = new UserDao();
		if(NT_password.equals(T_password)&&NT_password!=null&&T_username!=null){
			
			userDao.Tupdate(T_username, NT_password);
			request.setAttribute("info", "修改成功");
		}
		else{
			request.setAttribute("info", "修改失败");
		}
		request.getRequestDispatcher("T_up.jsp").forward(request, response);
	}

}
