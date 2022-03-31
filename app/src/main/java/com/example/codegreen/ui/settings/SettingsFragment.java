package com.example.codegreen.ui.settings;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.example.codegreen.MainActivity;
import com.example.codegreen.R;
import com.example.codegreen.databinding.FragmentSettingsBinding;

import java.util.Objects;

public class SettingsFragment extends Fragment {
    private FragmentSettingsBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        MainActivity mainActivity = (MainActivity) getActivity();
        assert mainActivity != null;
        binding = FragmentSettingsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        binding.deleteCO2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogFragment dialogue = new ConfirmDeleteCO2DataFragment();
                dialogue.show(mainActivity.getSupportFragmentManager(), "ConfirmDeleteCO2DataFragment");
            }
        });
        binding.disableAccountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogFragment dialogue = new ConfirmClearUserFragment();
                dialogue.show(mainActivity.getSupportFragmentManager(), "ConfirmClearUserFragment");
            }
        });

        binding.largeTextSwitch.setChecked(mainActivity.getUser().isLargeText());
        binding.notificationsSwitch.setChecked(mainActivity.getUser().isNotifications());

        // Having it require a restart is severely suboptimal, but I cannot see another good way to apply it since themes only apply on initial view. (And I couldn't even get setTextSize to work for an example text).
        binding.largeTextSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainActivity.getUser().setLargeText(binding.largeTextSwitch.isActivated());
            }
        });

        binding.notificationsSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainActivity.getUser().setLargeText(binding.notificationsSwitch.isActivated());
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