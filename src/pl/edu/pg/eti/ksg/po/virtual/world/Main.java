package pl.edu.pg.eti.ksg.po.virtual.world;

import pl.edu.pg.eti.ksg.po.virtual.world.Classes.Animals.CyberSheep;
import pl.edu.pg.eti.ksg.po.virtual.world.Classes.Animals.Human;
import pl.edu.pg.eti.ksg.po.virtual.world.Classes.Animals.Sheep;
import pl.edu.pg.eti.ksg.po.virtual.world.Classes.Animals.Wolf;
import pl.edu.pg.eti.ksg.po.virtual.world.Classes.Plants.Grass;
import pl.edu.pg.eti.ksg.po.virtual.world.Classes.Plants.Parnsip;
import pl.edu.pg.eti.ksg.po.virtual.world.Classes.Position;
import pl.edu.pg.eti.ksg.po.virtual.world.Classes.SaveLoad;
import pl.edu.pg.eti.ksg.po.virtual.world.Classes.World;
import pl.edu.pg.eti.ksg.po.virtual.world.Components.View.ViewManager;
import pl.edu.pg.eti.ksg.po.virtual.world.Interfaces.Organism;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Main {

    public static void main(String[] args) {
        String appTitle = "Virtual World";
        int sizeX = 5;
        int sizeY = 10;
        Sheep sheep = new Sheep(new Position(2, 3), null);
        Sheep sheep2 = new Sheep(new Position(1, 3), null);
        Sheep sheep3 = new Sheep(new Position(3, 0), null);
        Parnsip parnsip1 = new Parnsip(0,0,null);
        Parnsip parnsip2 = new Parnsip(0,9,null);
        Grass grass1=new Grass(0,1,null);
        CyberSheep cyberSheep1 = new CyberSheep(4,9,null);
        Wolf wolf1 = new Wolf(3, 9, null);

        Human human = new Human(4,9,null);
        ArrayList<Organism> organisms = new ArrayList<Organism>();
        organisms.add(sheep3);
        organisms.add(parnsip1);
        organisms.add(grass1);
        organisms.add(wolf1);
        organisms.add(sheep2);
        organisms.add(human);
        World world = new World(sizeX, sizeY, organisms);

        SaveLoad load = new SaveLoad();
        try {
            load.load(null);
        }
        catch (FileNotFoundException e){

        }


        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ViewManager(appTitle, sizeY, sizeX, world, human);
            }
        });
    }
}