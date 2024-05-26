package question14;

import javax.swing.*;
import java.awt.*;

public class ViewSimple extends View<ControllerSimple> {
    private JLabel label;

    public ViewSimple(FinanceOffice m, ControllerSimple c) {
        super(m, c);

        // Initialize and add the label
        label = new JLabel("Total amount of debt: " + m.totalDebt());
        this.add(label, BorderLayout.CENTER);

        // Set up the frame
        this.setSize(300, 100);
        this.setTitle("Message");
        this.setVisible(true);
    }

    @Override
    public void update() {
        label.setText("Total amount of debt: " + m.totalDebt());
    }
}