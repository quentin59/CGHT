package hei.projetiti.dao.impl;

import javax.sql.DataSource;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class DataSourceProvider {

	private static MysqlDataSource dataSource;

	public static DataSource getDataSource() {
		if (dataSource == null) {
			dataSource = new MysqlDataSource();
			dataSource.setServerName("localhost");
			dataSource.setPort(3306);
			dataSource.setDatabaseName("projetiti");
			dataSource.setUser("root");
			dataSource.setPassword("");
			dataSource.setEncoding("UTF-8");
		}
		return dataSource;
	}
}
