import java.util.Date;

public class CreditPayment extends Payment{
    private String transactionNumber;
    private String cardNumber;

    public CreditPayment(double amount, Date date, String transactionNumber,String cardNumber) {
        super(amount,date);
        this.transactionNumber = transactionNumber;
        this.cardNumber = cardNumber;
    }

    public String getTransactionNumber() {
        return transactionNumber;
    }

    public void setTransactionNumber(String transactionNumber) {
        this.transactionNumber = transactionNumber;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public String toString() {
        return  super.toString() + "CreditPayment{" +
                "transactionNumber='" + transactionNumber + '\'' +
                ", cardNumber='" + cardNumber + '\'' +
                '}';
    }
}
