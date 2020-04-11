package com.example.sviaje.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.sviaje.Models.Lugares_sqlite;
import com.example.sviaje.R;

import java.util.List;

public class ListaAdapter extends BaseAdapter {

    private Context c;
    private List<Lugares_sqlite> list;

    public ListaAdapter(Context c, List<Lugares_sqlite> list){
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

            convertView = layoutInflater.inflate(R.layout.viaje_item, null);

        }

        TextView direccion = (TextView) convertView.findViewById(R.id.tv_direccion);

        TextView costo = (TextView) convertView.findViewById(R.id.costo);
        TextView f = (TextView) convertView.findViewById(R.id.fecha);



        direccion.setText(list.get(position).getId_viaje()+","+list.get(position).getN_pais()+","+list.get(position).getN_provincia()+","+list.get(position).getN_ciudad());
        costo.setText(list.get(position).getN_lugar()+"");
        f.setText(list.get(position).getFecha()+"; "+list.get(position).getHora());
        return convertView;
    }
}

