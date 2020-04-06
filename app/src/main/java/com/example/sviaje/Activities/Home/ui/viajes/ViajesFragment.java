package com.example.sviaje.Activities.Home.ui.viajes;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.sviaje.Adapters.ListaAdapter;
import com.example.sviaje.Models.Lugares_sqlite;
import com.example.sviaje.Models.MyDBOpenHelper;
import com.example.sviaje.R;

import java.util.ArrayList;
import java.util.List;


public class ViajesFragment extends Fragment {
    private Context context;
    private ViajesViewModel viajesViewModel;
    private List<Lugares_sqlite> list;
    ;
    private ListView lv;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        viajesViewModel =
                ViewModelProviders.of(this).get(ViajesViewModel.class);
        View root = inflater.inflate(R.layout.fragment_viajes, container, false);

        context = container.getContext();



        MyDBOpenHelper db = new MyDBOpenHelper(context, "viajes",  null, 1);
        SQLiteDatabase database= db.getWritableDatabase();
        Cursor fila = database.rawQuery("select * from viajes ",null);
       list= new ArrayList<Lugares_sqlite>();
        if(fila.moveToFirst()){
            for(int i = 0;i< fila.getCount();i++){
                Lugares_sqlite l = new Lugares_sqlite();

                l.setId_usuario(fila.getInt(0));
                l.setNum_viaje(fila.getInt(1));
                l.setN_pais(fila.getString(2));
                l.setN_provincia(fila.getString(3));
                l.setN_ciudad(fila.getString(4));
                l.setN_lugar(fila.getString(5));
                l.setFecha(fila.getString(6));
                l.setHora(fila.getString(7));
                l.setCosto(fila.getString(8));
                list.add(l);


            }
            lv= (ListView) root.findViewById(R.id.lv_viaje);
            ListaAdapter la = new ListaAdapter(getActivity(),list);
            lv.setAdapter(la);





        }
        return root;
    }
}