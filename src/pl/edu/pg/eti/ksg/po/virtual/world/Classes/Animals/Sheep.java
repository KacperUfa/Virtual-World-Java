package pl.edu.pg.eti.ksg.po.virtual.world.Classes.Animals;

import pl.edu.pg.eti.ksg.po.virtual.world.Classes.Position;
import pl.edu.pg.eti.ksg.po.virtual.world.Classes.World;
import pl.edu.pg.eti.ksg.po.virtual.world.Interfaces.Organism;

import javax.swing.*;

public class Sheep extends Animal {
    public Sheep(Position position, World world) {
        super(4,new ImageIcon("resources/Images/sheep.png"), 4, position, world);
    }

    public Sheep(int x, int y, World world) {
        super(4,new ImageIcon("resources/Images/sheep.png"), 4, x, y, world);
    }

    @Override
    public void newOrganism(Position position) {
        Sheep newSheep = new Sheep(position, this.WORLD);
        this.WORLD.addNew(newSheep);
    }

    @Override
    public void draw(){

    }
}
