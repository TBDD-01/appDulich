package com.example.asus.appdulich;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;

import com.example.asus.appdulich.ListAdapters.ListAdapter;
import com.example.asus.appdulich.ListAdapters.TourAdapter;

import java.util.ArrayList;
import java.util.List;

import Entity.HDV;
import Entity.Tour;

public class MainActivity extends AppCompatActivity {
//    Button btnSearch;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        Anhxa();
//        ClickButton();
//    }
//
//    private void Anhxa() {
//        btnSearch = (Button) findViewById(R.id.btnSearch);
//    }
//
//    private void ClickButton() {
//
//        btnSearch.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(MainActivity.this, TourActivity.class));
//            }
//        });
//    }
    //list hdv
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.list_test);
//
//        List<HDV> tList=getListData();
//        final ListView listView = (ListView) findViewById(R.id.listfortest);
//        listView.setAdapter(new ListAdapter(this, tList));
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Object o = listView.getItemAtPosition(position);
//                HDV hdv = (HDV) o;
//                setContentView(R.layout.hdv_details);
//                EditText name = findViewById(R.id.editTen);
//                EditText email = findViewById(R.id.editEmail);
//                EditText ChungChi = findViewById(R.id.editCC);
//                name.setText(hdv.getName());
//                email.setText(hdv.getEmail());
//                ChungChi.setText(hdv.getChungchi());
//
//            }
//        });
//    }
//    private List<HDV> getListData(){
//        List<HDV> list = new ArrayList<HDV>();
//        HDV t1 = new HDV(1,"hdv1","abc");
//        HDV t2 = new HDV(2,"hdv2","acb");
//        HDV t3 = new HDV(3,"hdv3","aaa");
//        list.add(t1);
//        list.add(t2);
//        list.add(t3);
//        return list;
//    }
    //List tour
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.list_tour);
//        HDV_Activity hdvActivity= new HDV_Activity();

    List<Tour> tList=getListData();
//        tList.add(new test(1,"hdv1",3));
//        tList.add(new test(2,"hdv2",5));
//        tList.add(new test(3,"hdv3",1));
    final ListView listView = (ListView) findViewById(R.id.listTour);
    listView.setAdapter(new TourAdapter(this, tList));
    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Object o = listView.getItemAtPosition(position);
            Tour hdv = (Tour) o;
            setContentView(R.layout.hdv_details);


        }
    });
}
    private List<Tour> getListData(){
        List<Tour> list = new ArrayList<Tour>();
        Tour t1 = new Tour("Tour 1","22/01/2019","30/02/2019","Trần Văn A");
        Tour t2 = new Tour("Tour 2","01/02/2019","02/02/2019","Lê Văn Luyện");
        Tour t3 = new Tour("Tour 3","29/02/2019","01/03/2019","Trương Văn C");
        list.add(t1);
        list.add(t2);
        list.add(t3);
        return list;
    }
}
