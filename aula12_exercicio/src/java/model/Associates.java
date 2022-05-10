/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.sql.*;

/**
 *
 * @author Fatec
 */
public class Associates {
    private int id;
    private String name;

    
    public static ArrayList<Associates> getList() throws Exception{
     ArrayList<Associates> list = new ArrayList<>();
     Class.forName("org.sqlite.JDBC");
     String url = "jdbc:sqlite:C:\\Users\\Fatec\\chinook\\chinook.db";
     Connection con = DriverManager.getConnection(url);
     Statement stat = con.createStatement();
     String query = "SELECT CustomerId,FirstName||' '||LastName name FROM customers order by FirstName;";
     ResultSet rs = stat.executeQuery(query);
     while(rs.next()){
         int id = rs.getInt("CustomerId");
         String name = rs.getString("name");
         Associates a = new Associates(id, name);
         list.add(a);
     }
     rs.close();
     stat.close();
     con.close();
    return list;
    }
    
     public static ArrayList<Associates> getList_funcionarios() throws Exception{
     ArrayList<Associates> list = new ArrayList<>();
     Class.forName("org.sqlite.JDBC");
     String url = "jdbc:sqlite:C:\\Users\\Fatec\\chinook\\chinook.db";
     Connection con = DriverManager.getConnection(url);
     Statement stat = con.createStatement();
     String query = "SELECT employeeID,FirstName||' '||LastName name FROM employees order by FirstName;";
     ResultSet rs = stat.executeQuery(query);
     while(rs.next()){
         int id = rs.getInt("employeeID");
         String name = rs.getString("name");
         Associates a = new Associates(id, name);
         list.add(a);
     }
     rs.close();
     stat.close();
     con.close();
    return list;
    }
    
    
    public Associates(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
    
}
