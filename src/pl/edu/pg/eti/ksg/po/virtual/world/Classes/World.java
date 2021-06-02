package pl.edu.pg.eti.ksg.po.virtual.world.Classes;

import pl.edu.pg.eti.ksg.po.virtual.world.Interfaces.Organism;

import java.util.ArrayList;

public class World {
    private ArrayList<Organism> organisms;
    private ArrayList<Organism> newOrganisms;
    private ArrayList<Organism> deadOrganisms;
    private Position mapSize;
    private ArrayList<ArrayList<Organism>> map;

    private ArrayList clearArray(ArrayList tmpList) {
        tmpList.stream().forEach((listItem) -> {
            listItem = null;
        });
        return tmpList;
    }

    public World(int x, int y, ArrayList<Organism> organisms) {
        this.organisms = organisms;
        this.mapSize = new Position(x, y);
        this.newOrganisms = new ArrayList<Organism>();
        this.deadOrganisms = new ArrayList<Organism>();
        this.map = new ArrayList<ArrayList<Organism>>();
        //this.map.get() = new ArrayList<Organism>(3);
        for(int i=0; i<y; i++){
            this.map.add(new ArrayList<Organism>());
            for(int j=0;j<x;j++){
                this.map.get(i).add(null);
            }
        }
        //this.map = new ArrayList<ArrayList<Organism>>(y);
        /*
        this.map.forEach((element) -> element = new ArrayList<Organism>(x));
        this.map.forEach(element -> {
            element = this.clearArray(element);
            System.out.println("xd");
        });
        */
        this.newOrganisms.clear();
        this.deadOrganisms.clear();
        placeOnMap();
    }

    public void addOrganisms(){
        for(Organism organism: newOrganisms){
            organisms.add(organism);
        }
        newOrganisms.clear();
    }

    public void removeOrganisms(){
        for(Organism organism: deadOrganisms){
            organisms.remove(organism);
        }
        deadOrganisms.clear();
    }

    public void placeOnMap() {
        this.organisms.forEach(organism -> {
            organism.setWORLD(this);
            int xPosition = organism.getPosition().getX();
            int yPosition = organism.getPosition().getY();
            this.map.get(yPosition).set(xPosition, organism);
        });
    }

    public void makeTurn() {
        for(Organism organism: organisms){
            if (organism.isAlive()) {
                organism.action();
                if (organism.isAlive()) {

                    int x = organism.getPosition().getX();
                    int y = organism.getPosition().getY();
                    System.out.println(x);
                    System.out.println(y);
                    this.map.get(y).set(x, organism);


                    //placeOrganism(organism);
                }
            }
        }
        /*
        this.organisms.forEach(organism -> {
            if (organism.isAlive()) {
                organism.action();
                if (organism.isAlive()) {
                    int x = organism.getPosition().getX();
                    int y = organism.getPosition().getY();
                    System.out.println(x);
                    System.out.println(y);
                    this.map.get(y).set(x, organism);
                }
            }
        });*/
    }

    public void organiseQueue(){
        this.deadOrganisms.forEach(organism -> {
            this.organisms.remove(organism);
            this.deadOrganisms.remove(organism);
        });
        this.newOrganisms.forEach(organism -> {
            this.organisms.add(organism);
            this.newOrganisms.remove(organism);
        });
        this.sortOrganisms();
    }

    public ArrayList<ArrayList<Organism>> getMap() {
        return map;
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

    public void setMap(ArrayList<ArrayList<Organism>> map) {
        this.map = map;
    }

    public void sortOrganisms() {
        ArrayList<Organism> tmpOrganisms = new ArrayList<Organism>();
        for (int i = 7; i >= 0; i--) {
            int x = i;
            organisms.forEach((element) -> {
                if (element.getINITIATIVE() == x) {
                    tmpOrganisms.add(element);
                }
            });
        }
        organisms = tmpOrganisms;
    }

    public void addKilled(Organism organism) {
        deadOrganisms.add(organism);
    }

    public Organism getOrganism(int x, int y){
        return map.get(y).get(x);
    }

    public void erasePosition(int x, int y){
        this.map.get(y).set(x, null);
    }

    public void erasePosition(Position position){
        this.map.get(position.getY()).set(position.getX(), null);
    }

    public void addNew(Organism organism) {
        newOrganisms.add(organism);
        this.placeOrganism(organism);
    }

    public void placeOrganism(Organism organism){
        int x = organism.getPosition().getX();
        int y = organism.getPosition().getY();
        this.map.get(y).set(x, organism);
    }
}
