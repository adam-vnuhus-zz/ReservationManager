import java.util.ArrayList;

public class Information {
    ArrayList<Client> clients;
    CreditPayment creditPayment;
    CashPayment cashPayment;

    public Information(){};
    public Information(ArrayList<Client> clients, CreditPayment creditPayment, CashPayment cashPayment) {
        this.clients = clients;
        this.creditPayment = creditPayment;
        this.cashPayment = cashPayment;
    }

    public ArrayList<Client> getClients() {
        return clients;
    }

    public void setClients(ArrayList<Client> clients) {
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
