import java.io.FileNotFoundException;
import java.util.*;

public class ReservationTester {
	public static void main(String[] args) throws FileNotFoundException {
	    Scanner scanner = new Scanner(System.in);
	    Information information = new Information();
        ArrayList<Client> clients = new ArrayList<>();
        Map<String,Information> map = ConvertJson.getFromJSON("data.json");
        if (map==null) map = new HashMap<>();
	    int tmp;
	    do {
            Client client = new Client();
            System.out.println("Nhap Client Id");
            client.setClientId(scanner.nextLine());
            Type type;
            do {
                System.out.println("nhap type [gold,silver,normal]");
                type = fromString(scanner.nextLine());
                client.setType(type);
            } while (type == null);
            clients.add(client);
            System.out.println("Nhan phim 1 de tiec tuc nhap, phim 0 de thoat nhap client ");
            tmp = Integer.parseInt(scanner.nextLine());
        }while (tmp==1);
        information.setClients(clients);
        tmp = 0;
        System.out.println("Nhap amount");
        Double amount = Double.parseDouble(scanner.nextLine());
        System.out.println("Nhan phim 1 de thanh toan bang Cash, phim 0 de thanh toan bang credit");
        CashPayment cashPayment = null;
        CreditPayment creditPayment = null;
        do {
            String temp = scanner.nextLine();
            if (temp.equals("1")){
                tmp = 1;
                System.out.println("Nhap receipt number");
                String receiptNumber = scanner.nextLine();
                cashPayment = new CashPayment(amount,new Date(),receiptNumber);
            }
            else if (temp.equals("0")){
                tmp = 2;
                System.out.println("Nhap transaction number");
                String transactionNumber = scanner.nextLine();
                System.out.println("Nhap card number");
                String cardNumber = scanner.nextLine();
                creditPayment = new CreditPayment(amount,new Date(), transactionNumber,cardNumber);
            }
            else System.out.println("Nhap lai");
        }while (tmp==0);
        information.setCashPayment(cashPayment);
        information.setCreditPayment(creditPayment);
        if (map==null){
            map.put("1",information);
        }else map.put(String.valueOf(map.size()+1),information);

        ConvertJson.toJSON(map,"data.json");
        System.out.println("Nhap ma dat cho");
        print(scanner.nextLine());


    }
    public static Type fromString(String str){
	    for (Type type : Type.values())
            if (String.valueOf(type).equals(str)) return type;
        return null;
	}

	public static void print(String j) throws FileNotFoundException {
        Map map = ConvertJson.getFromJSON("data.json");
        Information information = (Information) map.get(j);
        ArrayList<Client> clients = information.getClients();
        CreditPayment creditPayment = information.getCreditPayment();
        CashPayment cashPayment = information.getCashPayment();
        // In ra thong tin khach hang
        System.out.println("Thong tin cac khach hang ");

        for (int i=0;i<clients.size();i++)
            System.out.println("id = " + clients.get(i).getClientId() + " type = " + clients.get(i).getType());

        // In ra thong tin thanh toan

        System.out.println("__________________________");
        System.out.println("Thong tin thanh toan");
        if (cashPayment!=null){
            System.out.println("Thanh toan bang tien mat");
            System.out.println("so hoa don : " + cashPayment.getReceiptNumber());
            System.out.println("So tien : " + cashPayment.getAmount());
        }
        else {
            System.out.println("Thanh toan bang the tin dung");
            System.out.println("so giao dich : " + creditPayment.getTransactionNumber());
            System.out.println("So the : " + creditPayment.getCardNumber());
            System.out.println("So tien : " + creditPayment.getAmount());
        }
	}
}
