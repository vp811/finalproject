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
import androidx.navigation.Navigation;

import com.example.codegreen.R;
import com.example.codegreen.databinding.FragmentFootprintBinding;
import com.example.codegreen.databinding.FragmentHomeBinding;

public class FootprintFragment extends Fragment {

    private FootprintViewModel footprintViewModel;
    private FragmentFootprintBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        footprintViewModel =
                new ViewModelProvider(this).get(FootprintViewModel.class);

        binding = FragmentFootprintBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        binding.buttonFootprintUser.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Navigation.findNavController(view).navigate(R.id.action_navigation_footprint_to_navigation_userprofile);
            }
        });

        binding.buttonFootprintSettings.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Navigation.findNavController(view).navigate(R.id.action_navigation_footprint_to_navigation_settings);
            }
        });

        return root;
    }
}