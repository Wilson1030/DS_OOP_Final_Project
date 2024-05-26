package question14;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public abstract class View<T extends Controller> extends JFrame implements ModelListener {
    protected FinanceOffice m;
    protected T c;

    public View(FinanceOffice m, T c) {
        this.m = m;
        this.c = c;
        
        // Register the view with the model
        m.addListener(this);
        
        // Common setup for all views
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                hideFrame();
                c.shutdown();
            }
        });
    }

    // Hide the frame when the user clicks on the "close" button
    public void hideFrame() {
        this.setVisible(false);
    }

    @Override
    public abstract void update();
}