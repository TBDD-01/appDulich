package com.example.asus.appdulich;

import android.annotation.SuppressLint;
import android.os.StrictMode;

import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDb {
    int a;
    @SuppressLint("NewAPi")
    public java.sql.Connection connectionclass() throws SQLException, ClassNotFoundException {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        //Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        Class.forName("net.sourceforge.jtds.jdbc.Driver");
        String ConnectionURL ="jdbc:jtds:sqlserver://10.0.113.110/ANDROID;user=sa;password=1";
        java.sql.Connection connection =DriverManager.getConnection(ConnectionURL);
        return connection;
    }
}
