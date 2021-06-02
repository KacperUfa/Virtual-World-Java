package pl.edu.pg.eti.ksg.po.virtual.world.Classes.Plants;

import pl.edu.pg.eti.ksg.po.virtual.world.Classes.Position;
import pl.edu.pg.eti.ksg.po.virtual.world.Classes.World;

import javax.swing.*;

public class Dandelion extends Plant{
    public Dandelion(Position position, World world) {
        super(0, new ImageIcon("resources/Images/dandelion.png"), position, world);
    }

    public Dandelion(int x, int y, World world) {
        super(0, new ImageIcon("resources/Images/dandelion.png"), x, y, world);
    }

    @Override
    public void action(){
        for(int i=0;i<3;i++){
            super.action();
        }
    }

    @Override
    public void newOrganism(Position position) {
        Dandelion dandelion = new Dandelion(position, this.WORLD);
        this.WORLD.addNew(dandelion);
    }

    @Override
    public void draw() {

    }
}
