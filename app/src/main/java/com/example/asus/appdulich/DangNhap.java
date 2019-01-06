package com.example.asus.appdulich;


import android.content.Intent;
import android.os.AsyncTask;
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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public  class DangNhap extends AppCompatActivity {

    ConnectionDb connectionDb = new ConnectionDb();
    Button loginCty, loginHDV, loginKhach;
    EditText username, password;
    ProgressBar progressBar;
    TextView dk;



    Connection conn;

    int a;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dangnhap);
        loginCty = (Button)findViewById(R.id.btnCty);
        loginHDV = (Button)findViewById(R.id.btnHDV);
        loginKhach = (Button)findViewById(R.id.btnKhach);
        username = (EditText)findViewById(R.id.username);
        password = (EditText)findViewById(R.id.password);
        progressBar=(ProgressBar)findViewById(R.id.progressBar);
        dk = (TextView) findViewById(R.id.txtdangki);
        progressBar.setVisibility(View.GONE);





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
                Intent intent = new Intent(DangNhap.this, DangKi.class);
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
            String usernam1 = username.getText().toString();
            String passwordd1 = password.getText().toString();
            switch (a){
                case 1:
                    query  = "select * from CongTy where SDT =" +usernam1+"and pass="+passwordd1;
                    break;
                case 2:
                    query  = "select * from KhachHang where SDT =" +usernam1+"and password="+passwordd1;
                    break;
                case 3:
                    query  = "select * from HDVDL where SDT =" +usernam1+"and password="+passwordd1;
                    break;
            }
            if (usernam1.trim().equals("") || passwordd1.trim().equals("")) {
                z = "Vui lòng nhập tên đăng nhập và mật khẩu";
            } else {
                try {
                    conn = connectionDb.connectionclass();
                    if (conn == null) {
                        z = "Vui lòng kiểm tra kết nối";
                    } else {

                        Statement stmt = conn.createStatement();
                        ResultSet rs = stmt.executeQuery(query);
                        if (rs.next()) {
                            z = "Đăng nhập thành công 1";
                            isSuccess = true;
                            conn.close();
                        } else {
                            z = "Người dùng không tồn tại";
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
            Toast.makeText(DangNhap.this,s,Toast.LENGTH_SHORT).show();
            if(isSuccess){
                Toast.makeText(DangNhap.this,"Đăng nhập thành công ",Toast.LENGTH_LONG).show();

                try {
                    conn = connectionDb.connectionclass();
                   String usernam1 = username.getText().toString();
                   String passwordd1 = password.getText().toString();
                    switch (a){
                        case 1:
                        Statement stmt1 = conn.createStatement();
                         ResultSet rs1 = stmt1.executeQuery("update CongTy set trangthai = 'True' where SDT =" +usernam1+"and pass="+passwordd1);
                         rs1.next();
                        conn.close();
                         break;

                        case 2:
                            Statement stmt2 = conn.createStatement();
                            ResultSet rs2 = stmt2.executeQuery("update KhachHang set trangthai = 'True' where SDT =" +usernam1+"and password="+passwordd1);
                            rs2.next();
                            conn.close();
                            break;

                        case 3:
                            Statement stmt3 = conn.createStatement();
                            ResultSet rs3 = stmt3.executeQuery("update HDVDL set trangthai = 'True' where SDT =" +usernam1+"and password="+passwordd1);
                            rs3.next();
                            conn.close();
                            break;
                       }
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }

                Intent intent = new Intent(DangNhap.this, TrangCaNhan.class);
                startActivity(intent);
           }

        }
        }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }
}
