package pl.edu.pg.eti.ksg.po.virtual.world;

import pl.edu.pg.eti.ksg.po.virtual.world.Classes.Animals.Sheep;
import pl.edu.pg.eti.ksg.po.virtual.world.Classes.Position;
import pl.edu.pg.eti.ksg.po.virtual.world.Components.View.ViewManager;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        String appTitle = "Virtual World";
        int sizeX = 5;
        int sizeY = 7;
        Sheep sheep = new Sheep(new Position(3,3), null);
        sheep.action();
        SwingUtilities.invokeLater( () -> {
            new ViewManager(appTitle, sizeX, sizeY, sheep);
        });
    }
}
