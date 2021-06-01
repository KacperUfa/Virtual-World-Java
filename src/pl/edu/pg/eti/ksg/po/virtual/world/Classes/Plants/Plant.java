package pl.edu.pg.eti.ksg.po.virtual.world.Classes.Plants;

import pl.edu.pg.eti.ksg.po.virtual.world.Classes.Position;
import pl.edu.pg.eti.ksg.po.virtual.world.Classes.World;
import pl.edu.pg.eti.ksg.po.virtual.world.Interfaces.Organism;

import javax.swing.*;
import java.util.Random;

public abstract class Plant extends Organism {
    public Plant(ImageIcon organismIcon, int power, Position position, World world) {
        super(0, organismIcon, power, position, world);
    }

    public Plant(ImageIcon organismIcon, int power, int x, int y, World world) {
        super(0, organismIcon, power, x, y, world);
    }

    @Override
    public void action() {
        Random random = new Random();
        int spread;
        spread = random.nextInt(10);
        if (spread == 0) {
            int actualX = this.position.getX();
            int actualY = this.position.getY();
            Position actualPosition = this.position;
            Position worldSize = this.getWORLD().getMapSize();
            Position move = this.randomMove();

            correctMove(move,worldSize,actualX,actualY);

            int xAction = actualX+move.getX();
            int yAction = actualY+move.getY();

            Organism tmpOrganism = this.WORLD.getOrganism(xAction, yAction);

            if(tmpOrganism==null){
                Position breedPosition = new Position(xAction,yAction);
                this.newOrganism(breedPosition);
            }
        }
    }

    @Override
    public void collision(Organism aggressiveOrganism, int organismX, int organismY, Position move) {
        this.getWORLD().addKilled(this);
        this.kill();
        this.getWORLD().erasePosition(this.getPosition());
        aggressiveOrganism.move(move.getX(),move.getY());
        aggressiveOrganism.getWORLD().erasePosition(organismX, organismY);
    }

}
