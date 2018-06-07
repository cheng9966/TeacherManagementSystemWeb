package com.zx.teacherSystemWeb.service;

public interface AccountService {
	public boolean login(String account, String password);

	public boolean regist(String account, String password);
}
