package question13;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewPay extends View<ControllerPay> {
    private JTextField t1;
    private JTextField t2;
    private JButton button;

    public ViewPay(FinanceOffice m, ControllerPay c) {
        super(m, c);

        // Set up the layout
        this.setLayout(new GridLayout(3, 1));

        // Initialize the text fields and button
        t1 = new JTextField("Type a payer name here");
        t2 = new JTextField("Type an amount of money here");
        button = new JButton("Pay");

        // Add components to the frame
        this.add(t1);
        this.add(t2);
        this.add(button);

        // Add action listener to the button
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = t1.getText();
                String amount = t2.getText();
                String result = c.pay(name, amount);
                if (!result.isEmpty()) {
                    JOptionPane.showMessageDialog(ViewPay.this, result);
                }
            }
        });

        // Set up the frame
        this.setSize(300, 150);
        this.setTitle("View Pay");
        this.setVisible(true);
    }

    @Override
    public void update() {}
}