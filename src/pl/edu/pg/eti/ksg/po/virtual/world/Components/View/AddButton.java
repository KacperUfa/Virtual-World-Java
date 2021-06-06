package pl.edu.pg.eti.ksg.po.virtual.world.Components.View;

import pl.edu.pg.eti.ksg.po.virtual.world.Interfaces.Organism;

import javax.swing.*;

/*
Button designed for adding panel
 */

public class AddButton extends JButton {
    private Organism organism;

    public AddButton(Organism organismTmp){
        super(ViewManager.scaleIcon(organismTmp.getORGANISM_ICON(), 100, 100));
        this.setSize(100,100);
        this.organism = organismTmp;
    }

    public Organism getOrganism() {
        return organism;
    }

    public void setOrganism(Organism organism) {
        this.organism = organism;
    }
}
