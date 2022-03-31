package com.example.codegreen.ui.leaderboard;

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
import com.example.codegreen.databinding.FragmentLeaderboardBinding;

public class LeaderboardFragment extends Fragment {

    private LeaderboardViewModel leaderboardViewModel;
    private FragmentLeaderboardBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentLeaderboardBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        binding.buttonProfileLeaderboard.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Navigation.findNavController(view).navigate(R.id.action_navigation_leaderboard_to_navigation_userprofile);
            }
        });

        binding.buttonSettingsLeaderboard.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Navigation.findNavController(view).navigate(R.id.action_navigation_leaderboard_to_navigation_settings);
            }
        });

        leaderboardViewModel =
                new ViewModelProvider(this).get(LeaderboardViewModel.class);

        View roots = inflater.inflate(R.layout.fragment_leaderboard, container, false);

        final TextView textView = root.findViewById(R.id.text_leaderboard);
        leaderboardViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {

                textView.setText(s);
            }
        });
        return root;

    }
}