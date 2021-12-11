package Gui;

import Domain.Key;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gui extends JFrame {

    Key generateKey = new Key();

    private JPanel panelMain;
    private JTextField textFieldInputLength;
    private JRadioButton lowercaseRadioButton;
    private JRadioButton upperCaseRadioButton;
    private JRadioButton numbersRadioButton;
    private JRadioButton symbolsRadioButton;
    private JTextField keyTextField;
    private JButton exitButton;
    private JLabel labelNumberVersion;
    private JLabel labelVersion;
    private JLabel labelInputLength;
    private JLabel labelFilling1;
    private JButton generateButton;
    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;
    private JPanel panel4;
    private JPanel panel5;
    private JPanel panel5_1;

    private final ImageIcon logo = new ImageIcon("src/main/java/Images/garfield.png");

    public Gui() {
        setTitle("Generator Key");
        setSize(400, 290);
        setIconImage(logo.getImage());
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        initComponents();
    }

    private void initComponents() {
        setContentPane(panelMain);
        listeners();
    }

    private void listeners() {
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    System.exit(0);
            }
        });

        generateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String key = generateKey.generateKey(Integer.parseInt(textFieldInputLength.getText()), createArrBooleans());
                keyTextField.setText(key);
            }
        });
    }

    private boolean[] createArrBooleans() {
        boolean[] booleans = {lowercaseRadioButton.isSelected(), upperCaseRadioButton.isSelected(), numbersRadioButton.isSelected(), symbolsRadioButton.isSelected()};
        return booleans;
    }
}
