import java.util.Date;

public class Payment {
	private double amount;
	private Date date;

	public double getAmount() {
		return amount;
	}

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    public void setAmount(double amount) {
	    this.amount = amount;
    }

	public Payment(double amount, Date date) {
		this.amount = amount;
		this.date = date;
	}

    @Override
    public String toString() {
        return  " Payment{" +
                "amount=" + amount +
                ", date=" + date +
                '}';
    }
}
