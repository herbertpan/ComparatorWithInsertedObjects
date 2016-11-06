package com.company;

import java.util.Comparator;
import java.util.Map;


/**
 * Created by panme on 11/6/2016.
 */
public class ValueComparator implements Comparator<Character> {
    private Map<Character, Integer> hashMap;

    public ValueComparator(Map<Character, Integer> x) {
        hashMap = x;
    }

    public int compare(Character ch1, Character ch2) {
        return hashMap.get(ch1) - hashMap.get(ch2);
    }
}
