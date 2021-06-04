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
        String appTitle = "Virtual World - Kacper ufa 184501";
        int sizeX = 5;
        int sizeY = 10;

        GenerateWorld generateWorld = new GenerateWorld(sizeX,sizeY);
        ArrayList<Organism> organisms;
        World world = generateWorld.createWorld();
        Human human2 = null;
        SaveLoad load = new SaveLoad();
        //World world = load.load();
        organisms = world.getOrganisms();
        for(Organism organism:organisms){
            if(organism.getClass().getSimpleName().equals("Human")){
                human2 = (Human) organism;
                break;
            }
        }
        Human human;
        if(human2==null){
             human= new Human(0,0,world);
             human.setAlive(false);
        }
        else{
            human = human2;
        }

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