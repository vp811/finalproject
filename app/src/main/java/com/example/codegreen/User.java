package com.example.codegreen;

import com.example.codegreen.ui.userprofile.Milestone;

import java.util.ArrayList;
import java.lang.Math;

public class User {
    private String username;
    private String location;
    private String userAbout;
    private Object userCO2Data; // Stand-in since this part of it is not my section.
    private ArrayList<Milestone> milestones;
    private Milestone favoriteMilestone;
    private int score;
    private int image;
    private boolean largeText = false;
    private boolean notifications = false; // Unused, since this has no notifications in this more or less "demo" build.

    public User() {
        image = 0;
        username = "Unset Name";
        location = "Unset Location";
        score = 0;
        userAbout = "Describe yourself!";
        userCO2Data = null;
        milestones = new ArrayList<Milestone>();
    }

    public String getLocation() {
        return location;
    }

    public void setScore(int score){
        this.score = score;
        this.score = Math.max(milestones.size(), this.score);
    }

    public int getScore() {
        return score;
    }

    public String getUserAbout() {
        return userAbout;
    }

    public String getUsername() {
        return username;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setUserAbout(String userAbout) {
        this.userAbout = userAbout;
    }

    // Clears user data.
    public void clearAllData() {
        clearUserCO2Data();
        clearMilestones();
        location = "Unset";
        username = "New User";
        userAbout = "";
    }

    public void setUsername(String username) {
        this.username = username;
    }

    // CO2Data is not part of the section I am handling beyond this, so these are dummy functions for now.
    public Object getUserCO2Data() {
        return userCO2Data;
    }
    public void setUserCO2Data(Object userCO2Data) {
        this.userCO2Data = userCO2Data;
    }
    public void clearUserCO2Data() {
        this.userCO2Data = null;
    }

    // Adds a milestone assuming there is not already one with the same ID, returns true if successful, false otherwise.
    public boolean addToMilestones(Milestone milestone) {
        boolean didAdd = true;
        for (int i = 0; i < milestones.size(); i++) {
            if (milestones.get(i).getId() == milestone.getId()) {
                didAdd = false;
                break;
            }
        }
        if (didAdd) {
            milestones.add(milestone);
        }
        return didAdd;
    }

    public void clearMilestones() {
        milestones.clear();
        milestones.add(new Milestone(
                "Code Green",
                "You have downloaded and started using Code Green!",
                R.drawable.ic_home_black_24dp,
                0));
        favoriteMilestone = milestones.get(0);
    }

    public ArrayList<Milestone> getMilestones() {
        return milestones;
    }

    public Milestone getFavoriteMilestone() {
        return favoriteMilestone;
    }

    public void setFavoriteMilestone(Milestone favoriteMilestone) {
        this.favoriteMilestone = favoriteMilestone;
    }

    public boolean isLargeText() {
        return largeText;
    }

    public void setImage(int image){
        this.image = image;
    }
    public int getImage() {
        return image;
    }


    public void setLargeText(boolean largeText) {
        this.largeText = largeText;
    }

    public void setNotifications(boolean notifications) {
        this.notifications = notifications;
    }

    public boolean isNotifications() {
        return notifications;
    }
}
