package com.zx.teacherSystemWeb.servlet;

import com.zx.teacherSystemWeb.controller.TeacherController;
import com.zx.teacherSystemWeb.flection.Resource;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebServlet(name = "DeleteServlet")
public class DeleteServlet extends HttpServlet {
    @Resource(value = "controller.TeacherController")
    private static TeacherController controller;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ids = request.getParameter("ids");
        String teacherIds[] = ids.split(",");

        Integer[] idParams = new Integer[teacherIds.length];
        int i = 0;
        for (String id : teacherIds) {
            idParams[i++] = Integer.valueOf(id);
        }
        int result = controller.deleteTeacher(idParams);
        response.getWriter().append("true");
    }
}
