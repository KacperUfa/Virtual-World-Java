package pl.edu.pg.eti.ksg.po.virtual.world.Classes.Animals;

import pl.edu.pg.eti.ksg.po.virtual.world.Classes.Position;
import pl.edu.pg.eti.ksg.po.virtual.world.Classes.World;
import pl.edu.pg.eti.ksg.po.virtual.world.Interfaces.Organism;

import javax.swing.*;

public class CyberSheep extends Animal {
    public CyberSheep(Position position, World world) {
        super(4, new ImageIcon("resources/Images/cyberSheep.png"), 11, position, world);
    }

    public CyberSheep(int x, int y, World world) {
        super(4, new ImageIcon("resources/Images/cyberSheep.png"), 11, x, y, world);
    }

    public Position setMove(Position move, int i, int j) {
        if (this.position.getY() > i) {
            move.setY(-1);
        } else if (this.position.getY() < i) {
            move.setY(1);
        }
        else{
            move.setY(0);
        }
        if (this.position.getX() > j) {
            move.setX(-1);
        } else if (this.position.getX() < j) {
            move.setX(1);
        }
        else{
            move.setX(0);
        }

        return move;
    }

    public Position findWeed() {
        int x = 0;
        int y = 0;
        int xVec =0;
        int yVec=0;
        int sum = 0;
        Position move = new Position(0, 0);
        for (int i = 0; i < this.WORLD.getMapSize().getX(); i++) {
            for (int j = 0; j < this.WORLD.getMapSize().getY(); j++) {

                //hogweed
                Organism organism = this.WORLD.getOrganism(i, j);
                if(organism!=null){
                    Class c = organism.getClass();
                    if (c.getSimpleName().equals("Parnsip")) {
                        int tmpX = Math.abs(this.position.getX() - i);
                        int tmpY = Math.abs(this.position.getY() - j);
                        if (!(xVec == 0 && yVec == 0)) {
                            int tmpSum = tmpX + tmpY;
                            if (sum > tmpSum) {
                                xVec=tmpX;
                                yVec=tmpY;
                                x = j;
                                y = i;
                                sum = tmpSum;
                                this.setMove(move, j, i);
                            }
                        }
                        else {
                            xVec=tmpX;
                            yVec=tmpY;


                            x = j;
                            y = i;
                            sum = tmpX + tmpY;

                            this.setMove(move, j, i);
                        }
                    }
                }

            }
        }
        //this.setMove(move, x, y);
        return move;
    }

    public Position findWeedPosition() {
        int x = 0;
        int y = 0;
        int xVec =0;
        int yVec=0;
        int sum = 0;
        for (int i = 0; i < this.WORLD.getMapSize().getX(); i++) {
            for (int j = 0; j < this.WORLD.getMapSize().getY(); j++) {

                //hogweed
                Organism organism = this.WORLD.getOrganism(i, j);
                if(organism!=null){
                    Class c = organism.getClass();
                    if (c.getSimpleName().equals("Parnsip")) {
                        int tmpX = Math.abs(this.position.getX() - i);
                        int tmpY = Math.abs(this.position.getY() - j);
                        if (!(sum==0)) {
                            int tmpSum = tmpX + tmpY;
                            if (sum > tmpSum) {
                                x = i;
                                y = j;
                                sum = tmpSum;
                            }
                        }
                        else {
                            x = i;
                            y = j;
                            sum = tmpX + tmpY;

                        }
                    }
                }

            }
        }
        return new Position(x,y);
    }

    @Override
    public void action(){
        System.out.println(this.getClass().getSimpleName());
        Position move=this.findWeed();
        if(move.getX()==0 && move.getY()==0){
            super.action();
        }
        else{
            int actualX = this.position.getX();
            int actualY = this.position.getY();
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
    }

    @Override
    public void collision(Organism aggressiveOrganism, int organismX,int organismY, Position move){
        Position moveTMP=this.findWeed();
        if(moveTMP.getX()==0 && moveTMP.getY()==0){
            super.collision(aggressiveOrganism,organismX,organismY,move);
        }
        else{
            Position parnsipPosition = this.findWeedPosition();
            this.WORLD.getOrganism(parnsipPosition.getX(), parnsipPosition.getY()).kill();
            this.WORLD.erasePosition(parnsipPosition.getX(),parnsipPosition.getY());
            int xTmp = this.position.getX();
            int yTmp = this.position.getY();
            this.setPosition(parnsipPosition);
            this.WORLD.placeOrganism(this);
            this.WORLD.erasePosition(xTmp,yTmp);
            aggressiveOrganism.move(move);
            aggressiveOrganism.getWORLD().erasePosition(organismX,organismY);
        }
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
