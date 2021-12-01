package com.example.assignment7;

import java.util.ArrayList;
import java.util.List;

public class Car {
    private String name;
    private ArrayList<Integer> imageIds;

    public Car(String name, ArrayList<Integer> imageIds) {
        this.name = name;
        this.imageIds = imageIds;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Integer> getImageIds() {
        return imageIds;
    }

    public void setImageIds(ArrayList<Integer> imageIds) {
        this.imageIds = imageIds;
    }

}
