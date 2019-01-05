package com.example.asus.appdulich;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public  class MainActivity extends AppCompatActivity {

    ConnectionDb connectionDb = new ConnectionDb();
    Button loginCty, loginHDV, loginKhach;
    EditText username, password;
    ProgressBar progressBar;
    TextView dk;



    Connection conn;
    String un, pass, db,ip;
    int a;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loginCty = (Button)findViewById(R.id.btnCty);
        loginHDV = (Button)findViewById(R.id.btnHDV);
        loginKhach = (Button)findViewById(R.id.btnKhach);
        username = (EditText)findViewById(R.id.username);
        password = (EditText)findViewById(R.id.password);
        progressBar=(ProgressBar)findViewById(R.id.progressBar);
        dk = (TextView) findViewById(R.id.txtdangki);
        progressBar.setVisibility(View.GONE);
        un="sa";
        pass="1";
        db="ANDROID";
        ip="192.168.1.111";




        loginCty.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                a=1;
                CheckLogin checkLogin = new CheckLogin();
                checkLogin.execute("");

            }
        });

        loginKhach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                a=2;
                CheckLogin checkLogin = new CheckLogin();
                checkLogin.execute("");

            }
        });

        loginHDV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                a=3;
                CheckLogin checkLogin = new CheckLogin();
                checkLogin.execute("");

            }
        });

        dk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, DangKi.class);
                startActivity(intent);
            }
        });
    }

    public class CheckLogin extends AsyncTask<String,String,String> {
        String z ="";
        Boolean isSuccess = false;

        @Override
        protected void onPreExecute(){
            progressBar.setVisibility(View.VISIBLE);
        }

        @Override
        protected String doInBackground(String... strings) {
            String query = null;
            String usernam = username.getText().toString();
            String passwordd = password.getText().toString();
            switch (a){
                case 1:
                    query  = "select * from CongTy where SDT =" +usernam+"and pass="+passwordd;
                    break;
                case 2:
                    query  = "select * from KhachHang where SDT =" +usernam+"and password="+passwordd;
                    break;
                case 3:
                    query  = "select * from HDVDL where SDT =" +usernam+"and password="+passwordd;
                    break;
            }
            if (usernam.trim().equals("") || passwordd.trim().equals("")) {
                z = "vui long nhap ten dang nhap va mat khau";
            } else {
                try {
                    conn = connectionDb.connectionclass(un, pass, db, ip);
                    if (conn == null) {
                        z = "vui long kiem tra ket noi";
                    } else {

                        Statement stmt = conn.createStatement();
                        ResultSet rs = stmt.executeQuery(query);
                        if (rs.next()) {
                            z = "Dang nhap thanh cong";
                            isSuccess = true;
                            conn.close();
                        } else {
                            z = "nguoi dung khong ton tai";
                            isSuccess = false;
                        }
                    }
                } catch (Exception ex) {
                    isSuccess = false;
                    z = ex.getMessage();
                }
            }
            return z;
        }
        protected void onPostExecute(String s) {
            progressBar.setVisibility(View.GONE);
            Toast.makeText(MainActivity.this,s,Toast.LENGTH_SHORT).show();
            if(isSuccess){
                Toast.makeText(MainActivity.this,"Dang nhap thanh cong",Toast.LENGTH_LONG).show();
            }
        }
        }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }
}
