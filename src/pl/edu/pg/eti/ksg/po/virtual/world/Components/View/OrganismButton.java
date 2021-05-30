package pl.edu.pg.eti.ksg.po.virtual.world.Components.View;

import pl.edu.pg.eti.ksg.po.virtual.world.Interfaces.Organism;

import javax.swing.*;
import java.awt.*;

public class OrganismButton extends JButton {
    Organism organism;


    public OrganismButton(Organism organism) {
        this.organism = organism;
    }

    public OrganismButton(String text, Organism organism) {
        super(text);
        this.organism = organism;
        this.setBackground(Color.BLACK);
        this.setForeground(Color.RED);
    }

    public OrganismButton(String text) {
        super(text);
    }

    public Organism getOrganizm() {
        return organism;
    }

    public void setOrganizm(Organism organism) {
        this.organism = organism;
    }
}
