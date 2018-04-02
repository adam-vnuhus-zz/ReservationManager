import java.io.FileNotFoundException;
import java.util.*;

import static java.lang.String.*;

public class ReservationTester {

    public void main() {

        Scanner scanner = new Scanner(System.in);

        int n;
        do {

            System.out.println("Nhấn phím 1 để đặt chỗ " +
                    "hoặc phím 0 để xem thông tin.");
            n = Integer.parseInt(scanner.nextLine());

        } while (n != 0 && n != 1);

        if (n == 0) {

            System.out.print("Nhập mã đặt chỗ: ");
            print(Integer.parseInt(scanner.nextLine()));

        } else {

            Information information;
            information = new Information();
            List<Client> clients = new ArrayList<>();
            Map<String, Information> map = null;
            try {
                map = ConvertJson.getFromJSON("data.json");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

            if (map == null) map = new HashMap<>();

            int tmp = 0;
            do {

                Client client = new Client();
                int check = 0;
                String id;
                do {

                    if (check == 1) {
                        System.out.println("Bạn đã nhập trùng mã, xin nhập lại.");
                    }
                    System.out.print("Nhập mã khách hàng: ");
                    id = scanner.nextLine().trim();
                    check = 1;

                } while (!checkIdExists(id, clients));

                client.setClientId(id);
                Type type;
                do {

                    System.out.print("Nhập loại [GOLD || SILVER || NORMAL]: ");
                    type = fromString(scanner.nextLine().trim());
                    client.setType(type);

                } while (type == null);
                clients.add(client);
                System.out.println("Nhấn phím 1 để tiếp tục nhập " +
                        "hoặc phím 0 để thoát nhập.");
                tmp = Integer.parseInt(scanner.nextLine());

            } while (tmp == 1);

            information.setClients(clients);

            tmp = 0;
            System.out.print("Nhập số tiền: ");
            Double amount = Double.parseDouble(scanner.nextLine());
            System.out.println("Nhấn phím 1 để thanh toán bằng tiền mặt " +
                    "hoặc phím 0 để thanh toán bằng thẻ.");

            CashPayment cashPayment;
            CreditPayment creditPayment;

            do {
                String temp = scanner.nextLine();
                if (temp.equals("1")) {
                    tmp = 1;
                    System.out.print("Nhập số hóa đơn: ");
                    String receiptNumber = scanner.nextLine();
                    cashPayment = new CashPayment(amount, new Date(), receiptNumber);
                    information.setCashPayment(cashPayment);
                } else if (temp.equals("0")) {
                    tmp = 2;
                    System.out.print("Nhập số giao dịch tín dụng: ");
                    String transactionNumber = scanner.nextLine();
                    System.out.print("Nhập số thẻ: ");
                    String cardNumber = scanner.nextLine();
                    creditPayment = new CreditPayment(amount, new Date()
                            , transactionNumber, cardNumber);
                    information.setCreditPayment(creditPayment);
                } else System.out.print("Nhập lại: ");

            } while (tmp == 0);

            Reservation reservation = new Reservation();

            if (map == null) {
                map.put("1", information);
                reservation.setReservationNumber("1");
            } else {
                map.put(valueOf(map.size() + 1), information);
                reservation.setReservationNumber(valueOf(map.size()));
            }
            information.setReservation(reservation);
            ConvertJson.toJSON(map, "data.json"); // Ghi data ra file
            System.out.println("Nhập thông tin thành công.");
        }
    }

    public static Type fromString(String str) {
        for (Type type : Type.values())
            if (valueOf(type).equals(str)) return type;
        return null;
    }

    public static boolean checkIdExists(String id, List<Client> clients) {
        ArrayList<String> tmp = new ArrayList<>();
        for (int i = 0; i < clients.size(); i++) {
            tmp.add(clients.get(i).getClientId());
        }
        if (tmp.contains(id)) return false;
        return true;
    }

    public static void print(int j) {

        Map map = null;
        try {
            map = ConvertJson.getFromJSON("data.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Information information;
        information = (Information) map.get(valueOf(j));
        Double amount;
        if (information == null) {
            System.out.println("Mã đặt chỗ không tồn tại!!!");
            return;
        }
        Reservation reservation = information.getReservation();
        List<Client> clients = information.getClients();
        CreditPayment creditPayment = information.getCreditPayment();
        CashPayment cashPayment = information.getCashPayment();

        System.out.println("Mã đặt chỗ: " + reservation.getReservationNumber());

        // In ra thong tin khach hang

        System.out.println("Thông tin các khách hàng.");
        for (int i = 0; i < clients.size(); i++)
            System.out.println("id = " + clients.get(i).getClientId()
                    + " type = " + clients.get(i).getType());

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
            System.out.println("Số giao dịch tín dụng: " + creditPayment.getTransactionNumber());
            System.out.println("Số thẻ tín dụng: " + creditPayment.getCardNumber());
            System.out.println("Số tiền: " + creditPayment.getAmount());
            System.out.println("Ngày giao dịch: " + creditPayment.getDate());
            amount = creditPayment.getAmount();
        }
        System.out.println("Số tiền phải trả: " + reservation.getDueWithDiscount(clients, amount));
    }
}
