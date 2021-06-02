package pl.edu.pg.eti.ksg.po.virtual.world.Classes.Animals;

import pl.edu.pg.eti.ksg.po.virtual.world.Classes.Position;
import pl.edu.pg.eti.ksg.po.virtual.world.Classes.World;
import pl.edu.pg.eti.ksg.po.virtual.world.Interfaces.Organism;

import javax.swing.*;
import java.util.Random;

public class Turtle extends Animal{
    public Turtle(Position position, World world) {
        super(1, new ImageIcon("resources/Images/turtle.png"), 2, position, world);
    }

    public Turtle(int x, int y, World world) {
        super(1, new ImageIcon("resources/Images/turtle.png"), 2, x, y, world);
    }

    @Override
    public void action(){
        Random random = new Random();
        int rand = random.nextInt(4);
        if(rand==0){
            super.action();
        }
    }

    @Override
    public void collision(Organism aggressiveOrganism, int organismX,int organismY, Position move){
        if(aggressiveOrganism.getPower()>=5 || aggressiveOrganism.checkSpecies(this)){
            super.collision(aggressiveOrganism, organismX, organismY, move);
        }
    }

    @Override
    public void newOrganism(Position position) {
        Turtle turtle = new Turtle(position,this.WORLD);
        this.WORLD.addNew(turtle);
    }

    @Override
    public void draw() {

    }
}
