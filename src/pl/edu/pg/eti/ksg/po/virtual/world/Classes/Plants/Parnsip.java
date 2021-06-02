package pl.edu.pg.eti.ksg.po.virtual.world.Classes.Plants;

import pl.edu.pg.eti.ksg.po.virtual.world.Classes.Position;
import pl.edu.pg.eti.ksg.po.virtual.world.Classes.World;
import pl.edu.pg.eti.ksg.po.virtual.world.Interfaces.Organism;

import javax.swing.*;

public class Parnsip extends Plant {
    public Parnsip(Position position, World world) {
        super(10, new ImageIcon("resources/Images/parnsip.png"), position, world);
    }

    public Parnsip(int x, int y, World world) {
        super(10, new ImageIcon("resources/Images/parnsip.png"), x, y, world);
    }

    @Override
    public void action(){
        super.action();

        int actualX = this.position.getX();
        int actualY = this.position.getY();

        for(int i=-1;i<2;i++){
            if(actualX+i<0 || actualX+i>this.getWORLD().getMapSize().getY()-1){
                continue;
            }
            for(int j=-1;j<2;j++){
                if(actualY+j<0 || actualY+j>this.getWORLD().getMapSize().getX()-1){
                    continue;
                }
                Organism organismTmp = this.getWORLD().getOrganism(actualX+i,actualY+j);
                Class c = organismTmp.getClass();
                if(organismTmp!=null && !c.getSimpleName().equals("CyberSheep")){
                    Position newPosition = new Position(actualX+i,actualY+j);

                    organismTmp.getWORLD().addKilled(organismTmp);
                    organismTmp.kill();
                    organismTmp.getWORLD().erasePosition(actualX+i,actualY+j);

                }
            }
        }

    }

    @Override
    public void collision(Organism aggressiveOrganism, int organismX, int organismY, Position move) {
        Class c = aggressiveOrganism.getClass();
        if (c.getSimpleName().equals("CyberSheep")) {
            super.collision(aggressiveOrganism, organismX, organismY, move);
        } else {
            this.WORLD.addKilled(this);
            this.WORLD.addKilled(aggressiveOrganism);
            this.kill();
            aggressiveOrganism.kill();
            this.getWORLD().erasePosition(this.getPosition());
            aggressiveOrganism.getWORLD().erasePosition(organismX, organismY);
        }
    }

    @Override
    public void newOrganism(Position position) {
        Parnsip parnsip = new Parnsip(position, this.WORLD);
        this.WORLD.addNew(parnsip);
    }

    @Override
    public void draw() {

    }
}
