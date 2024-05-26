package question14;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewCreate extends View<ControllerCreate> {
    private JTextField t1;
    private JTextField t2;
    private JComboBox<String> cb;
    private JButton button;

    public ViewCreate(FinanceOffice m, ControllerCreate c) {
        super(m, c);

        // Set up the layout
        this.setLayout(new GridLayout(4, 1));

        // Initialize the text fields and combo box
        t1 = new JTextField("Type a new payer name here");
        t2 = new JTextField("Type an amount of money here");
        cb = new JComboBox<>(new String[]{"Student", "Employee", "Faculty Member"});
        button = new JButton("Create Payer");

        // Add components to the frame
        this.add(t1);
        this.add(t2);
        this.add(cb);
        this.add(button);

        // Add action listener to the button
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = t1.getText();
                String amount = t2.getText();
                int type = cb.getSelectedIndex();
                String result = c.create(name, amount, type);
                if (!result.isEmpty()) {
                    JOptionPane.showMessageDialog(ViewCreate.this, result);
                }
            }
        });

        // Set up the frame
        this.setSize(300, 200);
        this.setTitle("View Create");
        this.setVisible(true);
    }

    @Override
    public void update() {}
}