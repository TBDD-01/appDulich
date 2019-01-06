package com.example.asus.appdulich;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class TrangCaNhan extends AppCompatActivity {
    ListView listView;
    ArrayList<Ttour>arrayList;
    TCNTuorArray tcnTuorArray;
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
        listView = (ListView)findViewById(R.id.listview);
        tcn_timkiem =(Button)findViewById(R.id.btntcn_timtour);
        tcn_sua =(Button)findViewById(R.id.btntcn_suathongtin);
        tcn_label = (TextView)findViewById(R.id.txttcn_label);
        tcn_hoten =(EditText)findViewById(R.id.txttcn_hoten);

        arrayList = new ArrayList<>();
    }

    public class Loadlist extends AsyncTask<String,String,String> {
        String z ="";
        Boolean isSuccess = false;

        @Override
        protected void onPreExecute(){}


        @Override
        protected String doInBackground(String... strings) {
            String query = "select Ten from KhachHang where trangthai ='True'";
            String query1 = "select TenCty from CongTy where trangthai ='True'";
            String query2 = "select Ten from HDVDL where trangthai ='True'";

            int a;
            try {
                conn = connectionDb.connectionclass();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(query);
                if (rs.next())
                {
                    tcn_label.setText("CÔNG TY");
                    String t = rs.getString(String.valueOf(stmt.executeQuery(query1)));
                   tcn_hoten.setText(t);
                   int n = Integer.parseInt(String.valueOf(stmt.executeQuery("SELECT TOP(1)idCTHDV FROM CTHDV ORDER BY idCTHDV desc;")));
                   for(int i=1;i<=n;i++){

                       String query4 ="select Tour.TenTour from Tour, CTHDV where Tour.idTour = CTHDV.idTour and CTHDV.idTour ="+n;
                       String query5="select ngaybd from CTHDV where CTHDV.idTour ="+n;
                       String query6="select ngaykt from CTHDV where CTHDV.idTour ="+n;
                       String query7="select HDVDL.Ten from HDVDL, CTHDV where HDVDL.idHDV = CTHDV.idHDV and CTHDV.idTour ="+n;
                               arrayList.add(new Ttour("String.valueOf(stmt.executeQuery(query4)","String.valueOf(stmt.executeQuery(query5)","String.valueOf(stmt.executeQuery(query6)","String.valueOf(stmt.executeQuery(query7)"));
                    conn.close();
                   }
                }
                else{
                     rs = stmt.executeQuery(query);
                     if(rs.next())
                     {
                         tcn_label.setText("KHÁCH HÀNG");
                         String t = rs.getString(String.valueOf(stmt.executeQuery(query)));
                         tcn_hoten.setText(t);
                         /*int n = Integer.parseInt(String.valueOf(stmt.executeQuery("SELECT COUNT(DanhSachKH.idKH) from DanhsachKH, KhachHang where KhachHang.Ten = '"+tcn_hoten+"' and KhachHang.idKH = DanhsachKH.idKH group by DanhSachKh.idKH;")));
                         for(int i=n;i>=1;i--){*/

                            /* String query4 ="select Tour.TenTour from Tour, CTHDV where Tour.idTour = CTHDV.idTour and CTHDV.idTour ="+n;
                             String query5="select ngaybd from CTHDV where CTHDV.idTour ="+n;
                             String query6="select ngaykt from CTHDV where CTHDV.idTour ="+n;
                             String query7="select HDVDL.Ten from HDVDL, CTHDV where HDVDL.idHDV = CTHDV.idHDV and CTHDV.idTour ="+n;
                             arrayList.add(new Ttour("String.valueOf(stmt.executeQuery(query4)","String.valueOf(stmt.executeQuery(query5)","String.valueOf(stmt.executeQuery(query6)","String.valueOf(stmt.executeQuery(query7)"));
                             conn.close();*/
                     //}
                }
        }

            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            return null;
        }

}
}