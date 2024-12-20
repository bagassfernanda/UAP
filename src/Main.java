import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class AsciiBinaryConverterSwing {

    public static String charToBinary(char character) {
        return String.format("%08d", Integer.parseInt(Integer.toBinaryString(character)));
    }

    public static char binaryToChar(String binary) {
        return (char) Integer.parseInt(binary, 2);
    }

    public static String stringToBinary(String input) {
        StringBuilder binaryBuilder = new StringBuilder();
        for (char c : input.toCharArray()) {
            binaryBuilder.append(charToBinary(c)).append(" ");
        }
        return binaryBuilder.toString().trim();
    }

    public static String stringToAscii(String input) {
        StringBuilder asciiBuilder = new StringBuilder();
        for (char c : input.toCharArray()) {
            asciiBuilder.append((int) c).append(" ");
        }
        return asciiBuilder.toString().trim();
    }

    public static String binaryToString(String binaryInput) {
        StringBuilder result = new StringBuilder();
        String[] binaries = binaryInput.split(" ");
        for (String binary : binaries) {
            if (binary.length() == 8 && binary.matches("[01]+")) {
                result.append(binaryToChar(binary));
            } else {
                return "Invalid binary input";
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("ASCII - Binary Converter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 500);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(9, 1, 10, 10));

        JLabel labelNameToAscii = new JLabel("Enter a name (String to ASCII):");
        JTextField fieldNameToAscii = new JTextField();
        JButton buttonNameToAscii = new JButton("Convert Name to ASCII");
        JLabel resultNameToAscii = new JLabel("ASCII: ");

        JLabel labelAsciiToBinary = new JLabel("Enter text (ASCII to Binary):");
        JTextField fieldAsciiToBinary = new JTextField();
        JButton buttonAsciiToBinary = new JButton("Convert to Binary");
        JLabel resultAsciiToBinary = new JLabel("Binary: ");

        JLabel labelBinaryToName = new JLabel("Enter binary string (Binary to Name):");
        JTextField fieldBinaryToName = new JTextField();
        JButton buttonBinaryToName = new JButton("Convert Binary to Name");
        JLabel resultBinaryToName = new JLabel("Name: ");

        panel.add(labelNameToAscii);
        panel.add(fieldNameToAscii);
        panel.add(buttonNameToAscii);
        panel.add(resultNameToAscii);

        panel.add(labelAsciiToBinary);
        panel.add(fieldAsciiToBinary);
        panel.add(buttonAsciiToBinary);
        panel.add(resultAsciiToBinary);

        panel.add(labelBinaryToName);
        panel.add(fieldBinaryToName);
        panel.add(buttonBinaryToName);
        panel.add(resultBinaryToName);

        buttonNameToAscii.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = fieldNameToAscii.getText();
                if (input.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Please enter a name.", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    String ascii = stringToAscii(input);
                    resultNameToAscii.setText("ASCII: " + ascii);
                }
            }
        });

        buttonAsciiToBinary.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = fieldAsciiToBinary.getText();
                if (input.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Please enter some text.", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    String binary = stringToBinary(input);
                    resultAsciiToBinary.setText("Binary: " + binary);
                }
            }
        });

        buttonBinaryToName.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String binary = fieldBinaryToName.getText();
                if (binary.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Please enter binary string.", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    String name = binaryToString(binary);
                    resultBinaryToName.setText("Name: " + name);
                }
            }
        });

        frame.add(panel);
        frame.setVisible(true);
    }
}
