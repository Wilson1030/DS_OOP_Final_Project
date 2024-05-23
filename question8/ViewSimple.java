package question8;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.*;

public class ViewSimple extends JFrame implements ModelListener {
    private FinanceOffice m;
    private ControllerSimple c;
    private JLabel label;

    public ViewSimple(FinanceOffice m, ControllerSimple c) {
        this.m = m;
        this.c = c;

        // Register the view with the model
        m.addListener(this);

        // Initialize and add the label
        label = new JLabel("Total amount of debt: " + m.totalDebt());
        this.add(label, BorderLayout.CENTER);

        // Set up the frame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(300, 100);
        this.setVisible(true);
    }

    @Override
    public void update() {
        label.setText("Total amount of debt: " + m.totalDebt());
    }
}