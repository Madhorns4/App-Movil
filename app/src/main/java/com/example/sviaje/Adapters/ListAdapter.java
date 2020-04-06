package com.example.sviaje.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.sviaje.Models.Ciudad;
import com.example.sviaje.R;

import java.util.List;

public class ListAdapter extends BaseAdapter {

    private Context c;
        private List<Ciudad> list;

    public ListAdapter(Context c, List<Ciudad> list){
        this.c =c;
        this.list= list;
    }
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView==null){

            LayoutInflater layoutInflater=(LayoutInflater)c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            convertView = layoutInflater.inflate(R.layout.ciudad_item, null);

        }

        TextView ciudad = (TextView) convertView.findViewById(R.id.tv_ciudad);




        ciudad.setText(list.get(position).getNombre());


        return convertView;
    }
}
