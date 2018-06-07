package com.zx.teacherSystemWeb.flection.processor;

/**
 * tomcat监听类，用于在运行时运行Resource注解处理器
 * 
 * @author 周鑫
 *
 */
public class ResourceListener {

	static {
		new ResourceProcessor();
	}
}
