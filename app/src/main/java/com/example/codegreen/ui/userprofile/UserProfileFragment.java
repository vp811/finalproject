package com.example.codegreen.ui.userprofile;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.codegreen.EditUserProfileActivity;
import com.example.codegreen.MainActivity;
import com.example.codegreen.R;
import com.example.codegreen.databinding.ActivityMainBinding;
import com.example.codegreen.databinding.FragmentUserprofileBinding;
import com.example.codegreen.databinding.FragmentUserProfileMilestonesBinding;

import java.util.ArrayList;

public class UserProfileFragment extends Fragment {

    private FragmentUserprofileBinding binding;
    private Fragment isThis;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentUserprofileBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        isThis = this;

        MainActivity mainActivity = (MainActivity) getActivity();
        assert mainActivity != null;
        binding.locationBox.setText("Location: " + mainActivity.getUser().getLocation());
        binding.aboutMeContents.setText(mainActivity.getUser().getUserAbout());
        binding.nameBox.setText("Name: " + mainActivity.getUser().getUsername());
        ArrayList<Milestone> milestones = mainActivity.getUser().getMilestones();

        // User must always have one milestone (download code green milestone).
        binding.userMilestone.setImageDrawable(getContext().getDrawable(mainActivity.getUser().getFavoriteMilestone().getImage()));
        binding.viewMilestoneOne.setImageDrawable(getContext().getDrawable(milestones.get(milestones.size() - 1).getImage()));
        binding.viewMilestoneOne.setVisibility(View.VISIBLE);
        if (milestones.size() > 1) {
            binding.viewMilestoneTwo.setImageDrawable(getContext().getDrawable(milestones.get(milestones.size() - 2).getImage()));
            binding.viewMilestoneTwo.setVisibility(View.VISIBLE);
            if (milestones.size() > 2) {
                binding.viewMilestoneThree.setImageDrawable(getContext().getDrawable(milestones.get(milestones.size() - 3).getImage()));
                binding.viewMilestoneThree.setVisibility(View.VISIBLE);
                if (milestones.size() > 3) {
                    binding.viewMilestoneFour.setImageDrawable(getContext().getDrawable(milestones.get(milestones.size() - 4).getImage()));
                    binding.viewMilestoneFour.setVisibility(View.VISIBLE);
                    if (milestones.size() > 4) {
                        binding.viewMilestoneFive.setImageDrawable(getContext().getDrawable(milestones.get(milestones.size() - 5).getImage()));
                        binding.viewMilestoneFive.setVisibility(View.VISIBLE);
                    }
                }
            }
        }

        binding.editUserProfileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), EditUserProfileActivity.class);
                intent.putExtra(MainActivity.EXTRA_USERNAME, mainActivity.getUser().getUsername());
                intent.putExtra(MainActivity.EXTRA_USERABOUT, mainActivity.getUser().getUserAbout());
                intent.putExtra(MainActivity.EXTRA_LOCATION, mainActivity.getUser().getLocation());
                getEditingData.launch(intent);
            }
        });


        binding.moreMilestonesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_navigation_userprofile_to_userProfileMilestonesFragment);
            }
        });
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    ActivityResultLauncher<Intent> getEditingData = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        MainActivity mainActivity = (MainActivity) getActivity();
                        Intent data = result.getData();
                        mainActivity.getUser().setLocation(data.getStringExtra(MainActivity.EXTRA_LOCATION));
                        mainActivity.getUser().setUserAbout(data.getStringExtra(MainActivity.EXTRA_USERABOUT));
                        mainActivity.getUser().setUsername(data.getStringExtra(MainActivity.EXTRA_USERNAME));
                        binding.locationBox.setText("Location: " + mainActivity.getUser().getLocation());
                        binding.aboutMeContents.setText(mainActivity.getUser().getUserAbout());
                        binding.nameBox.setText("Name: " + mainActivity.getUser().getUsername());
                        mainActivity.getUser().addToMilestones(
                                new Milestone(
                                        "Getting to Know You",
                                        "You have set up your User Profile!",
                                        R.drawable.ic_gear_black_24dp,
                                        4));
                    }
                }
            });

}