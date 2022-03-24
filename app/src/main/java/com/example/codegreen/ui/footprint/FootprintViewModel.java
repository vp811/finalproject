package com.example.codegreen.ui.footprint;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class FootprintViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public FootprintViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is the footprint fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}