package pl.edu.pg.eti.ksg.po.virtual.world.Components.View;

import pl.edu.pg.eti.ksg.po.virtual.world.Classes.Animals.Human;
import pl.edu.pg.eti.ksg.po.virtual.world.Classes.GenerateWorld;
import pl.edu.pg.eti.ksg.po.virtual.world.Classes.SaveLoad;
import pl.edu.pg.eti.ksg.po.virtual.world.Classes.World;
import pl.edu.pg.eti.ksg.po.virtual.world.Interfaces.Organism;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

public class StartManager implements ActionListener {
    private final JFrame jframe;
    private JPanel panel;
    private JPanel textPanel;
    private JTextField xField;
    private JTextField yField;

    public StartManager() {
        this.jframe = new JFrame("Start panel");
        jframe.setSize(300,180);
        this.jframe.setLocationRelativeTo(null);
        this.panel = new JPanel();
        this.panel.setBounds(0,20,300,50);
        this.textPanel = new JPanel();
        this.textPanel.setBounds(0,90,300,50);
        JButton newWorld = new JButton("New World");
        newWorld.addActionListener(this);
        newWorld.setActionCommand("newWorld");

        JButton loadWorld = new JButton("Load World");
        loadWorld.addActionListener(this);
        loadWorld.setActionCommand("loadWorld");

        File tempFile = new File("gameSave/save.txt");
        boolean exists = tempFile.exists();
        if(!exists){
            loadWorld.setEnabled(false);
        }

        this.xField = new JTextField(5);
        this.yField = new JTextField(5);
        JLabel xLabel = new JLabel("X:");
        JLabel yLabel = new JLabel("Y:");
        panel.add(newWorld);
        panel.add(loadWorld);
        textPanel.add(xLabel);
        textPanel.add(xField);
        textPanel.add(yLabel);
        textPanel.add(yField);

        jframe.add(panel);
        jframe.add(textPanel);
        jframe.setLayout(null);
        jframe.setResizable(false);
        jframe.setVisible(true);
    }

    public static boolean isInteger(String s, int radix) {
        if(s.isEmpty()) return false;
        for(int i = 0; i < s.length(); i++) {
            if(i == 0 && s.charAt(i) == '-') {
                if(s.length() == 1) return false;
                else continue;
            }
            if(Character.digit(s.charAt(i),radix) < 0) return false;
        }
        return true;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("newWorld")) {
            String xString = xField.getText();
            String yString = yField.getText();
            if(isInteger(xString, 10) && isInteger(yString,10)){
                int actualX = Integer.parseInt(xString);
                int actualY = Integer.parseInt(yString);
                if(actualX>0 && actualY>0){
                    //System.out.println("Sukces");

                    GenerateWorld generateWorld = new GenerateWorld(actualX,actualY);
                    ArrayList<Organism> organisms;
                    World world = generateWorld.createWorld();
                    Human human2 = null;
                    organisms = world.getOrganisms();
                    for(Organism organism:organisms){
                        if(organism.getClass().getSimpleName().equals("Human")){
                            human2 = (Human) organism;
                            break;
                        }
                    }
                    Human human;
                    if(human2==null){
                        human= new Human(0,0,world);
                        human.setAlive(false);
                    }
                    else{
                        human = human2;
                    }

                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            String appTitle = "Virtual World - Kacper ufa 184501";
                            new ViewManager(appTitle, actualY , actualX, world, human);
                        }
                    });
                    jframe.dispose();
                }
            }
        }
        else if (e.getActionCommand().equals("loadWorld")) {
            ArrayList<Organism> organisms;
            Human human2 = null;
            SaveLoad load = new SaveLoad();
            World world = load.load();
            organisms = world.getOrganisms();
            for(Organism organism:organisms){
                if(organism.getClass().getSimpleName().equals("Human")){
                    human2 = (Human) organism;
                    break;
                }
            }
            Human human;
            if(human2==null){
                human= new Human(0,0,world);
                human.setAlive(false);
            }
            else{
                human = human2;
            }

            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    String appTitle = "Virtual World - Kacper ufa 184501";
                    int actualX = world.getMapSize().getX();
                    int actualY = world.getMapSize().getY();
                    new ViewManager(appTitle, actualY, actualX, world, human);
                }
            });
            jframe.dispose();
        }
    }
}
