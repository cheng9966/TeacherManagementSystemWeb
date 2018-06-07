package com.zx.teacherSystemWeb.controller;

import java.util.List;
import java.util.Map;

import com.zx.teacherSystemWeb.entity.Teacher;
import com.zx.teacherSystemWeb.flection.Resource;
import com.zx.teacherSystemWeb.service.TeacherService;

public class TeacherController {
	@Resource(value = "service.iml.TeacherServiceIml")
	private static TeacherService service;

	/**
	 * 新增一个老师
	 * 
	 * @param teacher
	 * @return
	 * @author zhouxin
	 */
	public int addTeacher(Teacher teacher) {
		return service.addTeacher(teacher);
	}

	/**
	 * 获取到所有老师信息
	 * 
	 * @return
	 * @author zhouxin
	 */
	public List<Map<String, Object>> getTeachers(Teacher teacher) {
		return service.getTeachers(teacher);
	}

	/**
	 * 根据老师的某些信息查询
	 * 
	 * @param teacher
	 * @return
	 * @author zhouxin
	 */
	public List<Teacher> getTeacher(Teacher teacher) {
		return service.getTeacher(teacher);
	}

	/**
	 * 根据主键来更改老师的信息
	 * 
	 * @param teacher
	 *            更改的老师信息
	 * @param id
	 *            主键
	 * @return
	 * @author zhouxin
	 */
	public int updateTeacher(Teacher teacher, Integer id) {
		return service.updateTeacher(teacher, id);
	}

	/**
	 * 根据主键删除老师，可以同时删除多个，也可只删除一个
	 * 
	 * @param ids
	 *            主键的数组
	 * @return
	 */
	public int deleteTeacher(Integer[] ids) {
		return service.deleteTeachers(ids);
	}
}
