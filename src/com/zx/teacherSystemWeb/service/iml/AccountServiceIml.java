package com.zx.teacherSystemWeb.service.iml;

import com.zx.teacherSystemWeb.dao.base.EntityDao;
import com.zx.teacherSystemWeb.entity.Account;
import com.zx.teacherSystemWeb.flection.Resource;
import com.zx.teacherSystemWeb.service.AccountService;

public class AccountServiceIml implements AccountService {
	@Resource(value = "dao.base.EntityDao")
	private static EntityDao dao;

	@Override
	public boolean login(String account, String password) {
		String condition = "";
		if (account != null && !account.isEmpty()) {
			condition += " and account='" + account + "'";
		}
		if (password != null && !password.isEmpty()) {
			condition += " and password='" + password + "'";
		}
		if (condition.equals("")) {
			return false;
		}

		Account account2 = dao.getEntityByCondition(condition, Account.class);
		if (account2 == null)
			return false;

		return true;
	}

	@Override
	public boolean regist(String username, String password) {
		Account account = new Account();
		account.setAccount(username);
		account.setPassword(password);

		int result = dao.saveEntity(account, Account.class);
		if (result > 0)
			return true;
		return false;
	}
}
