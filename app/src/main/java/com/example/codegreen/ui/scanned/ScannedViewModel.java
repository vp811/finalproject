package com.example.codegreen.ui.scanned;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ScannedViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public ScannedViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is scanned fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}