package main;

import restaurant.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ReservationManager manager = ReservationManager.getInstance();

        Restaurant restaurant1 = new Restaurant("The Gourmet Place");
        restaurant1.addMenuItem(new MenuItem("Pasta", 12.99));
        restaurant1.addMenuItem(new MenuItem("Steak", 25.50));
        restaurant1.addMenuItem(new MenuItem("Salad", 8.75));

        Restaurant restaurant2 = new Restaurant("The Cozy Diner");
        restaurant2.addMenuItem(new MenuItem("Burger", 10.00));
        restaurant2.addMenuItem(new MenuItem("Fries", 4.50));
        restaurant2.addMenuItem(new MenuItem("Milkshake", 5.25));

        List<Restaurant> restaurants = List.of(restaurant1, restaurant2);

        while (true) {
            System.out.println("\nEnhanced Restaurant Reservation System");
            System.out.println("1. Add Reservation");
            System.out.println("2. View Reservations");
            System.out.println("3. Cancel Reservation");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Select a restaurant:");
                    for (int i = 0; i < restaurants.size(); i++) {
                        System.out.println((i + 1) + ". " + restaurants.get(i).getName());
                    }
                    int restaurantChoice = scanner.nextInt();
                    scanner.nextLine(); 

                    if (restaurantChoice < 1 || restaurantChoice > restaurants.size()) {
                        System.out.println("Invalid restaurant choice.");
                        break;
                    }

                    Restaurant selectedRestaurant = restaurants.get(restaurantChoice - 1);
                    selectedRestaurant.showMenu();

                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter phone number: ");
                    String phone = scanner.nextLine();
                    System.out.print("Enter date (YYYY-MM-DD): ");
                    String date = scanner.nextLine();
                    System.out.print("Enter number of guests: ");
                    int guests = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Select menu items (comma-separated numbers): ");
                    String menuSelection = scanner.nextLine();
                    String[] menuIndexes = menuSelection.split(",");
                    List<MenuItem> selectedMenu = new ArrayList<>();

                    for (String index : menuIndexes) {
                        int menuIndex = Integer.parseInt(index.trim()) - 1;
                        if (menuIndex >= 0 && menuIndex < selectedRestaurant.getMenu().size()) {
                            selectedMenu.add(selectedRestaurant.getMenu().get(menuIndex));
                        } else {
                            System.out.println("Invalid menu item number: " + (menuIndex + 1));
                        }
                    }

                    Reservation reservation = new Reservation(name, phone, date, guests, selectedRestaurant, selectedMenu);
                    manager.addReservation(reservation);
                    break;

                case 2:
                    manager.viewReservations();
                    break;

                case 3:
                    System.out.print("Enter reservation number to cancel: ");
                    int reservationNumber = scanner.nextInt();
                    scanner.nextLine(); 
                    manager.cancelReservation(reservationNumber);
                    break;

                case 4:
                    System.out.println("Exiting system. Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
