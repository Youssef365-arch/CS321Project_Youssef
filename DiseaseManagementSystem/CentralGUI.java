package DiseaseManagementSystem;
import java.awt.event.*;
import java.security.NoSuchAlgorithmException;

import javax.swing.*;
import java.awt.*;

import DiseaseManagementSystem.*;

/**
 * This class serves as the central screen which displays for our user. They are shown 3 buttons which
 * they can press to load the various screens in the system.
 * 
 * @author John Fulton, Cain Clifton, Youssef Melk
 */
public class CentralGUI extends JFrame implements ActionListener {
    
    /**
     * These are the various buttons that the user can press to choose what screen they want
     * to load or to exit the system.
     */
    static JButton dataEntryButton, reviewButton, approvalButton, exitButton;
    /**
     * This label is the welcome message that displays above the buttons to greet the user.
     */
    static JLabel welcomeMessage;
    /**
     * This JFrame is the window that the screen will be displayed in.
     */
    static JFrame frame;

    static WorkflowTable workflowtable;

    /**
     * This method loads the central screen.
     */
    public static void loadCentralScreen(WorkflowTable wft) {

        workflowtable = wft;
        // making frame
        frame = new JFrame("Disease Management System");

        // making label
        welcomeMessage = new JLabel("Welcome to the Disease Management System");
        welcomeMessage.setFont(welcomeMessage.getFont().deriveFont(18.0f));
        welcomeMessage.setHorizontalAlignment(JLabel.CENTER);

        // making buttons
        dataEntryButton = new JButton("Data Entry System");
        reviewButton = new JButton("Reviewing System");
        approvalButton = new JButton("Approval System");
        exitButton = new JButton("Exit");
        // making gui object
        CentralGUI gui = new CentralGUI();

        // added action listeners
        dataEntryButton.addActionListener(gui);
        reviewButton.addActionListener(gui);
        approvalButton.addActionListener(gui);
        exitButton.addActionListener(gui);

        // creating panel and gbc
        JPanel centralPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;

        // Adding the welcome label
        gbc.gridx = 1;
        gbc.gridy = 0;
        centralPanel.add(welcomeMessage, gbc);

        // Adding the data entry button
        gbc.gridx = 0;
        gbc.gridy = 1;
        centralPanel.add(dataEntryButton, gbc);

        // Adding the review button
        gbc.gridx = 1;
        gbc.gridy = 1;
        centralPanel.add(reviewButton, gbc);

        // Adding the approval button
        gbc.gridx = 2;
        gbc.gridy = 1;
        centralPanel.add(approvalButton, gbc);

        // Adding the exit button
        gbc.gridx = 1;
        gbc.gridy = 2;
        centralPanel.add(exitButton, gbc);   

        frame.add(centralPanel);

        frame.setSize(300,300);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

    }

    /**
     * This method is a part of the actionListener.
     * It handles action events that are triggered by the user when they press the following
     * buttons: dataEntryButton, reviewButton, approvalButton, and the exitButton.
     * @param e the event recorded by the action listener (what button the user pressed).
     */
    public void actionPerformed(ActionEvent e) {
        String buttonPressed = e.getActionCommand();

        if (buttonPressed.equals("Data Entry System")) {
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(false);
            DataEntryGUI dataGUI = new DataEntryGUI();
            dataGUI.loadDataScreen(workflowtable);
        } else if (buttonPressed.equals("Reviewing System")) {
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(false);
            ReviewGUI reviewGUI = new ReviewGUI();
            reviewGUI.loadReviewScreen(workflowtable, null);
        } else if (buttonPressed.equals("Approval System")) {
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(false);
            ApprovalGUI approvalGUI = new ApprovalGUI();
            approvalGUI.loadApprovalScreen(workflowtable);
        } else if (buttonPressed.equals("Exit")) {
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(false);
        }
    }

    /**
     * This method serves as the driver method for the central screen.
     * @param args the array of strings passed in as CLI by the user.
     */
    public static void main(String[] args) {
        WorkflowTable workflowtable = new WorkflowTable();
        loadCentralScreen(workflowtable);
    }


}
