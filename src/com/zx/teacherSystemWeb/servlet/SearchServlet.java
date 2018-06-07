package com.zx.teacherSystemWeb.servlet;

import com.zx.teacherSystemWeb.controller.TeacherController;
import com.zx.teacherSystemWeb.entity.Teacher;
import com.zx.teacherSystemWeb.flection.Resource;
import net.sf.json.JSON;
import net.sf.json.JSON;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class SearchServlet extends HttpServlet {
    @Resource(value = "controller.TeacherController")
    private static TeacherController controller;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String teacherName = request.getParameter("teacherName");
        Teacher teacher = new Teacher();
        teacher.setTeacherName(teacherName);
        List<Map<String, Object>> teachers = controller.getTeachers(teacher);

        if (teachers == null) {
            response.getWriter().append("false");
        } else {
            response.setCharacterEncoding("utf-8");
            response.getWriter().append(JSONArray.fromObject(teachers).toString());
        }
    }
}
