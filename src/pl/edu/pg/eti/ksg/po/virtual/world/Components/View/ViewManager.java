package pl.edu.pg.eti.ksg.po.virtual.world.Components.View;

import javax.swing.*;
import java.awt.*;

public class ViewManager {
    private JFrame frame;

    public ViewManager(String windowTitle, int sizeX, int sizeY) {
        this.frame = new JFrame(windowTitle);
        this.frame.setSize(1000, 1000);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setResizable(false);
        this.frame.setLocationRelativeTo(null);
        this.frame.add(createPanelWithButtons(sizeX, sizeY), BorderLayout.CENTER);
        this.frame.setVisible(true);
    }

    private JPanel createPanelWithButtons(int sizeX, int sizeY) {
        int abaliableButtons = sizeX * sizeY;
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(sizeX, sizeY));
        for (int i = 0; i < abaliableButtons; i++){
            OrganizmButton button = new OrganizmButton("Text " + i);
            panel.add(button);
        }
        panel.setBorder(BorderFactory.createEmptyBorder(100,100,100,100));
        return panel;
    }
}
