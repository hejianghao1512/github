package com.zucc.hjh.Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zucc.hjh.Dao.UserDao;
import com.zucc.hjh.model.TakeCores;

/**
 * Servlet implementation class ChooseServlet
 */
public class ChooseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChooseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cNo=request.getParameter("id");
		UserDao userDao = new UserDao();
		TakeCores takeCores = userDao.take(cNo);
		userDao.saveTakeCores(takeCores);
		List<List> list =userDao.takecores();
		request.getSession().setAttribute("he",list);
		request.getRequestDispatcher("choose.jsp").forward(request, response);
	}

}
