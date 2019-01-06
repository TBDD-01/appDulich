package com.example.asus.appdulich;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.sql.Connection;



public class TrangCaNhan extends AppCompatActivity {
    ConnectionDb connectionDb = new ConnectionDb();
    Connection conn;

    Button tcn_timkiem, tcn_sua;
    TextView tcn_label;
    EditText tcn_hoten;
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add("Thoát");
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.trangcanhan);
        tcn_timkiem =(Button)findViewById(R.id.btntcn_timtour);
        tcn_sua =(Button)findViewById(R.id.btntcn_suathongtin);
        tcn_label = (TextView)findViewById(R.id.txttcn_label);
        tcn_hoten =(EditText)findViewById(R.id.txttcn_hoten);
    }
}
