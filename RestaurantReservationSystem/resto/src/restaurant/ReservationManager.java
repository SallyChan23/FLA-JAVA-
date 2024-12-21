package restaurant;

import java.util.ArrayList;
import java.util.List;

public class ReservationManager {
    private static ReservationManager instance;
    private List<Reservation> reservations;

    private ReservationManager() {
        reservations = new ArrayList<>();
    }

    public static ReservationManager getInstance() {
        if (instance == null) {
            instance = new ReservationManager();
        }
        return instance;
    }

    public void addReservation(Reservation reservation) {
        reservations.add(reservation);
        System.out.println("Reservation added successfully!");
    }

    public void viewReservations() {
        if (reservations.isEmpty()) {
            System.out.println("No reservations available.");
        } else {
            System.out.println("Current Reservations:");
            for (int i = 0; i < reservations.size(); i++) {
                System.out.println((i + 1) + ". " + reservations.get(i));
            }
        }
    }

    public void cancelReservation(int index) {
        if (index < 1 || index > reservations.size()) {
            System.out.println("Invalid reservation number.");
        } else {
            reservations.remove(index - 1);
            System.out.println("Reservation canceled successfully!");
        }
    }
}
