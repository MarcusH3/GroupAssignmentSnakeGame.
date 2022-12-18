package se.nackademin.GameEngine;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TitleScreen extends JFrame {
    private JLabel titleLabel;
    private int menuIndex;
    private String[] menuItems = { "New Game", "High Score", "Quit" };

    public TitleScreen() {
        setTitle("Title Screen");
        setSize(400, 300);

        getContentPane().setBackground(Color.BLACK);

        titleLabel = new JLabel("Title");
        titleLabel.setFont(new Font("Times New Roman", Font.PLAIN, 36));
        titleLabel.setForeground(Color.WHITE);

        getContentPane().add(titleLabel, BorderLayout.NORTH);

        menuIndex = 0;
        updateLabelText();

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    menuIndex = (menuIndex + menuItems.length - 1) % menuItems.length;
                    updateLabelText();
                } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    menuIndex = (menuIndex + 1) % menuItems.length;
                    updateLabelText();
                }
            }
        });

        setFocusable(true);
        requestFocusInWindow();
    }

    private void updateLabelText() {
        titleLabel.setText(menuItems[menuIndex]);
    }

    public static void main(String[] args) {
        TitleScreen titleScreen = new TitleScreen();
        titleScreen.setVisible(true);
    }
}
