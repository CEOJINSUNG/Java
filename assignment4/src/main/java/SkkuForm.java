import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SkkuForm extends JFrame {
    // At the left side, there is a big picture
    private JLabel westLabel;

    // Within EastPanel, Several Forms will show
    private JPanel eastPanel;

    // At top-right, there are title and logo
    private JLabel topLabel;

    // applicant name box
    private JPanel applicantBox;
    private JTextArea applicantName;
    private JTextArea applicantNameInput;

    // birth date box
    private JPanel birthDateBox;
    private JTextArea birthDate;
    private JTextArea birthDateInput;

    // email box
    private JPanel emailBox;
    private JTextArea email;
    private JTextArea emailInput;

    // degree box
    private JPanel degreeBox;
    private JTextArea degree;
    private JTextArea degreeInput;

    // attended university box
    private JPanel attendedUniversityBox;
    private JTextArea attendedUniversity;
    private JTextArea attendedUniversityInput;

    // gpa box
    private JPanel gpaBox;
    private JTextArea gpa;
    private JTextArea gpaInput;

    // personal statement box
    private JPanel personalStatementBox;
    private JTextArea personalStatement;
    private JTextArea personalStatementInput;

    // home address box
    private JPanel homeAddressBox;
    private JTextArea homeAddress;
    private JTextArea homeAddressInput;

    // phone number box
    private JPanel phoneNumberBox;
    private JTextArea phoneNumber;
    private JTextArea phoneNumberInput;

    // major box
    private JPanel majorBox;
    private JTextArea major;
    private JTextArea majorInput;

    // when click submit button, pop up will show
    private JButton submitButton;

    public SkkuForm() {
        // For batching elements, border layout looks good
        setLayout(new BorderLayout(10, 10));

        Container container = this.getContentPane();

        //======================LEFT LOGO=========================
        // For importing the logo, the path is necessary and image will include in Jlabel
        ImageIcon logo = new ImageIcon(getClass().getResource("images/skku_wallpaper.png"));
        westLabel = new JLabel();

        // opaque should be true for changing its background color
        westLabel.setOpaque(true);
        westLabel.setIcon(logo); // add icon into topLabel
        westLabel.setBackground(Color.WHITE);
        container.add(westLabel, BorderLayout.WEST);

        //======================RIGHT PANEL=========================
        eastPanel = new JPanel(); // west panel includes three button
        eastPanel.setLayout(new BoxLayout(eastPanel, BoxLayout.Y_AXIS)); // Align components vertically
        eastPanel.setBorder(BorderFactory.createEmptyBorder(0, 15, 0, 0)); // Set Margin
        eastPanel.setSize(600, 650);
        eastPanel.setBackground(Color.WHITE);

        // Top title Image
        ImageIcon skku = new ImageIcon(getClass().getResource("images/title_label.png"));
        topLabel = new JLabel();

        topLabel.setOpaque(true);
        topLabel.setIcon(skku);
        topLabel.setBackground(Color.WHITE);
        topLabel.setAlignmentX(CENTER_ALIGNMENT);
        topLabel.setBorder(BorderFactory.createEmptyBorder(10, 100, 10, 100));

        eastPanel.add(topLabel);

        // ============ Applicant Name Box, Text, Input =============
        applicantBox = new JPanel();
        applicantBox.setLayout(new FlowLayout(FlowLayout.RIGHT));
        applicantBox.setBackground(Color.WHITE);
        applicantBox.setBorder(BorderFactory.createEmptyBorder(8, 0, 8, 10));
        applicantBox.setMaximumSize(new Dimension(600, 30));

        applicantName = new JTextArea();
        applicantName.setText("Applicant Name: ");
        applicantName.setEditable(false);
        applicantName.setAlignmentX(JTextArea.RIGHT_ALIGNMENT);

        applicantNameInput = new JTextArea();
        applicantNameInput.setMinimumSize(new Dimension(270, 16));
        applicantNameInput.setPreferredSize(new Dimension(270, 16));
        applicantNameInput.setMaximumSize(new Dimension(270, 16));
        applicantNameInput.setBackground(Color.WHITE);
        applicantNameInput.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

        applicantBox.add(applicantName);
        applicantBox.add(applicantNameInput);
        eastPanel.add(applicantBox);

        // ============ Birth Date Box, Text, Input =============
        birthDateBox = new JPanel();
        birthDateBox.setLayout(new FlowLayout(FlowLayout.RIGHT));
        birthDateBox.setBackground(Color.WHITE);
        birthDateBox.setBorder(BorderFactory.createEmptyBorder(8, 0, 8, 10));
        birthDateBox.setMaximumSize(new Dimension(600, 30));

        birthDate = new JTextArea();
        birthDate.setText("Birth Date: ");
        birthDate.setEditable(false);
        birthDate.setAlignmentX(JTextArea.RIGHT_ALIGNMENT);

        birthDateInput = new JTextArea();
        birthDateInput.setMinimumSize(new Dimension(270, 16));
        birthDateInput.setPreferredSize(new Dimension(270, 16));
        birthDateInput.setMaximumSize(new Dimension(270, 16));
        birthDateInput.setBackground(Color.WHITE);
        birthDateInput.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

        birthDateBox.add(birthDate);
        birthDateBox.add(birthDateInput);
        eastPanel.add(birthDateBox);

        // ============ Email Box, Text, Input =============
        emailBox = new JPanel();
        emailBox.setLayout(new FlowLayout(FlowLayout.RIGHT));
        emailBox.setBackground(Color.WHITE);
        emailBox.setBorder(BorderFactory.createEmptyBorder(8, 0, 8, 10));
        emailBox.setMaximumSize(new Dimension(600, 30));

        email = new JTextArea();
        email.setText("Email: ");
        email.setEditable(false);
        email.setAlignmentX(JTextArea.RIGHT_ALIGNMENT);

        emailInput = new JTextArea();
        emailInput.setMinimumSize(new Dimension(270, 16));
        emailInput.setPreferredSize(new Dimension(270, 16));
        emailInput.setMaximumSize(new Dimension(270, 16));
        emailInput.setBackground(Color.WHITE);
        emailInput.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

        emailBox.add(email);
        emailBox.add(emailInput);
        eastPanel.add(emailBox);

        // ============ Degree Box, Text, Input =============
        degreeBox = new JPanel();
        degreeBox.setLayout(new FlowLayout(FlowLayout.RIGHT));
        degreeBox.setBackground(Color.WHITE);
        degreeBox.setBorder(BorderFactory.createEmptyBorder(8, 0, 8, 10));
        degreeBox.setMaximumSize(new Dimension(600, 30));

        degree = new JTextArea();
        degree.setText("Degree: ");
        degree.setEditable(false);
        degree.setAlignmentX(JTextArea.RIGHT_ALIGNMENT);

        degreeInput = new JTextArea();
        degreeInput.setMinimumSize(new Dimension(270, 16));
        degreeInput.setPreferredSize(new Dimension(270, 16));
        degreeInput.setMaximumSize(new Dimension(270, 16));
        degreeInput.setBackground(Color.WHITE);
        degreeInput.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

        degreeBox.add(degree);
        degreeBox.add(degreeInput);
        eastPanel.add(degreeBox);

        // ============ Attended University Box, Text, Input =============
        attendedUniversityBox = new JPanel();
        attendedUniversityBox.setLayout(new FlowLayout(FlowLayout.RIGHT));
        attendedUniversityBox.setBackground(Color.WHITE);
        attendedUniversityBox.setBorder(BorderFactory.createEmptyBorder(8, 0, 8, 10));
        attendedUniversityBox.setMaximumSize(new Dimension(600, 30));

        attendedUniversity = new JTextArea();
        attendedUniversity.setText("Attended university (for Graduates): ");
        attendedUniversity.setEditable(false);
        attendedUniversity.setAlignmentX(JTextArea.RIGHT_ALIGNMENT);

        attendedUniversityInput = new JTextArea();
        attendedUniversityInput.setMinimumSize(new Dimension(270, 16));
        attendedUniversityInput.setPreferredSize(new Dimension(270, 16));
        attendedUniversityInput.setMaximumSize(new Dimension(270, 16));
        attendedUniversityInput.setBackground(Color.WHITE);
        attendedUniversityInput.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

        attendedUniversityBox.add(attendedUniversity);
        attendedUniversityBox.add(attendedUniversityInput);
        eastPanel.add(attendedUniversityBox);

        // ============ GPA Box, Text, Input =============
        gpaBox = new JPanel();
        gpaBox.setLayout(new FlowLayout(FlowLayout.RIGHT));
        gpaBox.setBackground(Color.WHITE);
        gpaBox.setBorder(BorderFactory.createEmptyBorder(8, 0, 8, 10));
        gpaBox.setMaximumSize(new Dimension(600, 30));

        gpa = new JTextArea();
        gpa.setText("GPA (for Graduates): ");
        gpa.setEditable(false);
        gpa.setAlignmentX(JTextArea.RIGHT_ALIGNMENT);

        gpaInput = new JTextArea();
        gpaInput.setMinimumSize(new Dimension(270, 16));
        gpaInput.setPreferredSize(new Dimension(270, 16));
        gpaInput.setMaximumSize(new Dimension(270, 16));
        gpaInput.setBackground(Color.WHITE);
        gpaInput.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

        gpaBox.add(gpa);
        gpaBox.add(gpaInput);
        eastPanel.add(gpaBox);

        // ============ Home Address Box, Text, Input =============
        personalStatementBox = new JPanel();
        personalStatementBox.setLayout(new FlowLayout(FlowLayout.CENTER));
        personalStatementBox.setBackground(Color.WHITE);
        personalStatementBox.setMaximumSize(new Dimension(500, 100));
        personalStatementBox.setBorder(BorderFactory.createEmptyBorder(16, 0, 8, 10));

        personalStatement = new JTextArea();
        personalStatement.setText("Personal Statement");
        personalStatement.setEditable(false);

        personalStatementInput = new JTextArea();
        personalStatementInput.setFont(new Font("", Font.ITALIC, 12));
        personalStatementInput.setText("At least 100 words.");
        personalStatementInput.setMinimumSize(new Dimension(500, 60));
        personalStatementInput.setPreferredSize(new Dimension(500, 60));
        personalStatementInput.setMaximumSize(new Dimension(500, 60));
        personalStatementInput.setBackground(Color.lightGray);

        personalStatementBox.add(personalStatement);
        personalStatementBox.add(personalStatementInput);
        eastPanel.add(personalStatementBox);

        // ============ Home Address Box, Text, Input =============
        homeAddressBox = new JPanel();
        homeAddressBox.setLayout(new FlowLayout(FlowLayout.RIGHT));
        homeAddressBox.setBackground(Color.WHITE);
        homeAddressBox.setBorder(BorderFactory.createEmptyBorder(8, 0, 8, 10));
        homeAddressBox.setMaximumSize(new Dimension(600, 30));

        homeAddress = new JTextArea();
        homeAddress.setText("Home Address: ");
        homeAddress.setEditable(false);
        homeAddress.setAlignmentX(JTextArea.RIGHT_ALIGNMENT);

        homeAddressInput = new JTextArea();
        homeAddressInput.setMinimumSize(new Dimension(270, 16));
        homeAddressInput.setPreferredSize(new Dimension(270, 16));
        homeAddressInput.setMaximumSize(new Dimension(270, 16));
        homeAddressInput.setBackground(Color.WHITE);
        homeAddressInput.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

        homeAddressBox.add(homeAddress);
        homeAddressBox.add(homeAddressInput);
        eastPanel.add(homeAddressBox);

        // ============ Phone Number Box, Text, Input =============
        phoneNumberBox = new JPanel();
        phoneNumberBox.setLayout(new FlowLayout(FlowLayout.RIGHT));
        phoneNumberBox.setBackground(Color.WHITE);
        phoneNumberBox.setBorder(BorderFactory.createEmptyBorder(8, 0, 8, 10));
        phoneNumberBox.setMaximumSize(new Dimension(600, 30));

        phoneNumber = new JTextArea();
        phoneNumber.setText("Phone Number: ");
        phoneNumber.setEditable(false);
        phoneNumber.setAlignmentX(JTextArea.RIGHT_ALIGNMENT);

        phoneNumberInput = new JTextArea();
        phoneNumberInput.setMinimumSize(new Dimension(270, 16));
        phoneNumberInput.setPreferredSize(new Dimension(270, 16));
        phoneNumberInput.setMaximumSize(new Dimension(270, 16));
        phoneNumberInput.setBackground(Color.WHITE);
        phoneNumberInput.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

        phoneNumberBox.add(phoneNumber);
        phoneNumberBox.add(phoneNumberInput);
        eastPanel.add(phoneNumberBox);

        // ============ Major Box, Text, Input =============
        majorBox = new JPanel();
        majorBox.setLayout(new FlowLayout(FlowLayout.RIGHT));
        majorBox.setBackground(Color.WHITE);
        majorBox.setBorder(BorderFactory.createEmptyBorder(8, 0, 30, 10));
        majorBox.setMaximumSize(new Dimension(600, 60));

        major = new JTextArea();
        major.setText("Major: ");
        major.setEditable(false);
        major.setAlignmentX(JTextArea.RIGHT_ALIGNMENT);

        majorInput = new JTextArea();
        majorInput.setMinimumSize(new Dimension(270, 16));
        majorInput.setPreferredSize(new Dimension(270, 16));
        majorInput.setMaximumSize(new Dimension(270, 16));
        majorInput.setBackground(Color.WHITE);
        majorInput.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

        majorBox.add(major);
        majorBox.add(majorInput);
        eastPanel.add(majorBox);

        // ============ Submit Button =============
        submitButton = new JButton();
        submitButton.setText("Submit Application");
        submitButton.setFont(new Font("", Font.BOLD, 12));
        submitButton.setBackground(Color.BLUE);
        submitButton.setForeground(Color.WHITE);
        submitButton.setOpaque(true);
        submitButton.setBorderPainted(false);
        submitButton.setMaximumSize(new Dimension(300, 50));
        submitButton.setAlignmentX(CENTER_ALIGNMENT);
        submitButton.setAlignmentY(CENTER_ALIGNMENT);

        submitButton.addActionListener(new ButtonHandler());

        eastPanel.add(submitButton);

        container.add(eastPanel, BorderLayout.EAST);


    }

    public static void main(String[] args) {
        // Initially, shows the panel
        SkkuForm skkuForm = new SkkuForm();
        skkuForm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        skkuForm.setSize(900, 650);
        skkuForm.setVisible(true);
    }

    private class ButtonHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            // 0. name check
            String[] name = applicantName.getText().split("\\s+");
            boolean nameCheck = true;
            boolean nameEmpty = false;

            if (name.length < 2) {
                nameCheck = false;
                if (applicantName.getText().length() == 0) {
                    nameEmpty = true;
                }
            }

            // 1. empty field check
            boolean degreeEmpty = false;
            if (degree.getText().length() == 0) {
                degreeEmpty = true;
            }

            boolean attendedUniversityEmpty = false;
            if (attendedUniversity.getText().length() == 0) {
                attendedUniversityEmpty = true;
            }

            boolean gpaEmpty = false;
            if (gpa.getText().length() == 0) {
                gpaEmpty = true;
            }

            boolean homeAddressEmpty = false;
            if (homeAddress.getText().length() == 0) {
                homeAddressEmpty = true;
            }

            boolean personalStatementEmpty = false;
            if (personalStatement.getText().length() == 0) {
                personalStatementEmpty = true;
            }

            boolean majorEmpty = false;
            if (major.getText().length() == 0) {
                majorEmpty = true;
            }

            // 2. birth date format
            boolean birthDateCheck = false;
            boolean birthDateEmpty = false;
            if(birthDate.getText().matches("\\d{2}-\\d{2}-\\d{4}")){
                birthDateCheck = true;
            } else {
                if (birthDate.getText().length() == 0) {
                    birthDateEmpty = true;
                }
            }

            // 3. email check
            boolean emailCheck = false;
            boolean emailEmpty = false;
            String regexEmail = "^(.+)@(.+)$";
            Pattern patternEmail = Pattern.compile(regexEmail);
            Matcher matcherEmail = patternEmail.matcher(email.getText());
            if (matcherEmail.matches()) {
                emailCheck = true;
            } else {
                if (email.getText().length() == 0) {
                    emailEmpty = true;
                }
            }

            // 4. phone number check
            boolean phoneNumberCheck = false;
            boolean phoneNumberEmpty = false;
            String regexPhone = "^[0-9\\s-]*$";
            Pattern patternPhone = Pattern.compile(regexPhone);
            Matcher matcherPhone = patternPhone.matcher(phoneNumber.getText());
            if (matcherPhone.matches()) {
                phoneNumberCheck = true;
            } else {
                if (phoneNumber.getText().length() == 0) {
                    phoneNumberEmpty = true;
                }
            }

            // 5.

            // 6. gpa range check
            boolean gpaRangeCheck = true;
            if (Integer.parseInt(gpa.getText()) < 0 || Integer.parseInt(gpa.getText()) > 4.5) {
                gpaRangeCheck = false;
            }

            // 7. personal statement
            boolean personalStatementCheck = false;
            if (personalStatement.getText().length() > 100) {
                personalStatementCheck = true;
            }
        }
    }
}
