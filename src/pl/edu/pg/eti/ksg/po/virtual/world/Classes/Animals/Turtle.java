package pl.edu.pg.eti.ksg.po.virtual.world.Classes.Animals;

import pl.edu.pg.eti.ksg.po.virtual.world.Classes.Position;
import pl.edu.pg.eti.ksg.po.virtual.world.Classes.World;
import pl.edu.pg.eti.ksg.po.virtual.world.Interfaces.Organism;

import javax.swing.*;
import java.util.Random;

/*
Turtle is extension of animal class, it makes a move in action only in 25% of the times,
additionally it is collided by animal that ha less than 5 power it is protected by it's shell
 */

public class Turtle extends Animal{
    public Turtle(Position position, World world) {
        super(1, new ImageIcon("resources/Images/turtle.png"), 2, position, world);
    }

    public Turtle(int x, int y, World world) {
        super(1, new ImageIcon("resources/Images/turtle.png"), 2, x, y, world);
    }

    //Making Turtle move only in 25% of the times
    @Override
    public void action(){
        Random random = new Random();
        int rand = random.nextInt(4);
        if(rand==0){
            super.action();
        }else{
            String log = this.getClass().getSimpleName() + "s decided to stay in place\n";
            this.WORLD.getLogBuilder().append(log);
        }
    }

    //Checking the power of the aggressor, if it is less than five, it cancels it's attack
    @Override
    public void collision(Organism aggressiveOrganism, int organismX,int organismY, Position move){
        if(aggressiveOrganism.getPower()>=5 || aggressiveOrganism.checkSpecies(this)){
            super.collision(aggressiveOrganism, organismX, organismY, move);
        }
        else{
            String log = this.getClass().getSimpleName() + "s defended itself\n";
            this.WORLD.getLogBuilder().append(log);
        }
    }

    @Override
    public void newOrganism(Position position) {
        Turtle turtle = new Turtle(position,this.WORLD);
        this.WORLD.addNew(turtle);
    }
}
