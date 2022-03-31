package com.example.codegreen.ui.scan;

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
import androidx.navigation.Navigation;

import com.example.codegreen.R;
import com.example.codegreen.databinding.FragmentHomeBinding;
import com.example.codegreen.databinding.FragmentScanBinding;

public class ScanFragment extends Fragment {

    private ScanViewModel scanViewModel;
    private FragmentScanBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        scanViewModel =
                new ViewModelProvider(this).get(ScanViewModel.class);

        binding = FragmentScanBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        binding.buttonScanUser.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Navigation.findNavController(view).navigate(R.id.action_navigation_scan_to_navigation_userprofile);
            }
        });

        binding.buttonScanSettings.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Navigation.findNavController(view).navigate(R.id.action_navigation_scan_to_navigation_settings);
            }
        });

        View roots = inflater.inflate(R.layout.fragment_scan, container, false);

        final TextView textView = root.findViewById(R.id.text_scan);
        scanViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {

                textView.setText(s);
            }
        });
        return root;
    }
}