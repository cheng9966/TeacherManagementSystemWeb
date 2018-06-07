package com.zx.teacherSystemWeb.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zx.teacherSystemWeb.controller.TeacherController;
import com.zx.teacherSystemWeb.entity.Teacher;
import com.zx.teacherSystemWeb.flection.Resource;

import net.sf.json.JSONArray;

public class TableServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Resource(value="controller.TeacherController")
	private static TeacherController controller;
       
    public TableServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Map<String, Object>> teachers = controller.getTeachers(new Teacher());
		JSONArray jsonArray = JSONArray.fromObject(teachers);
 		System.out.println(jsonArray);
		
 		response.setCharacterEncoding("UTF-8");
		response.getWriter().append(jsonArray.toString());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
