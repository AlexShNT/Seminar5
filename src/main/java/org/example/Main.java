package org.example;

//
//import java.awt.*;
//import java.util.Map;
import java.util.*;

public class Main {
    public static void addContact(HashMap<String, List<String>> phBk, String name, String phNum) {
        if (phBk.containsKey(name)) {
            phBk.get(name).add(phNum);
        } else {
            List<String> phTmp = new ArrayList<>();
            phTmp.add(phNum);
            phBk.put(name, phTmp);
        }
    }

    public static void main(String[] args) {

    HashMap<String, List<String>> phBk = new HashMap<>();

    addContact(phBk, "Иванов", "1234567890");
    addContact(phBk, "Петров", "9876543210");
    addContact(phBk, "Сидоров", "1111111111");
    addContact(phBk, "Иванов", "2222222222");
    addContact(phBk, "Петров", "3333333333");
    addContact(phBk, "Петров", "4444444444");


    List<Map.Entry<String, List<String>>> sorCons = new ArrayList<>(phBk.entrySet());


    sorCons.sort(new Comparator<Map.Entry<String, List<String>>>() {
        @Override
        public int compare(Map.Entry<String, List<String>> contact1, Map.Entry<String, List<String>> contact2) {
            return Integer.compare(contact2.getValue().size(), contact1.getValue().size());
        }
    });


    sorCons.forEach(e-> System.out.println(e.getKey() + " : " + e.getValue()));

}

}