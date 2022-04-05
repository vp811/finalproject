package com.example.codegreen;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;
import android.widget.TextView;

import com.example.codegreen.ui.userprofile.Milestone;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.codegreen.databinding.ActivityMainBinding;

import org.eazegraph.lib.charts.PieChart;
import org.eazegraph.lib.models.PieModel;


public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    public static final String EXTRA_USERNAME = "com.example.codegreen.USERNAME";
    public static final String EXTRA_LOCATION = "com.example.codegreen.LOCATION";
    public static final String EXTRA_USERABOUT = "com.example.codegreen.USERABOUT";
    private User user;

    public AppBarConfiguration appBarConfiguration;

    public User makeGenericUser() {
        User user = new User();
        user.setUsername("Default username.");
        user.setScore(12);
        user.setLocation("Unset");
        user.setUserAbout("Describe yourself!");
        user.setImage(R.drawable.user);
        // Some generic sounding milestones.
        user.addToMilestones(
                new Milestone(
                        "Code Green",
                        "You have downloaded and started using Code Green!",
                        R.drawable.ic_home_black_24dp,
                        0));
        user.addToMilestones(
                new Milestone(
                        "First Scanning",
                        "You have scanned your first item!",
                        R.drawable.ic_camera_black_24dp,
                        1));
        user.addToMilestones(
                new Milestone(
                        "Top Half",
                        "You made the top half of users in your area!",
                        R.drawable.ic_notifications_black_24dp,
                        2));

        user.addToMilestones(
                new Milestone(
                        "One Month of Green",
                        "You have used Code Green for one month!",
                        R.drawable.ic_dashboard_black_24dp,
                        3));

        user.addToMilestones(
                new Milestone(
                        "Getting to Know You",
                        "You have set up your User Profile!",
                        R.drawable.ic_gear_black_24dp,
                        4));
        user.setFavoriteMilestone(user.getMilestones().get(2));
        CO2DataObject co2 = user.getUserCO2Data();
        co2.setClothing(2.5);
        co2.setFood(20);
        co2.setOther(12.5);
        co2.setTransport(15);
        return user;
    }


    @Override
    protected void onStart() {
        super.onStart();
        int themeId = R.style.FontSizeNormal;
        if (user.isLargeText()) {
            themeId = R.style.FontSizeLarge;
        }
        setTheme(themeId);
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        user = makeGenericUser();

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_leaderboard, R.id.navigation_footprint, R.id.navigation_overview, R.id.navigation_scanner)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);
    }

    // Based on Android Studio tutorials, allows use of back button (for things like User Profile Milestones Fragment).
    @Override
    public boolean onSupportNavigateUp () {
        NavController nav = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        return nav.navigateUp() || super.onSupportNavigateUp();
    }

    public User getUser() {

        return user;
    }
}

