package TAL_projekt;

import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.*;

public class ResultsFrame {
    public ResultsFrame(long time, long memory, boolean result) {
        ResultsPanel resultsPanel = new ResultsPanel(time, memory, result);
        JFrame resultsFrame = new JFrame("Dane końcowe");
        resultsFrame.setContentPane(resultsPanel);
        resultsFrame.pack();
        resultsFrame.setLocationRelativeTo(null);
        resultsFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        resultsFrame.setVisible(true);
    }

    public ResultsFrame(long time, long memory, boolean result, HashMap<String, ArrayList<Integer>> map) {
        ResultsPanel resultsPanel = new ResultsPanel(time, memory, result, map);
        JFrame resultsFrame = new JFrame("Dane końcowe");
        resultsFrame.setContentPane(resultsPanel);
        resultsFrame.pack();
        resultsFrame.setLocationRelativeTo(null);
        resultsFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        resultsFrame.setVisible(true);
    }
}
