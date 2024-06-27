package com.basecamp.contactmanager;

import java.sql.Connection;
import java.sql.Statement;

public class DBTables {
    public void createTable(Connection conn, String table_name){
        Statement statement;
        try{
            String query = "create table "+table_name+"(contactID SERIAL,name varchar(200),phone varchar(200), email varchar(200), address varchar(200) primary key(empid));";
            statement = conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Table Created");
        }catch(Exception e){
            System.out.println(e);
        }
    }
    public void insert_row(Connection conn, String table_name, String name, String address){
        Statement statement;
        try{
            String query = String.format("insert into %s(name, address) values('%s','%s');", table_name, name, address);
            statement=conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Row Inserted");
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
