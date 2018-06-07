package com.zx.teacherSystemWeb.util;

/**
 * 账户工厂
 * 
 * @author zhouxin
 *
 */
public class AccountFactory {

	/**
	 * 产生不重复的账户account
	 * 
	 * @return account
	 */
	public static String createAccount() {
		String account = System.currentTimeMillis() + "";
		
		return account.substring(5);
	}
}
