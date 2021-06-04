package pl.edu.pg.eti.ksg.po.virtual.world.Classes;

import pl.edu.pg.eti.ksg.po.virtual.world.Interfaces.Organism;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

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
        for(int i=0; i<y; i++){
            this.map.add(new ArrayList<Organism>());
            for(int j=0;j<x;j++){
                this.map.get(i).add(null);
            }
        }
        this.newOrganisms.clear();
        this.deadOrganisms.clear();
        this.sortOrganisms();
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
/*
                    int x = organism.getPosition().getX();
                    int y = organism.getPosition().getY();
                    this.map.get(y).set(x, organism);
*/
                    placeOrganism(organism);
                }
            }
        }

        addOrganisms();
        removeOrganisms();
        sortOrganisms();
        sortOrganisms();
        SaveLoad save = new SaveLoad();
        try {
            save.save(this.organisms, this);
        }
        catch (IOException e){

        }

    }

    public void organiseQueue(){
        addOrganisms();
        removeOrganisms();
        sortOrganisms();
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
            /*
            for(Organism organism:organisms){
                if (organism.getINITIATIVE() == i) {
                    if(organism.isAlive()){
                        tmpOrganisms.add(organism);
                    }

                }
            }
            /*
            organisms.forEach((element) -> {
                if (element.getINITIATIVE() == x) {
                    tmpOrganisms.add(element);
                }
            });*/
        }
        //setOrganisms(tmpOrganisms);
        Comparator x= Comparator.comparing(Organism::getINITIATIVE);
        organisms.sort(x);
        Collections.reverse(organisms);
        //Arrays.sort(this.organisms, Collections.reverseOrder());
        //Arrays.sort(organisms, );

        //sort(T[] a, Comparator<? super T> c)

        //Arrays.sort(a, Collections.reverseOrder());
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
