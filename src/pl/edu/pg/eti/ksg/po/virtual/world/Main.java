package pl.edu.pg.eti.ksg.po.virtual.world;

import pl.edu.pg.eti.ksg.po.virtual.world.Components.View.ViewManager;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        String appTitle = "Virtual World";
        int sizeX = 5;
        int sizeY = 7;
        SwingUtilities.invokeLater( () -> {
            new ViewManager(appTitle, sizeX, sizeY);
        });
    }
}
