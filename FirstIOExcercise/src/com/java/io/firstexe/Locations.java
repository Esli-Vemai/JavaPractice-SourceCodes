package com.java.io.firstexe;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Locations implements Map<Integer, Location> {
    private static Map<Integer, Location> locations = new HashMap<Integer, Location>();

    public static void main(String[] args) throws IOException{
        //https://docs.oracle.com/javase/7/docs/technotes/guides/language/try-with-resources.html
    // Using try-with-resource
       try(FileWriter locFile = new FileWriter("locations.txt");
            FileWriter dicFile = new FileWriter("directions.txt")) {
            for (Location loc : locations.values()) {
                locFile.write(loc.getLocationID() + ", " + loc.getDescription() + "\n");
                for (String dir : loc.getExits().keySet()) {
                    dicFile.write(loc.getLocationID() + "," + dir + "," + loc.getExits().get(dir) + "\n");
                }
            }
       }
   }
       /* FileWriter locfile = null;
        try {
            locfile = new FileWriter("locations.txt");
            for(Location location: locations.values()) {
                locfile.write(location.getLocationID() + ", " + location.getDescription() + "\n");
            }
        } finally {
            System.out.println("In finally block");
                if(locfile != null) {
                    System.out.println("attempting to close locfile");
                    locfile.close();
                }
        }
    }*/
    static {
           //Scanner scanner = null;
           //read locations.
           try (Scanner scanner = new Scanner(new FileReader("locations_big.txt"))) {
               //scanner = new Scanner(new FileReader("locations_big.txt"));
               scanner.useDelimiter(",");
               while (scanner.hasNextLine()) {
                   int id = scanner.nextInt();
                   scanner.skip(scanner.delimiter());
                   String des = scanner.nextLine();
                   System.out.println("Imported loc: " + id + ", " + des);
                   Map<String, Integer> tempExits = new HashMap<>();
                   locations.put(id, new Location(id, des, tempExits));
               }
           } catch (IOException exp) {
               exp.printStackTrace();
           }

           /*finally {
                // no need to close Filereader here coz the scanner close() will handle it as it
               // close all resources that implements the Closable interface.
               if(scanner != null) {
                    scanner.close();
               }*/


           // read exits
           // using buffer is more optimal as reading a resource object adds overhead. Instead of calling the
           // resource for every small input it is better to buffer all the input to a buffer reader and then read once
           try (BufferedReader dirFile = new BufferedReader(new FileReader("directions_big.txt"))) {
                //scanner = new Scanner(new BufferedReader(new FileReader("directions_big.txt")));
               String input;
                 while ((input = dirFile.readLine()) != null) {
                      /* int id = scanner.nextInt();
                       scanner.skip(scanner.delimiter());
                       String direction = scanner.next();
                       scanner.skip(scanner.delimiter());
                       String destination = scanner.nextLine();
                       int dest = Integer.parseInt(destination);
                       */

                     //Using String instead
                     String[] data = input.split(",");
                     int id = Integer.parseInt(data[0]);
                     String direction = data[1];
                     int dest = Integer.parseInt(data[2]);

                     System.out.println(id + ", " + direction + ", " + dest);
                       Location location = locations.get(id);
                       location.addExits(direction, dest);
                   }


           } catch (IOException exp) {
               exp.printStackTrace();
           }












    /*    Map<String, Integer> tempExit = new HashMap<String, Integer>();
        locations.put(0, new Location(0, "You are sitting in front of a computer learning Java",null));

        tempExit = new HashMap<String, Integer>();
        tempExit.put("W", 2);
        tempExit.put("E", 3);
        tempExit.put("S", 4);
        tempExit.put("N", 5);
        locations.put(1, new Location(1, "You are standing at the end of a road before a small brick building",tempExit));

        tempExit = new HashMap<String, Integer>();
        tempExit.put("N", 5);
        locations.put(2, new Location(2, "You are at the top of a hill",tempExit));

        tempExit = new HashMap<String, Integer>();
        tempExit.put("W", 1);
        locations.put(3, new Location(3, "You are inside a building, a well house for a small spring",tempExit));

        tempExit = new HashMap<String, Integer>();
        tempExit.put("N", 1);
        tempExit.put("W", 2);
        locations.put(4, new Location(4, "You are in a valley beside a stream",tempExit));

        tempExit = new HashMap<String, Integer>();
        tempExit.put("S", 1);
        tempExit.put("W", 2);
        locations.put(5, new Location(5, "You are in the forest",tempExit));*/

    }

    @Override
    public int size() {
        return locations.size();
    }

    @Override
    public boolean isEmpty() {
        return locations.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return locations.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return locations.containsValue(value);
    }

    @Override
    public Location get(Object key) {
        return locations.get(key);
    }

    @Override
    public Location put(Integer key, Location value) {
        return locations.put(key, value);
    }

    @Override
    public Location remove(Object key) {
        return locations.remove(key);
    }

    @Override
    public void putAll(Map<? extends Integer, ? extends Location> m) {

    }

    @Override
    public void clear() {
        locations.clear();

    }

    @Override
    public Set<Integer> keySet() {
        return locations.keySet();
    }

    @Override
    public Collection<Location> values() {
        return locations.values();
    }

    @Override
    public Set<Entry<Integer, Location>> entrySet() {
        return locations.entrySet();
    }
}
