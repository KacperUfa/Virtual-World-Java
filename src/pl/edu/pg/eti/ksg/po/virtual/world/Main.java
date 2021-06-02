package pl.edu.pg.eti.ksg.po.virtual.world;

import pl.edu.pg.eti.ksg.po.virtual.world.Classes.Animals.Sheep;
import pl.edu.pg.eti.ksg.po.virtual.world.Classes.Animals.Wolf;
import pl.edu.pg.eti.ksg.po.virtual.world.Classes.Position;
import pl.edu.pg.eti.ksg.po.virtual.world.Classes.World;
import pl.edu.pg.eti.ksg.po.virtual.world.Components.View.ViewManager;
import pl.edu.pg.eti.ksg.po.virtual.world.Interfaces.Organism;

import javax.swing.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        String appTitle = "Virtual World";
        int sizeX = 5;
        int sizeY = 10;

        Sheep sheep = new Sheep(new Position(2, 3), null);
        Sheep sheep2 = new Sheep(new Position(1, 3), null);
        Sheep sheep3 = new Sheep(new Position(0, 0), null);
        Wolf wolf1 = new Wolf(1, 2, null);
        ArrayList<Organism> organisms = new ArrayList<Organism>();
        organisms.add(sheep);
        organisms.add(wolf1);
        World world = new World(sizeX, sizeY, organisms);
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ViewManager(appTitle, sizeY, sizeX, world);
            }
        });
    }
}