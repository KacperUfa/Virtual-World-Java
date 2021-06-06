package pl.edu.pg.eti.ksg.po.virtual.world.Classes.Plants;

import pl.edu.pg.eti.ksg.po.virtual.world.Classes.Position;
import pl.edu.pg.eti.ksg.po.virtual.world.Classes.World;
import pl.edu.pg.eti.ksg.po.virtual.world.Interfaces.Organism;

import javax.swing.*;

/*
Nightshade is deadly plant, that kills the animal that ate it
*/

public class NightShade extends Plant{
    public NightShade(Position position, World world) {
        super(99, new ImageIcon("resources/Images/nightshade.png"), position, world);
    }

    public NightShade(int x, int y, World world) {
        super(99, new ImageIcon("resources/Images/nightshade.png"), x, y, world);
    }

    //Overridden collision method so that both, this plant and attacking organism are killed and removed from world
    @Override
    public void collision(Organism aggressiveOrganism, int organismX, int organismY, Position move){
        this.WORLD.addKilled(this);
        this.WORLD.addKilled(aggressiveOrganism);
        this.kill();
        aggressiveOrganism.kill();
        this.getWORLD().erasePosition(this.getPosition());
        aggressiveOrganism.getWORLD().erasePosition(organismX, organismY);
    }

    @Override
    public void newOrganism(Position position) {
        NightShade nightShade = new NightShade(position,this.WORLD);
        this.WORLD.addNew(nightShade);
    }

}
