package com.graph;

import org.junit.Test;

import java.util.HashMap;

public class TestReaderFileCreateArray {


    private String fileName = "F:\\workspace\\Play-with-Graph-Algorithms\\src\\main\\resources\\001.txt";

    @Test
    public void test_reader_file() {
        AdjMartix adjMartix = new AdjMartix(fileName);
        System.out.println(adjMartix.toString());
        new HashMap<>();
    }

    @Test
    public void test_adj_list() {
        AdjList adjList = new AdjList(fileName);
        System.out.println(adjList);
    }
}
