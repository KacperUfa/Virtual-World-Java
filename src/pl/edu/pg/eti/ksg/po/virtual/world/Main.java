package pl.edu.pg.eti.ksg.po.virtual.world;

import pl.edu.pg.eti.ksg.po.virtual.world.Classes.Animals.CyberSheep;
import pl.edu.pg.eti.ksg.po.virtual.world.Classes.Animals.Human;
import pl.edu.pg.eti.ksg.po.virtual.world.Classes.Animals.Sheep;
import pl.edu.pg.eti.ksg.po.virtual.world.Classes.Animals.Wolf;
import pl.edu.pg.eti.ksg.po.virtual.world.Classes.GenerateWorld;
import pl.edu.pg.eti.ksg.po.virtual.world.Classes.Plants.Grass;
import pl.edu.pg.eti.ksg.po.virtual.world.Classes.Plants.Parnsip;
import pl.edu.pg.eti.ksg.po.virtual.world.Classes.Position;
import pl.edu.pg.eti.ksg.po.virtual.world.Classes.SaveLoad;
import pl.edu.pg.eti.ksg.po.virtual.world.Classes.World;
import pl.edu.pg.eti.ksg.po.virtual.world.Components.View.StartManager;
import pl.edu.pg.eti.ksg.po.virtual.world.Components.View.ViewManager;
import pl.edu.pg.eti.ksg.po.virtual.world.Interfaces.Organism;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Main {

    public static void main(String[] args) {
        StartManager startManager = new StartManager();



/*
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                int worldX = world.getMapSize().getX();
                int worldY = world.getMapSize().getY();
                new ViewManager(appTitle, worldY , worldX, world, human);
            }
        });*/
    }
}