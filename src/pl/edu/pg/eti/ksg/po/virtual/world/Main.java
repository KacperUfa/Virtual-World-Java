package pl.edu.pg.eti.ksg.po.virtual.world;

import pl.edu.pg.eti.ksg.po.virtual.world.Components.View.ViewManager;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        String appTitle = "Virtual World";
        int sizeX = 500;
        int sizeY = 500;
        SwingUtilities.invokeLater( () -> {
            new ViewManager(appTitle, sizeX, sizeY);
        });
    }
}
