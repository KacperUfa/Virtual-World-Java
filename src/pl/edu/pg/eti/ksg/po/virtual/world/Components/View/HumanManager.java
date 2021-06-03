package pl.edu.pg.eti.ksg.po.virtual.world.Components.View;

import pl.edu.pg.eti.ksg.po.virtual.world.Classes.Animals.Human;
import pl.edu.pg.eti.ksg.po.virtual.world.Classes.Position;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HumanManager implements ActionListener {
    private final JFrame jframe;
    private JPanel upKeyPanel;
    private JPanel midKeyPanel;
    private JPanel downKeyPanel;
    private Human human;
    private ViewManager viewManager;

    public HumanManager(Human human, ViewManager viewManager){
        this.human=human;
        this.viewManager=viewManager;
        jframe = new JFrame("Human move");
        upKeyPanel = new JPanel();
        midKeyPanel = new JPanel();
        downKeyPanel = new JPanel();
        jframe.setSize(600, 450);
        upKeyPanel.setBounds(20, 20, 560, 100);
        midKeyPanel.setBounds(20, 140, 560, 100);
        downKeyPanel.setBounds(20, 260, 560, 100);
        HumanButton upButton= new HumanButton(0,-1,new ImageIcon("resources/Images/arrowUp.png"));
        HumanButton downButton= new HumanButton(0,1,new ImageIcon("resources/Images/arrowDown.png"));
        HumanButton leftButton= new HumanButton(-1,0,new ImageIcon("resources/Images/arrowLeft.png"));
        HumanButton rightButton= new HumanButton(1,0,new ImageIcon("resources/Images/arrowRight.png"));
        HumanButton superPowerButton = new HumanButton(0,0,new ImageIcon("resources/Images/superPower.png"));
        if(!(this.human.isAbleToActivate())){
            superPowerButton.setEnabled(false);
        }
        if(this.human.getPosition().getY()==0){
            upButton.setEnabled(false);
        }
        if(this.human.getPosition().getY()== this.human.getWORLD().getMapSize().getY() - 1){
            downButton.setEnabled(false);
        }
        if(this.human.getPosition().getX()==0){
            leftButton.setEnabled(false);
        }
        if(this.human.getPosition().getX()== this.human.getWORLD().getMapSize().getX() - 1){
            rightButton.setEnabled(false);
        }

        upButton.addActionListener(this);
        downButton.addActionListener(this);
        rightButton.addActionListener(this);
        leftButton.addActionListener(this);
        superPowerButton.addActionListener(this);

        upKeyPanel.add(upButton);
        midKeyPanel.add(leftButton);
        midKeyPanel.add(downButton);
        midKeyPanel.add(rightButton);
        downKeyPanel.add(superPowerButton);

        jframe.add(upKeyPanel);
        jframe.add(midKeyPanel);
        jframe.add(downKeyPanel);
        jframe.setLayout(null);
        jframe.setResizable(false);
        jframe.setVisible(true);
    }

    public JFrame getJframe() {
        return jframe;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        HumanButton humanButton = (HumanButton) e.getSource();
        int xButton = humanButton.getXx();
        int yButton = humanButton.getYy();
        human.setMove(new Position(xButton,yButton));
        human.getWORLD().makeTurn();
        viewManager.updateCanvas();
        jframe.dispose();
    }
}
