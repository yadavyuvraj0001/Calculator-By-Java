// Import Swing library for GUI components like JFrame, JButton, JTextField
import javax.swing.*;

// Import AWT for layout and fonts
import java.awt.*;

// Import event package for button click handling
import java.awt.event.*;

// Create Calculator class that extends JFrame (window)
// and implements ActionListener (to handle button clicks)
public class Calculator extends JFrame implements ActionListener {
	public static void main(String[] args) {
    new Calculator();
}


    // Create display text field to show numbers and results
    JTextField textField;

    // Variables to store numbers and result
    double num1 = 0, num2 = 0, result = 0;

    // Variable to store operator (+, -, *, /)
    char operator;

    // ===== Constructor (runs when program starts) =====
    Calculator() {

        // Create text field (display area)
        textField = new JTextField();

        // Set font style and size
        textField.setFont(new Font("Arial", Font.BOLD, 28));

        // User cannot type directly
        textField.setEditable(false);

        // Align text to right side
        textField.setHorizontalAlignment(JTextField.RIGHT);

        // ===== Frame settings =====

        // Title of window
        this.setTitle("Simple Calculator");

        // Window size
        this.setSize(300, 400);

        // Close program when window closed
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Use BorderLayout (top + center layout)
        this.setLayout(new BorderLayout());

        // Add display at top of window
        this.add(textField, BorderLayout.NORTH);

        // ===== Create Panel for Buttons =====

        // Create panel
        JPanel panel = new JPanel();

        // Grid layout: 5 rows, 4 columns, gaps between buttons
        panel.setLayout(new GridLayout(5, 4, 10, 10));

        // Button labels
        String buttons[] = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "0", "C", "=", "+"
        };

        // Loop to create buttons
        for (String text : buttons) {

            // Create button with label
            JButton btn = new JButton(text);

            // Set button font
            btn.setFont(new Font("Arial", Font.BOLD, 18));

            // Add click event listener
            btn.addActionListener(this);

            // Add button to panel
            panel.add(btn);
        }

        // Add panel to center of window
        this.add(panel, BorderLayout.CENTER);

        // Make window visible
        this.setVisible(true);
    }

    // ===== Button Click Logic =====
    public void actionPerformed(ActionEvent e) {

        // Get button text that was clicked
        String command = e.getActionCommand();

        // ===== If number button pressed =====
        if (command.charAt(0) >= '0' && command.charAt(0) <= '9') {

            // Add number to display
            textField.setText(textField.getText() + command);
        }

        // ===== If operator pressed (+ - * /) =====
        else if (command.equals("+") || command.equals("-")
                || command.equals("*") || command.equals("/")) {

            // Store first number
            num1 = Double.parseDouble(textField.getText());

            // Store operator
            operator = command.charAt(0);

            // Clear display for next number
            textField.setText("");
        }

        // ===== If equal button pressed =====
        else if (command.equals("=")) {

            // Store second number
            num2 = Double.parseDouble(textField.getText());

            // Perform calculation based on operator
            switch (operator) {
                case '+': result = num1 + num2; break;
                case '-': result = num1 - num2; break;
                case '*': result = num1 * num2; break;
                case '/': result = num1 / num2; break;
            }

            // Show result on display
            textField.setText(String.valueOf(result));
        }

        // ===== If clear button pressed =====
        else if (command.equals("C")) {

            // Clear display
            textField.setText("");

            // Reset all variables
		}
	}
}

