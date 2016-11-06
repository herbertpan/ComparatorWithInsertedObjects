package com.company;

import java.util.Comparator;

/**
 * Created by panme on 11/4/2016.
 */
public class Node implements Comparable<Node>{
    private char ch;
    private int count;

    public int compareTo(Node node2) {
        if (this.count > node2.getCount()) {
            return 1;
        } else {
            return -1;
        }
    }

    Node(Character ch, Integer count) {
        this.ch = ch;
        this.count = count;
    }

    public void addCount() {
        count++;
    }

    public char getChar() {
        return ch;
    }

    public int getCount() {
        return count;
    }
}

