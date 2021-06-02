package pl.edu.pg.eti.ksg.po.virtual.world.Classes;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SaveLoad {

    public void load(World world){
        File file = new File("gameSave/save.txt");
        try {
            Scanner scanner = new Scanner(file);
            String tmpString = "";
            while(scanner.hasNextLine()){
                tmpString=scanner.nextLine();

            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void save(){

    }
}
