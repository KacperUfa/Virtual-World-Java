package pl.edu.pg.eti.ksg.po.virtual.world.Components.View;

import pl.edu.pg.eti.ksg.po.virtual.world.Interfaces.Organizm;

import javax.swing.*;
import java.awt.*;

public class OrganismButton extends JButton {
    Organizm organizm;


    public OrganismButton(Organizm organizm) {
        this.organizm = organizm;
    }

    public OrganismButton() {
        super();
    }

    public OrganismButton(String text, Organizm organizm) {
        super(text);
        this.organizm = organizm;
    }

    public OrganismButton(Icon icon) {
        super(icon);
    }

    public OrganismButton(String text) {
        super(text);
    }

    public Organizm getOrganism() {
        return organizm;
    }

    public void setOrganism(Organizm organizm) {
        this.organizm = organizm;
    }
}
