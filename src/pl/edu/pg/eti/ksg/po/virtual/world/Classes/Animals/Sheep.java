package pl.edu.pg.eti.ksg.po.virtual.world.Classes.Animals;

import pl.edu.pg.eti.ksg.po.virtual.world.Classes.Position;
import pl.edu.pg.eti.ksg.po.virtual.world.Classes.World;
import pl.edu.pg.eti.ksg.po.virtual.world.Interfaces.Organism;

import javax.swing.*;

public class Sheep extends Animal {
    private final ImageIcon ORGANISM_ICON;

    public Sheep(Position position, World world) {

        super(4, 4, position, world);

        ORGANISM_ICON = new ImageIcon("resources/Images/sheep.png");

    }

    public Sheep(int x, int y, World world) {
        super(4, 4, x, y, world);

        ORGANISM_ICON = new ImageIcon("resources/Images/sheep.png");
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
