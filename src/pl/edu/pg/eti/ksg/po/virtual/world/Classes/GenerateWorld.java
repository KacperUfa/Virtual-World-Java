package pl.edu.pg.eti.ksg.po.virtual.world.Classes;

import pl.edu.pg.eti.ksg.po.virtual.world.Classes.Animals.*;
import pl.edu.pg.eti.ksg.po.virtual.world.Classes.Plants.*;
import pl.edu.pg.eti.ksg.po.virtual.world.Interfaces.Organism;

import java.util.ArrayList;
import java.util.Random;

public class GenerateWorld {
    private int x;
    private int y;

    public GenerateWorld(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public World generateWorld(){
        int maxAmount = x*y;
        int plantAmount = maxAmount/5;
        int animalAmount = maxAmount/4;
        ArrayList<Organism> organisms = new ArrayList<>();
        ArrayList<ArrayList<Organism>> map = new ArrayList<ArrayList<Organism>>();
        for(int i=0; i<y; i++){
            map.add(new ArrayList<Organism>());
            for(int j=0;j<x;j++){
                map.get(i).add(null);
            }
        }
        this.addPlants(plantAmount,organisms,map);
        this.addAnimals(animalAmount, organisms,map);
        Random random = new Random();
        int randX,randY;
        do{
            randX = random.nextInt(this.x);
            randY = random.nextInt(this.y);
        }while (map.get(randY).get(randX)!=null);

        Human human = new Human(randX,randY,null);
        organisms.add(human);
        World world = new World(this.x, this.y,organisms);
        return world;
    }

    public void addPlants(int plantAmount, ArrayList<Organism> organisms, ArrayList<ArrayList<Organism>> map){
        Random random = new Random();
        for(int i=0;i<plantAmount;i++){
            int randX,randY;
            int rand = random.nextInt(5);
            do{
                randX = random.nextInt(this.x);
                randY = random.nextInt(this.y);
            }while (map.get(randY).get(randX)!=null);

            Plant plant = null;
            switch (rand){
                case 0:{
                    plant = new Dandelion(randX,randY,null);
                    break;
                }
                case 1:{
                    plant = new Grass(randX,randY,null);
                    break;
                }
                case 2:{
                    plant = new Guarana(randX,randY,null);
                    break;
                }
                case 3:{
                    plant = new NightShade(randX,randY,null);
                    break;
                }
                case 4:{
                    plant = new Parnsip(randX, randY, null);
                    break;
                }
                default:
                    break;
            }
            organisms.add(plant);
            map.get(randY).set(randX, plant);
        }
    }

    public void addAnimals(int animalAmount, ArrayList<Organism> organisms, ArrayList<ArrayList<Organism>> map){
        Random random = new Random();
        for(int i=0;i<animalAmount;i++){
            int randX,randY;
            int rand = random.nextInt(6);
            do{
                randX = random.nextInt(this.x);
                randY = random.nextInt(this.y);
            }while (map.get(randY).get(randX)!=null);

            Animal animal = null;
            switch (rand){
                case 0:{
                    animal = new Antelope(randX,randY,null);
                    break;
                }
                case 1:{
                    animal = new CyberSheep(randX,randY,null);
                    break;
                }
                case 2:{
                    animal = new Fox(randX,randY,null);
                    break;
                }
                case 3:{
                    animal = new Sheep(randX,randY,null);
                    break;
                }
                case 4:{
                    animal = new Turtle(randX, randY, null);
                    break;
                }
                case 5:{
                    animal = new Wolf(randX, randY, null);
                    break;
                }
                default:
                    break;
            }
            organisms.add(animal);
            map.get(randY).set(randX, animal);
        }
    }
}
