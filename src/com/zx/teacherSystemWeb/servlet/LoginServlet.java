package com.zx.teacherSystemWeb.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zx.teacherSystemWeb.controller.AccountController;
import com.zx.teacherSystemWeb.flection.Resource;

/**
 * 登录Servlet
 * 
 * @author zhouxin
 *
 */
// @WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Resource(value = "controller.AccountController")
	private static AccountController controller;
	
	public LoginServlet() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String account = request.getParameter("username");
		System.out.println("账号" + account);
		String password = request.getParameter("password");
		System.out.println("密码" + password);

		controller.test();
		boolean result = controller.login(account, password);
		response.getWriter().append(result + "");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
