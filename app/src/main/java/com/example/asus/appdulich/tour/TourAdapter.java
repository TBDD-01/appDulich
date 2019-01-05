package com.example.asus.appdulich.tour;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.asus.appdulich.R;

import Entity.Tour;

import java.util.ArrayList;
import java.util.List;

public class TourAdapter extends BaseAdapter {
    private ArrayList<Tour> tours;
    private LayoutInflater layoutInflater;
    private Context context;

    public TourAdapter(Context context, ArrayList<Tour> tours) {
//        super();
        this.tours = tours;
        this.context = context;
        this.layoutInflater = LayoutInflater.from((Context) context);
    }

//    public ListAdapter(MainActivity mainActivity, List<Entity.test> tList) {
//        this.context = mainActivity;
//        this.test = tList;
//    }

    @Override
    public int getCount() {
        return tours.size();
    }

    @Override
    public Object getItem(int position) {
        return tours.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView == null){
            convertView = layoutInflater.inflate(R.layout.tour_layout,null);
            holder = new ViewHolder();
            holder.name = (TextView) convertView.findViewById(R.id.txtName);
            holder.Date= (TextView) convertView.findViewById(R.id.Date);
            convertView.setTag(holder);
        }
        else{
            holder = (ViewHolder) convertView.getTag();
        }
        Tour t = this.tours.get(position);
        holder.name.setText(t.getTenTour());
        holder.Date.setText(t.getNgaybd().toString() + " - " + t.getNgaykt());
        return convertView;
    }

    static class ViewHolder{
        TextView Date;
        TextView name;
//       TextView score;
    }

}
