package pl.edu.pg.eti.ksg.po.virtual.world.Components.View;

import pl.edu.pg.eti.ksg.po.virtual.world.Interfaces.Organism;

import javax.swing.*;
import java.awt.*;

public class OrganismButton extends JButton {
    Organism organism;


    public OrganismButton(Organism organizm) {
        this.organism = organizm;
    }

    public OrganismButton() {
        super();
    }

    public OrganismButton(String text, Organism organizm) {
        super(text);
        this.organism = organizm;
    }

    public OrganismButton(Icon icon) {
        super(icon);
    }

    public OrganismButton(String text) {
        super(text);
    }

    public Organism getOrganism() {
        return organism;
    }

    public void setOrganism(Organism organizm) {
        this.organism = organizm;
    }
}