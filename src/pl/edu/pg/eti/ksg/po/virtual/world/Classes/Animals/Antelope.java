package pl.edu.pg.eti.ksg.po.virtual.world.Classes.Animals;

import pl.edu.pg.eti.ksg.po.virtual.world.Classes.Position;
import pl.edu.pg.eti.ksg.po.virtual.world.Classes.World;
import pl.edu.pg.eti.ksg.po.virtual.world.Interfaces.Organism;

import javax.swing.*;
import java.util.Random;

/*
Antelope differs from basic animal in that, it moves by two fields instead of one and if it has empty filed
nearby it has 50% chance to escape before fight
 */

public class Antelope extends Animal {
    public Antelope(Position position, World world) {
        super(4, new ImageIcon("resources/Images/antelope.png"), 4, position, world);
    }

    public Antelope(int x, int y, World world) {
        super(4, new ImageIcon("resources/Images/antelope.png"), 4, x, y, world);
    }

    //Adjusted for moving by two fields
    @Override
    public void correctMove(Position move, Position worldSize, int actualX, int actualY) {
        if ((actualX == 0 || actualX == 1) && move.getX() < 0) {
            move.setX(2);
        } else if ((actualX == worldSize.getX() - 2 || actualX == worldSize.getX() - 1) && move.getX() > 0) {
            move.setX(-2);
        }
        if ((actualY == 0 || actualY == 1) && move.getY() < 0) {
            move.setY(2);
        } else if ((actualY == worldSize.getY() - 2 || actualY == worldSize.getY() - 1) && move.getY() > 0) {
            move.setY(-2);
        }
    }

    //Adjusted for moving by two fields
    @Override
    public void action() {
        int actualX = this.position.getX();
        int actualY = this.position.getY();
        Position worldSize = this.getWORLD().getMapSize();
        Position move = randomMove();
        move.setX(move.getX() * 2);
        move.setY(move.getY() * 2);
        correctMove(move, worldSize, actualX, actualY);
        int xAction = actualX + move.getX();
        int yAction = actualY + move.getY();
        Organism tmpOrganism = this.WORLD.getOrganism(xAction, yAction);
        if (tmpOrganism == null) {
            this.move(move.getX(), move.getY());
            this.WORLD.erasePosition(actualX, actualY);
        } else {
            tmpOrganism.collision(this, actualX, actualY, move);
        }
    }

    //implementing the escape mechanics in base collision
    @Override
    public void collision(Organism aggressiveOrganism, int organismX, int organismY, Position move) {
        Random random = new Random();
        int rand = random.nextInt(2);
        Position breedPosition = this.breedPosition();
        if (rand == 0 && breedPosition != null && !aggressiveOrganism.checkSpecies(this)) {
            int xTmp = this.position.getX();
            int yTmp = this.position.getY();
            this.setPosition(breedPosition);
            this.WORLD.placeOrganism(this);
            this.WORLD.erasePosition(xTmp, yTmp);
            aggressiveOrganism.move(move);
            aggressiveOrganism.getWORLD().erasePosition(organismX, organismY);
        } else {
            super.collision(aggressiveOrganism, organismX, organismY, move);
        }
    }

    @Override
    public void newOrganism(Position position) {
        Antelope antelope = new Antelope(position, this.WORLD);
        this.WORLD.addNew(antelope);
    }
}
