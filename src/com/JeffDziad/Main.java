package com.JeffDziad;

import java.io.*;
import java.util.Scanner;

public class Main {

    private static final Scanner keyboard = new Scanner(System.in);
    private static PaintCalculator paintCalculator = new PaintCalculator();
    private static boolean endProgram = false;

    private static void printMenu(){
        System.out.println("\nSelect one of the following menu options: ");
        System.out.println("""
                1. Add Room
                2. View Rooms
                3. Read Rooms from File
                4. Write Rooms to File
                5. Exit""");
        System.out.print(">");
    }

    private static double promptForDimension(String dimensionName){
        double measurement = 0;
        boolean isError;
        do{
            try{
                isError = false;
                System.out.printf("Enter %s: ", dimensionName);
                measurement = Integer.parseInt(keyboard.nextLine());
            }catch(NumberFormatException ex){
                System.out.println("That is not a valid input! Try again...");
                isError = true;
            }
        }while(isError);
        return measurement;
    }

    private static void createRoom(){
        System.out.println("Room Dimensions: ");
        double length = promptForDimension("Length");
        double width = promptForDimension("Width");
        double height = promptForDimension("Height");
        paintCalculator.addRoom(length, width, height);
        System.out.println("Room successfully created!");
    }

    private static void viewRooms(){
        System.out.println(paintCalculator.toString());
    }

    private static void readFile(){
        try(FileInputStream fis = new FileInputStream("pcData.dat");
            ObjectInputStream ois = new ObjectInputStream(fis)){
            paintCalculator = (PaintCalculator)ois.readObject();
            System.out.println("Successfully read and updated from File!");
        } catch (IOException ioe) {
            System.out.println("A problem occurred when reading from the file pcData.dat.");
        } catch (ClassNotFoundException cnfe) {
            System.out.println("Could not recognize incoming data as an existing class.");
        }
    }

    private static void writeFile(){
        try(FileOutputStream fos = new FileOutputStream("pcData.dat");
            ObjectOutputStream oos = new ObjectOutputStream(fos)){
            oos.writeObject(paintCalculator);
            System.out.println("Successfully wrote to disk!");
        }catch(IOException ioe){
            System.out.println("A problem occurred when trying to open pcData.dat for writing.");
        }
    }

    public static void main(String[] args) {
        int choice;
        do{
            printMenu();
            choice = Integer.parseInt(keyboard.nextLine());
            System.out.print("\n");
            switch (choice) {
                case 1 -> createRoom();
                case 2 -> viewRooms();
                case 3 -> readFile();
                case 4 -> writeFile();
                case 5 -> {
                    System.out.println("Goodbye!");
                    endProgram = true;
                }
                default -> System.out.println("Invalid Input! Try again...");
            }
        }while(!endProgram);
    }
}
