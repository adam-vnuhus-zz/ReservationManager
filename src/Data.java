import java.io.FileNotFoundException;
import java.util.List;

public class Data {
    public static Information getInformation(int index) throws FileNotFoundException {
        List list = ConvertJson.getFromJSON("data.json");
        // Kiểm tra sự tồn tại của chỉ số index, nếu không tồn tại index thì information trả về null
        // Ở đây index == (mã đặt chỗ)-1 vì mã đặt chỗ bắt đầu từ 1, list bắt đầu từ 0
        Information information = null;
        if (list == null || index-list.size() >= 0 || index<0) return information;
        // Nếu tồn tại chỉ số thì trả về information 
        information = (Information) list.get(index);
        return information;
    }

    public static void showData(Information information){
        Double amount;
        Reservation reservation = information.getReservation();
        List<Client> clients = information.getClients();
        CreditPayment creditPayment = information.getCreditPayment();
        CashPayment cashPayment = information.getCashPayment();

        System.out.println("Mã đặt chỗ: " + reservation.getReservationNumber());

        // In ra thong tin khach hang

        System.out.println("Thông tin các khách hàng.");
        for (int i = 0; i < clients.size(); i++)
            System.out.println("id = " + clients.get(i).getClientId() + " type = " + clients.get(i).getType());

        // In ra thong tin thanh toan

        System.out.println("_______________________________");
        System.out.println("Thông tin thanh toán.");
        if (cashPayment != null) {
            System.out.println("Thanh toán bằng tiền mặt.");
            System.out.println("Số hóa đơn: " + cashPayment.getReceiptNumber());
            System.out.println("Số tiền: " + cashPayment.getAmount());
            System.out.println("Ngày giao dịch: " + cashPayment.getDate());
            amount = cashPayment.getAmount();
        } else {
            System.out.println("Thanh toán bằng thẻ tín dụng.");
            System.out.println("Số giao dịch tín dụng : " + creditPayment.getTransactionNumber());
            System.out.println("Số thẻ tín dụng : " + creditPayment.getCardNumber());
            System.out.println("Số tiền : " + creditPayment.getAmount());
            System.out.println("Ngày giao dịch: " + creditPayment.getDate());
            amount = creditPayment.getAmount();
        }
        System.out.println("Số tiền phải trả : " + reservation.getDueWithDiscount(clients,amount));
    }
}
