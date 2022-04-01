package com.example.codegreen;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.codegreen.databinding.ActivityUserEditUserProfileBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.codegreen.databinding.ActivityMainBinding;

public class EditUserProfileActivity extends AppCompatActivity {

    private ActivityUserEditUserProfileBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityUserEditUserProfileBinding.inflate((getLayoutInflater()));
        binding.inputLocationBox.setText(getIntent().getStringExtra(MainActivity.EXTRA_LOCATION));
        binding.inputAboutMe.setText(getIntent().getStringExtra(MainActivity.EXTRA_USERABOUT));
        binding.inputNameBox.setText(getIntent().getStringExtra(MainActivity.EXTRA_USERNAME));
        setContentView(binding.getRoot());
    }

    public void onClickCancel(View view) {
        Intent returnValues = getIntent();
        setResult(RESULT_CANCELED, returnValues);
        finish();
    }

    public void onClickSave(View view) {
        Intent returnValues = getIntent();
        returnValues.putExtra(MainActivity.EXTRA_USERNAME, binding.inputNameBox.getText().toString());
        returnValues.putExtra(MainActivity.EXTRA_USERABOUT, binding.inputAboutMe.getText().toString());
        returnValues.putExtra(MainActivity.EXTRA_LOCATION, binding.inputLocationBox.getText().toString());
        setResult(RESULT_OK, returnValues);
        finish();
    }
}