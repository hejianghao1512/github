package com.zucc.hjh.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zucc.hjh.Dao.UserDao;
import com.zucc.hjh.model.Cores;
import com.zucc.hjh.model.Suser;

/**
 * Servlet implementation class AddServlet
 */
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddServlet() {
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
		String cNo = request.getParameter("cNo");		
		String coresname = request.getParameter("coresname");
		String credit = request.getParameter("credit");
		UserDao userDao = new UserDao();
		Cores  cores =null;
		if(cNo!=null&&!cNo.isEmpty()){	
			if(userDao.coresExist(cNo)){
				cores = new Cores();
				cores.setcNo(cNo);
				cores.setCoresname(coresname);
				cores.setCredit(credit);
				userDao.coresSave(cores);	
				
				
			}
		}
		List<List> list =userDao.coresinfo();
		request.getSession().setAttribute("list",list);
		request.getRequestDispatcher("addcores.jsp").forward(request, response);
	}

}
