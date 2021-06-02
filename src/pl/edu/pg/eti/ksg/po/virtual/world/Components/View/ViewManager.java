package pl.edu.pg.eti.ksg.po.virtual.world.Components.View;

import pl.edu.pg.eti.ksg.po.virtual.world.Classes.Position;
import pl.edu.pg.eti.ksg.po.virtual.world.Classes.World;
import pl.edu.pg.eti.ksg.po.virtual.world.Interfaces.Organism;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class ViewManager implements ActionListener {
    private final JFrame frame;
    private JPanel buttonsPanel;
    private JPanel otherButtons;
    private JPanel container;
    private int sizeX;
    private int sizeY;
    private World world;
    private ArrayList<Organism> organisms;

    public ViewManager(String windowTitle, int sizeX, int sizeY, World world) {
        this.world = world;
        this.organisms = this.world.getOrganisms();
        this.otherButtons = new JPanel();
        this.container = new JPanel();
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
        this.frame = new JFrame(windowTitle);
        this.frame.setSize(1000, 1000);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setResizable(false);
        this.frame.setLocationRelativeTo(null);
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        createPanelWithButtons();
        JButton makeTurn = new JButton("Make Turn");
        makeTurn.addActionListener(this);
        makeTurn.setActionCommand("makeTurn");
        this.otherButtons.add(makeTurn);
        this.otherButtons.setVisible(true);
        this.otherButtons.setVisible(true);
        this.buttonsPanel.setVisible(true);
        this.container.add(this.otherButtons);
        this.container.add(this.buttonsPanel);
        this.frame.add(this.container);
        this.frame.setVisible(true);
    }

    private static ImageIcon scaleIcon(ImageIcon icon, int width, int height) {
        Image image = icon.getImage();
        image = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(image);
    }

    private void createPanelWithButtons() {
        this.buttonsPanel = new JPanel();
        this.buttonsPanel.setLayout(new GridLayout(this.sizeX, this.sizeY));
        for (int i = 0; i < this.sizeX; i++) {
            for (int j = 0; j < this.sizeY; j++) {
                OrganismButton button = new OrganismButton(new Position(j, i));
                button.setActionCommand("addOrganism");
                button.addActionListener(this);
                this.buttonsPanel.add(button);
            }
        }
        this.buttonsPanel.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
    }

    public void fillButtonsWithTheirImages() {
        Component[] components = this.buttonsPanel.getComponents();
        for (Component component : components) {
            if (((OrganismButton) component).getOrganism() == null) {
                continue;
            }
            int width = ((OrganismButton) component).getWidth();
            int height = ((OrganismButton) component).getHeight();
            ((OrganismButton) component).setIcon(scaleIcon(((OrganismButton) component).getOrganismIcon(), width, height));
        }
    }


    public void addOrganismToButton(Organism organism) {
        OrganismButton button = findButton(organism.getPosition());
        button.setOrganism(organism);
    }

    private OrganismButton findButton(Position position) {
        Component[] components = this.buttonsPanel.getComponents();
        java.util.List<Component> listOfButton = Arrays.stream(components)
                .filter(cpt -> ((OrganismButton) cpt).getPosition().equals(position))
                .collect(Collectors.toList());
        return (OrganismButton) listOfButton.get(0);
    }

    public void addOrganismsToButtons() {
        for (Organism o : this.organisms) {
            OrganismButton button = findButton(o.getPosition());
            if (button == null)
                continue;
            button.setOrganism(o);
        }
    }

    public void refresh() {
        this.frame.setVisible(false);
        this.frame.setVisible(true);
    }

    public void clearCanvas() {
        this.frame.remove(this.container);
        this.container.remove(this.buttonsPanel);
        this.createPanelWithButtons();
        this.container.add(this.buttonsPanel);
        this.frame.add(this.container);
        this.frame.setVisible(true);
        this.container.revalidate();
        this.container.repaint();
        this.frame.revalidate();
        this.frame.repaint();
    }

    public void updateCanvas() {
        this.clearCanvas();
        this.addOrganismsToButtons();
        this.fillButtonsWithTheirImages();
        this.refresh();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("makeTurn")) {
            this.world.makeTurn();
            this.updateCanvas();
        }
        if (e.getActionCommand().equals("addOrganism")) {
            /*
            OrganismButton butOrganism = (OrganismButton) e.getSource();
            int x = butOrganism.position.getX();
            int y = butOrganism.position.getY();
            Wolf wolf = new Wolf(x, y, this.world);
            this.world.addNew(wolf);
            this.world.addOrganisms();
            this.updateCanvas();
             */
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    JFrame jframe = new JFrame();
                    jframe.setSize(200, 300);
                    JPanel jp = new JPanel();
                    jp.setLayout(new BoxLayout(jp, BoxLayout.X_AXIS));
                    JButton jb = new JButton("1");
                    JButton jb2 = new JButton("2");
                    JButton jb3 = new JButton("3");
                    JButton jb4 = new JButton("4");
                    jp.add(jb);
                    jp.add(jb2);
                    jp.add(jb3);
                    jp.add(jb4);
                    jframe.add(jp);
                    jframe.setVisible(true);

                }
            });
        }
    }
}
