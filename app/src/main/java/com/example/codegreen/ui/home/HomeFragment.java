package com.example.codegreen.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.codegreen.R;
import com.example.codegreen.databinding.FragmentFootprintBinding;
import com.example.codegreen.databinding.FragmentHomeBinding;
import com.example.codegreen.databinding.FragmentLeaderboardBinding;
import com.example.codegreen.databinding.FragmentOverviewBinding;
import com.example.codegreen.databinding.FragmentScanBinding;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        binding.buttonHomeProfile.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Navigation.findNavController(view).navigate(R.id.action_navigation_home_to_navigation_userprofile);
            }
        });

        binding.homeFootprintIcon.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Navigation.findNavController(view).navigate(R.id.action_navigation_home_to_navigation_footprint);
            }
        });

        binding.homeScanIcon.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Navigation.findNavController(view).navigate(R.id.action_navigation_home_to_scannerFragment);
            }
        });

        binding.homeLeaderboardIcon.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Navigation.findNavController(view).navigate(R.id.action_navigation_home_to_navigation_leaderboard);
            }
        });

        binding.homeOverviewIcon.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Navigation.findNavController(view).navigate(R.id.action_navigation_home_to_navigation_overview);
            }
        });

        binding.buttonHomeSettings.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Navigation.findNavController(view).navigate(R.id.action_navigation_home_to_navigation_settings);
            }
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }


}