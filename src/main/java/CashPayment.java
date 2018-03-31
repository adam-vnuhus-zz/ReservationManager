import java.util.Date;

public class CashPayment extends Payment {
    private String receiptNumber;

    public CashPayment(double amount, Date date, String receiptNumber) {
        super(amount, date);
        this.receiptNumber = receiptNumber;
    }

    public String getReceiptNumber() {
        return receiptNumber;
    }

    public void setReceiptNumber(String receiptNumber) {
        this.receiptNumber = receiptNumber;
    }

    @Override
    public String toString() {
        return super.toString() + " CashPayment{" +
                "receiptNumber='" + receiptNumber + '\'' +
                '}';
    }
}
