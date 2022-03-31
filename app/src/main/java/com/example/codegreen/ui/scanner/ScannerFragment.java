package com.example.codegreen.ui.scanner;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;


import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import com.example.codegreen.R;


public class ScannerFragment extends Fragment {

    private ScannerViewModel scannerViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        scannerViewModel =
                new ViewModelProvider(this).get(ScannerViewModel.class);
        View root = inflater.inflate(R.layout.fragment_scanner, container, false);

        ImageButton button = (ImageButton) root.findViewById(R.id.takePicture);
        button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Navigation.findNavController(v).navigate(R.id.action_scannerFragment_to_scannedFragment);
            }
        });

        return root;
    }

}