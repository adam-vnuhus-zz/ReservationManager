
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.awt.print.PrinterException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MyFirstApplication extends JFrame {

    private JTextField textFieldClientId;
    private JTextField textFieldReceiptNumber;
    private JTextField textFieldTransactionNumber;
    private JTextField textFieldCardNumber;
    private JTextField textFieldAmount;
    private JTextField textFieldReservationNumber;
    private JTable table;
    private JTextField textFieldTotal;

    public MyFirstApplication() {

        this.setTitle("OrderRecord");
        this.setBounds(0, 0, 1040, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(new CardLayout(0, 0));
        this.initialize();
    }

    private void initialize() {

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowActivated(WindowEvent arg0) {
                textFieldReceiptNumber.setEnabled(false);
                textFieldTransactionNumber.setEnabled(false);
                textFieldCardNumber.setEnabled(false);
                textFieldReceiptNumber.setText("0");
                textFieldTransactionNumber.setText("0");
                textFieldCardNumber.setText("0");
                textFieldTotal.setEnabled(false);
                textFieldTotal.setText("0");
            }
        });

        JPanel panel_4 = new JPanel();
        this.getContentPane().add(panel_4);
        panel_4.setLayout(null);
        panel_4.setVisible(true);

        JPanel panel_5 = new JPanel();
        panel_5.setBorder(new TitledBorder(new LineBorder(new Color(128, 128, 128), 4)
                , "Client Records", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panel_5.setBounds(10, 11, 592, 368);
        panel_4.add(panel_5);
        panel_5.setLayout(null);

        JLabel lblClientId = new JLabel("Client Id:");
        lblClientId.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblClientId.setBounds(22, 41, 105, 14);
        panel_5.add(lblClientId);

        textFieldClientId = new JTextField();
        textFieldClientId.setFont(new Font("Tahoma", Font.ITALIC, 13));
        textFieldClientId.setHorizontalAlignment(SwingConstants.LEFT);
        textFieldClientId.setBounds(151, 37, 119, 20);
        panel_5.add(textFieldClientId);
        textFieldClientId.setColumns(10);

        JLabel lblType = new JLabel("Type:");
        lblType.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblType.setBounds(322, 41, 105, 14);
        panel_5.add(lblType);

        JLabel lblReceiptNumber = new JLabel("Receipt Number:");
        lblReceiptNumber.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblReceiptNumber.setBounds(22, 125, 119, 14);
        panel_5.add(lblReceiptNumber);

        textFieldReceiptNumber = new JTextField();
        textFieldReceiptNumber.setFont(new Font("Tahoma", Font.ITALIC, 13));
        textFieldReceiptNumber.setHorizontalAlignment(SwingConstants.LEFT);
        textFieldReceiptNumber.setBounds(151, 121, 119, 20);
        panel_5.add(textFieldReceiptNumber);
        textFieldReceiptNumber.setColumns(10);

        JLabel lblTransactionNumber = new JLabel("Transaction Number:");
        lblTransactionNumber.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblTransactionNumber.setBounds(307, 125, 119, 14);
        panel_5.add(lblTransactionNumber);

        textFieldTransactionNumber = new JTextField();
        textFieldTransactionNumber.setFont(new Font("Tahoma", Font.ITALIC, 13));
        textFieldTransactionNumber.setHorizontalAlignment(SwingConstants.LEFT);
        textFieldTransactionNumber.setBounds(450, 121, 119, 20);
        panel_5.add(textFieldTransactionNumber);
        textFieldTransactionNumber.setColumns(10);

        JLabel lblCardNumber = new JLabel("Card Number:");
        lblCardNumber.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblCardNumber.setBounds(307, 150, 119, 14);
        panel_5.add(lblCardNumber);

        textFieldCardNumber = new JTextField();
        textFieldCardNumber.setFont(new Font("Tahoma", Font.ITALIC, 13));
        textFieldCardNumber.setHorizontalAlignment(SwingConstants.LEFT);
        textFieldCardNumber.setBounds(450, 146, 119, 20);
        panel_5.add(textFieldCardNumber);
        textFieldCardNumber.setColumns(10);

        JLabel lblReservationNumber = new JLabel("Reservation Number: ");
        lblReservationNumber.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblReservationNumber.setBounds(22, 239, 129, 14);
        panel_5.add(lblReservationNumber);

        textFieldReservationNumber = new JTextField();
        textFieldReservationNumber.setFont(new Font("Tahoma", Font.ITALIC, 13));
        textFieldReservationNumber.setHorizontalAlignment(SwingConstants.LEFT);
        textFieldReservationNumber.setBounds(151, 241, 119, 20);
        panel_5.add(textFieldReservationNumber);
        textFieldReservationNumber.setColumns(10);

        JLabel lblTotal = new JLabel("Total:");
        lblTotal.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblTotal.setBounds(22, 308, 109, 14);
        panel_5.add(lblTotal);

        textFieldTotal = new JTextField();
        textFieldTotal.setFont(new Font("Tahoma", Font.ITALIC, 13));
        textFieldTotal.setHorizontalAlignment(SwingConstants.LEFT);
        textFieldTotal.setBounds(151, 304, 119, 20);
        panel_5.add(textFieldTotal);
        textFieldTotal.setColumns(10);

        final JComboBox comboBoxType = new JComboBox();
        comboBoxType.setModel(new DefaultComboBoxModel(new String[]{"", "GOLD", "SILVER", "NORMAL"}));
        comboBoxType.setBounds(450, 37, 119, 22);
        panel_5.add(comboBoxType);

        JSeparator separator = new JSeparator();
        separator.setForeground(SystemColor.desktop);
        separator.setBounds(22, 285, 547, 2);
        panel_5.add(separator);

        JPanel panel_1 = new JPanel();
        panel_1.setBorder(new TitledBorder(new LineBorder(new Color(128, 128, 128), 4)
                , "Order Transcript", TitledBorder.CENTER, TitledBorder.TOP
                , null, new Color(0, 0, 0)));
        panel_1.setBounds(607, 11, 405, 368);
        panel_4.add(panel_1);
        panel_1.setLayout(null);

        JScrollPane scrollPane_1 = new JScrollPane();
        scrollPane_1.setBounds(10, 23, 385, 334);
        panel_1.add(scrollPane_1);

        final JTextArea textOrderTranscript = new JTextArea();
        scrollPane_1.setViewportView(textOrderTranscript);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 390, 1002, 104);
        panel_4.add(scrollPane);

        table = new JTable();
        scrollPane.setViewportView(table);
        table.setModel(new DefaultTableModel(new Object[][]{}, new String[]{"Reservation Number", "Client Id",
                "Type", "Receipt Number", "Transaction Number", "Card Number", "Amount"}));
        table.getColumnModel().getColumn(0).setPreferredWidth(117);
        table.getColumnModel().getColumn(1).setPreferredWidth(56);
        table.getColumnModel().getColumn(2).setPreferredWidth(57);
        table.getColumnModel().getColumn(3).setPreferredWidth(90);
        table.getColumnModel().getColumn(4).setPreferredWidth(108);
        table.getColumnModel().getColumn(5).setPreferredWidth(73);

        final JRadioButton rdbtnCreditPayment = new JRadioButton("CreditPayment");
        rdbtnCreditPayment.setFont(new Font("Tahoma", Font.BOLD, 11));
        final JRadioButton rdbtnCashPayment = new JRadioButton("CashPayment");
        rdbtnCashPayment.setFont(new Font("Tahoma", Font.BOLD, 11));

        rdbtnCashPayment.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                if (rdbtnCashPayment.isSelected()) {

                    rdbtnCreditPayment.setSelected(false);
                    textFieldReceiptNumber.setEnabled(true);
                    textFieldCardNumber.setEnabled(false);
                    textFieldTransactionNumber.setEnabled(false);
                    textFieldReceiptNumber.setText(null);
                    textFieldCardNumber.setText("0");
                    textFieldTransactionNumber.setText("0");
                    textFieldReceiptNumber.requestFocus();
                } else {
                    textFieldReceiptNumber.setEnabled(false);
                    textFieldReceiptNumber.setText("0");
                }
            }
        });

        rdbtnCashPayment.setBounds(18, 95, 109, 23);
        panel_5.add(rdbtnCashPayment);

        rdbtnCreditPayment.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                if (rdbtnCreditPayment.isSelected()) {

                    rdbtnCashPayment.setSelected(false);
                    textFieldReceiptNumber.setEnabled(false);
                    textFieldCardNumber.setEnabled(true);
                    textFieldTransactionNumber.setEnabled(true);
                    textFieldCardNumber.setText(null);
                    textFieldTransactionNumber.setText(null);
                    textFieldReceiptNumber.setText("0");
                    textFieldCardNumber.requestFocus();
                    textFieldTransactionNumber.requestFocus();
                } else {
                    textFieldCardNumber.setEnabled(false);
                    textFieldCardNumber.setText("0");
                    textFieldTransactionNumber.setEnabled(false);
                    textFieldTransactionNumber.setText("0");
                }
            }
        });

        rdbtnCreditPayment.setBounds(307, 95, 120, 23);
        panel_5.add(rdbtnCreditPayment);

        JLabel lblAmount = new JLabel("Amount:");
        lblAmount.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblAmount.setBounds(22, 214, 119, 14);
        panel_5.add(lblAmount);

        textFieldAmount = new JTextField();
        textFieldAmount.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent arg0) {
                try {
                    KeyEvent evt = arg0;
                    char iNumber = evt.getKeyChar();
                    if (!(Character.isDigit(iNumber))
                            || (iNumber == KeyEvent.VK_BACK_SPACE)
                            || (iNumber == KeyEvent.VK_DELETE)) {
                        evt.consume();
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showConfirmDialog(null, "Order Systems Error");
                }
            }
        });

        textFieldAmount.setFont(new Font("Tahoma", Font.ITALIC, 13));
        textFieldAmount.setHorizontalAlignment(SwingConstants.LEFT);
        textFieldAmount.setBounds(151, 210, 119, 20);
        panel_5.add(textFieldAmount);
        textFieldAmount.setColumns(10);

        JButton btnPrintOrder = new JButton("Print Order");
        btnPrintOrder.setFont(new Font("Tahoma", Font.BOLD, 11));

        btnPrintOrder.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                try {
                    textOrderTranscript.print();
                } catch (PrinterException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });

        btnPrintOrder.setBounds(41, 505, 124, 45);
        panel_4.add(btnPrintOrder);

        JButton btnExit = new JButton("Exit");
        btnExit.setFont(new Font("Tahoma", Font.BOLD, 11));

        btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                JFrame frameOrderSystem = new JFrame("Exit");
                if (JOptionPane.showConfirmDialog(frameOrderSystem, "Confirm if you want to exit",
                        "Clear TextField System", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
                    System.exit(0);
                }
            }
        });

        btnExit.setBounds(712, 505, 128, 45);
        panel_4.add(btnExit);

        JButton btnReset = new JButton("Reset");
        btnReset.setFont(new Font("Tahoma", Font.BOLD, 11));
        btnReset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {

                textFieldClientId.setText(null);
                textFieldReceiptNumber.setText(null);
                textFieldTransactionNumber.setText(null);
                textFieldCardNumber.setText(null);
                textFieldAmount.setText(null);
                textFieldReservationNumber.setText(null);
                textFieldTotal.setText(null);
                textOrderTranscript.setText(null);
                comboBoxType.setSelectedItem("");
                textFieldTotal.setEnabled(false);
                textFieldTotal.setText("0");

                rdbtnCashPayment.setSelected(false);
                rdbtnCreditPayment.setSelected(false);
            }
        });

        btnReset.setBounds(578, 505, 124, 45);
        panel_4.add(btnReset);

        JButton btnDetails = new JButton("Details");
        btnDetails.setFont(new Font("Tahoma", Font.BOLD, 11));
        btnDetails.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                model.addRow(new Object[]{textFieldReservationNumber.getText()
                        , textFieldClientId.getText(), comboBoxType.getSelectedItem()
                        , textFieldReceiptNumber.getText(), textFieldTransactionNumber.getText()
                        , textFieldCardNumber.getText(), textFieldAmount.getText()
                });
            }
        });

        btnDetails.setBounds(310, 505, 124, 45);
        panel_4.add(btnDetails);

        JButton btnTranscript = new JButton("Transcript");
        btnTranscript.setFont(new Font("Tahoma", Font.BOLD, 11));
        btnTranscript.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {

                Calendar timer = Calendar.getInstance();
                timer.getTime();
                SimpleDateFormat tTime = new SimpleDateFormat("HH:mm:ss");
                tTime.format(timer.getTime());
                SimpleDateFormat tDate = new SimpleDateFormat("dd-MM-yyyy");
                tDate.format(timer.getTime());

                textOrderTranscript.setText("\tOrder Recording Systems\n"
                        + "Reservation Number:       " + textFieldReservationNumber.getText()
                        + "\n======================================\n" + "ClientId:               "
                        + textFieldClientId.getText() + "\n\n" + "Type:                   "
                        + comboBoxType.getSelectedItem() + "\n\n" + "Receipt Number:          "
                        + textFieldReceiptNumber.getText() + "\n\n" + "Transaction Number:  "
                        + textFieldTransactionNumber.getText() + "\n\n" + "Card Number:               "
                        + textFieldCardNumber.getText() + "\n\n" + "Amount:                  "
                        + textFieldAmount.getText() + "\n"
                        + "\n=======================================\n"
                        + "Total:                   " + textFieldTotal.getText() + "\n"
                        + "\n=======================================\n"
                        + "\nDate: " + tDate.format(timer.getTime())
                        + "\tTime: " + tTime.format(timer.getTime())
                        + "\n\t\t Thank you and See you soon!!!");
            }
        });

        btnTranscript.setBounds(444, 505, 124, 45);
        panel_4.add(btnTranscript);

        JButton btnTotal = new JButton("Total");
        btnTotal.setFont(new Font("Tahoma", Font.BOLD, 11));
        btnTotal.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                double total = 0.0;
                if (comboBoxType.getSelectedItem().equals("GOLD")) {
                    double amount = Double.parseDouble(textFieldAmount.getText());
                    total = total + amount - amount * 0.2;
                } else if (comboBoxType.getSelectedItem().equals("SILVER")) {
                    double amount = Double.parseDouble(textFieldAmount.getText());
                    total = total + amount - amount * 0.1;
                } else if (comboBoxType.getSelectedItem().equals("NORMAL")) {
                    double amount = Double.parseDouble(textFieldAmount.getText());
                    total = total + amount;
                }
                String totalString = new Double(total).toString();
                textFieldTotal.setText(totalString);
            }
        });

        btnTotal.setBounds(850, 505, 124, 45);
        panel_4.add(btnTotal);

        JButton btnDelete = new JButton("Delete");
        btnDelete.setFont(new Font("Tahoma", Font.BOLD, 11));

        btnDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                if (table.getSelectedRow() == -1) {
                    if (table.getRowCount() == 0) {
                        JOptionPane.showMessageDialog(null, "No data to delete"
                                , "Order System", JOptionPane.OK_OPTION);
                    } else {
                        JOptionPane.showMessageDialog(null, "Select a row to delete"
                                , "Order System",
                                JOptionPane.OK_OPTION);
                    }
                } else {
                    model.removeRow(table.getSelectedRow());
                }
            }
        });

        btnDelete.setBounds(176, 505, 124, 45);
        panel_4.add(btnDelete);
    }
}
