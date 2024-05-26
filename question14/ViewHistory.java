package question14;

public class ViewHistory extends View<ControllerHistory> {
    private HistoryPanel historyPanel;

    public ViewHistory(FinanceOffice m, ControllerHistory c) {
        super(m, c);
        historyPanel = new HistoryPanel(m);
        this.add(historyPanel);
        this.setSize(400, 300);
        this.setTitle("View History");
        this.setVisible(true);
    }

    @Override
    public void update() {
        historyPanel.repaint();
    }
}