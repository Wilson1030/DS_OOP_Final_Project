package question13;

import javax.swing.*;

public abstract class View<T extends Controller> extends JFrame implements ModelListener {
    protected FinanceOffice m;
    protected T c;

    public View(FinanceOffice m, T c) {
        this.m = m;
        this.c = c;
        
        // Register the view with the model
        m.addListener(this);
        
        // Common setup for all views
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public abstract void update();
}