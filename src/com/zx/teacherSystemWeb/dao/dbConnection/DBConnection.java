package com.zx.teacherSystemWeb.dao.dbConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 连接到数据库的类
 *
 * @author zhouxin
 */
public class DBConnection {
	private static Connection connection = null;

	public static Connection getConnection() {
		if (connection != null) {
			return connection;
		}

		try {
			System.out.println("开始加载驱动......");
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("驱动加载成功\n开始连接数据库......");
			String url = "jdbc:mysql://127.0.0.1:3306/teacher?useUnicode=true&characterEncoding=UTF-8&useSSL=true&serverTimezone=GMT%2B8";
			String user = "root";
			String password = "";
			connection = DriverManager.getConnection(url, user, password);
			System.out.println("数据库连接成功......");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("加载驱动失败!");
		} catch (SQLException e) {
		    e.printStackTrace();
			System.out.println("连接数据库失败");
		}

		return connection;
	}
}
