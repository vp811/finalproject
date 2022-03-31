package com.example.codegreen.ui.userprofile;
// Very basic Milestone class
public class Milestone {
    private String name;
    private String description;
    private int image;
    private int id;

    public Milestone(String name, String description, int image, int id) {
        this.name = name;
        this.description = description;
        this.image = image;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getImage() {
        return image;
    }

    public int getId() {
        return id;
    }
}
