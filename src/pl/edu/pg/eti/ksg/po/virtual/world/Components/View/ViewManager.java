package pl.edu.pg.eti.ksg.po.virtual.world.Components.View;

import javax.swing.*;
import java.awt.*;

public class ViewManager {
    public ViewManager(String vindowTitle, int sizeX, int sizeY) {
        JFrame frame = new JFrame(vindowTitle);
        frame.setSize(sizeX, sizeY);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }
}
