package com.zx.teacherSystemWeb.servlet;

import com.zx.teacherSystemWeb.controller.TeacherController;
import com.zx.teacherSystemWeb.entity.Teacher;
import com.zx.teacherSystemWeb.flection.Resource;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class AddServlet extends HttpServlet {
    @Resource(value = "controller.TeacherController")
    private static TeacherController controller;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String teacherName = request.getParameter("teacherName");
        String teacherBirthday = request.getParameter("teacherBirthday");
        String teacherSex = request.getParameter("teacherSex");
        String teacherSalary = request.getParameter("teacherSalary");
        String teacherEmail = request.getParameter("teacherEmail");
        String teacherType = request.getParameter("teacherType");
        String teacherLevel = request.getParameter("teacherLevel");
        String teacherAddress = request.getParameter("teacherAddress");
        String remark = request.getParameter("remark");

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Teacher teacher = null;
        try {
            teacher = new Teacher(teacherName, format.parse(teacherBirthday), teacherSex, Double.valueOf(teacherSalary), teacherEmail, teacherType, teacherLevel, teacherAddress, remark);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        int result = controller.addTeacher(teacher);
        if (result > 0)
            response.getWriter().append("true");
        else
            response.getWriter().append("false");
    }
}
