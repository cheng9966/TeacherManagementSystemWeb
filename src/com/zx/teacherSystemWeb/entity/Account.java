package com.zx.teacherSystemWeb.entity;

import com.zx.teacherSystemWeb.entity.base.Entity;
import com.zx.teacherSystemWeb.flection.Column;

@SuppressWarnings("serial")
public class Account extends Entity {
	@Column(value = "id", type = "Integer")
	private Integer id;
	@Column(value = "account", type = "String")
	private String account;
	@Column(value = "password", type = "String")
	private String password;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String getTableName() {
		return "account";
	}
}
