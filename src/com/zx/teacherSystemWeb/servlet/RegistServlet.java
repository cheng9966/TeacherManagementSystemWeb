package com.zx.teacherSystemWeb.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zx.teacherSystemWeb.controller.AccountController;
import com.zx.teacherSystemWeb.flection.Resource;
import com.zx.teacherSystemWeb.util.AccountFactory;

/**
 * 注册Servlet
 * 
 * @author zhouxin
 *
 */
public class RegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Resource(value = "controller.AccountController")
	private static AccountController controller;
	
	public RegistServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String password = request.getParameter("password");
		String account = AccountFactory.createAccount();

		boolean result = controller.register(account, password);
		if (result) {
			response.getWriter().append(account);
		} else {
			response.getWriter().append("" + result);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
