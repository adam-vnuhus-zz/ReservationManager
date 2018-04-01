import java.io.FileNotFoundException;
import java.util.*;

public class ReservationTester {
    private static Random random;

    public static void main(String[] args) throws FileNotFoundException {

        random = new Random();
        Scanner scanner = new Scanner(System.in);

        Information information = new Information();
        List<Client> clients = new ArrayList<>();
        Map<String, Information> map = ConvertJson.getFromJSON("data.json");

        if (map == null) map = new HashMap<>();

        int tmp = 0;

        do {
            String temp1 = " ";
            Client client = new Client();

            System.out.print("Nhập mã khách hàng: ");
            client.setClientId(scanner.nextLine());

            if (temp1.equals(client.getClientId())) {
                System.out.print("Nhập mã khách hàng: ");
            }
            Type type;
            do {
                System.out.print("Nhập loại [GOLD || SILVER || NORMAL]: ");
                type = fromString(scanner.nextLine());
                client.setType(type);
            } while (type == null);
            clients.add(client);
            System.out.println("Nhấn phím 1 để tiếp tục nhập hoặc phím 0 để thoát nhập.");
            temp1 = client.getClientId();
            tmp = Integer.parseInt(scanner.nextLine());
        } while (tmp == 1);
        information.setClients(clients);

        tmp = 0;
        System.out.print("Nhập số tiền: ");
        Double amount = Double.parseDouble(scanner.nextLine());
        System.out.println("Nhấn phím 1 để thanh toán bằng tiền mặt hoặc phím 0 để thanh toán bằng thẻ.");
        CashPayment cashPayment = null;
        CreditPayment creditPayment = null;

        do {
            String temp = scanner.nextLine();
            if (temp.equals("1")) {
                tmp = 1;
                System.out.print("Nhập số hóa đơn: ");
                String receiptNumber = scanner.nextLine();
                cashPayment = new CashPayment(amount, new Date(), receiptNumber);
            } else if (temp.equals("0")) {
                tmp = 2;
                System.out.print("Nhập số giao dịch tín dụng: ");
                String transactionNumber = scanner.nextLine();
                System.out.print("Nhập số thẻ: ");
                String cardNumber = scanner.nextLine();
                creditPayment = new CreditPayment(amount, new Date(), transactionNumber, cardNumber);
            } else System.out.print("Nhập lại: ");
        } while (tmp == 0);

        information.setCashPayment(cashPayment);
        information.setCreditPayment(creditPayment);

        if (map == null) {
            map.put("1", information);
        } else map.put(String.valueOf(map.size() + 1), information);
        ConvertJson.toJSON(map, "data.json");

        System.out.print("Nhập mã đặt chỗ: ");

        String reservationNumber = scanner.nextLine();
        Reservation reservation = new Reservation(reservationNumber);
        information.setReservation(reservation);

        print(random.nextInt(80) + 20);
    }

    public static Type fromString(String str) {
        for (Type type : Type.values())
            if (String.valueOf(type).equals(str)) return type;
        return null;
    }

    public static void print(int j) throws FileNotFoundException {

        Map map = ConvertJson.getFromJSON("data.json");
        Information information = (Information) map.get(j);

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
        } else {
            System.out.println("Thanh toán bằng thẻ tín dụng.");
            System.out.println("Số giao dịch tín dụng : " + creditPayment.getTransactionNumber());
            System.out.println("Số thẻ tín dụng : " + creditPayment.getCardNumber());
            System.out.println("Số tiền : " + creditPayment.getAmount());
            System.out.println("Ngày giao dịch: " + creditPayment.getDate());
        }
    }
}
