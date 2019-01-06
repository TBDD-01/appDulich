package com.example.asus.appdulich;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.asus.appdulich.conn.ConnectionDb;
import com.example.asus.appdulich.tour.TourAdapter;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Entity.Tour;

public class MainActivity extends AppCompatActivity {

    //List tour

    private ListView listView;
    private ConnectionDb db = new ConnectionDb();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_tour);
        ArrayList<Tour> tList = new ArrayList<>();
        listView = (ListView) findViewById(R.id.listTour);
        TourData tData = new TourData();
        tData.execute();
    }
    private class TourData extends AsyncTask<String, String, String> {
        ArrayList<Tour> tList = new ArrayList<>();
        //chạy ở background
        @Override
        protected String doInBackground(String... strings) {
            Connection conn = null;
            try {
                conn = db.connectionclass();
                //query
                String query = "SELECT idHDV,CTHDV.idTour,idCTHDV, ngaybd, ngaykt, Tour.TenTour FROM CTHDV, Tour WHERE CTHDV.idTour = Tour.idTour";
                Statement stm = conn.createStatement();
                ResultSet rs = stm.executeQuery(query);
                //Lấy từng tour ra rồi đưa vào mảng
                while (rs.next()) {
                    //lấy 1 tour từ rs
                    Tour t = new Tour(rs.getInt(1),rs.getInt(2), rs.getInt(3), rs.getDate(4), rs.getDate(5),
                            rs.getString(6));
                    //thêm vào list
                    tList.add(t);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            return null;
        }
        //sau khi chạy hết các lệnh ở background
        @Override
        protected void onPostExecute(String s) {
            TourAdapter TourA = new TourAdapter(MainActivity.this,tList);
            listView.setAdapter(TourA);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Object o = listView.getItemAtPosition(position);
                    Tour tour = (Tour) o;
                    setContentView(R.layout.tour_detail);

                    TextView name = findViewById(R.id.editTenTour);
                    TextView startDay = findViewById(R.id.editNgayBD);
                    TextView endDay = findViewById(R.id.editNgayKT);
                    TextView guide = findViewById(R.id.editHDV);

                    name.setText(tour.getTenTour());
                    startDay.setText(tour.getNgaybd().toString());
                    endDay.setText(tour.getNgaykt().toString());
                    guide.setText(String.valueOf(tour.getIdHDV()));
                }
            });
        }
    }
}
//    private List<Tour> getListData(){
//        List<Tour> list = new ArrayList<Tour>();
//        Tour t1 = new Tour("Tour 1","22/01/2019","30/02/2019","Trần Văn A");
//        Tour t2 = new Tour("Tour 2","01/02/2019","02/02/2019","Lê Văn Luyện");
//        Tour t3 = new Tour("Tour 3","29/02/2019","01/03/2019","Trương Văn C");
//        list.add(t1);
//        list.add(t2);
//        list.add(t3);
//        return list;
//    }
//}
