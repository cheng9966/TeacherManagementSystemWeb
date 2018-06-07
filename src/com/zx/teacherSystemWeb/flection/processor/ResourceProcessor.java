package com.zx.teacherSystemWeb.flection.processor;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

import com.zx.teacherSystemWeb.controller.AccountController;
import com.zx.teacherSystemWeb.controller.TeacherController;
import com.zx.teacherSystemWeb.flection.Resource;
import com.zx.teacherSystemWeb.service.iml.AccountServiceIml;
import com.zx.teacherSystemWeb.service.iml.TeacherServiceIml;
import com.zx.teacherSystemWeb.servlet.*;

/**
 * Resource处理器
 * 
 * @author zhouxin
 *
 */
public class ResourceProcessor {

	public ResourceProcessor() {
		System.out.println("Resource注解处理器");
		init(AccountServiceIml.class);
		init(TeacherServiceIml.class);
		init(AccountController.class);
		init(TeacherController.class);
		init(LoginServlet.class);
		init(RegistServlet.class);
		init(TableServlet.class);
		init(AddServlet.class);
		init(DeleteServlet.class);
		init(SearchServlet.class);
	}

	/** Resource处理器初始方法，注入对象 */
	private void init(Class<?> clazz) {
		// 取得所有对象的描述对象
		Field[] fields = clazz.getDeclaredFields();

		if (fields == null) { // 如果方法里面么有属性，就直接结束
			System.out.println(clazz.getName() + "没有属性");
			return;
		}

		for (Field field : fields) {
			// 获取每个字段上面的所有注解
			Annotation[] annotations = field.getAnnotations();
			System.out.println(field.getName() + "有" + annotations.length + "个注解");
			for (Annotation annotation : annotations) {
				// 判断注解是不是Resource类型
				if (annotation.annotationType() == Resource.class) {
					System.out.println("yes");
					// 通过Resource的value获取要使用的beanName
					String beanName = ((Resource) annotation).value();
					// 生成一个指定的ServiceIml的对象
					try {
						Class<?> cc = Class.forName("com.zx.teacherSystemWeb." + beanName);
						Object ob = cc.newInstance();
						// 设置让私有属性能被修改
						field.setAccessible(true);
						// 通过set方法将新建的实例对象赋值给private EntityDao dao
						field.set(null, ob);
						System.out.println("注入" + cc.getName() + "成功");
					} catch (ClassNotFoundException e) {
						System.out.println("找不到" + "com.zx.teacherSystemWeb." + beanName);
						e.printStackTrace();
					} catch (InstantiationException e) {
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
}
