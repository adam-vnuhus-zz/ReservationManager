import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Reservation {
	private String reservationNumber;

	public Reservation(String reservationNumber) {
		this.reservationNumber = reservationNumber;
	}

	void print() {
		System.out.println("reservationNumber = " + reservationNumber);
	}

}
