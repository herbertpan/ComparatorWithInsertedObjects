package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Node n1 = new Node('a', 4);
        Node n2 = new Node('b', 3);
        Node n3 = new Node('c', 2);
        Node n4 = new Node('d', 1);
        /***
         *  TreeSet and TreeMap only call their comparators when a new node is inserted.
         *  Change an inserted Node cannot invoke comparator.
         */
        Set<Node> hashSet = new HashSet<>();
        hashSet.add(n1);
        hashSet.add(n2);
        hashSet.add(n3);
        hashSet.add(n4);
        Iterator<Node> itSet = hashSet.iterator();
        while (itSet.hasNext()) {
            Node temp = itSet.next();
            System.out.println(temp.getChar() + " " + temp.getCount());
        }
        System.out.println();

        //Set Method
        Set<Node> treeSet = new TreeSet<>(new Comparator<Node>() {
            @Override
            public int compare(Node n1, Node n2) {
                //System.out.println(n1.getChar() + " " + n2.getChar());
                return n1.compareTo(n2);
            }
        });
        treeSet.addAll(hashSet);
        itSet = treeSet.iterator();
        while (itSet.hasNext()) {
            Node temp = itSet.next();
            System.out.println(temp.getChar() + " " + temp.getCount());
        }
        System.out.println();

        Map<Character, Integer> hashMap = new HashMap<>();
        hashMap.put('a', 4);
        hashMap.put('b', 3);
        hashMap.put('c', 2);
        hashMap.put('d', 1);
        Iterator<Map.Entry<Character, Integer>> itMap = hashMap.entrySet().iterator();
        while (itMap.hasNext()) {
            Map.Entry<Character, Integer> entry = itMap.next();
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
        System.out.println();

        //Map method1
        Map<Character, Integer> treeMap = new TreeMap<>(new ValueComparator(hashMap));
        treeMap.putAll(hashMap);
        itMap = treeMap.entrySet().iterator();
        while (itMap.hasNext()) {
            Map.Entry<Character, Integer> entry = itMap.next();
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
        System.out.println();

        //Map Method2
        List<Map.Entry<Character, Integer>> list = new ArrayList<>(hashMap.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Character, Integer>>(){
            @Override
            public int compare(Map.Entry<Character, Integer> entry1,
                               Map.Entry<Character, Integer> entry2) {
                return entry1.getValue() - entry2.getValue();
            }
        });
        for(Map.Entry<Character, Integer> entry : list) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
