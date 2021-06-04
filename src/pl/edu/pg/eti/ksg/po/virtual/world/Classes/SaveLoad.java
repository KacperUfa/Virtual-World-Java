package pl.edu.pg.eti.ksg.po.virtual.world.Classes;

import pl.edu.pg.eti.ksg.po.virtual.world.Classes.Animals.*;
import pl.edu.pg.eti.ksg.po.virtual.world.Classes.Plants.*;
import pl.edu.pg.eti.ksg.po.virtual.world.Interfaces.Organism;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class SaveLoad {

    public World load() {

        //File file = new File("gameSave/save.txt");
        //ArrayList<Organism> organisms = new ArrayList<>();
        try {
            File file = new File("gameSave/save.txt");
            ArrayList<Organism> organisms = new ArrayList<>();

            Scanner scanner = new Scanner(file);
            String world = scanner.nextLine();
            String[] worldWords = world.split(" ");
            int worldX = Integer.parseInt(worldWords[0]);
            int worldY = Integer.parseInt(worldWords[1]);
            while(scanner.hasNextLine()){
                String tmpString=scanner.nextLine();

                String[] words = tmpString.split(" ");
                int x = Integer.parseInt(words[1]);
                int y = Integer.parseInt(words[2]);
                int power = Integer.parseInt(words[3]);
                Organism organism = null;
                switch (words[0]){
                    case "Human":{
                        Boolean active = Boolean.parseBoolean(words[4]);
                        int counter = Integer.parseInt(words[5]);
                        Human human = new Human(x,y,null);
                        human.setPower(power);
                        human.setCanActivate(active);
                        human.setCountSpecial(counter);
                        organisms.add(human);
                        break;
                    }
                    case "Antelope":{
                        organism = new Antelope(x,y,null);
                        organism.setPower(power);
                        organisms.add(organism);
                        break;
                    }
                    case "CyberSheep":{
                        organism = new CyberSheep(x,y,null);
                        organism.setPower(power);
                        break;
                    }
                    case "Dandelion":{
                        organism = new Dandelion(x,y,null);
                        organism.setPower(power);
                        break;
                    }
                    case "Fox":{
                        organism = new Fox(x,y,null);
                        organism.setPower(power);
                        break;
                    }
                    case "Grass":{
                        organism = new Grass(x,y,null);
                        organism.setPower(power);
                        break;
                    }
                    case "Guarana":{
                        organism = new Guarana(x,y,null);
                        organism.setPower(power);
                        break;
                    }
                    case "NightShade":{
                        organism = new NightShade(x,y,null);
                        organism.setPower(power);
                        break;
                    }
                    case "Parnsip":{
                        organism = new Parnsip(x,y,null);
                        organism.setPower(power);
                        break;
                    }
                    case "Sheep":{
                        organism = new Sheep(x,y,null);
                        organism.setPower(power);
                        break;
                    }
                    case "Turtle":{
                        organism = new Turtle(x,y,null);
                        organism.setPower(power);
                        break;
                    }
                    case "Wolf":{
                        organism = new Wolf(x,y,null);
                        organism.setPower(power);
                        break;
                    }
                    default:
                        break;
                }
                if(organism!=null && !words[0].equals("Human")){
                    organisms.add(organism);
                }
            }
            for (Organism organismX : organisms){
                System.out.println(organismX.getClass().getSimpleName()+" "+organismX.getPosition().getX()+" "+organismX.getPosition().getY());
            }
            System.out.println(worldX+" "+worldY);
            World newWorld = new World(worldX, worldY,organisms);
            return newWorld;
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void save(ArrayList<Organism> organisms, World world) throws IOException {
        String tmpString = "";
        tmpString += world.getMapSize().getX()+" "+world.getMapSize().getY()+"\n";
        for(Organism organism:organisms){
            String name = organism.getClass().getSimpleName();
            int x = organism.getPosition().getX();
            int y = organism.getPosition().getY();
            int power = organism.getPower();
            if(name.equals("Human")){
                boolean active = ((Human) organism).isAbleToActivate();
                int countSpecial = ((Human) organism).getCountSpecial();
                tmpString += name+" "+x+" "+y+" "+power+" "+active+" "+countSpecial+"\n";
            }
            else{
                tmpString += name+" "+x+" "+y+" "+power+"\n";
            }
        }

        String XD =  tmpString.substring(0, tmpString.length() - 1);  ;

        FileWriter fileWriter = new FileWriter("gameSave/save.txt");
        fileWriter.write(XD);
        fileWriter.close();
    }
}
