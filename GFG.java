// Java program "Converter temperature"

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;



public class GFG{
    static JLabel result = new JLabel("Result is: ");
    static String input = "";
    // Main driver method
    public static void main(String[] args) {
        String cmdConv = "Convert";

        JPanel radioPanel = new JPanel();
        radioPanel.setLayout(new GridLayout(2, 1)); // Кнопки будуть одна під одною


        JFrame frame = new JFrame("Tempcon");
        frame.setLayout(new FlowLayout());
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextField textField = new JTextField(10    );

        JButton ConvBtn = new JButton("Convert");
        ConvBtn.setActionCommand(cmdConv);

        JRadioButton FBottom = new JRadioButton("Fahrenheit");
        FBottom.setSelected(true);

        JRadioButton CBottom = new JRadioButton("Celsius");

        ActionListener listener = e -> {
            String temp_type = e.getActionCommand();
            input = textField.getText();
            try {
                double value = Double.parseDouble(input);
                if (temp_type.equals("Convert") && FBottom.isSelected()){
                    double final_temp = temp_calcF(value);
                    result.setText(String.format("%.1f °C", temp_calcF(value)));
                } else if (temp_type.equals(cmdConv) && CBottom.isSelected()) {
                    result.setText(temp_calcC(value) + "Fahrenheits");
                    double final_temp = temp_calcF(value);
                }
                else {
                    frame.dispose(); // Закриває вікно та звільняє ресурси
                }
            }
            catch (NumberFormatException es){
                textField.setText("Invalid input");
            }


        };
        ConvBtn.addActionListener(listener);

        ButtonGroup group = new ButtonGroup();
        group.add(FBottom);
        group.add(CBottom);

        radioPanel.add(CBottom);
        radioPanel.add(FBottom);

        frame.add(result);
        frame.add(ConvBtn);
        frame.add(radioPanel, BorderLayout.WEST);
        frame.add(textField);
        frame.setVisible(true);
    }
    static double temp_calcF(double value){
        return (value - 32) * 5.0 / 9.0;//in celsius
    }
    static double temp_calcC(double value){
        return (value * 9.0 / 5.0) + 32;//in fahrenheit
    }
}