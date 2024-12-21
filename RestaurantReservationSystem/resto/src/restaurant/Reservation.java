package restaurant;

import java.util.List;

public class Reservation {
    private String name;
    private String phone;
    private String date;
    private int numberOfGuests;
    private Restaurant restaurant;
    private List<MenuItem> selectedMenu;
    private double totalPrice;

    public Reservation(String name, String phone, String date, int numberOfGuests, Restaurant restaurant, List<MenuItem> selectedMenu) {
        this.name = name;
        this.phone = phone;
        this.date = date;
        this.numberOfGuests = numberOfGuests;
        this.restaurant = restaurant;
        this.selectedMenu = selectedMenu;
        this.totalPrice = calculateTotalPrice();
    }

    private double calculateTotalPrice() {
        return selectedMenu.stream().mapToDouble(MenuItem::getPrice).sum();
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getDate() {
        return date;
    }

    public int getNumberOfGuests() {
        return numberOfGuests;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public List<MenuItem> getSelectedMenu() {
        return selectedMenu;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    @Override
    public String toString() {
        return "Reservation: \n" +
                "Name= " + name + "\n" +
                "Phone= " + phone + "\n" +
                "Date= " + date + "\n" +
                "\nGuests= " + numberOfGuests +
                "\nRestaurant= " + restaurant.getName() +
                "\nSelectedMenu=" + selectedMenu +
                "\nTotalPrice=$" + totalPrice + "";
             
    }
}
