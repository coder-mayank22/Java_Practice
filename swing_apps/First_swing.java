package swing_apps;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

class MyFrame extends JFrame implements ActionListener{
    JLabel l;
    JButton b;
    int count=0;
    MyFrame(){
        super("Swing Demo");
        setLayout(new FlowLayout());
        l = new JLabel("Clicked " + count + " Times");
        b = new JButton("Click");

        add(l);
        add(b);

        b.addActionListener(this);
        getRootPane().setDefaultButton(b);
        b.setIcon(new ImageIcon("C:/Users/mayan/Downloads/Click.png"));
        l.setToolTipText("Counter");
    }
    
    public void actionPerformed(ActionEvent e){
        count++;
        l.setText("Clicked " + count + " Times");
    }
}
public class First_swing {
    public static void main(String[] args) {
        MyFrame f = new MyFrame();
        f.setSize(500, 500);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

/*import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Calculator extends JFrame implements ActionListener {
    // Components
    private JTextField display;
    private JButton[] numberButtons = new JButton[10];
    private JButton addButton, subButton, mulButton, divButton, decButton, equButton, delButton, clrButton;
    private JPanel panel;

    // Variables to store inputs and operator
    private double num1 = 0, num2 = 0, result = 0;
    private char operator;

    public Calculator() {
        // Frame setup
        setTitle("Simple Calculator");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Display field
        display = new JTextField();
        display.setFont(new Font("Arial", Font.BOLD, 24));
        display.setEditable(false);
        add(display, BorderLayout.NORTH);

        // Buttons
        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        equButton = new JButton("=");
        delButton = new JButton("DEL");
        clrButton = new JButton("CLR");

        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
        }

        addButton.addActionListener(this);
        subButton.addActionListener(this);
        mulButton.addActionListener(this);
        divButton.addActionListener(this);
        decButton.addActionListener(this);
        equButton.addActionListener(this);
        delButton.addActionListener(this);
        clrButton.addActionListener(this);

        // Panel layout
        panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4, 10, 10));

        // Adding buttons to panel
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulButton);
        panel.add(decButton);
        panel.add(numberButtons[0]);
        panel.add(equButton);
        panel.add(divButton);

        add(panel, BorderLayout.CENTER);

        // Control panel for delete and clear
        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new GridLayout(1, 2, 10, 10));
        controlPanel.add(delButton);
        controlPanel.add(clrButton);

        add(controlPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberButtons[i]) {
                display.setText(display.getText().concat(String.valueOf(i)));
            }
        }

        if (e.getSource() == decButton) {
            display.setText(display.getText().concat("."));
        }

        if (e.getSource() == addButton) {
            num1 = Double.parseDouble(display.getText());
            operator = '+';
            display.setText("");
        }

        if (e.getSource() == subButton) {
            num1 = Double.parseDouble(display.getText());
            operator = '-';
            display.setText("");
        }

        if (e.getSource() == mulButton) {
            num1 = Double.parseDouble(display.getText());
            operator = '*';
            display.setText("");
        }

        if (e.getSource() == divButton) {
            num1 = Double.parseDouble(display.getText());
            operator = '/';
            display.setText("");
        }

        if (e.getSource() == equButton) {
            num2 = Double.parseDouble(display.getText());

            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    result = num1 / num2;
                    break;
            }
            display.setText(String.valueOf(result));
            num1 = result;
        }

        if (e.getSource() == clrButton) {
            display.setText("");
        }

        if (e.getSource() == delButton) {
            String str = display.getText();
            display.setText(str.length() > 0 ? str.substring(0, str.length() - 1) : "");
        }
    }

    public static void main(String[] args) {
        new Calculator();
    }
}
*/
