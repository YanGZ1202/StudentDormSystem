package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dbutil {
    //连接数据库
    private String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private String DB_URL = "jdbc:mysql://localhost:3306/db_dorm?useUnicode=true&characterEncoding=utf8&useSSL=false&serverTimezone=Asia/Shanghai";
    private String USER = "root";
    private String PASS = "ykf971245";

    //连接数据库函数
    public Connection getCon() throws ClassNotFoundException, SQLException {
        Class.forName(JDBC_DRIVER);
        Connection con = DriverManager.getConnection(DB_URL,USER,PASS);
        return con;
    }

    //断开数据库函数
    public void closeCon(Connection con) throws SQLException {
        if(con != null){
            con.close();
        }
    }
}
