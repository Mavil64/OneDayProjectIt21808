package main;

import weather.OpenData;

import java.io.IOException;

import java.util.ArrayList;
import java.util.HashMap;


public class Main
{

    public static void main(String[] args) throws IOException, InterruptedException
    {
        //I create the gui and the Hashmap needed for the program
        HashMap<String, int[]> Citymap = new HashMap<String, int[]>();
        Gui gui = new Gui(665,525);
        System.out.println("Loading...");

        //Used to redirect the System.out to the gui
        CustomOutputStream customStream = new CustomOutputStream(gui.ta_out);
        FileThingy filethingy = new FileThingy();

        //I create an array of arraylists
        ArrayList<String>[] Cities = new ArrayList[2];


        //Initializing the arraylists
        for (int i = 0; i < 2; i++)
        {
            Cities[i] = new ArrayList<String>();
        }
        ArrayList<Integer>[] WeatherData = new ArrayList[2];
        for (int i = 0; i < 2; i++)
        {
            WeatherData[i] = new ArrayList<Integer>();
        }
        filethingy.loadCities(Cities);

        //After loading the cities the Weather Data is acquired
        OpenData od = new OpenData(Cities[0],Cities[1], WeatherData);


        Double avgHumid = 0.0;
        for(int i = 0; i < Cities[0].size(); i++)
        {
            avgHumid += WeatherData[1].get(i);
        }
        avgHumid = avgHumid/Cities[0].size();

        for(int i = 0; i < Cities[0].size(); i++)
        {
            if(WeatherData[1].get(i) >= avgHumid)
            {
                int[] temp = {WeatherData[0].get(i), WeatherData[1].get(i)};
                Citymap.put(Cities[0].get(i), temp);
            }
        }
        System.out.println("Done!!!");
        gui.setCitymap(Citymap);


    }
}
