package com.example.codegreen.ui.footprint;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.codegreen.R;

public class FootprintFragment extends Fragment {

    private FootprintViewModel footprintViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        footprintViewModel =
                new ViewModelProvider(this).get(FootprintViewModel.class);

        View root = inflater.inflate(R.layout.fragment_footprint, container, false);

        final TextView textView = root.findViewById(R.id.text_footprint);
        footprintViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {

                textView.setText(s);
            }
        });
        return root;
    }
}