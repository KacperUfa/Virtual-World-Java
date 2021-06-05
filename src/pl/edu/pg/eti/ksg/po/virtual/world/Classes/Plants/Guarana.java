package pl.edu.pg.eti.ksg.po.virtual.world.Classes.Plants;

import pl.edu.pg.eti.ksg.po.virtual.world.Classes.Position;
import pl.edu.pg.eti.ksg.po.virtual.world.Classes.World;
import pl.edu.pg.eti.ksg.po.virtual.world.Interfaces.Organism;

import javax.swing.*;

public class Guarana extends Plant {
    public Guarana(Position position, World world) {
        super(0, new ImageIcon("resources/Images/guarana.png"), position, world);
    }

    public Guarana(int x, int y, World world) {
        super(0, new ImageIcon("resources/Images/guarana.png"), x, y, world);
    }

    @Override
    public void collision(Organism aggressiveOrganism, int organismX, int organismY, Position move) {
        aggressiveOrganism.setPower(aggressiveOrganism.getPower() + 3);
        super.collision(aggressiveOrganism, organismX, organismY, move);
    }

    @Override
    public void newOrganism(Position position) {
        Guarana guarana = new Guarana(position, this.WORLD);
        this.WORLD.addNew(guarana);
    }
}
