package pl.edu.pg.eti.ksg.po.virtual.world.Components.View;

import pl.edu.pg.eti.ksg.po.virtual.world.Interfaces.Organism;

import javax.swing.*;

/*
Button designed for humanManager
 */

public class HumanButton extends JButton {
    int x;
    int y;
    public HumanButton(int x, int y, ImageIcon icon){
        super(ViewManager.scaleIcon(icon, 90, 90));
        this.setSize(100,100);
        this.x=x;
        this.y=y;
    }

    public int getXx() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getYy() {
        return y;
    }

    public void setYy(int y) {
        this.y = y;
    }
}
