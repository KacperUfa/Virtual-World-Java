package pl.edu.pg.eti.ksg.po.virtual.world.Classes.Animals;

import pl.edu.pg.eti.ksg.po.virtual.world.Classes.Position;
import pl.edu.pg.eti.ksg.po.virtual.world.Classes.World;

import javax.swing.*;

public class Wolf extends Animal{

    public Wolf(Position position, World world) {
        super(5, new ImageIcon("resources/Images/sheep.png"), 9, position, world);
    }

    public Wolf(int x, int y, World world) {
        super(5, new ImageIcon("resources/Images/sheep.png"), 9, x, y, world);
    }

    @Override
    public void newOrganism(Position position) {
        Wolf wolf = new Wolf(position,this.WORLD);
        this.WORLD.addNew(wolf);
    }

    @Override
    public void draw() {

    }
}
