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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.codegreen.MainActivity;
import com.example.codegreen.R;
import com.example.codegreen.User;
import com.example.codegreen.databinding.FragmentHomeBinding;
import com.example.codegreen.databinding.FragmentLeaderboardBinding;

import java.util.ArrayList;
import java.util.List;

public class LeaderboardFragment extends Fragment {

    private LeaderboardViewModel leaderboardViewModel;
    private FragmentLeaderboardBinding binding;
    List<User> userList = new ArrayList<>();

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

        MainActivity mainActivity = (MainActivity) getActivity();
        assert mainActivity != null;

        RecyclerView recyclerView = binding.userList;
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(mainActivity));

        User user1 = mainActivity.makeGenericUser();
        user1.setUsername("Paul");
        user1.setLocation("Chicago");
        user1.setScore(10);

        User user2 = mainActivity.makeGenericUser();
        user2.setUsername("Olivia");
        user2.setLocation("New York");
        user2.setScore(8);

        User user3 = mainActivity.makeGenericUser();
        user3.setUsername("Jake");
        user3.setLocation("Seatle");
        user3.setScore(6);

        User user4 = mainActivity.makeGenericUser();
        user4.setUsername("Jordan");
        user4.setLocation("Washington");
        user4.setScore(4);

        User user5 = mainActivity.makeGenericUser();
        user5.setUsername("Nisha");
        user5.setLocation("Boston");
        user5.setScore(2);


        userList.add(mainActivity.getUser());

        userList.add(
                user1
        );
        userList.add(
                user2
        );
        userList.add(
                user3
        );
        userList.add(
                user4
        );
        userList.add(
                user5
        );

        UserAdaptor adapter = new UserAdaptor(mainActivity, userList);

        recyclerView.setAdapter(adapter);

        return root;

    }
}