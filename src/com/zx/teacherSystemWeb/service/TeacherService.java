package com.zx.teacherSystemWeb.service;

import java.util.List;
import java.util.Map;

import com.zx.teacherSystemWeb.entity.Teacher;

public interface TeacherService {
	public int addTeacher(Teacher teacher);

	public List<Map<String, Object>> getTeachers(Teacher teacher);

	public List<Teacher> getTeacher(Teacher teacher);

	public int deleteTeachers(Integer[] ids);

	public int updateTeacher(Teacher teacher, Integer id);
}
