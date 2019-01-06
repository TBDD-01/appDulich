package com.example.asus.appdulich.conn;

import android.annotation.SuppressLint;
import android.os.StrictMode;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDb {

    @SuppressLint("NewAPi")
    public java.sql.Connection connectionclass() throws SQLException, ClassNotFoundException {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
//        Connection conn = null;
        //Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        Class.forName("net.sourceforge.jtds.jdbc.Driver");
        String ConnectionURL ="jdbc:jtds:sqlserver://192.168.0.108/DuLich;user=sa;password=sa";
        Connection conn =DriverManager.getConnection(ConnectionURL);
        return conn;
    }




}
