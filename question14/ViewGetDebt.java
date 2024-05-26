package question14;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewGetDebt extends View<ControllerGetDebt> {
    private JTextField t;
    private JButton button;

    public ViewGetDebt(FinanceOffice m, ControllerGetDebt c) {
        super(m, c);

        // Set up the layout
        this.setLayout(new GridLayout(2, 1));

        // Initialize the text field and button
        t = new JTextField("Type a payer name here");
        button = new JButton("Tell me the debt");

        // Add components to the frame
        this.add(t);
        this.add(button);

        // Add action listener to the button
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = t.getText();
                String result = c.getDebt(name);
                JOptionPane.showMessageDialog(ViewGetDebt.this, result);
            }
        });

        // Set up the frame
        this.setSize(300, 100);
        this.setTitle("View Debt");
        this.setVisible(true);
    }

    @Override
    public void update() {
    }
}
