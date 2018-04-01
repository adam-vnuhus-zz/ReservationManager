import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Reservation {
    private String reservationNumber;

    public Reservation() {

    }

    public Reservation(String reservationNumber) {
        this.reservationNumber = reservationNumber;
    }

    public String getReservationNumber() {
        return reservationNumber;
    }

    public void setReservationNumber(String reservationNumber) {
        this.reservationNumber = reservationNumber;
    }

    void print() {
        System.out.println("reservationNumber = " + reservationNumber);
    }
}
