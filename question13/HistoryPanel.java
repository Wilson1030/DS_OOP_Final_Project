package question13;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class HistoryPanel extends JPanel {
    private FinanceOffice model;

    public HistoryPanel(FinanceOffice model) {
        this.model = model;
    }

    private int historyMax(ArrayList<Integer> history) {
        int max = Integer.MIN_VALUE;
        for (int value : history) {
            if (value > max) {
                max = value;
            }
        }
        return max;
    }

    private int historyMin(ArrayList<Integer> history) {
        int min = Integer.MAX_VALUE;
        for (int value : history) {
            if (value < min) {
                min = value;
            }
        }
        return min;
    }

    private int historyRange(ArrayList<Integer> history) {
        int min = historyMin(history);
        int max = historyMax(history);
        int range = max - min;
        return (range < 200) ? 200 : range;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        ArrayList<Integer> history = model.getHistory();
        int min = historyMin(history);
        int range = historyRange(history);
        int maxX = getWidth() - 1;
        int maxY = getHeight() - 1;
        int zero = maxY + min * maxY / range;

        g.setColor(Color.BLUE);
        
        // Draw zero line
        g.drawLine(0, zero, maxX, zero);
        
        g.setColor(Color.RED);
        
        // Draw red line representing total debt
        for (int i = 0; i < history.size(); i++) {
            int x = 10 * i;
            int y = zero - (history.get(i) * maxY / range);
            if (i > 0) {
                int prevX = 10 * (i - 1);
                int prevY = zero - (history.get(i - 1) * maxY / range);
                g.drawLine(prevX, prevY, x, y);
            } else {
                g.fillRect(x, y, 1, 1);
            }
        }
    }
}