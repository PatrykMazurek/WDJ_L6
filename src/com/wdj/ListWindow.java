package com.wdj;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ListWindow {

    JTextField searchText;
    public ListWindow(){
        JFrame frame = new JFrame("Lista obiektów");

//        frame.setBounds(20, 20, 350, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel navigationPanel = new JPanel();

        JButton AddNewObj = new JButton("Dodaj nowy element");
        JButton search = new JButton("Zapisz");
        search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser file = new JFileChooser(
                        FileSystemView.getFileSystemView().getHomeDirectory());
                int rerurnCode = file.showOpenDialog(null);
                if (rerurnCode == JFileChooser.APPROVE_OPTION){
                    int decision = JOptionPane.showConfirmDialog(null,
                            "Czy napewno chcesz otworzyć plik?");
                    if (decision == JOptionPane.YES_OPTION){
                        File selectedFile = file.getSelectedFile();
                        System.out.println("Wybrany plik " + selectedFile.getName());
                        try {
                            FileWriter fw = new FileWriter(selectedFile);
                            fw.write(searchText.getText());
                            fw.close();
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    }
                }
            }
        });
        JButton refresh = new JButton("Odświerz");
        searchText = new JTextField(15);

        navigationPanel.add(AddNewObj);
        navigationPanel.add(searchText);
        navigationPanel.add(search);
        navigationPanel.add(refresh);

        String[] headerName = {"nr", "Pole 1", "Pole 2", "Pole 3"};

        Object[][] data = {{1, "Pole 1", 12, 20.5},
                {2, "Pole 2", 12, 20.5},
                {3, "Pole 3", 12, 20.5},
                {4, "Pole 4", 12, 20.5},};

        JTable objTable = new JTable(data, headerName);
        objTable.setAutoCreateRowSorter(true);

        JScrollPane scroleTable = new JScrollPane(objTable);

        frame.setJMenuBar(createMenu());
        frame.setLayout(new BorderLayout());
        frame.add(navigationPanel, BorderLayout.NORTH);
        frame.add(scroleTable, BorderLayout.CENTER);
        frame.pack();
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
                JFileChooser file = new JFileChooser(
                        FileSystemView.getFileSystemView().getHomeDirectory());
                int rerurnCode = file.showOpenDialog(null);
                if (rerurnCode == JFileChooser.APPROVE_OPTION){
//                    JOptionPane.showMessageDialog(null,
//                            "Wybrano " + selectedFile.getName(),
//                            "Błąd", JOptionPane.ERROR_MESSAGE);

                    int decision = JOptionPane.showConfirmDialog(null,
                            "Czy napewno chcesz otworzyć plik?");
                    if (decision == JOptionPane.YES_OPTION){
                        File selectedFile = file.getSelectedFile();
                        System.out.println("Wybrany plik " + selectedFile.getName());
                    }
                }
            }
        });
        fileMenu.add(saveItem);
        fileMenu.add(openItem);
        menuBar.add(fileMenu);
        return menuBar;
    }
}
