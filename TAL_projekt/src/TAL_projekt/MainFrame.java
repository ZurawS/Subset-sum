package TAL_projekt;

import javax.swing.JFrame;

public class MainFrame {
    JFrame mainFrame = new JFrame("TAL: Problem sumy podzbioru \n");

    MainPanel mainPanel = new MainPanel();

    public MainFrame() {
        this.mainFrame.setContentPane(this.mainPanel);
        this.mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.mainFrame.pack();
        this.mainFrame.setLocationRelativeTo(null);
        this.mainFrame.setVisible(true);
    }

    public static void main(String[] args) {
        new MainFrame();
    }
}
