package DiseaseManagementSystem;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

class DataEntryGUI extends JFrame implements ActionListener {
    // JTextField
    static JTextField t1, t2, t3, t4, t5;

    // JFrame
    static JFrame f;

    // JButton
    static JButton b;

    // Labels to display text
    static JLabel l1, l2, l3, l4, l5, title;

    // Data variables
    static String name, email, birthdate, children, diseaseData;

    // Default constructor
    DataEntryGUI() {
    }

    // Main class
    public static void main(String[] args) {
        // Create a new frame to store text fields and button
        f = new JFrame("Disease Management System");

        // Create labels to display text
        title = new JLabel("Disease Management System");
        title.setFont(title.getFont().deriveFont(18.0f)); // Increase font size

        l1 = new JLabel("Enter Name:");
        l2 = new JLabel("Enter Email:");
        l3 = new JLabel("Enter Birthdate (MM/DD/YYYY):");
        l4 = new JLabel("Enter Number of Children (Parent or guardian):");
        l5 = new JLabel("Enter Disease Data:");

        // Create a new button
        b = new JButton("Submit");

        // Create an object of the TextFieldsDemo class
        DataEntryGUI demo = new DataEntryGUI();

        // Add ActionListener to the button
        b.addActionListener(demo);

        // Create five objects of JTextField
        t1 = new JTextField(16);
        t2 = new JTextField(16);
        t3 = new JTextField(16);
        t4 = new JTextField(16);
        t5 = new JTextField(16);

        // Set the preferred size for the text fields (smaller width and height)
        Dimension fieldSize = new Dimension(100, 20); // Adjust the size as needed
        t1.setPreferredSize(fieldSize);
        t2.setPreferredSize(fieldSize);
        t3.setPreferredSize(fieldSize);
        t4.setPreferredSize(fieldSize);
        t5.setPreferredSize(fieldSize);

        // Create a panel with GridBagLayout
        JPanel p = new JPanel(new GridBagLayout());

        // Create GridBagConstraints to center components
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets.set(5, 5, 5, 5);

        // Add the title label at the top
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        p.add(title, gbc);

        // Reset gridwidth for other components
        gbc.gridwidth = 1;

        // Add labels, text fields, and the button to the panel with GridBagConstraints
        gbc.anchor = GridBagConstraints.WEST;
        gbc.gridy++;
        p.add(l1, gbc);
        gbc.gridy++;
        p.add(t1, gbc);
        gbc.gridy++;
        p.add(l2, gbc);
        gbc.gridy++;
        p.add(t2, gbc);
        gbc.gridy++;
        p.add(l3, gbc);
        gbc.gridy++;
        p.add(t3, gbc);
        gbc.gridy++;
        p.add(l4, gbc);
        gbc.gridy++;
        p.add(t4, gbc);
        gbc.gridy++;
        p.add(l5, gbc);
        gbc.gridy++;
        p.add(t5, gbc);
        gbc.gridy++;
        gbc.anchor = GridBagConstraints.CENTER;
        p.add(b, gbc);

        // Add the panel to the frame
        f.add(p);

        // Set the size of the frame
        f.setSize(300, 300); // Adjust the size as needed

        // Center the frame on the screen
        f.setLocationRelativeTo(null);

        // Make the frame visible
        f.setVisible(true);


        //Create the form.
        InfectedUserData dataEntryForm = new InfectedUserData(name, diseaseData, email, birthdate, Integer.parseInt(children), false, false, null);

        //Set the form date to the current date.
        dataEntryForm.setDateToCurrent();

        //If the user has children, set parent and guardian to true.
        if (dataEntryForm.getNumChildren() > 0) {
            dataEntryForm.setParent(true);
            dataEntryForm.setGuardian(true);
        }

        dataEntryForm.setName(name);
        dataEntryForm.setData(diseaseData);
        
    }

    // If the button is pressed
    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();
        if (s.equals("Submit")) {
            // Retrieve data from text fields and store in variables
            name = t1.getText();
            email = t2.getText();
            birthdate = t3.getText();
            children = t4.getText();
            diseaseData = t5.getText();

            // Clear text fields
            t1.setText("");
            t2.setText("");
            t3.setText("");
            t4.setText("");

            // Print the stored data to the console
            System.out.println("Name: " + name);
            System.out.println("Email: " + email);
            System.out.println("Birthdate: " + birthdate);
            System.out.println("Number of Children: " + children);
            System.out.println("Disease Data: " + diseaseData);

            // Clear the panel to create a white screen
            Container contentPane = f.getContentPane();
            contentPane.removeAll();
            contentPane.repaint();
        }
    }
}