package ru.geekbrains.java2.dz.dz3.esomov;

import java.util.*;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created by spo_admin4 on 22.03.2017.
 */
public class Test {
    public static void main(String[] args) {

        ArrayList<String> al = new ArrayList<String>();
        al.add("A");
        al.add("B");
        al.add("C");
        al.add("D");
        al.add("E");
        al.add(3,"A0");
        System.out.println(al);
        al.remove("E");
        al.remove(2);
        System.out.println(al);

        for (String x : al) {
            x += "1";
            System.out.println(x);
        }

        LinkedList<String> w = new LinkedList<String>();
        w.add("F");
        w.add("B");
        w.add("D");
        w.add("E");
        w.add("C");
        w.addLast("Z");
        w.addFirst("A");
        w.add(1,"A2");
        System.out.println(w);
        w.remove("F");
        w.remove(2);
        System.out.println(w);
        w.removeFirst();
        w.removeLast();
        System.out.println(w);

        HashMap<String, String> hm = new HashMap<String, String>();
        hm.put("Russia", "Moscow");
        hm.put("France", "Paris");
        hm.put("Germany", "Berlin");
        hm.put("Norway", "Oslo");
        System.out.println(hm);
        Set<Map.Entry<String, String>> set = hm.entrySet();
        for (Map.Entry<String, String> i : set) {
            System.out.print(i.getKey()+":");
            System.out.println(i.getValue());
        }
        System.out.println();
        hm.put("Norway", "Oslo2");
        System.out.println("New Norway Enty: "+hm.get("Norway"));
        System.out.println(hm);
    }
}
