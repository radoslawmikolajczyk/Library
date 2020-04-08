package com.mikolajczyk.GUI;

import com.mikolajczyk.Components.Book;
import com.mikolajczyk.Components.History;
import com.mikolajczyk.Components.Reader;
import com.mikolajczyk.Configuration.DeleteRecord;
import com.mikolajczyk.Configuration.LibraryConfiguration;
import com.mikolajczyk.Configuration.RecordAdding;

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

    public JLabel getHourDate() {
        return hourDate;
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

        switch (choose) {
            case "Czytelnicy":
                errorMessage.setText("Wystarczy, że podasz imię, nazwisko oraz numer telefonu czytelnika.");
                break;
            case "Książki":
                errorMessage.setText("Wystarczy, że podasz tytuł i autora książki");
                break;
            case "Wypożyczenia":
                errorMessage.setText("Musisz podać wszystkie dane wymagane w polach");
                break;
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
                errorMessage.setText("");
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
            if (addRecord.isSelected()){
                createAdding();
            } else if (deleteRecord.isSelected()){
                createDeletion();
            } else if (showInfo.isSelected()){

            }
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

    public void createDeletion(){
        String choose = (String) chooseFromList.getItemAt(chooseFromList.getSelectedIndex());

        switch (choose) {
            case "Czytelnicy":
                Reader reader = new Reader();
                reader.setfName(enterNameTitle.getText());
                reader.setlName(enterLNameAuthor.getText());
                reader.setPhoneNumber(enterPhNumberPublicy.getText());
                DeleteRecord deleteRecord = new DeleteRecord(reader);
                deleteRecord.deleteReader();
                break;
            case "Książki":
                Book book = new Book();
                book.setTitle(enterNameTitle.getText());
                book.setAuthor(enterLNameAuthor.getText());
                DeleteRecord deleteRecord1 = new DeleteRecord(book);
                deleteRecord1.deleteBook();
                break;
            case "Wypożyczenia":
                History history = new History();
                history.setfName(enterNameTitle.getText());
                history.setlName(enterLNameAuthor.getText());
                history.setTitle(enterPhNumberPublicy.getText());
                history.setAuthor(enterAddressYearOfPub.getText());
                DeleteRecord deleteRecord2 = new DeleteRecord(history);
                deleteRecord2.deleteHistory();
                break;
        }
        LibraryConfiguration.commit();
        LibraryConfiguration.refresh();
    }

    public void createAdding(){
        String choose = (String) chooseFromList.getItemAt(chooseFromList.getSelectedIndex());

        switch (choose) {
            case "Czytelnicy":
                Reader reader = new Reader();
                reader.setfName(enterNameTitle.getText());
                reader.setlName(enterLNameAuthor.getText());
                reader.setPhoneNumber(enterPhNumberPublicy.getText());
                reader.setAddress(enterAddressYearOfPub.getText());
                RecordAdding recordAdding = new RecordAdding(reader);
                recordAdding.saveRecord(reader);
                break;
            case "Książki":
                Book book = new Book();
                book.setTitle(enterNameTitle.getText());
                book.setAuthor(enterLNameAuthor.getText());
                book.setNumber(Integer.parseInt(enterNumberOfBooks.getText()));
                book.setPublisher(enterPhNumberPublicy.getText());
                book.setYear(Integer.parseInt(enterAddressYearOfPub.getText()));
                RecordAdding recordAdding1 = new RecordAdding(book);
                recordAdding1.saveRecord(book);
                break;
            case "Wypożyczenia":
                LocalDateTime now = LocalDateTime.now();
                DateTimeFormatter dtf  = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                String lendDate = dtf.format(now);
                History history = new History();
                history.setfName(enterNameTitle.getText());
                history.setlName(enterLNameAuthor.getText());
                history.setTitle(enterPhNumberPublicy.getText());
                history.setAuthor(enterAddressYearOfPub.getText());
                history.setLendDate(lendDate);
                RecordAdding recordAdding2 = new RecordAdding(history);
                recordAdding2.saveRecord(history);
                break;
        }
        LibraryConfiguration.commit();
        LibraryConfiguration.refresh();
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
