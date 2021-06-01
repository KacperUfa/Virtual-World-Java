package pl.edu.pg.eti.ksg.po.virtual.world.Classes.Animals;

import pl.edu.pg.eti.ksg.po.virtual.world.Classes.Position;
import pl.edu.pg.eti.ksg.po.virtual.world.Classes.World;
import pl.edu.pg.eti.ksg.po.virtual.world.Interfaces.Organism;

import javax.swing.*;
import java.util.Random;

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

    public Position randomMove() {
        Random random = new Random();
        int x, y;
        do {
            x = random.nextInt(3) - 2;
            y = random.nextInt(3) - 2;
        }
        while (x == 0 && y == 0);

        Position vector = new Position(x, y);
        return vector;
    }

    @Override
    public void action() {
        int x, y;
        int actualX = this.position.getX();
        int actualY = this.position.getY();
        Position actualPosition = this.position;
        Position worldSize = this.getWORLD().getMapSize();

        Position move = randomMove();

        if (actualX == 0 && randomMove().getX() < 0) {
            randomMove().setX(1);
        } else if (actualX == worldSize.getY() - 1 && randomMove().getX() > 0) {
            randomMove().setX(-1);
        }
        if (actualY == 0 && randomMove().getY() < 0) {
            randomMove().setY(1);
        } else if (actualY == worldSize.getX() - 1 && randomMove().getY() > 0) {
            randomMove().setY(-1);
        }

       // Organism tmpOrganism = this.WORLD.


    }

}
