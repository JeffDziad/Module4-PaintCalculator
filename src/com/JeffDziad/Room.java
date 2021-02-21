package com.JeffDziad;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Room implements Serializable {

    private List<Wall> wallList = new ArrayList<>();

    public Room(double width, double length, double height){
        Wall wall1 = new Wall(width, height);
        Wall wall2 = new Wall(width, height);
        Wall wall3 = new Wall(length, height);
        Wall wall4 = new Wall(length, height);
        wallList.add(wall1);
        wallList.add(wall2);
        wallList.add(wall3);
        wallList.add(wall4);
    }

    public double getArea(){
        double sum = 0;
        for(Wall wall: wallList){
            sum += wall.getArea();
        }
        return sum;
    }

    @Override
    public String toString(){
        double sum = 0;
        for(Wall wall: wallList){
            sum += wall.getArea();
        }
        return String.format("Surface Area: %f", sum);
    }
}
