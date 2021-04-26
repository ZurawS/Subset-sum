package TAL_projekt;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MainPanel extends JPanel implements ActionListener {

    private int width = 840;
    private int height = 400;
    JTextArea input;
    JTextField sum, minRandom, maxRandom, minGenerate, maxGenerate, generateAmount;
    JButton random, generate, run, dokButton, heuButton;
    JLabel inputLabel, searchedNumber, randomizeNumber, chooseAlgorithm, dokladny, heurystyczny, generateNum;
    int choice = 0;
    Algorithms algorithms = new Algorithms();

    public JLabel createLabel(String text, int x, int y, int width) {
        JLabel label = new JLabel(text);
        label.setForeground(new Color(50, 50, 50));
        label.setBounds(x, y, width, 20);
        return label;
    }

    public JTextField createField(int x, int y, int width) {
        JTextField field = new JTextField();
        field.setBackground(new Color(70, 70, 70));
        field.setForeground(new Color(255, 255, 255));
        field.setBounds(x, y, width, 20);
        field.setBorder(null);
        field.setHorizontalAlignment(0);
        return field;
    }

    public JButton createButton(String text, int x, int y, int width, String actionCommand) {
        JButton button = new JButton(text);
        button.setBackground(new Color(56, 89, 152));
        button.setBounds(x, y, width, 20);
        button.setBorder(null);
        button.setForeground(new Color(255, 255, 255));
        button.setActionCommand(actionCommand);
        button.addActionListener(this);
        return button;
    }

    public JButton smallButton(int x, int y, String actionCommand) {
        JButton button = new JButton();
        button.setBackground(new Color(255, 165, 0));
        button.setBounds(x, y + 6, 10, 10);
        button.setBorder(null);
        button.setForeground(new Color(255, 255, 255));
        button.setActionCommand(actionCommand);
        button.addActionListener(this);
        return button;
    }

    public void actionPerformed(ActionEvent ae) {
        String var2;
        Random rand;
        int sum;
//        System.out.println(ae.getActionCommand().toString().hashCode());
        switch ((var2 = ae.getActionCommand().toString()).hashCode()) {
            case 82539:
                if (var2.equals("Run")) {
                    if (this.choice == 0) {
                        this.algorithms.algDokladny(this.getZbior(), Integer.parseInt(this.sum.getText()));
                    } else {
                        this.algorithms.algHeurystyczny(this.getZbior(), Integer.parseInt(this.sum.getText()));
                    }
                }
                break;
            case 1146728058:
                if (var2.equals("Dokladny")) {
                    this.choice = 0;
                    this.dokButton.setBackground(new Color(255, 165, 0));
                    this.heuButton.setBackground(new Color(70, 70, 70));
                }
                break;
            case 1038097051:
                if (var2.equals("Heurystyczny")) {
                    this.choice = 1;
                    this.dokButton.setBackground(new Color(70, 70, 70));
                    this.heuButton.setBackground(new Color(255, 165, 0));
                }
                break;
            case 1176435089:
                if (var2.equals("Randomize")) {
                    rand = new Random();
                    sum = rand.nextInt(Integer.parseInt(this.maxRandom.getText()) - Integer.parseInt(this.minRandom.getText()) + 1) + Integer.parseInt(this.minRandom.getText());
                    this.sum.setText(Integer.toString(sum));
                }
                break;
            case 1875016085:
                if (var2.equals("Generate")) {
                    rand = new Random();
                    StringBuilder text = new StringBuilder();

                    for (int i = 1; i < Integer.parseInt(this.generateAmount.getText()); i++) {
                        sum = rand.nextInt(Integer.parseInt(this.maxGenerate.getText()) - Integer.parseInt(this.minGenerate.getText()) + 1) + Integer.parseInt(this.minGenerate.getText());

                        text.append(sum);
                        if (i != Integer.parseInt(this.generateAmount.getText()) - 1) {
                            text.append(",");
                        }
                    }
                    this.input.setText(text.toString());
                }
        }

    }

    public ArrayList<Integer> getZbior() {
        ArrayList<Integer> zbior = new ArrayList<Integer>();
        if (input.getText().length() == 0) {
            return zbior;
        }
        String[] numsBefore = input.getText().split(",");

        for (int i = 0; i < numsBefore.length; i++) {
            zbior.add(Integer.parseInt(numsBefore[i]));
        }
        return zbior;
    }

    public MainPanel() {
        this.setPreferredSize(new Dimension(width, height));
        this.setLayout(null);
        this.setBackground(new Color(200, 200, 200));

        this.inputLabel = this.createLabel("Dane wejściowe:", this.width / 2, 0, this.width / 2);
        this.add(this.inputLabel);

        this.input = new JTextArea();
        this.input.setBackground(new Color(70, 70, 70));
        this.input.setForeground(new Color(255, 255, 255));
        this.input.setBounds(this.width / 2, 20, this.width / 2 - 10, this.height - 30);
        this.input.setLineWrap(true);
        this.add(this.input);
        this.input.setText("0");

        this.searchedNumber = this.createLabel("Poszukiwana suma:", 10, 10, this.width / 2);
        this.add(this.searchedNumber);

        this.sum = this.createField(10, 30, 400);
        this.sum.setText(Integer.toString(10));
        this.add(this.sum);

        this.randomizeNumber = this.createLabel("Wylosuj poszukiwaną sumę:", 10, 50, this.width / 2);
        this.add(this.randomizeNumber);

        this.minRandom = this.createField(40, 75, 100);
        this.minRandom.setText(Integer.toString(0));
        this.add(this.minRandom);

        this.maxRandom = this.createField(150, 75, 100);
        this.maxRandom.setText(Integer.toString(10));
        this.add(this.maxRandom);

        this.random = this.createButton("Losuj", 260, 75, 100, "Randomize");
        this.add(this.random);

        this.chooseAlgorithm = this.createLabel("Wybierz algorytm:", 10, 100, this.width / 2);
        this.add(this.chooseAlgorithm);

        this.dokButton = this.smallButton(30, 125, "Dokladny");
        this.add(this.dokButton);

        this.dokladny = this.createLabel("Algorytm dokładny", 50, 125, 150);
        this.add(this.dokladny);

        this.heuButton = this.smallButton(220, 125, "Heurystyczny");
        this.heuButton.setBackground(new Color(70, 70, 70));
        this.add(this.heuButton);

        this.heurystyczny = this.createLabel("Algorytm heurystyczny", 240, 125, 150);
        this.add(this.heurystyczny);

        this.generateNum = this.createLabel("Wylosuj dane wejściowe:", 10, 150, this.width / 2);
        this.add(this.generateNum);

        this.minGenerate = this.createField(40, 180, 70);
        this.minGenerate.setText(Integer.toString(0));
        this.add(this.minGenerate);

        this.maxGenerate = this.createField(120, 180, 70);
        this.maxGenerate.setText(Integer.toString(10));
        this.add(this.maxGenerate);

        this.generateAmount = this.createField(200, 180, 70);
        this.generateAmount.setText(Integer.toString(10));
        this.add(this.generateAmount);

        this.generate = this.createButton("Generuj", 280, 180, 80, "Generate");
        this.add(this.generate);

        this.run = this.createButton("START", this.width / 4 - 60, 220, 120, "Run");
        this.add(this.run);

    }
}
