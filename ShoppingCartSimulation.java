import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;
import java.util.Map;

public class ShoppingCartSimulation extends JFrame {
    private JCheckBox laptopCheckbox, phoneCheckbox, headphonesCheckbox;
    private JButton generateBillButton;
    private JTextArea billArea;

    private Map<String, Integer> prices = new HashMap<>();

    public ShoppingCartSimulation() {
        setTitle("Shopping Cart Simulation");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        prices.put("Laptop", 800);
        prices.put("Phone", 500);
        prices.put("Headphones", 100);

        laptopCheckbox = new JCheckBox("Laptop ($800)");
        phoneCheckbox = new JCheckBox("Phone ($500)");
        headphonesCheckbox = new JCheckBox("Headphones ($100)");

        // Button
        generateBillButton = new JButton("Generate Bill");

     
        billArea = new JTextArea(8, 30);
        billArea.setEditable(false);

        JPanel checkboxPanel = new JPanel();
        checkboxPanel.setLayout(new GridLayout(3, 1));
        checkboxPanel.add(laptopCheckbox);
        checkboxPanel.add(phoneCheckbox);
        checkboxPanel.add(headphonesCheckbox);

        // Panel for button
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(generateBillButton);

        // Add components to frame
        setLayout(new BorderLayout());
        add(checkboxPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
        add(new JScrollPane(billArea), BorderLayout.SOUTH);

        // Button click event
        generateBillButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                generateBill();
            }
        });
    }

    private void generateBill() {
        StringBuilder bill = new StringBuilder("Selected Items:\n");
        int total = 0;

        if (laptopCheckbox.isSelected()) {
            bill.append("Laptop - $").append(prices.get("Laptop")).append("\n");
            total += prices.get("Laptop");
        }
        if (phoneCheckbox.isSelected()) {
            bill.append("Phone - $").append(prices.get("Phone")).append("\n");
            total += prices.get("Phone");
        }
        if (headphonesCheckbox.isSelected()) {
            bill.append("Headphones - $").append(prices.get("Headphones")).append("\n");
            total += prices.get("Headphones");
        }

        bill.append("----------------------\n");
        bill.append("Total Price: $").append(total);

        billArea.setText(bill.toString());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new ShoppingCartSimulation().setVisible(true);
        });
    }
}