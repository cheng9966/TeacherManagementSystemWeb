package com.zx.teacherSystemWeb.entity.base;

import java.io.Serializable;

public abstract class Entity implements Serializable {
	private static final long serialVersionUID = 1L;

	/** 返回表名 */
	public abstract String getTableName();
}
