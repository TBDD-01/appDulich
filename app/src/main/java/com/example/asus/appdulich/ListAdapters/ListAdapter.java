package com.example.asus.appdulich.ListAdapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.asus.appdulich.R;

import Entity.HDV;

import java.util.List;

public class ListAdapter extends BaseAdapter {
    private List<HDV> test;
    private LayoutInflater layoutInflater;
    private Context context;

    public ListAdapter(Context context, List<HDV> test) {
//        super();
        this.test = test;
        this.context = context;
        this.layoutInflater = LayoutInflater.from((Context) context);
    }

//    public ListAdapter(MainActivity mainActivity, List<Entity.test> tList) {
//        this.context = mainActivity;
//        this.test = tList;
//    }

    @Override
    public int getCount() {
        return test.size();
    }

    @Override
    public Object getItem(int position) {
        return test.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView == null){
            convertView = layoutInflater.inflate(R.layout.hdv_layout,null);
            holder = new ViewHolder();
            holder.name = (TextView) convertView.findViewById(R.id.name);
            holder.email= (TextView) convertView.findViewById(R.id.score);
            convertView.setTag(holder);
        }
        else{
            holder = (ViewHolder) convertView.getTag();
        }
        HDV t = this.test.get(position);
        holder.name.setText(t.getName());
        holder.email.setText("email: "+ t.getEmail());
        return convertView;
    }

   static class ViewHolder{
       TextView email;
       TextView name;
//       TextView score;
   }

}
