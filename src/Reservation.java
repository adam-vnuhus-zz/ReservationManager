import java.util.*;

public class Reservation {
    private String reservationNumber;

    public Reservation(){}

    public Reservation(String reservationNumber) {
        this.reservationNumber = reservationNumber;
    }

    public String getReservationNumber() {
        return reservationNumber;
    }

    public void setReservationNumber(String reservationNumber) {
        this.reservationNumber = reservationNumber;
    }

    public double getDueWithDiscount(List<Client> clients,double amount){
        int max = 0;
        List<Integer> values = new ArrayList<>();
        for (int i = 0; i<clients.size(); i++){
            Type type = clients.get(i).getType();
            switch (type){
                case GOLD : {values.add(2); break;}
                case SILVER : {values.add(1); break;}
                case NORMAL : {values.add(0); break;}
            }
        }
        max = Collections.max(values);

        // round double
        double amountWithDiscount = amount-(amount*max/10);
        double scale = Math.pow(10, 2);
        return Math.round(amountWithDiscount * scale) / scale;
    }
}
