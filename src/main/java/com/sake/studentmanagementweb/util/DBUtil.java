package com.sake.studentmanagementweb.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtil {

    public static final Properties props = new Properties();
    static {
        try(InputStream in = DBUtil.class.getClassLoader().getResourceAsStream("db.properties")){
            props.load(in);
        } catch (IOException e) {
            throw new RuntimeException("读取db.properties失败",e);
        }
    }

    public static Connection getConnection() throws SQLException{
        return DriverManager.getConnection(
                props.getProperty("jdbc.url"),
                props.getProperty("jdbc.user"),
                props.getProperty("jdbc.password")
        );
    }
}
