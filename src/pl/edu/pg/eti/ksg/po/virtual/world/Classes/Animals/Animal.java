package pl.edu.pg.eti.ksg.po.virtual.world.Classes.Animals;

import pl.edu.pg.eti.ksg.po.virtual.world.Classes.Position;
import pl.edu.pg.eti.ksg.po.virtual.world.Classes.World;
import pl.edu.pg.eti.ksg.po.virtual.world.Interfaces.Organism;

import javax.swing.*;

public abstract class Animal extends Organism {
    public Animal(int initiative, ImageIcon organismIcon, int power, Position position, World world) {
        super(initiative, organismIcon, power, position, world);
    }

    public Animal(int initiative, ImageIcon organismIcon, int power, int x, int y, World world) {
        super(initiative, organismIcon, power, x, y, world);
    }

    public void move(int x, int y) {
        this.position.move(x, y);
    }

    @Override
    public void action() {
        int x, y;
        int actualX = this.position.getX();
        int actualY = this.position.getY();

    }

}
