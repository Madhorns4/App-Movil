package com.example.sviaje.Activities.Home.ui.viajes;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.sviaje.R;


public class ViajesFragment extends Fragment {

    private ViajesViewModel viajesViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        viajesViewModel =
                ViewModelProviders.of(this).get(ViajesViewModel.class);
        View root = inflater.inflate(R.layout.fragment_viajes, container, false);
        final TextView textView = root.findViewById(R.id.text_share);

        return root;
    }
}