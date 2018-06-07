package com.zx.teacherSystemWeb.flection;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 行注解
 *
 * @author zhouxin
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Column {
	/** 获取数据库中列名 */
	public String value() default "";

	/** 属性对应的类型 */
	public String type() default "";
}
