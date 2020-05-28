package com.java.io.challenge.bufferreader;

import java.io.*;
import java.util.*;

public class Locations implements Map<Integer, Location> {
    private static Map<Integer, Location> locations = new LinkedHashMap<>();

    public static void main(String[] args) throws IOException{
        //https://docs.oracle.com/javase/7/docs/technotes/guides/language/try-with-resources.html
    // Using try-with-resource
       try(BufferedWriter locFile = new BufferedWriter(new FileWriter("locations.txt"));
           BufferedWriter dicFile = new BufferedWriter(new FileWriter("directions.txt"))) {
            for (Location loc : locations.values()) {
                locFile.write(loc.getLocationID() + ", " + loc.getDescription() + "\n");
                for (String dir : loc.getExits().keySet()) {
                    if(!dir.equalsIgnoreCase("Q")) {
                        dicFile.write(loc.getLocationID() + "," + dir + "," + loc.getExits().get(dir) + "\n");
                    }
                }
            }
       }
   }

    static {
           try (BufferedReader locFile = new BufferedReader(new FileReader("locations_big.txt"))) {
              String input;
               while ((input = locFile.readLine()) != null) {
                   String[] data = input.split(",");
                   int loc = Integer.parseInt(data[0]);
                   String description = data[1];

                   System.out.println("Imported loc: " + loc + ", " + description);
                   Map<String, Integer> tempExits = new HashMap<>();
                   locations.put(loc, new Location(loc, description, tempExits));
               }
           } catch (IOException exp) {
               exp.printStackTrace();
           }



           // read exits
           // using buffer is more optimal as reading a resource object adds overhead. Instead of calling the
           // resource for every small input it is better to buffer all the input to a buffer reader and then read once
           try (BufferedReader dirFile = new BufferedReader(new FileReader("directions_big.txt"))) {
               String input;
                 while ((input = dirFile.readLine()) != null) {

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
