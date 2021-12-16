package Gui;

import Domain.Key;

import javax.swing.*;

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
    private String version = "1.1";

    private final ImageIcon logo = new ImageIcon("src/main/java/Images/garfield.png");

    public Gui() {
        setTitle("Generator Key");
        setSize(450, 320);
        setIconImage(logo.getImage());
        setLocationRelativeTo(null);
        //setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        initComponents();
    }

    private void initComponents() {
        setContentPane(panelMain);
        labelNumberVersion.setText(version);
        listeners();
    }

    private void listeners() {
        exitButton.addActionListener(e -> System.exit(0));

        generateButton.addActionListener(e -> {
            String textInput = textFieldInputLength.getText();
            String key;
            boolean isNumeric;
            try {
                Integer.parseInt(textInput);
                isNumeric = true;
            } catch (NumberFormatException exception) {
                isNumeric = false;
            }
            if (isNumeric) {
                if (Integer.parseInt(textInput) > 0) {
                    key = generateKey.generateKey(Integer.parseInt(textFieldInputLength.getText()), createArrBooleans());
                } else {
                    key = "";
                }
            } else {
                key = "";
            }
            keyTextField.setText(key);
        });
    }

    private boolean[] createArrBooleans() {
        return new boolean[]{lowercaseRadioButton.isSelected(), upperCaseRadioButton.isSelected(), numbersRadioButton.isSelected(), symbolsRadioButton.isSelected()};
    }

}
