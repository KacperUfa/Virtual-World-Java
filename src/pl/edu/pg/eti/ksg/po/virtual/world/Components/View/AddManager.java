package pl.edu.pg.eti.ksg.po.virtual.world.Components.View;

import pl.edu.pg.eti.ksg.po.virtual.world.Classes.Animals.*;
import pl.edu.pg.eti.ksg.po.virtual.world.Classes.Plants.*;
import pl.edu.pg.eti.ksg.po.virtual.world.Classes.Position;
import pl.edu.pg.eti.ksg.po.virtual.world.Classes.World;
import pl.edu.pg.eti.ksg.po.virtual.world.Interfaces.Organism;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/*
Window that appears when you add new organism by clicking
 */

public class AddManager implements ActionListener {
    private final JFrame jframe;
    private JPanel animalPanel;
    private JPanel plantPanel;
    private int x;
    private int y;
    private World world;
    private Organism selectedOrganism;
    private ViewManager view;

    public AddManager(int x, int y, World world, ViewManager view){
        this.world = world;
        this.jframe = new JFrame("Add Organism");
        jframe.setSize(1000, 400);
        this.jframe.setLocationRelativeTo(null);
        animalPanel = new JPanel();
        plantPanel = new JPanel();
        animalPanel.setBounds(20, 20, 960, 170);
        plantPanel.setBounds(20, 210, 960, 170);
        this.x=x;
        this.y=y;
        this.view=view;

        ArrayList<AddButton> animalArray= new ArrayList<>();
        AddButton antelopeButton = new AddButton(new Antelope(0, 0, null));
        AddButton foxButton = new AddButton(new Fox(0, 0, null));
        AddButton sheepButton = new AddButton(new Sheep(0, 0, null));
        AddButton wolfButton = new AddButton(new Wolf(0, 0, null));
        AddButton turtleButton = new AddButton(new Turtle(0, 0, null));
        AddButton cyberSheepButton = new AddButton(new CyberSheep(0, 0, null));
        animalArray.add(antelopeButton);
        animalArray.add(foxButton);
        animalArray.add(sheepButton);
        animalArray.add(wolfButton);
        animalArray.add(turtleButton);
        animalArray.add(cyberSheepButton);
        //plants
        ArrayList<AddButton> plantArray= new ArrayList<>();
        AddButton dandelionButton = new AddButton(new Dandelion(0, 0, null));
        AddButton grassButton = new AddButton(new Grass(0, 0, null));
        AddButton guaranaButton = new AddButton(new Guarana(0, 0, null));
        AddButton nigshtshadeButton = new AddButton(new NightShade(0, 0, null));
        AddButton parnsipButton = new AddButton(new Parnsip(0, 0, null));
        plantArray.add(dandelionButton);
        plantArray.add(grassButton);
        plantArray.add(guaranaButton);
        plantArray.add(nigshtshadeButton);
        plantArray.add(parnsipButton);

        for(AddButton button:animalArray){
            animalPanel.add(button);
            button.addActionListener(this);
        }
        for(AddButton button:plantArray){
            plantPanel.add(button);
            button.addActionListener(this);
        }

        jframe.add(animalPanel);
        jframe.add(plantPanel);
        jframe.setLayout(null);
        jframe.setResizable(false);
        jframe.setVisible(true);

    }

    //when you click button it gets the organism it was holding inside and creates a new object of this organism
    @Override
    public void actionPerformed(ActionEvent e) {
        AddButton butOrganism = (AddButton) e.getSource();
        System.out.println(butOrganism.getOrganism().getClass().getSimpleName());
        super.getClass().getSimpleName();
        Organism newOrganism = butOrganism.getOrganism();
         newOrganism.setPosition(new Position(x,y));
         newOrganism.setWORLD(this.world);
        this.world.addNew(newOrganism);
        this.world.addOrganisms();
        view.updateCanvas();
        jframe.dispose();
    }
}
