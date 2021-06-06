package pl.edu.pg.eti.ksg.po.virtual.world.Classes;

import pl.edu.pg.eti.ksg.po.virtual.world.Interfaces.Organism;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*
Class that gathers everything, the heart and brain of the project, every organism is gathered here and placed on map
 */

public class World {
    private ArrayList<Organism> organisms;
    private ArrayList<Organism> newOrganisms;
    private ArrayList<Organism> deadOrganisms;
    private Position mapSize;
    private ArrayList<ArrayList<Organism>> map;
    private final StringBuilder logBuilder;

    public World(int x, int y, ArrayList<Organism> organisms) {
        this.logBuilder = new StringBuilder("");
        this.organisms = organisms;
        this.mapSize = new Position(x, y);
        this.newOrganisms = new ArrayList<Organism>();
        this.deadOrganisms = new ArrayList<Organism>();
        this.map = new ArrayList<ArrayList<Organism>>();
        for (int i = 0; i < y; i++) {
            this.map.add(new ArrayList<Organism>());
            for (int j = 0; j < x; j++) {
                this.map.get(i).add(null);
            }
        }
        this.newOrganisms.clear();
        this.deadOrganisms.clear();
        this.sortOrganisms();
        placeOnMap();
    }

    public StringBuilder getLogBuilder() {
        return logBuilder;
    }

    //adding organism to queue that was freshly born
    public void addOrganisms() {
        for (Organism organism : newOrganisms) {
            organisms.add(organism);
        }
        newOrganisms.clear();
    }

    //removing dead organisms from queue
    public void removeOrganisms() {
        for (Organism organism : deadOrganisms) {
            organisms.remove(organism);
        }
        deadOrganisms.clear();
    }

    //placing every organism from queue to it's coordinates
    public void placeOnMap() {
        this.organisms.forEach(organism -> {
            organism.setWORLD(this);
            int xPosition = organism.getPosition().getX();
            int yPosition = organism.getPosition().getY();
            this.map.get(yPosition).set(xPosition, organism);
        });
    }

    //making turn in simulation is making action by every organism in queue and then organising queue for next turn
    public void makeTurn() {
        for (Organism organism : organisms) {
            if (organism.isAlive()) {
                organism.action();
                if (organism.isAlive()) {
                    placeOrganism(organism);
                }
            }
        }
        addOrganisms();
        removeOrganisms();
        sortOrganisms();
        sortOrganisms();
    }

    public ArrayList<ArrayList<Organism>> getMap() {
        return map;
    }

    public void setMap(ArrayList<ArrayList<Organism>> map) {
        this.map = map;
    }

    public ArrayList<Organism> getOrganisms() {
        return organisms;
    }

    public void setOrganisms(ArrayList<Organism> organisms) {
        this.organisms = organisms;
    }

    public ArrayList<Organism> getNewOrganisms() {
        return newOrganisms;
    }

    public void setNewOrganisms(ArrayList<Organism> newOrganisms) {
        this.newOrganisms = newOrganisms;
    }

    public ArrayList<Organism> getDeadOrganisms() {
        return deadOrganisms;
    }

    public void setDeadOrganisms(ArrayList<Organism> deadOrganisms) {
        this.deadOrganisms = deadOrganisms;
    }

    public Position getMapSize() {
        return mapSize;
    }

    public void setMapSize(Position mapSize) {
        this.mapSize = mapSize;
    }

    //Sorting all organisms in que by their initiative
    public void sortOrganisms() {
        Comparator x = Comparator.comparing(Organism::getINITIATIVE);
        organisms.sort(x);
        Collections.reverse(organisms);
    }

    //adding dead organism to list of dead organisms
    public void addKilled(Organism organism) {
        deadOrganisms.add(organism);
    }

    public Organism getOrganism(int x, int y) {
        return map.get(y).get(x);
    }

    public void erasePosition(int x, int y) {
        this.map.get(y).set(x, null);
    }

    public void erasePosition(Position position) {
        this.map.get(position.getY()).set(position.getX(), null);
    }

    //adding newborn organism to list with newborns and placing it on the map
    public void addNew(Organism organism) {
        newOrganisms.add(organism);
        this.placeOrganism(organism);
    }

    //place organism on the map
    public void placeOrganism(Organism organism) {
        int x = organism.getPosition().getX();
        int y = organism.getPosition().getY();
        this.map.get(y).set(x, organism);
    }
}
