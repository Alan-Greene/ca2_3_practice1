package ca_practice;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Test {

    public static void main(String[] args) {
        Flight f = new Flight(200, 3.5);
        int i = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader("files/data.txt"))){
            for (String line; (line = reader.readLine()) != null;) {
                // make sure to make a new list each time.
                char[] bag_size = new char[3];
                Double[] bag_weight = new Double[3];

                String[] values = line.split(",");
                bag_weight[i] = Double.parseDouble(values[2]);
                bag_size[i] = values[5].charAt(0);
                i++;
                bag_weight[i] = Double.parseDouble(values[3]);
                bag_size[i] = values[6].charAt(0);
                i++;
                bag_weight[i] = Double.parseDouble(values[4]);
                bag_size[i] = values[7].charAt(0);

                Flight.Passenger p = f.new Passenger(values[0], Integer.parseInt(values[1]), bag_weight, bag_size);
                f.fillList(p);
                i = 0;

            }
        } catch (IOException e){
            System.err.println(e.getMessage());
            System.exit(-2);
        }


        f.print();
        System.out.println(f.checkAvailability());
        System.out.println(f.calcOldestPassenger());
    }
}
