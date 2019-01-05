//package com.example.asus.appdulich.tour;
//
//import android.os.AsyncTask;
//import android.os.Bundle;
//
//import com.example.asus.appdulich.ListAdapters.ListAdapter;
//import com.example.asus.appdulich.MainActivity;
//import com.example.asus.appdulich.conn.ConnectionDb;
//
//import java.sql.Connection;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.ArrayList;
//
//import Entity.Tour;
//
//public class TourData extends AsyncTask<String, String, String>
//{
//    ArrayList<Tour> tList= new ArrayList<>();
//
//    ConnectionDb db;
//    @Override
//    protected String doInBackground(String... strings) {
//            Connection conn = null;
//            try {
//                conn = db.connectionclass();
//                String query = "SELECT idHDV,CTHDV.idTour, idCTHDV, ngaybd, ngaykt, Tour.TenTour FROM CTHDV, Tour WHERE CTHDV.idTour = Tour.idTour";
//                Statement stm = conn.createStatement();
//                ResultSet rs = stm.executeQuery(query);
//                while(rs.next()){
//                    Tour t = new Tour(rs.getInt(0),rs.getInt(1),rs.getInt(2),rs.getDate(3),rs.getDate(4),
//                                rs.getString(5));
//                    tList.add(t);
//                }
//            } catch (SQLException e) {
//                e.printStackTrace();
//            } catch (ClassNotFoundException e) {
//                e.printStackTrace();
//            }
//        return null;
//    }
//
//    @Override
//    protected void onPostExecute(String s) {
//        TourAdapter TourA = new TourAdapter(MainActivity.Con,tList);
//    }
//}
