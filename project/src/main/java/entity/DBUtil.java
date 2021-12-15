package entity;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


import java.sql.Connection;
        import java.sql.DriverManager;
        import java.sql.SQLException;

//public class DBUtil {
//
////    public static Connection connect () throws SQLException {
////        return DriverManager.getConnection("jdbc:mysql://localhost:3306/workshop2?useSSL=false&characterEncoding=utf8&serverTimezone=UTC", "root", "coderslab");
////        return DriverManager.getConnection("jdbc:mysql://localhost:3306/workshop2?useSSL=false&characterEncoding=utf8&serverTimezone=UTC", "coderslab", "1");
////    }
//}
 public class DBUtil {
    private static DataSource dataSource;

//    Connection conn = DbUtil.getConnection();

    public static Connection connect() throws SQLException {
        return getInstance().getConnection();   }
    private static DataSource getInstance() {
        if (dataSource == null) {
            try {
                Context initContext = new InitialContext();
                Context envContext = (Context)initContext.lookup("java:/comp/env");
                dataSource = (DataSource)envContext.lookup("jdbc/users");
            } catch (NamingException e) { e.printStackTrace(); }
        }
        return dataSource;
    }
}
