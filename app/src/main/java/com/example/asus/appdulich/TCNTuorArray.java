package com.example.asus.appdulich;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;

import java.util.ArrayList;

public class TCNTuorArray extends ArrayAdapter<Ttour> {
    Context context;
    ArrayList<Ttour>arrayList;
    int layoutResource;

    public TCNTuorArray(Context context, int resource, ArrayList<Ttour>objects){
        super(context,resource,objects);
        this.context=context;
        this.arrayList=objects;
        this.layoutResource = resource;
    }

    public View getView(int position, View view, ViewGroup parent){
        LayoutInflater inflater = LayoutInflater.from(context);
        view=inflater.inflate(layoutResource,null);

        EditText txt1 =(EditText)view.findViewById(R.id.txtrow_TenTour);
        txt1.setText(arrayList.get(position).getTen());

        EditText txt2 =(EditText)view.findViewById(R.id.txtrow_ngaydi);
        txt2.setText(arrayList.get(position).getNgaydi());

        EditText txt3 =(EditText)view.findViewById(R.id.txtrow_ngayve);
        txt3.setText(arrayList.get(position).getNgayve());

        EditText txt4 =(EditText)view.findViewById(R.id.txtrow_hdv);
        txt4.setText(arrayList.get(position).getHdv());

        return view;
    }
    }

