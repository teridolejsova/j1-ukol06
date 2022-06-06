package cz.czechitas.ukol6;


import com.formdev.flatlaf.FlatLightLaf;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Aplikace extends JFrame {
    private JLabel husyLabel;
    private JLabel kraliciLabel;
    private JLabel pocetHlavLabel;
    private JLabel pocetNohouLabel;

    private JSpinner husySpinner;
    private JSpinner kraliciSpinner;
    private JTextField pocetHlavField;
    private JTextField pocetNohouField;


    private JButton vypocitatButton;




    public static void main(String[] args) {
        FlatLightLaf.setup();
        new Aplikace().start();
    }

    public Aplikace() throws HeadlessException {
        super("Farmářka 1.0");
        this.init();
    }

    public void start() {
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void init() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setIconImage(new ImageIcon(Aplikace.class.getResource("czechitas-icon.png")).getImage());
        setLayout(new MigLayout("wrap 2", "[right]rel[50:120:150,grow,fill]"));
        setMinimumSize(new Dimension(250, 200));

        //TODO implementovat formulář podle zadání

        husySpinner = new JSpinner();
        husyLabel = new JLabel("Husy");
        husyLabel.setLabelFor(husySpinner);
        add(husyLabel);
        add(husySpinner);

        kraliciSpinner = new JSpinner();
        kraliciLabel = new JLabel("Králíci");
        kraliciLabel.setLabelFor(kraliciSpinner);
        add(kraliciLabel);
        add(kraliciSpinner);


        add(createButtonBar(),"span");


        pocetHlavField = new JTextField();
        pocetHlavField.setHorizontalAlignment(JTextField.TRAILING);
        pocetHlavField.setEditable(false);
        pocetHlavLabel = new JLabel("Počet hlav");
        pocetHlavLabel.setLabelFor(pocetHlavField);
        add(pocetHlavLabel);
        add(pocetHlavField);

        pocetNohouField = new JTextField();
        pocetNohouField.setHorizontalAlignment(JTextField.TRAILING);
        pocetNohouField.setEditable(false);
        pocetHlavField.isEnabled();
        pocetNohouLabel = new JLabel("Počet nohou");
        pocetNohouLabel.setLabelFor(pocetNohouField);
        add(pocetNohouLabel);
        add(pocetNohouField);


        pack();

        vypocitatButton.addActionListener(this::handleVypocitat);
    }
    private JPanel createButtonBar(){
        vypocitatButton = new JButton("Vypočítat");
        JPanel buttonBar = new JPanel(new MigLayout(null, "[right, grow]"));
        buttonBar.add(vypocitatButton);
        return buttonBar;

    }

    private void handleVypocitat (ActionEvent actionEvent){
        System.out.println("Počítám..");
        int kraliciHlavyCislo = (Integer) kraliciSpinner.getValue();
        int husyHlavyCislo = (Integer) husySpinner.getValue();
        int pocetHlavCelkem = (kraliciHlavyCislo+husyHlavyCislo);
        String pocetHlavCelkemtext = Integer.toString(pocetHlavCelkem);
        System.out.println("Počet hlav:"+ pocetHlavCelkemtext);
        pocetHlavField.setText(pocetHlavCelkemtext);

        int kraliciNohyCislo = (Integer) kraliciSpinner.getValue();;
        int husynohyCislo = (Integer) husySpinner.getValue();
        int pocetNohouCelkem = (kraliciNohyCislo*4) +(husynohyCislo*2);
        String pocetNohouCelkemtext = Integer.toString(pocetNohouCelkem);
        System.out.println("Počet nohou:"+ pocetNohouCelkemtext);
        pocetNohouField.setText(pocetNohouCelkemtext);

    }

}
