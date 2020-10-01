package string.prac;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.ArrayList;

public class IterateOverHashMap {

    public static void main(String[] args) {

        Map<Integer, String> mainMap = new HashMap<>();

        mainMap.put(1, "hello");
        mainMap.put(2, "moto");

        // using enhanced for loop
        System.out.println("Using For Each Loop");
        for (Map.Entry<Integer, String> entry : mainMap.entrySet()) {

            System.out.println("key: " + entry.getKey() + " Value:" + entry.getValue());
        }

        // using foreach method
        System.out.println("Using For Each Method");
        mainMap.forEach((key, value) -> {
            System.out.println("key: " + key + " Value:" + value);
        });

        // using Iterator
        System.out.println("Using Iterator");
        Iterator<Entry<Integer, String>> itr = mainMap.entrySet().iterator();

        while (itr.hasNext()) {

            Entry<Integer, String> entry = (Entry<Integer, String>) itr.next();
            System.out.println("key: " + entry.getKey() + " Value:" + entry.getValue());

        }
        System.out.println("Get only KeySet");
        Set<Integer> keySet = mainMap.keySet();
        System.out.println(keySet);
        
        
        System.out.println("GEt only values collection");
       List<String> values = new ArrayList( mainMap.values());
       System.out.println(values);
       
       

    }

}
