package com.cars;
import com.cars.Car;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Collection<Car> cars = new ArrayList<Car>();
        int menuOption;

        do {
            System.out.println("===A Warm Welcome To The Vehicle Registration App===");
            System.out.println("(1) Add Vehicle Details");
            System.out.println("(2) View Vehicle Report");
            System.out.println("(3) Search Vehicle Details");
            System.out.println("(4) Delete Vehicle Details");
            System.out.println("(5) Exit Application");
            System.out.println("Choose An Option");

            while (!input.hasNextInt()) {
                System.out.println("Please Enter A Valid Input eg. 1, 2 , 3 , 4 or 5 ");
                input.nextLine();
            }

            menuOption = input.nextInt();
            input.nextLine();

            switch (menuOption) {
                case 1 -> {
                    Car car = new Car();

                    System.out.println("Enter Vehicle Manufacturer. eg. BMW, Volvo, Hyundai etc.");
                    car.setMake(input.nextLine());

                    System.out.println("Enter Vehicle Model. eg. Golf-7, 3-series , M-5, Polo, etc ");
                    car.setModel(input.nextLine());

                    System.out.println("Enter Vehicle Vin Number. only 17 Characters Long");
                    String vin = input.nextLine();
                    while (vin.length() != 17) {
                        System.out.println("Please Enter A Valid Vin Number eg. 17 Characters Long : ");
                        vin = input.nextLine();
                    }
                    car.setVin(vin);

                    System.out.print("Choose A Plate Format. Old Or New");
                    int plateChoice = input.nextInt();
                    input.nextLine();

                    System.out.print("Enter a Plate number : ");
                    String platenumber = input.nextLine();
                    car.setPlatenumber(platenumber);

                    System.out.print("Enter Mileage : ");
                    while (!input.hasNextInt()) {
                        System.out.print("Please Enter A Mileage : ");
                        input.nextLine();
                    }
                    car.setMileage(input.nextInt());

                    System.out.print("Enter Year Of Manufacture : ");
                    while (!input.hasNextInt()) {
                        System.out.print("Please Enter A Valid Input Year : ");
                        input.nextLine();
                    }
                    car.setYear(input.nextInt());
                    input.nextLine();

                    cars.add(car);
                    System.out.println("Vehicle Added Successfully.");
                }
                case 2 -> {
                    if (cars.isEmpty()) {
                        System.out.println("There Are No Vehicles To Display.");
                    } else {
                        System.out.println("=======Vehicle Details=======");
                        for (Car c : cars) {
                            System.out.println(c);
                            System.out.println("---------------");
                        }
                    }
                }
                case 3 -> {
                    System.out.println("Please Enter Vin to Search: ");
                    String searchVin = input.nextLine();
                    boolean found = false;
                    for (Car c : cars) {
                        if (c.getVin().equalsIgnoreCase(searchVin)) {
                            System.out.println("Vin Found Successfully:\n" + c);
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Vin Number Not Found: " + searchVin);
                    }
                }
                case 4 -> {
                    System.out.println("Please Enter Vin Number to Delete : ");
                    String deleteVin = input.nextLine();
                    Iterator<Car> carIterator = cars.iterator();
                    boolean deleted = false;

                    while (carIterator.hasNext()) {
                        Car c = carIterator.next();
                        if (c.getVin().equalsIgnoreCase(deleteVin)) {
                            carIterator.remove();
                            deleted = true;
                            System.out.println("Vehicle Deleted Successfully");
                            break;
                        }
                    }
                    if (!deleted) {
                        System.out.println("Vin Number Not Found: " + deleteVin);
                    }
                }
                case 5 -> {
                    System.out.println("Thank You For Using The Application!");
                }
                default -> {
                    System.out.println("Invalid Option. Please choose Between Option 1 - 5. ");
                }
            }

        } while (menuOption != 5);
    }
}