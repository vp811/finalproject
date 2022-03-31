package com.example.codegreen.ui.settings;

import android.app.AlertDialog;
import android.app.Dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.codegreen.MainActivity;
import com.example.codegreen.R;
import com.example.codegreen.ui.userprofile.Milestone;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.fragment.app.DialogFragment;

import com.example.codegreen.databinding.ActivityMainBinding;

public class ConfirmDeleteCO2DataFragment extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage("Are you sure you want to delete your CO2 data? This CANNOT be restored!")
                .setPositiveButton("Confirm delete", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        MainActivity mainActivity = (MainActivity) getActivity();
                        assert mainActivity != null;
                        mainActivity.getUser().clearUserCO2Data();
                        ConfirmDeleteCO2DataFragment.this.getDialog().cancel();
                    }
                })
                .setNegativeButton("Cancel delete", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        ConfirmDeleteCO2DataFragment.this.getDialog().cancel();
                    }
                });
        return builder.create();
    }
}