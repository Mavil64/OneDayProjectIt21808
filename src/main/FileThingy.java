package main;

import java.io.*;
import java.util.ArrayList;


public class FileThingy
{

    public FileThingy() {}
    //Loads all cities in the file Cities.txt.
    public static void loadCities(ArrayList<String>[] Cities) throws IOException {
        File file = new File("Cities.txt");
        file.createNewFile();
        if (file.exists() && !file.isDirectory())
        {
            BufferedReader br = new BufferedReader(new FileReader("Cities.txt"));
            String line = null;

            //while the buffer reader continues to find stuff it loads them
            while ((line = br.readLine()) != null)
            {
                String TmpCity[] = line.split("\t");

                Cities[0].add(TmpCity[0]);
                Cities[1].add(TmpCity[1]);
            }

            br.close();
        }
    }
}