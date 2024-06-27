package com.basecamp.contactmanager;
import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        DbFunctions db = new DbFunctions();
        Connection conn = db.getConnection();
        //db.createTable(conn, "employee");
//        db.insert_row(conn, "employee", "Joshua", "Mississippi");
    }
}
