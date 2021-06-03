package pl.edu.pg.eti.ksg.po.virtual.world.Classes.Animals;

import pl.edu.pg.eti.ksg.po.virtual.world.Classes.Position;
import pl.edu.pg.eti.ksg.po.virtual.world.Classes.World;
import pl.edu.pg.eti.ksg.po.virtual.world.Interfaces.Organism;

import javax.swing.*;
import java.util.Random;

public abstract class Animal extends Organism {
    public Animal(int initiative, ImageIcon organismIcon, int power, Position position, World world) {
        super(initiative, organismIcon, power, position, world);
    }

    public Animal(int initiative, ImageIcon organismIcon, int power, int x, int y, World world) {
        super(initiative, organismIcon, power, x, y, world);
    }

    @Override
    public void action() {
        System.out.println(this.getClass().getSimpleName());
        int actualX = this.position.getX();
        int actualY = this.position.getY();
        Position worldSize = this.getWORLD().getMapSize();
        Position move = randomMove();
        correctMove(move,worldSize,actualX,actualY);
        int xAction = actualX+move.getX();
        int yAction = actualY+move.getY();
        Organism tmpOrganism = this.WORLD.getOrganism(xAction, yAction);
        if(tmpOrganism==null){
            this.move(move.getX(), move.getY());
            this.WORLD.erasePosition(actualX,actualY);
        }
        else{
            tmpOrganism.collision(this, actualX, actualY, move);
        }
    }

    @Override
    public void collision(Organism aggressiveOrganism, int organismX,int organismY, Position move){
        if(aggressiveOrganism.checkSpecies(this)){
            //Breed
            Position breedPosition = this.breedPosition();
            if(breedPosition!=null){
                this.newOrganism(breedPosition);
            }
        }
        else{
            //Fight
            if(aggressiveOrganism.getPower()>=this.getPower()){
                this.kill();
                this.WORLD.addKilled(this);
                aggressiveOrganism.getWORLD().erasePosition(this.position);
                aggressiveOrganism.move(move);
            }
            else{
                aggressiveOrganism.getWORLD().addKilled(aggressiveOrganism);
                aggressiveOrganism.kill();
            }
            aggressiveOrganism.getWORLD().erasePosition(organismX,organismY);
        }
    }

}
