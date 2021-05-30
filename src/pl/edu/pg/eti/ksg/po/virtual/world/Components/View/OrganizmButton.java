package pl.edu.pg.eti.ksg.po.virtual.world.Components.View;

import pl.edu.pg.eti.ksg.po.virtual.world.Interfaces.Organizm;

import javax.swing.*;
import java.awt.*;

public class OrganizmButton extends JButton {
    Organizm organizm;


    public OrganizmButton(Organizm organizm) {
        this.organizm = organizm;
    }

    public OrganizmButton(String text, Organizm organizm) {
        super(text);
        this.organizm = organizm;
        this.setBackground(Color.BLACK);
        this.setForeground(Color.RED);
    }

    public OrganizmButton(String text) {
        super(text);
    }

    public Organizm getOrganizm() {
        return organizm;
    }

    public void setOrganizm(Organizm organizm) {
        this.organizm = organizm;
    }
}
