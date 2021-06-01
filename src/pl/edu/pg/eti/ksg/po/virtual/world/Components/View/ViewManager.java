package pl.edu.pg.eti.ksg.po.virtual.world.Components.View;

import pl.edu.pg.eti.ksg.po.virtual.world.Classes.Position;
import pl.edu.pg.eti.ksg.po.virtual.world.Interfaces.Organism;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.stream.Collectors;

public class ViewManager {
    private final JFrame frame;
    private JPanel buttonsPanel;

    public ViewManager(String windowTitle, int sizeX, int sizeY, Organism organism) {
        this.frame = new JFrame(windowTitle);
        this.frame.setSize(1000, 1000);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setResizable(false);
        this.frame.setLocationRelativeTo(null);
        createPanelWithButtons(sizeX, sizeY);
        this.frame.add(this.buttonsPanel, BorderLayout.CENTER);
        addOrganismToButton(organism);
        this.frame.setVisible(true);
        this.fillButtonsWithTheirImages();
    }

    private static ImageIcon scaleIcon(ImageIcon icon, int width, int height) {
        Image image = icon.getImage();
        image = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(image);
    }

    private void createPanelWithButtons(int sizeX, int sizeY) {
        int availableButtons = sizeX * sizeY;
        this.buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new GridLayout(sizeX, sizeY));
        for (int i = 0; i < sizeX; i++) {
            for (int j = 0; j < sizeY; j++) {
                OrganismButton button = new OrganismButton(new Position(i, j));
                buttonsPanel.add(button);
            }
        }
        buttonsPanel.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
    }

    private void fillButtonsWithTheirImages() {
        Component[] components = this.buttonsPanel.getComponents();
        /*
        TODO
          lambda bug
        java.util.Arrays.stream(components).forEach((cpt) -> {
            if(((OrganismButton) cpt).getOrganismIcon() != null) {
                ((OrganismButton) cpt).setIcon(scaleIcon((((OrganismButton) cpt).getOrganismIcon()), cpt.getSize().width, cpt.getSize().height));
            }
        });*/
        for(Component component : components){
            if(((OrganismButton) component).getOrganism() == null){
                continue;
            }
            ((OrganismButton) component).setIcon(((OrganismButton) component).getOrganismIcon());
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
}
