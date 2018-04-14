package payroll.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;

import java.util.ArrayList;
import java.util.Date;
import payroll.pojo.User;

public class DatabaseController {
    public static final String TABLE_USER = "tbluser" ;
    
    private static Connection connection;
    private static final String URL = "jdbc:mysql://localhost/dbpayroll";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "123456789";

    public static boolean connect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
            return true;
        } catch(Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void executeUpdate(String sql, String[] values) throws SQLException {
        if(!connection.isClosed()){
            PreparedStatement st;
            st = connection.prepareStatement(sql);
            for(int i=0; i<values.length; i++) {
                    st.setString((i+1), values[i]);
            }
            st.executeUpdate();
            st.close();
        }
    }

    public static ArrayList<?> executeQuery(String sql, String[]values, String tableName)throws SQLException{
        ArrayList returnData = null;
        if(!connection.isClosed()){
            //---Prepare For Statement---
            PreparedStatement st;
            st = connection.prepareStatement(sql);
            for(int i=0; i<values.length; i++) {
                    st.setString((i+1), values[i]);
            }
            
            //---Executing Query---
            ResultSet rs = st.executeQuery();
            
            //---Making Array List---
            if(tableName.equals(TABLE_USER)){
                returnData = new ArrayList<User>();
                while(rs.next()){
                    String username = rs.getString(1);
                    int jabatan = rs.getInt(2);
                    returnData.add(new User(username, jabatan) );
                }
            }
            st.close();
        }
        return returnData;
    }

    public static boolean close() {
        try {
            connection.close();
            return true;
        }catch(Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
