package com.evgesha.petshop;

import com.evgesha.petshop.animal.dog.Shpitz;

import java.util.HashMap;
import java.util.Map;

public class TestMap {
    public static void main(String[] args) {
       int a = 25;
       String name = "Pureshka";
       String name2 = new String("Pureshka");

       Shpitz shpitz3 = new Shpitz("Pureshka");
       Shpitz shpitz4 = new Shpitz();

        Map<String, Integer> store = new HashMap<>();
        store.put("Kormushka", new Integer (11));
        store.put("Igrushka", Integer.valueOf(13));
        store.put("Hozyaika", 0);

        Integer cena = store.get("Hozyaika");
        int cena1 = store.get("Hozyaika");







    }
}
