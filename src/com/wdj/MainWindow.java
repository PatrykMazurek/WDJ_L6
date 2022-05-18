package com.wdj;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;

public class MainWindow {

    Font labelFont;
    Font textFont;

    public MainWindow(){

        JFrame frame = new JFrame("moje okno");
        frame.setBounds(30, 30, 300, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        labelFont = new Font("SansSerif", Font.BOLD, 17);
        textFont = new Font("SansSerif", Font.HANGING_BASELINE, 15);

        JButton button = new JButton("Zapisz");

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // przywróecnie działania przycisku
//                String s = textField.getText();
//                int n = Integer.parseInt(spinner.getValue().toString());
//                message.setText("Pobrane wartości " + s + " " + n);
                //System.out.println( "Pobrane wartości " + s + " " + n);
            }
        });
        frame.setJMenuBar(createMenu());
        frame.setLayout(new GridLayout(3,1));
        frame.add(personPanel());
        frame.add(new JPanel().add(new JButton("Zapisz")));
        frame.add(new JPanel().add(new JLabel("Message")));

//        frame.pack();

        frame.setVisible(true);
    }

    protected JMenuBar createMenu(){
        JMenuBar menuBar = new JMenuBar();
        // generowanie zakładek
        JMenu fileMenu = new JMenu("Pliki");
        // generowanie rekordów
        JMenuItem saveItem = new JMenuItem("Zapisz");
        JMenuItem openItem = new JMenuItem("Otwórz");
        openItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Dowolny tekst");
                // do uzupełnienia otwieranie filechooser i pobranie loklizacji pliku
//                JFileChooser file = new JFileChooser();
//                file.setVisible(true);
            }
        });
        fileMenu.add(saveItem);
        fileMenu.add(openItem);
        menuBar.add(fileMenu);
        return menuBar;
    }

    protected JPanel personPanel(){
        JPanel tempPanel = new JPanel(new GridBagLayout());
        GridBagConstraints cgrid = new GridBagConstraints();
        cgrid.fill = GridBagConstraints.HORIZONTAL;
        cgrid.gridx=0;
        cgrid.gridy=0;
        JLabel text = new JLabel("imię");
        text.setFont(labelFont);
        tempPanel.add(text, cgrid);

        cgrid.gridx=1;
        cgrid.gridy=0;
        JTextField textField = new JTextField(15);
        textField.setFont(textFont);
        tempPanel.add(textField, cgrid);

        cgrid.gridx=0;
        cgrid.gridy=1;
        JLabel ageLabel = new JLabel("Wiek");
        ageLabel.setFont(labelFont);
        tempPanel.add(ageLabel, cgrid);

        cgrid.gridx=1;
        cgrid.gridy=1;
        // generowanie daty
        JSpinner ageSpinner = new JSpinner(new SpinnerDateModel(
                new Date(), null, null, Calendar.DAY_OF_MONTH));
        JSpinner.DateEditor dateEditor =
                new JSpinner.DateEditor(ageSpinner, "dd/MM/YYYY");
        ageSpinner.setEditor(dateEditor);
        // generowanie numeru
//        JSpinner ageSpinner = new JSpinner(
//                new SpinnerNumberModel(1, 0, 100, 1));
//        ageSpinner.setSize(30, 25);
        ageSpinner.setFont(textFont);
        tempPanel.add(ageSpinner, cgrid);
        return tempPanel;
    }

}
