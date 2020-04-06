package com.example.sviaje.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.sviaje.Models.Provincia;
import com.example.sviaje.R;

import java.util.List;

public class GridAdapter extends BaseAdapter {
    private Context c;
    private List<Provincia> list;

    public GridAdapter(Context c, List<Provincia> list){
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

            LayoutInflater layoutInflater=(LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            assert layoutInflater != null;
            convertView = layoutInflater.inflate(R.layout.panel_gird, null);

        }

        TextView tv_provincia = (TextView)convertView.findViewById(R.id.tv_provincia);
        ImageView img = (ImageView) convertView.findViewById(R.id.img_provincia);




           String EDteamImage = list.get(position).getUrl();
            Glide.with(c).load(EDteamImage).into(img);
            tv_provincia.setText(list.get(position).getNombre()+", "+list.get(position).getPais());


        return convertView;
    }
}
