package com.JeffDziad;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PaintCalculator implements Serializable {

    private List<Room> roomList = new ArrayList<>();

    public void addRoom(double length, double width, double height){
        Room room = new Room(width, length, height);
        roomList.add(room);
    }

    @Override
    public String toString(){
        String output = "Room #: -Area-\n";
        int size = roomList.size();
        double totalSA = 0;
        if(size == 0){
            return "No rooms have been created!";
        }else{
            int itr = 1;
            for(Room room: roomList){
                output += String.format("Room %d: %,.2f\n", itr, room.getArea());
                totalSA += room.getArea();
                itr++;
            }
            output += String.format("Total Surface Area: %,.2f", totalSA);
            return output;
        }
    }
}
