package com.company;
import java.util.ConcurrentModificationException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Main {

    public static void main(final String[] arguments) {
        Map<String,String> map = new ConcurrentHashMap<String, String>();
        map.put("Dhanya", "Female");
        map.put("Harsidh", "Male");
        map.put("Hemalatha", "Female");
        map.put("Ramesh", "Male");

        System.out.println("Initial ConcurrentHashMap: " + map);
        Iterator<String> iterator = map.keySet().iterator();

        try {

            while(iterator.hasNext()) {
                String key = iterator.next();

                if(key.equals("Dhanya")) {
                    map.put("Sruthi", "Female");
                }
            }
        } catch(ConcurrentModificationException cme) {
            cme.printStackTrace();
        }
        System.out.println("ConcurrentHashMap after modification: " + map);
    }
}