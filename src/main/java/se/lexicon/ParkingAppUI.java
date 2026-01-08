package se.lexicon;

import java.util.Scanner;

public class ParkingAppUI {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean running = true;
        System.out.println("Welcome to the Parking App!");

        while (running) {
            System.out.println("\nMenu:");
            System.out.println("1. Register Customer");
            System.out.println("2. View Parking Spots");
            System.out.println("3. Make Reservation");
            System.out.println("0. Exit");
            System.out.print("Select an option: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Enter customer name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter phone number: ");
                    String phone = scanner.nextLine();
                    System.out.print("Enter vehicle registration number: ");
                    String regNumber = scanner.nextLine();
                    // Here you would create and store the Customer object
                    System.out.println("Customer registered: " + name);
                    break;
                    case "2":
                    System.out.println("Displaying parking spots...");
                        System.out.println("Spot ID: 101, Available: Yes");
                        System.out.println("Spot ID: 102, Available: No");
                        System.out.println("Spot ID: 103, Available: Yes");
                        System.out.println("Spot ID: 104, Available: Yes");
                        System.out.println("Spot ID: 105, Available: No");
                    // Here you would retrieve and display parking spots
                    break;
                case "3":
                    System.out.print("Enter parking spot ID: ");
                    String spotId = scanner.nextLine();
                    System.out.print("Enter reservation duration (hours): ");
                    String duration = scanner.nextLine();
                    // Here you would create and store the Reservation object
                    System.out.println("Reservation made for spot ID " + spotId + " for " + duration + " hours.");
                    break;
                case "0":
                    running = false;
                    System.out.println("Exiting the Parking App. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
        scanner.close();

    }
}
