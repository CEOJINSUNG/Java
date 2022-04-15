import javax.swing.*;
import java.awt.*;

public class MenuFrame extends JFrame {

    // There are three buttons for showing various menus
    private JPanel westPanel;
    private JButton burgerButton;
    private JButton beverageButton;
    private JButton extraButton;

    // EAST INFORMATION ELEMENTS
    private JPanel eastPanel;
    private JTextArea board;
    private JLabel informationPanel;

    // In frame, logo is at top and "READY TO ORDER!" is at bottom
    private JLabel topLabel;
    private JLabel bottomLabel;

    public MenuFrame() {
        // For batching elements, border layout looks good
        setLayout(new BorderLayout(30, 25));

        Container container = this.getContentPane();

        //======================TOP LOGO=========================
        // For importing the logo, the path is necessary and image will include in Jlabel
        ImageIcon logo = new ImageIcon(getClass().getResource("img/subway_logo_skku.png"));
        topLabel = new JLabel();

        // opaque should be true for chaging its background color
        topLabel.setOpaque(true);
        topLabel.setIcon(logo); // add icon into topLabel
        topLabel.setBackground(Color.WHITE);
        container.add(topLabel, BorderLayout.NORTH);

        //======================WEST BUTTON PANEL=========================
        westPanel = new JPanel(); // west panel includes three button
        westPanel.setLayout(new BoxLayout(westPanel, BoxLayout.Y_AXIS)); // Align components vertically
        westPanel.setBorder(BorderFactory.createEmptyBorder(0, 15, 0, 0)); // Set Left Margin

        // First, get all images
        ImageIcon burgerLogo = new ImageIcon(getClass().getResource("img/burger_icon.png"));
        ImageIcon beverageLogo = new ImageIcon(getClass().getResource("img/beverages_icon.png"));
        ImageIcon extraLogo = new ImageIcon(getClass().getResource("img/extras_icon.png"));

        // Second, insert each image into each button and change the background color
        burgerButton = new JButton();
        burgerButton.setIcon(burgerLogo);
        burgerButton.setBackground(new Color(19, 136, 8));

        beverageButton = new JButton();
        beverageButton.setIcon(beverageLogo);
        beverageButton.setBackground(new Color(19, 136, 8));

        extraButton = new JButton();
        extraButton.setIcon(extraLogo);
        extraButton.setBackground(new Color(19, 136, 8));

        // Third, insert three buttons into west panel
        westPanel.add(burgerButton);
        westPanel.add(beverageButton);
        westPanel.add(extraButton);

        // Finally, add panel into frame
        container.add(westPanel, BorderLayout.WEST);

        //======================EAST INFORMATION PANEL=========================
        eastPanel = new JPanel();
        eastPanel.setLayout(new BoxLayout(eastPanel, BoxLayout.Y_AXIS));
        eastPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 15));

        // Second, information panel is positioning below textarea
        informationPanel = new JLabel();
        informationPanel.setText("Information Panel");

        // Set label font, style, name
        informationPanel.setFont(new Font("", Font.BOLD | Font.ITALIC, 14));
        informationPanel.setHorizontalAlignment(JLabel.CENTER);
        informationPanel.setOpaque(true);
        informationPanel.setBackground(Color.ORANGE);

        // For changing label size, three components should be used
        informationPanel.setMinimumSize(new Dimension(270, 16));
        informationPanel.setPreferredSize(new Dimension(270, 16));
        informationPanel.setMaximumSize(new Dimension(270, 16));

        // Add each component into east panel
        eastPanel.add(informationPanel);

        // Finally, add panel into frame
        container.add(eastPanel, BorderLayout.EAST);

        //======================BOTTOM LABEL=========================
        // This Element is for bottom design
        bottomLabel = new JLabel();
        bottomLabel.setText("READY TO ORDER");

        // For changing background color, opaque and borderpainted setting should be changed
        bottomLabel.setOpaque(true);
        bottomLabel.setBackground(new Color(19, 136, 8));
        bottomLabel.setForeground(Color.WHITE);
        bottomLabel.setHorizontalAlignment(JLabel.CENTER); // text align center
        container.add(bottomLabel, BorderLayout.SOUTH); // Bottom Button is in the South
    }

}
