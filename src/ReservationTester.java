import java.io.FileNotFoundException;
import java.util.*;

public class ReservationTester {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws FileNotFoundException {
        int in;
        do {
            System.out.println("Nhấn phím 1 để đặt chỗ hoặc phím 0 để xem thông tin.");
            in = Integer.parseInt(scanner.nextLine());
        } while (in != 0 && in != 1);
        input(in);
    }

    public static Type fromString(String str) {
        for (Type type : Type.values())
            if (String.valueOf(type).equals(str.toUpperCase())) return type;
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

    public static void input(int in) throws FileNotFoundException {
        if (in == 0) {
            System.out.print("Nhập mã đặt chỗ: ");
            int reservationNumber = Integer.parseInt(scanner.nextLine());
            Information information = Data.getInformation(reservationNumber - 1);
            if (information == null) System.out.println("Mã đặt chỗ không tồn tại!!!");
            else Data.showData(information);
        } else {
            Information information = new Information();
            List<Client> clients = new ArrayList<>();
            List<Information> list = ConvertJson.getFromJSON("data.json");

            if (list == null) list = new ArrayList<>();

            int tmp = 0;

            do {
                Client client = new Client();
                int check = 0;
                String id;
                do {
                    if (check == 1) {
                        System.out.println("Bạn đã nhập trùng id, xin nhập lại!!!");
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
                System.out.println("Nhấn phím 1 để tiếp tục nhập hoặc phím 0 để thoát nhập.");
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
                    information.setCashPayment(cashPayment);
                } else if (temp.equals("0")) {
                    tmp = 2;
                    System.out.print("Nhập số giao dịch tín dụng: ");
                    String transactionNumber = scanner.nextLine();
                    System.out.print("Nhập số thẻ: ");
                    String cardNumber = scanner.nextLine();
                    creditPayment = new CreditPayment(amount, new Date(), transactionNumber, cardNumber);
                    information.setCreditPayment(creditPayment);
                } else System.out.print("Nhập lại: ");
            } while (tmp == 0);
            Reservation reservation = new Reservation();
            list.add(information);
            reservation.setReservationNumber(String.valueOf(list.size()));
            information.setReservation(reservation);
            ConvertJson.toJSON(list, "data.json"); // Ghi data ra file
            System.out.println("Nhập thông tin thành công.");
        }
    }
}
