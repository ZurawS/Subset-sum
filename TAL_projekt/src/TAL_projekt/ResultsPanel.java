package TAL_projekt;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import javax.swing.*;

public class ResultsPanel extends JPanel {
    JLabel time;
    JLabel timeValue;
    JLabel memory;
    JLabel memoryValue;
    JLabel result;
    JLabel resultValue;
    JTextArea podzbiory;
    private int width = 300;
    private int height = 300;

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
        double mem = (double) memory * 0.125D / 1000.0D;//???????????
        this.memoryValue = this.value(Double.toString(mem) + "  kB", 0, 70, width);
        this.memoryValue.setForeground(new Color(255, 85, 0));
        this.add(this.memoryValue);

        this.result = this.valueName("Wynik operacji:", 10, 85, width);
        this.add(this.result);
        this.resultValue = this.value( Boolean.toString(result), 0, 105, width);
        if (result) {
            this.resultValue.setForeground(new Color(50, 155, 50));
        } else {
            this.resultValue.setForeground(new Color(255, 0, 0));
        }
        this.add(this.resultValue);

        this.podzbiory = new JTextArea();
        this.podzbiory.setBackground(new Color(200, 200, 200));
        this.podzbiory.setForeground(new Color(0,0,0));
        this.podzbiory.setBounds(0, 145, 300, 155);
        this.podzbiory.setLineWrap(true);
        this.podzbiory.setBorder(BorderFactory.createLineBorder(new Color(0,0,0)));
        this.add(this.podzbiory);
    }

    public ResultsPanel(long time, long memory, boolean result, HashMap<String, ArrayList<Integer>> map) {
        this.setLayout(null);
        this.setPreferredSize(new Dimension(width,height));
        this.setBackground(new Color(200,200,200));

        this.time = this.valueName("Czas wykonywania:", 10, 5, width);
        this.add(this.time);
        this.timeValue = this.value(Long.toString(time) + " ns", 0, 25, width);
        this.timeValue.setForeground(new Color(255, 85, 0));
        this.add(this.timeValue);

        this.memory = this.valueName("Maksymalna ilość zajętej pamięci:", 10, 45, width);
        this.add(this.memory);
        double mem = (double) (memory / 1000L);
        this.memoryValue = this.value(Double.toString(mem) + "  kB", 0, 70, width);
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

        this.podzbiory = new JTextArea();
        this.podzbiory.setBackground(new Color(200,200,200));
        this.podzbiory.setForeground(new Color(0,0,0));
        this.podzbiory.setBounds(0, 145, 300, 155);
        this.podzbiory.setLineWrap(true);
        this.podzbiory.setBorder(BorderFactory.createLineBorder(new Color(0,0,0)));

        StringBuilder sb = new StringBuilder();
        Iterator var11 = map.entrySet().iterator();
        while (var11.hasNext()) {
            Entry<String, ArrayList<Integer>> entry = (Entry) var11.next();
            sb.append("\t" + (String) entry.getKey() + "\n");
        }

        if (map.size() > 0) {
            sb.deleteCharAt(sb.toString().length() - 1);
        }

        this.podzbiory.setText(sb.toString());
        JScrollPane sp = new JScrollPane(this.podzbiory);
        sp.setBounds(0, 145, 300, 155);
        sp.setBorder(null);
        this.add(sp);
    }
}
