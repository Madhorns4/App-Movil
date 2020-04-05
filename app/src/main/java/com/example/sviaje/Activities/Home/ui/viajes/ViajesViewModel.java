package com.example.sviaje.Activities.Home.ui.viajes;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ViajesViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public ViajesViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is viajes fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}