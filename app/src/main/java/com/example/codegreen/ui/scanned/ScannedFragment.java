package com.example.codegreen.ui.scanned;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;


import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.example.codegreen.R;

public class ScannedFragment extends Fragment {

    private ScannedViewModel scannedViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        scannedViewModel =
                new ViewModelProvider(this).get(ScannedViewModel.class);
        View root = inflater.inflate(R.layout.fragment_scanned, container, false);
        //final TextView textView = root.findViewById((R.id.text_scanned));

        Button button1 = (Button) root.findViewById(R.id.GoHome);
        button1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Navigation.findNavController(v).navigate(R.id.action_scannedFragment2_to_navigation_home);
            }
        });

        Button button2 = (Button) root.findViewById(R.id.ScanAgain);
        button2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Navigation.findNavController(v).navigate(R.id.action_scannedFragment2_to_scannerFragment);
            }
        });

        return root;
    }
}