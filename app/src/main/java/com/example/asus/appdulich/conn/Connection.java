package com.example.asus.appdulich.conn;

import android.annotation.SuppressLint;
import android.os.StrictMode;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Connection {
    java.sql.Connection conn;
    String un, pass, db,ip;

    @SuppressLint("NewAPi")
    public java.sql.Connection connectionclass(String user, String passwordd, String database, String ipp) throws SQLException, ClassNotFoundException {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        //Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        Class.forName("net.sourceforge.jtds.jdbc.Driver");
        String ConnectionURL ="jdbc:jtds:sqlserver://170.20.10.2/dulich;user=sa;password=1";
        java.sql.Connection connection =DriverManager.getConnection(ConnectionURL);
        return connection;
    }




}
