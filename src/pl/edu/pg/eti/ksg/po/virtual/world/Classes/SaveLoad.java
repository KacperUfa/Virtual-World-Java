package pl.edu.pg.eti.ksg.po.virtual.world.Classes;

import pl.edu.pg.eti.ksg.po.virtual.world.Classes.Animals.Human;
import pl.edu.pg.eti.ksg.po.virtual.world.Interfaces.Organism;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class SaveLoad {

    public void load(World world) throws FileNotFoundException {

        File file = new File("gameSave/save.txt");
        try {
            Scanner scanner = new Scanner(file);
            while(scanner.hasNextLine()){
                //tmpString=scanner.next();
                System.out.println(scanner.next());
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void save(ArrayList<Organism> organisms) throws IOException {
        String tmpString = "";
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
