package pl.edu.pg.eti.ksg.po.virtual.world.Classes.Plants;

import pl.edu.pg.eti.ksg.po.virtual.world.Classes.Position;
import pl.edu.pg.eti.ksg.po.virtual.world.Classes.World;
import pl.edu.pg.eti.ksg.po.virtual.world.Interfaces.Organism;

import javax.swing.*;

/*
The most dangerous plant in virtual world, in it's action it kills every animal except CyberSheep, that is standing
on the nearby fields.
In the collision method,if it was not CyberSheep, it kills the animal that ate it
 */

public class Parnsip extends Plant {
    public Parnsip(Position position, World world) {
        super(10, new ImageIcon("resources/Images/parnsip.png"), position, world);
    }

    public Parnsip(int x, int y, World world) {
        super(10, new ImageIcon("resources/Images/parnsip.png"), x, y, world);
    }
    //In action besides normal spreading seeds, it is killing and removing every animal, besides CyberSheep
    //that is around it
    @Override
    public void action(){
        System.out.println(this.getClass().getSimpleName());
        super.action();

        int actualX = this.position.getX();
        int actualY = this.position.getY();

        for(int i=-1;i<2;i++){
            if(actualX+i<0 || actualX+i>this.getWORLD().getMapSize().getX()-1){
                continue;
            }
            for(int j=-1;j<2;j++){
                if(actualY+j<0 || actualY+j>this.getWORLD().getMapSize().getY()-1){
                    continue;
                }
                Organism organismTmp = this.getWORLD().getOrganism(actualX+i,actualY+j);
                boolean isInstance = true;
                boolean isCyber = false;
                if(organismTmp!=null) {
                    isInstance = organismTmp instanceof Plant;
                    Class c = organismTmp.getClass();
                    isCyber=c.getSimpleName().equals("CyberSheep");
                }
                if(organismTmp!=null && !isCyber && !isInstance){
                    organismTmp.getWORLD().addKilled(organismTmp);
                    organismTmp.kill();
                    organismTmp.getWORLD().erasePosition(actualX+i,actualY+j);
                    String log2 = this.getClass().getSimpleName() + "s killed "+organismTmp.getClass().getSimpleName()+"\n";
                    this.WORLD.getLogBuilder().append(log2);
                }
            }
        }

    }

    //In the collision parnsip kills itself and attacking organism if it was not CyberSheep
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
            String log = this.getClass().getSimpleName() + "s was eaten by "+aggressiveOrganism.getClass().getSimpleName()+"\n";
            String log2 = this.getClass().getSimpleName() + "s killed "+aggressiveOrganism.getClass().getSimpleName()+"\n";
            this.WORLD.getLogBuilder().append(log);
            this.WORLD.getLogBuilder().append(log2);
        }
    }

    @Override
    public void newOrganism(Position position) {
        Parnsip parnsip = new Parnsip(position, this.WORLD);
        this.WORLD.addNew(parnsip);
    }
}
