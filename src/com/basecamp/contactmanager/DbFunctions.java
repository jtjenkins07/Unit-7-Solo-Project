package com.basecamp.contactmanager;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DbFunctions {
    private static final String URL = "jdbc:postgresql://localhost:5432/contactdb";
    private static final String USER = "postgres";
    private static final String PASSWORD = "jenkins662";

    static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException("Connection Failed.", e);
        }
    }
}
//    public static Connection connect_to_db(String dbname, String user, String pass) {
//        Connection conn = null;
//        try {
//            Class.forName("org.postgresql.Driver");
//            conn= DriverManager.getConnection("jdbc:postgresql://localhost:5432/"+dbname, user, pass);
//            if(conn!=null){
//                System.out.println("Connection Established");
//            }else{
//                System.out.println("Connection Failed");
//            }
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//        return conn;
//    }
