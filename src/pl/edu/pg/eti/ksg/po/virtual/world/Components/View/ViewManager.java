package pl.edu.pg.eti.ksg.po.virtual.world.Components.View;

import javax.swing.*;
import java.awt.*;

public class ViewManager {
    private JFrame frame;

    public ViewManager(String windowTitle, int sizeX, int sizeY) {
        this.frame = new JFrame(windowTitle);
        this.frame.setSize(sizeX, sizeY);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setResizable(false);
        this.frame.setLocationRelativeTo(null);
        JScrollPane jsp = new JScrollPane(createPanelWithButtons());
        this.frame.add(createPanelWithButtons(), BorderLayout.CENTER);
        this.frame.setVisible(true);
    }

    private JPanel createPanelWithButtons() {
        Dimension size = this.frame.getSize();
        int avaliableField = size.width * size.height;
        int abaliableButtons = avaliableField / 10;
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5,10));
        for (int i = 0; i < 20; i++){
            OrganismButton button = new OrganismButton("Text");
            panel.add(button);
        }
        panel.setBorder(BorderFactory.createEmptyBorder((size.width/10),(size.height/10),(size.width/10),(size.height/10)));
        return panel;
    }
}
