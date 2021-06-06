package pl.edu.pg.eti.ksg.po.virtual.world.Classes.Animals;

import pl.edu.pg.eti.ksg.po.virtual.world.Classes.Position;
import pl.edu.pg.eti.ksg.po.virtual.world.Classes.World;
import pl.edu.pg.eti.ksg.po.virtual.world.Interfaces.Organism;

import javax.swing.*;

/*
Fox is the normal animal, but smart, if it would make a move that would kill it, it cancels that move
 */

public class Fox extends Animal {
    public Fox(Position position, World world) {
        super(7, new ImageIcon("resources/Images/fox.png"), 3, position, world);
    }

    public Fox(int x, int y, World world) {
        super(7, new ImageIcon("resources/Images/fox.png"), 3, x, y, world);
    }

    //changing base action method, so that the power of attacked organism is checked and compared
    //before moving and fighting with eat
    @Override
    public void action() {
        int actualX = this.position.getX();
        int actualY = this.position.getY();
        Position worldSize = this.getWORLD().getMapSize();
        Position move = randomMove();
        correctMove(move, worldSize, actualX, actualY);
        int xAction = actualX + move.getX();
        int yAction = actualY + move.getY();
        Organism tmpOrganism = this.WORLD.getOrganism(xAction, yAction);

        if (tmpOrganism == null) {
            this.move(move.getX(), move.getY());
            this.WORLD.erasePosition(actualX,actualY);
            String log = this.getClass().getSimpleName() + " moved\n";
            this.WORLD.getLogBuilder().append(log);
        } else {
            if (tmpOrganism.getPower() <= this.getPower()) {
                tmpOrganism.collision(this, actualX, actualY, move);
            }
            else{
                String log = this.getClass().getSimpleName() + " didn't move\n";
                this.WORLD.getLogBuilder().append(log);
            }
        }
    }

    @Override
    public void newOrganism(Position position) {
        Fox fox = new Fox(position, this.WORLD);
        this.WORLD.addNew(fox);
    }
}
