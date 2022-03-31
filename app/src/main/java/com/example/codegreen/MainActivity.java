package com.example.codegreen;

import android.content.Intent;
import android.graphics.Color;
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

    // Create the object of TextView and PieChart class
    TextView tvFood, tvTransport, tvClothing, tvOthers;
    PieChart pieChart;

    public User makeGenericUser() {
        User user = new User();
        user.setUsername("Default username.");
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

    private void setData() {

        // Set the percentage of carbons emitted

        tvFood.setText(Integer.toString(40));
        tvTransport.setText(Integer.toString(30));
        tvClothing.setText(Integer.toString(5));
        tvOthers.setText(Integer.toString(25));

        // Set the data and color to the pie chart
        pieChart.addPieSlice(
                new PieModel(
                        "Food (20KG)",
                        Integer.parseInt(tvFood.getText().toString()),
                        Color.parseColor("#FFA726")));
        pieChart.addPieSlice(
                new PieModel(
                        "Transport (15KG)",
                        Integer.parseInt(tvTransport.getText().toString()),
                        Color.parseColor("#66BB6A")));
        pieChart.addPieSlice(
                new PieModel(
                        "Others (12.5KG)",
                        Integer.parseInt(tvOthers.getText().toString()),
                        Color.parseColor("#29B6F6")));
        pieChart.addPieSlice(
                new PieModel(
                        "Clothing (2.5KG)",
                        Integer.parseInt(tvClothing.getText().toString()),
                        Color.parseColor("#EF5350")));

        // To animate the pie chart
        pieChart.startAnimation();
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


        // Link those objects with their respective id's that we have given in .XML file
        tvFood = findViewById(R.id.tvFood);
        tvTransport = findViewById(R.id.tvTransport);
        tvClothing = findViewById(R.id.tvClothing);
        tvOthers = findViewById(R.id.tvOthers);
        pieChart = findViewById(R.id.piechart);

        // Creating a method setData()
        // to set the text in text view and pie chart
        //This function is causing errors.
         //setData();
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

