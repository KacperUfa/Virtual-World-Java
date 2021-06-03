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
        x = random.nextInt(3) - 1;
        y = random.nextInt(3) - 1;
        while (x == 0 && y == 0){
            x = random.nextInt(3) - 1;
            y = random.nextInt(3) - 1;
        }

        return new Position(x, y);
    }

    public void correctMove(Position move, Position worldSize, int actualX, int actualY){
        if (actualX == 0 && move.getX() == -1) {
            move.setX(1);
        } else if (actualX == worldSize.getX() - 1 && move.getX() ==1) {
            move.setX(-1);
        }
        if (actualY == 0 && move.getY() ==-1) {
            move.setY(1);
        } else if (actualY == worldSize.getY() - 1 && move.getY() ==1) {
            move.setY(-1);
        }
    }

    public Position breedPosition(){
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
                if(this.getWORLD().getOrganism(actualX+i,actualY+j)==null){
                    Position newPosition = new Position(actualX+i,actualY+j);
                    return newPosition;
                }
            }
        }
        return null;
    };

    public boolean checkSpecies(Organism organism){
        if(organism.getClass()==this.getClass()){
            return true;
        }
        return false;
    }

    abstract public void newOrganism(Position position);

    abstract public void action();

    abstract public void collision(Organism aggressiveOrganism, int organismX,int organismY, Position move);

    abstract public void draw();
}
