package TAL_projekt;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import javax.swing.*;

public class ResultsPanel extends JPanel {
    JLabel time, timeValue, memory, memoryValue, result, resultValue;
    JTextArea subsets;
    private int width = 300, height = 300;

    public JLabel valueName(String text, int x, int y, int width) {
        JLabel label = new JLabel(text);
        label.setForeground(new Color(0, 0, 0));
        label.setBounds(x, y, width, 20);
        return label;
    }

    public JLabel value(String text, int x, int y, int width) {
        JLabel label = new JLabel(text);
        label.setForeground(new Color(0, 0, 0));
        label.setBounds(x, y, width, 20);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        return label;
    }

    public ResultsPanel(long time, long memory, boolean result) {
        this.setLayout(null);
        this.setPreferredSize(new Dimension(width, height));
        this.setBackground(new Color(200, 200, 200));

        this.time = this.valueName("Czas wykonania:", 10, 5, width);
        this.add(this.time);
        this.timeValue = this.value(Long.toString(time) + " ns", 0, 25, width);
        this.timeValue.setForeground(new Color(255, 85, 0));
        this.add(this.timeValue);

        this.memory = this.valueName("Maksymalna ilość zajętej pamięci:", 10, 45, width);
        this.add(this.memory);
        double mem = (double) memory / 1024 / 1024;
        this.memoryValue = this.value(Double.toString(mem) + "  MB", 0, 70, width);
        this.memoryValue.setForeground(new Color(255, 85, 0));
        this.add(this.memoryValue);

        this.result = this.valueName("Wynik operacji:", 10, 85, width);
        this.add(this.result);
        this.resultValue = this.value(Boolean.toString(result), 0, 105, width);
        if (result) {
            this.resultValue.setForeground(new Color(50, 155, 50));
        } else {
            this.resultValue.setForeground(new Color(255, 0, 0));
        }
        this.add(this.resultValue);

        this.subsets = new JTextArea();
        this.subsets.setBackground(new Color(200, 200, 200));
        this.subsets.setForeground(new Color(0, 0, 0));
        this.subsets.setBounds(0, 145, 300, 155);
        this.subsets.setLineWrap(true);
        this.subsets.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        this.add(this.subsets);
    }

    public ResultsPanel(long time, long memory, boolean result, HashMap<String, ArrayList<Integer>> map) {
        this.setLayout(null);
        this.setPreferredSize(new Dimension(width, height));
        this.setBackground(new Color(200, 200, 200));

        this.time = this.valueName("Czas wykonywania:", 10, 5, width);
        this.add(this.time);
        this.timeValue = this.value(Long.toString(time) + " ns", 0, 25, width);
        this.timeValue.setForeground(new Color(255, 85, 0));
        this.add(this.timeValue);

        this.memory = this.valueName("Maksymalna ilość zajętej pamięci:", 10, 45, width);
        this.add(this.memory);
        double mem = (double) memory / 1024 / 1024;
        this.memoryValue = this.value(Double.toString(mem) + "  MB", 0, 70, width);
        this.memoryValue.setForeground(new Color(255, 85, 0));
        this.add(this.memoryValue);

        this.result = this.valueName("Wynik operacji:", 10, 85, width);
        this.add(this.result);
        this.resultValue = this.value(Boolean.toString(result), 0, 105, width);
        if (result) {
            this.resultValue.setForeground(new Color(50, 155, 50));
        } else {
            this.resultValue.setForeground(new Color(255, 0, 0));
        }
        this.add(this.resultValue);

        this.subsets = new JTextArea();
        this.subsets.setBackground(new Color(200, 200, 200));
        this.subsets.setForeground(new Color(0, 0, 0));
        this.subsets.setBounds(0, 145, 300, 155);
        this.subsets.setLineWrap(true);
        this.subsets.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));

        StringBuilder sb = new StringBuilder();
        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            Entry<String, ArrayList<Integer>> entry = (Entry) it.next();
            sb.append("\t" + entry.getKey() + "\n");
        }

        if (map.size() > 0) {
            sb.deleteCharAt(sb.toString().length() - 1);
        }

        this.subsets.setText(sb.toString());
        JScrollPane sp = new JScrollPane(this.subsets);
        sp.setBounds(0, 145, 300, 155);
        sp.setBorder(null);
        this.add(sp);
    }
}
