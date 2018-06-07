package com.zx.teacherSystemWeb.controller;

import com.zx.teacherSystemWeb.flection.Resource;
import com.zx.teacherSystemWeb.service.AccountService;

public class AccountController {
	@Resource(value = "service.iml.AccountServiceIml")
	private static AccountService service;

	public void test() {
        System.out.println("controller注册成功");
    }
	
	/**
	 * 登录方法
	 * 
	 * @param account
	 *            账号
	 * @param password
	 *            密码
	 * @return
	 * @author zhouxin
	 */
	public boolean login(String account, String password) {
		return service.login(account, password);
	}

	/**
	 * 注册
	 * 
	 * @param account
	 *            账号
	 * @param password
	 *            密码
	 * @return
	 * @author zhouxin
	 */
	public boolean register(String account, String password) {
		return service.regist(account, password);
	}
}
