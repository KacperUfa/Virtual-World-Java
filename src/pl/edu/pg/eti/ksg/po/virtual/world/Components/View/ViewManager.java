package pl.edu.pg.eti.ksg.po.virtual.world.Components.View;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class ViewManager {
    private JFrame frame;

    public ViewManager(String windowTitle, int sizeX, int sizeY) {
        this.frame = new JFrame(windowTitle);
        this.frame.setSize(1000, 1000);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setResizable(false);
        this.frame.setLocationRelativeTo(null);
        JPanel panel = createPanelWithButtons(sizeX, sizeY);
        this.frame.add(panel, BorderLayout.CENTER);
        this.frame.setVisible(true);
        this.fillButtonsWithTheirImages(panel);
    }

    private JPanel createPanelWithButtons(int sizeX, int sizeY) {
        int availableButtons = sizeX * sizeY;
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(sizeX, sizeY));
        for (int i = 0; i < availableButtons; i++) {
            OrganismButton button = new OrganismButton();
            panel.add(button);
        }
        panel.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
        return panel;
    }

    private void fillButtonsWithTheirImages(JPanel panel) {
        Component[] components = panel.getComponents();
        Arrays.stream(components).forEach((cpt) -> {
            /**
             * TODO
             *  Add getIcon method to Organism class.
             * ((OrganismButton) cpt).setIcon(scaleIcon((cpt.getIcon()), cpt.getSize().width, cpt.getSize().height));
             **/
            ((OrganismButton) cpt).setIcon(scaleIcon(new ImageIcon("resources/Images/fox.png"), cpt.getSize().width, cpt.getSize().height));
        });
    }

    private static ImageIcon scaleIcon(ImageIcon icon, int width, int height) {
        Image image = icon.getImage();
        image = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(image);
    }
}
