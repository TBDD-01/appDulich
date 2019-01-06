package com.example.asus.appdulich;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class DangKi extends AppCompatActivity{
    ConnectionDb connectionDb = new ConnectionDb();
    Button Cty,kh, hdv;
    EditText ten, usern, passs;
    ProgressBar progressBar;
    int b;

    Connection conn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dangki);
        Cty = (Button)findViewById(R.id.btnCtydk);
        kh = (Button)findViewById(R.id.btnKhachdk);
        hdv = (Button)findViewById(R.id.btnhdvdk);
        progressBar=(ProgressBar)findViewById(R.id.progressBar2);
        ten = (EditText)findViewById(R.id.txtHoTen);
        usern = (EditText)findViewById(R.id.txtusernamedk);
        passs = (EditText)findViewById(R.id.txtpassdk);
        progressBar.setVisibility(View.GONE);

        Cty.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                b=1;
                DangKi.CheckRegistor checkRegistor = new DangKi.CheckRegistor();
                checkRegistor.execute("");
                Intent intent = new Intent(DangKi.this, DangNhap.class);
                startActivity(intent);

            }
        });

        kh.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                b=2;
                DangKi.CheckRegistor checkRegistor = new DangKi.CheckRegistor();
                checkRegistor.execute("");
                Intent intent = new Intent(DangKi.this, DangNhap.class);
                startActivity(intent);

            }
        });

        hdv.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                b=3;
                DangKi.CheckRegistor checkRegistor = new DangKi.CheckRegistor();
                checkRegistor.execute("");

                Intent intent = new Intent(DangKi.this, DangNhap.class);
                startActivity(intent);

            }
        });

    }

    public class CheckRegistor extends AsyncTask<String,String,String> {
        String z ="";
        Boolean isSuccess = false;

        @Override
        protected void onPreExecute(){
            progressBar.setVisibility(View.VISIBLE);
        }

        @Override
        protected String doInBackground(String... strings) {
            String query = null;
            String query1 =null;
            String Ten = ten.getText().toString();
            String Usern = usern.getText().toString();
            String Passw = passs.getText().toString();
            switch (b){
                case 1:
                    query1="select * from CongTy where SDT =" +Usern+"and pass="+Passw;
                    query = "insert into CongTy(TenCty,SDT,pass) values('"+Ten+"',"+Usern+","+Passw+")";
                    break;
                case 2:
                    query1="select * from KhachHang where SDT =" +Usern+"and password="+Passw;
                    query = "insert into KhachHang(Ten,SDT,password) values('"+Ten+"',"+Usern+","+Passw+")";
                    break;
                case 3:
                    query1="select * from HDVDL where SDT =" +Usern+"and password="+Passw;
                    query = "insert into HDVDL(Ten,SDT,password) values('"+Ten+"',"+Usern+","+Passw+")";
                    break;
            }
            if (Ten.trim().equals("")||Usern.trim().equals("") || Passw.trim().equals("")) {
                z = "Vui lòng nhập đầy đủ thông tin";
            } else {
                try {

                    conn = connectionDb.connectionclass();
                    if (conn == null) {
                        z = "Vui lòng kiểm tra kết nối";
                    } else {

                        Statement stmt = conn.createStatement();
                        ResultSet rs = stmt.executeQuery(query1);
                        if (rs.next()) {
                            z = "Người dung đã tồn tại, vui lòng nhập số điệnt hoại mới";
                            isSuccess = false;
                            conn.close();
                        } else {
                            Statement stmt1 = conn.createStatement();
                            ResultSet rs1=stmt1.executeQuery(query);
                            rs1.next();
                            z = "Đăng kí thành công";
                            isSuccess = true;
                            conn.close();
                        }
                    }
                } catch (Exception ex) {
                    isSuccess = false;

                }
            }
            return z;
        }
        protected void onPostExecute(String s) {
            progressBar.setVisibility(View.GONE);
            Toast.makeText(DangKi.this,s,Toast.LENGTH_SHORT).show();
            if(isSuccess){
                Toast.makeText(DangKi.this,"Đăng kí thành công",Toast.LENGTH_LONG).show();
            }
        }
    }
}
