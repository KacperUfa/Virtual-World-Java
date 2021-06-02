package pl.edu.pg.eti.ksg.po.virtual.world.Classes.Animals;

import pl.edu.pg.eti.ksg.po.virtual.world.Classes.Position;
import pl.edu.pg.eti.ksg.po.virtual.world.Classes.World;

import javax.swing.*;

public class Human extends Animal{
    private int countSpecial;
    private boolean canActivate;

    public Human(Position position, World world) {
        super(4, new ImageIcon("resources/Images/human.png"), 5, position, world);
    }

    public Human(int x, int y, World world) {
        super(4, new ImageIcon("resources/Images/human.png"), 5, x, y, world);
    }

    @Override
    public void action(){
        /*

        moving panel






         */



    }

    @Override
    public void newOrganism(Position position) {
        Human human = new Human(position, this.WORLD);
        this.WORLD.addNew(human);
    }

    @Override
    public void draw() {

    }
}
