package pl.edu.pg.eti.ksg.po.virtual.world;

import pl.edu.pg.eti.ksg.po.virtual.world.Classes.Animals.Sheep;
import pl.edu.pg.eti.ksg.po.virtual.world.Classes.Animals.Wolf;
import pl.edu.pg.eti.ksg.po.virtual.world.Classes.Position;
import pl.edu.pg.eti.ksg.po.virtual.world.Classes.World;
import pl.edu.pg.eti.ksg.po.virtual.world.Components.View.ViewManager;
import pl.edu.pg.eti.ksg.po.virtual.world.Interfaces.Organism;

import javax.swing.*;
import java.sql.SQLOutput;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        int sizeX = 3;
        int sizeY = 4;
        Sheep sheep = new Sheep(new Position(2,3), null);
        Sheep sheep2 = new Sheep(new Position(1,3), null);
        Sheep sheep3 = new Sheep(new Position(0,0), null);
        Wolf wolf1 = new Wolf(1,2,null);
        ArrayList<Organism> organisms = new ArrayList<Organism>();
        organisms.add(sheep);
        organisms.add(sheep2);
        organisms.add(sheep3);
        organisms.add(wolf1);
        World world = new World(sizeX, sizeY, organisms);

        //world.makeTurn();
        //System.out.println(sheep.getPosition().getX());
        //System.out.println(sheep.getPosition().getY());
        //System.out.println(sheep2.getPosition().getX());
        //System.out.println(sheep2.getPosition().getY());
        //int x1=sheep.getPosition().getX();
        //int x2=sheep2.getPosition().getX();
        //int y1 =sheep.getPosition().getY();
        //int y2 =sheep2.getPosition().getY();
        //System.out.println(world.getOrganism(x1,y1).getClass().getSimpleName());
        //System.out.println(world.getOrganism(x2,y2).getClass().getSimpleName());
        //world.makeTurn();
        for(int i=0;i<10000;i++){

            //System.out.println(sheep.getPosition().getX()+" "+sheep.getPosition().getY()+"\n");
            world.makeTurn();
        }
        //sheep.action();
    }
}
