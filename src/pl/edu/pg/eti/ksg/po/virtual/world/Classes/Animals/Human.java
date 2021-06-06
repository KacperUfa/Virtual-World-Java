package pl.edu.pg.eti.ksg.po.virtual.world.Classes.Animals;
import pl.edu.pg.eti.ksg.po.virtual.world.Classes.Position;
import pl.edu.pg.eti.ksg.po.virtual.world.Classes.World;
import pl.edu.pg.eti.ksg.po.virtual.world.Interfaces.Organism;
import javax.swing.*;

/*
Special extension of Animal class, there is only one human in world and if it is alive user make him move
in the chosen direction or activate special ability, which is getting power boost
 */

public class Human extends Animal{
    private int countSpecial;
    private boolean ableToActivate;
    private Position move;
    private static Object lock = new Object();

    public Human(Position position, World world) {
        super(4, new ImageIcon("resources/Images/human.png"), 5, position, world);
        this.ableToActivate=true;
        this.countSpecial=0;
        this.move = new Position(0,0);
    }

    public Human(int x, int y, World world) {
        super(4, new ImageIcon("resources/Images/human.png"), 5, x, y, world);
        this.ableToActivate=true;
        this.countSpecial=0;
    }

    public Position getMove() {
        return move;
    }

    public void setMove(Position move) {
        this.move = move;
    }

    public int getCountSpecial() {
        return countSpecial;
    }

    public boolean isAbleToActivate() {
        return ableToActivate;
    }

    public void setCountSpecial(int countSpecial) {
        this.countSpecial = countSpecial;
    }

    public void setCanActivate(boolean canActivate) {
        this.ableToActivate = canActivate;
    }

    //implementing action method in a way that move is not random and make operations connected with it's
    //special ability
    @Override
    public void action(){
        if(!this.isAbleToActivate()){
            this.countSpecial=this.countSpecial-1;
            if(this.countSpecial==0){
                this.setCanActivate(true);
            }
            else if(this.countSpecial>4){
                this.setPower(this.getPower()-1);
            }
        }


        if(!(this.move.getX()==0 && this.move.getY()==0)){
            int actualX = this.getPosition().getX();
            int actualY = this.getPosition().getY();
            int xAction = actualX+this.move.getX();
            int yAction = actualY+this.move.getY();
            Organism tmpOrganism = this.WORLD.getOrganism(xAction, yAction);
            if(tmpOrganism==null){
                this.move(move.getX(), move.getY());
                this.WORLD.erasePosition(actualX,actualY);
                String log = this.getClass().getSimpleName() + "s move\n";
                this.WORLD.getLogBuilder().append(log);
            }
            else{
                tmpOrganism.collision(this, actualX, actualY, move);
            }
        }
        else{
            this.setPower(this.getPower()+5);
            this.countSpecial=10;
            this.setCanActivate(false);
            String log = this.getClass().getSimpleName() + "s used super power\n";
            this.WORLD.getLogBuilder().append(log);
        }

    }

    @Override
    public void newOrganism(Position position) {
        Human human = new Human(position, this.WORLD);
        this.WORLD.addNew(human);
    }
}
