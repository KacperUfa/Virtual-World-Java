package pl.edu.pg.eti.ksg.po.virtual.world.Interfaces;

import pl.edu.pg.eti.ksg.po.virtual.world.Classes.Position;
import pl.edu.pg.eti.ksg.po.virtual.world.Classes.World;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public abstract class Organism {
    private final int INITIATIVE;
    private final ImageIcon ORGANISM_ICON;
    protected World WORLD;

    private int power;
    private boolean alive;
    protected Position position;

    public Organism(int initiative, ImageIcon organismIcon, int power, Position position, World world) {
        this.INITIATIVE = initiative;
        this.ORGANISM_ICON = organismIcon;
        this.power = power;
        this.alive = true;
        this.position = position;
        this.WORLD = world;
    }

    public Organism(int initiative, ImageIcon organismIcon, int power, int x, int y, World world) {
        this.INITIATIVE = initiative;
        this.ORGANISM_ICON = organismIcon;
        this.power = power;
        this.alive = true;
        this.position = new Position(x, y);
        this.WORLD = world;
    }

    public void setWORLD(World WORLD) {
        this.WORLD = WORLD;
    }

    public int getINITIATIVE() {
        return INITIATIVE;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public World getWORLD() {
        return WORLD;
    }

    public ImageIcon getORGANISM_ICON() {
        return ORGANISM_ICON;
    }

    public void kill(){
        this.alive=false;
        WORLD.addKilled(this);
    }

    public void move(int x, int y) {
        this.position.move(x, y);
    }

    public void move(Position position) {
        this.position.move(position.getX(), position.getY());
    }

    public Position randomMove() {
        Random random = new Random();
        int x, y;
        do {
            x = random.nextInt(3) - 2;
            y = random.nextInt(3) - 2;
        }
        while (x == 0 && y == 0);

        Position vector = new Position(x, y);
        return vector;
    }

    public void correctMove(Position move, Position worldSize, int actualX, int actualY){
        if (actualX == 0 && randomMove().getX() < 0) {
            move.setX(1);
        } else if (actualX == worldSize.getY() - 1 && randomMove().getX() > 0) {
            move.setX(-1);
        }
        if (actualY == 0 && randomMove().getY() < 0) {
            move.setY(1);
        } else if (actualY == worldSize.getX() - 1 && randomMove().getY() > 0) {
            move.setY(-1);
        }
    }

    abstract public void newOrganism(Position position);

    abstract public void action();

    abstract public void collision(Organism aggressiveOrganism, int organismX,int organismY, Position move);

    abstract public boolean checkSpecies(Organism organism);

    abstract public void draw();

    abstract public Position breedPosition();
}
