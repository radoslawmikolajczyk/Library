package com.mikolajczyk.GUI;

import com.mikolajczyk.Components.Book;
import com.mikolajczyk.Components.History;
import com.mikolajczyk.Components.Reader;
import com.mikolajczyk.Configuration.LibraryConfiguration;

import javax.swing.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Library extends JFrame implements Runnable{

    private JLabel chooseOperationText;
    private JRadioButton addRecord;
    private JRadioButton deleteRecord;
    private JRadioButton showInfo;
    private JComboBox chooseFromList;
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
    private JTextField enterNameTitle;
    private JLabel nameTitle;
    private JLabel lNameAuthor;
    private JTextField enterLNameAuthor;
    private JTextField enterPhNumberPublicy;
    private JLabel phNumberPublicy;
    private JTextField enterAddressYearOfPub;
    private JLabel addressYearOfPub;
    private JLabel numberOfBooks;
    private JTextField enterNumberOfBooks;

    public LocalDateTime now;
    public DateTimeFormatter dtf  = DateTimeFormatter.ofPattern("HH:mm:ss dd-MM-yyyy");
    private ButtonGroup buttonGroup1 = new ButtonGroup();
    private ButtonGroup buttonGroup2 = new ButtonGroup();
    private List<JTextField> readerTextFields = new ArrayList<>();
    private List<JTextField> bookTextFields = new ArrayList<>();
    private List<JTextField> historyTextFields = new ArrayList<>();
    private Reader reader;
    private History history;
    private Book book;


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

    public JTextField getEnterNameTitle() { return enterNameTitle; }

    public JLabel getNameTitle() {
        return nameTitle;
    }

    public JLabel getlNameAuthor() {
        return lNameAuthor;
    }

    public JTextField getEnterLNameAuthor() {
        return enterLNameAuthor;
    }

    public JTextField getEnterPhNumberPublicy() {
        return enterPhNumberPublicy;
    }

    public JLabel getPhNumberPublicy() {
        return phNumberPublicy;
    }

    public JTextField getEnterAddressYearOfPub() {
        return enterAddressYearOfPub;
    }

    public JLabel getAddressYearOfPub() {
        return addressYearOfPub;
    }

    public JLabel getNumberOfBooks() {
        return numberOfBooks;
    }

    public JTextField getEnterNumberOfBooks() {
        return enterNumberOfBooks;
    }

    public ButtonGroup getButtonGroup1() {
        return buttonGroup1;
    }

    public ButtonGroup getButtonGroup2() {
        return buttonGroup2;
    }

    public List<JTextField> getReaderTextFields() {
        return readerTextFields;
    }

    public List<JTextField> getBookTextFields() {
        return bookTextFields;
    }

    public List<JTextField> getHistoryTextFields() {
        return historyTextFields;
    }

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
        setJTextFieldLists();
        initButtonGroups();
        actionListeners();
        run();
    }

    public void setJTextFieldLists(){
        readerTextFields.add(enterNameTitle);
        readerTextFields.add(enterLNameAuthor);
        readerTextFields.add(enterAddressYearOfPub);
        readerTextFields.add(enterPhNumberPublicy);

        bookTextFields.addAll(readerTextFields);
        bookTextFields.add(enterNumberOfBooks);

        historyTextFields.addAll(readerTextFields);
    }

    public void initButtonGroups(){
        buttonGroup1.add(addRecord);
        buttonGroup1.add(deleteRecord);
        buttonGroup1.add(showInfo);

        buttonGroup2.add(showAll);
        buttonGroup2.add(onlySpecialRecord);
    }

    public void messageFromDeletingAndShowingInfo(){
        String choose = (String) chooseFromList.getItemAt(chooseFromList.getSelectedIndex());

        if (choose.equals("Czytelnicy")){
            errorMessage.setText("Wystarczy, że podasz imię, nazwisko oraz numer telefonu czytelnika.");
        } else if (choose.equals("Książki")){
            errorMessage.setText("Wystarczy, że podasz tytuł i autora książki");
        } else if (choose.equals("Wypożyczenia")){
            errorMessage.setText("Musisz podać wszystkie dane wymagane w polach");
        }
    }

    public void actionListeners(){

        reset.addActionListener(e -> defaultSettings());

        showAll.addActionListener(e -> {
            if (showAll.isSelected()) {
                numberOfBooks.setText("");
                nameTitle.setText("");
                lNameAuthor.setText("");
                phNumberPublicy.setText("");
                addressYearOfPub.setText("");
                for (JTextField field : bookTextFields){
                    field.setVisible(false);
                }
            }

        });

        deleteRecord.addActionListener(e -> {
            showAll.setVisible(false);
            onlySpecialRecord.setVisible(false);
            onlySpecialRecord.doClick();
            messageFromDeletingAndShowingInfo();
        });

        addRecord.addActionListener(e -> {
            showAll.setVisible(false);
            onlySpecialRecord.setVisible(false);
            errorMessage.setText("");
            onlySpecialRecord.doClick();


        });

        showInfo.addActionListener(e -> {
            showAll.setVisible(true);
            onlySpecialRecord.setVisible(true);
            errorMessage.setText("");
            messageFromDeletingAndShowingInfo();
        });

        confirm.addActionListener(e -> {

        });
    }

    public void defaultSettings(){
        buttonGroup1.clearSelection();
        buttonGroup2.clearSelection();
        enterNumberOfBooks.setText("");
        enterNameTitle.setText("");
        enterAddressYearOfPub.setText("");
        enterLNameAuthor.setText("");
        enterPhNumberPublicy.setText("");

    }

    public void checkCombobox(){
        String choose = (String) chooseFromList.getItemAt(chooseFromList.getSelectedIndex());

        if (choose.equals("Czytelnicy") && !showAll.isSelected()){
            numberOfBooks.setText("");
            enterNumberOfBooks.setVisible(false);
            nameTitle.setText("Imię");
            lNameAuthor.setText("Nazwisko");
            phNumberPublicy.setText("Numer telefonu");
            addressYearOfPub.setText("Adres");

            for (JTextField field : readerTextFields){
                field.setVisible(true);
            }
        } else if (choose.equals("Książki") && !showAll.isSelected()){
            numberOfBooks.setText("Ilość książek");
            nameTitle.setText("Tytuł");
            lNameAuthor.setText("Autor");
            phNumberPublicy.setText("Wydawnictwo");
            addressYearOfPub.setText("Rok wydania");

            for (JTextField field : bookTextFields){
                field.setVisible(true);
            }

        } else if (choose.equals("Wypożyczenia") && !showAll.isSelected()){
            numberOfBooks.setText("");
            enterNumberOfBooks.setVisible(false);
            nameTitle.setText("Imię");
            lNameAuthor.setText("Nazwisko");
            phNumberPublicy.setText("Tytuł książki");
            addressYearOfPub.setText("Autor książki");

            for (JTextField field : historyTextFields){
                field.setVisible(true);
            }
        }
    }

    public static void main(String[] args) {
        Library library = new Library();
        library.runWindow();
    }

    @Override
    public void run() {
        LibraryConfiguration.configure();
        while(true){
            now = LocalDateTime.now();
            getHourDate().setText(dtf.format(now));
            checkCombobox();
        }
    }
}
