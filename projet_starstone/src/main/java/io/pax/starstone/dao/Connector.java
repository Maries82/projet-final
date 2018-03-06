package io.pax.starstone.dao;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class Connector {
    DataSource dataSource = this.createDataSource();

    DataSource createDataSource() {
        try {
            Context context = new InitialContext();
            dataSource = (DataSource) context.lookup("java:/starstone");
        } catch (NamingException e) {
            MysqlDataSource mysqlDataSource = new MysqlDataSource();
            mysqlDataSource.setUser("root");
            mysqlDataSource.setPassword("");
            mysqlDataSource.setServerName("localhost");
            mysqlDataSource.setDatabaseName("starstone");
            mysqlDataSource.setPort(3306);
            dataSource = mysqlDataSource;
        }
        return dataSource;

    }

    public Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }
}