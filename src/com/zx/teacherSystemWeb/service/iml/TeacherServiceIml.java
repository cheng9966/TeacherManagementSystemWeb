package com.zx.teacherSystemWeb.service.iml;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.zx.teacherSystemWeb.dao.base.EntityDao;
import com.zx.teacherSystemWeb.entity.Teacher;
import com.zx.teacherSystemWeb.flection.Resource;
import com.zx.teacherSystemWeb.service.TeacherService;

public class TeacherServiceIml implements TeacherService {
	@Resource(value = "dao.base.EntityDao")
	private static EntityDao dao;

	@Override
	public int addTeacher(Teacher teacher) {
		int result = dao.saveEntity(teacher, Teacher.class);
		if (result > 0) {
			return result;
		}

		return -1;
	}

	@Override
	public List<Map<String ,Object>> getTeachers(Teacher teacher) {
		List<Teacher> teachers = null;
		String condition = getCondition(teacher);
		teachers = dao.getEntitysByCondition(condition, Teacher.class);

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		if (teachers == null) {
			return null;
		}

		for (Teacher teacher1: teachers) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("id", teacher1.getId());
			map.put("teacherName", teacher1.getTeacherName());
			map.put("teacherBirthday", format.format(teacher1.getTeacherBirthday()));
			map.put("teacherSex", teacher1.getTeacherSex());
			map.put("teacherSalary", teacher1.getTeacherSalary());
			map.put("teacherAddress", teacher1.getTeacherAddress());
			map.put("teacherEmail", teacher1.getTeacherEmail());
			map.put("teacherType", teacher1.getTeacherType());
			map.put("teacherLevel", teacher1.getTeacherLevel());
			map.put("remark", teacher1.getRemark());
			result.add(map);
		}

		return result;
	}

	@Override
	public int deleteTeachers(Integer[] ids) {
		int result = -1;
		result = dao.deleteEntitys(ids, Teacher.class);

		return result;
	}

	@Override
	public List<Teacher> getTeacher(Teacher teacher) {
		String condition = getCondition(teacher);
		List<Teacher> result = dao.getEntitysByCondition(condition, Teacher.class);

		return result;
	}

	@Override
	public int updateTeacher(Teacher teacher, Integer id) {
		String condition = " id=" + id;

		return dao.updateEntityByCondition(teacher, condition, Teacher.class);
	}

	private String getCondition(Teacher teacher) {
		String condition = "";

		if (teacher.getId() != null) {
			condition += " and id=" + teacher.getId();
		}
		if (teacher.getTeacherName() != null && !teacher.getTeacherName().isEmpty()) {
			condition += " and teacher_name='" + teacher.getTeacherName() + "'";
		}
		if (teacher.getTeacherBirthday() != null) {
			condition += " and teacher_birthday='" + teacher.getTeacherBirthday() + "'";
		}
		if (teacher.getTeacherSalary() != null) {
			condition += " and teacher_salary=" + teacher.getTeacherSalary();
		}
		if (teacher.getTeacherSex() != null && !teacher.getTeacherSex().isEmpty()) {
			condition += " and teacher_sex='" + teacher.getTeacherSex() + "'";
		}
		if (teacher.getTeacherAddress() != null && !teacher.getTeacherAddress().isEmpty()) {
			condition += " and teacher_address='" + teacher.getTeacherAddress() + "'";
		}
		if (teacher.getTeacherEmail() != null && !teacher.getTeacherEmail().isEmpty()) {
			condition += " and teacher_email='" + teacher.getTeacherEmail() + "'";
		}
		if (teacher.getTeacherType() != null && !teacher.getTeacherType().isEmpty()) {
			condition += " and teacher_type='" + teacher.getTeacherType() + "'";
		}
		if (teacher.getTeacherLevel() != null && !teacher.getTeacherLevel().isEmpty()) {
			condition += " and teacher_level='" + teacher.getTeacherLevel() + "'";
		}
		if (teacher.getRemark() != null && !teacher.getRemark().isEmpty()) {
			condition += " and remark='" + teacher.getRemark() + "'";
		}

		return condition;
	}
}
