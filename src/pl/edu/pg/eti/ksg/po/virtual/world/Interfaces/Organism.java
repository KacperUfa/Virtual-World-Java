package pl.edu.pg.eti.ksg.po.virtual.world.Interfaces;

import pl.edu.pg.eti.ksg.po.virtual.world.Classes.Position;
import pl.edu.pg.eti.ksg.po.virtual.world.Classes.World;

import javax.swing.*;
import java.awt.*;

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

    abstract public void newOrganism(Position position);

    abstract public void action();

    abstract public void collision(Organism aggressiveOrganism, int organismX,int organismY, Position move);

    abstract public boolean checkSpecies(Organism organism);

    abstract public void draw();

    abstract public Position breedPosition();
}
