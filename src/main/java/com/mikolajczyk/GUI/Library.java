package com.mikolajczyk.GUI;

import javax.swing.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Library extends JFrame implements Runnable{

    private JLabel chooseOperationText;
    private JRadioButton addRecord;
    private JRadioButton deleteRecord;
    private JRadioButton showInfo;
    private JComboBox chooseFromList;
    private JTextArea enterText;
    private JRadioButton showAll;
    private JRadioButton onlySpecialRecord;
    private JButton confirm;
    private JButton reset;
    private JTable historyTable;
    private JTable userTable;
    private JTable bookTable;
    private JPanel panel1;
    private JLabel hourDate;
    private JLabel errorMessage;

    public LocalDateTime now;
    public DateTimeFormatter dtf  = DateTimeFormatter.ofPattern("HH:mm dd-MM-yyyy");

    public void runWindow(){
        setTitle("Biblioteka ver. 1.0.2");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(true);
        setContentPane(panel1);
        pack();
        setSize(1600,850);
        setLocationRelativeTo(null);
        setIconImage(new ImageIcon("ksiazka.png").getImage());
        run();
    }

    public static void main(String[] args) {
        Library library = new Library();
        library.runWindow();
    }

    public JLabel getChooseOperationText() {
        return chooseOperationText;
    }

    public JRadioButton getAddRecord() {
        return addRecord;
    }

    public JRadioButton getDeleteRecord() {
        return deleteRecord;
    }

    public JRadioButton getShowInfo() {
        return showInfo;
    }

    public JComboBox getChooseFromList() {
        return chooseFromList;
    }

    public JTextArea getEnterText() {
        return enterText;
    }

    public JRadioButton getShowAll() {
        return showAll;
    }

    public JRadioButton getOnlySpecialRecord() {
        return onlySpecialRecord;
    }

    public JButton getConfirm() {
        return confirm;
    }

    public JButton getReset() {
        return reset;
    }

    public JTable getHistoryTable() {
        return historyTable;
    }

    public JTable getUserTable() {
        return userTable;
    }

    public JTable getBookTable() {
        return bookTable;
    }

    public JPanel getPanel1() {
        return panel1;
    }

    public JLabel getHourDate() {
        return hourDate;
    }

    public JLabel getErrorMessage() {
        return errorMessage;
    }

    @Override
    public void run() {
        while(true){
            now = LocalDateTime.now();
            getHourDate().setText(dtf.format(now));
        }
    }
}
