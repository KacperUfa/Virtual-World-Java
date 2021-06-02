package pl.edu.pg.eti.ksg.po.virtual.world.Classes.Animals;

import pl.edu.pg.eti.ksg.po.virtual.world.Classes.Position;
import pl.edu.pg.eti.ksg.po.virtual.world.Classes.World;

import javax.swing.*;

public class CyberSheep extends Animal{
    public CyberSheep(Position position, World world) {
        super(4, new ImageIcon("resources/Images/cyberSheep.png"), 11, position, world);
    }

    public CyberSheep(int x, int y, World world) {
        super(4, new ImageIcon("resources/Images/cyberSheep.png"), 11, x, y, world);
    }

    public Position findWeed(){
        for(int i=0;i<this.WORLD.getMapSize().getY();i++){
            for(int j=0; j<this.WORLD.getMapSize().getX(); j++){

                //hogweed

                if(this.WORLD.getOrganism(i,j).getClass()==null){

                }
            }
        }
        return null;
    }

    @Override
    public void newOrganism(Position position) {
        CyberSheep cyberSheep = new CyberSheep(position, this.WORLD);
        this.WORLD.addNew(cyberSheep);
    }

    @Override
    public void draw() {

    }
}
