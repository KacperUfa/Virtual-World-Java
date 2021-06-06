package pl.edu.pg.eti.ksg.po.virtual.world.Classes.Plants;

import pl.edu.pg.eti.ksg.po.virtual.world.Classes.Position;
import pl.edu.pg.eti.ksg.po.virtual.world.Classes.World;
import pl.edu.pg.eti.ksg.po.virtual.world.Interfaces.Organism;

import javax.swing.*;
import java.util.Random;

/*
Base class for all plants extending basic organism, it implements basic action and collision methods.
Additionally it sets initiative of all plants to 0
 */

public abstract class Plant extends Organism {
    public Plant(int power, ImageIcon organismIcon,  Position position, World world) {
        super(0, organismIcon, power, position, world);
    }

    public Plant(int power,ImageIcon organismIcon ,int x, int y, World world) {
        super(0, organismIcon ,power, x, y, world);
    }

    //Base plant action which is trying to spread seeds on the fields nearby it
    @Override
    public void action() {
        Random random = new Random();
        int spread;
        spread = random.nextInt(10);
        if (spread == 0) {
            int actualX = this.position.getX();
            int actualY = this.position.getY();
            Position worldSize = this.getWORLD().getMapSize();
            Position move = this.randomMove();

            correctMove(move,worldSize,actualX,actualY);

            int xAction = actualX+move.getX();
            int yAction = actualY+move.getY();

            Organism tmpOrganism = this.WORLD.getOrganism(xAction, yAction);

            if(tmpOrganism==null){
                Position breedPosition = new Position(xAction,yAction);
                this.newOrganism(breedPosition);
                String log = this.getClass().getSimpleName() + " spread seeds\n";
                this.WORLD.getLogBuilder().append(log);
            }
        }
    }

    //Base plant collision which is basically being eaten by something
    @Override
    public void collision(Organism aggressiveOrganism, int organismX, int organismY, Position move) {
        this.getWORLD().addKilled(this);
        this.kill();
        this.getWORLD().erasePosition(this.getPosition());
        aggressiveOrganism.move(move.getX(),move.getY());
        aggressiveOrganism.getWORLD().erasePosition(organismX, organismY);
        String log = this.getClass().getSimpleName() + " was eaten by "+aggressiveOrganism.getClass().getSimpleName()+"\n";
        this.WORLD.getLogBuilder().append(log);
    }

}
