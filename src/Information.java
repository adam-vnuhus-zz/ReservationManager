import java.util.List;

public class Information {

    private Reservation reservation;
    private List<Client> clients;
    private CreditPayment creditPayment;
    private CashPayment cashPayment;

    public Information(){}

    public Information(Reservation reservation, List<Client> clients, CreditPayment creditPayment, CashPayment cashPayment) {
        this.reservation = reservation;
        this.clients = clients;
        this.creditPayment = creditPayment;
        this.cashPayment = cashPayment;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    public CreditPayment getCreditPayment() {
        return creditPayment;
    }

    public void setCreditPayment(CreditPayment creditPayment) {
        this.creditPayment = creditPayment;
    }

    public CashPayment getCashPayment() {
        return cashPayment;
    }

    public void setCashPayment(CashPayment cashPayment) {
        this.cashPayment = cashPayment;
    }
}
