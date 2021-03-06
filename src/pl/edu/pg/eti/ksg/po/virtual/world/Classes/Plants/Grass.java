package pl.edu.pg.eti.ksg.po.virtual.world.Classes.Plants;

import pl.edu.pg.eti.ksg.po.virtual.world.Classes.Position;
import pl.edu.pg.eti.ksg.po.virtual.world.Classes.World;

import javax.swing.*;

/*
Basic plant, nothing special
 */

public class Grass extends Plant{
    public Grass(Position position, World world) {
        super(0, new ImageIcon("resources/Images/grass.png"), position, world);
    }

    public Grass(int x, int y, World world) {
        super(0, new ImageIcon("resources/Images/grass.png"), x, y, world);
    }

    @Override
    public void newOrganism(Position position) {
        Grass grass = new Grass(position,this.WORLD);
        this.WORLD.addNew(grass);
    }
}
