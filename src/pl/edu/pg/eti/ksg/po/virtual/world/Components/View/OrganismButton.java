package pl.edu.pg.eti.ksg.po.virtual.world.Components.View;

import pl.edu.pg.eti.ksg.po.virtual.world.Classes.Position;
import pl.edu.pg.eti.ksg.po.virtual.world.Interfaces.Organism;

import javax.swing.*;

/*
Button used for organism in viewmanager map
 */

public class OrganismButton extends JButton {
    Organism organism;
    Position position;

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
        this.organism = null;
    }

    public OrganismButton(Organism organism) {
        this.organism = organism;
    }

    public OrganismButton(Position position) {
        super();
        this.position = position;
    }

    public OrganismButton(String text, Organism organism) {
        super(text);
        this.organism = organism;
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

    public void setOrganism(Organism organism) {
        this.organism = organism;
    }

    public ImageIcon getOrganismIcon() {
        if(this.organism != null)
            return this.organism.getORGANISM_ICON();
        return new ImageIcon("resources/Images/fox.png");
    }
}