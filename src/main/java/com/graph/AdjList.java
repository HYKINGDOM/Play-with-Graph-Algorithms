package com.graph;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class AdjList {

    private int V;

    private int E;

    private LinkedList<Integer>[] adj;


    public int getV() {
        return V;
    }


    public int getE() {
        return E;
    }

    public boolean hasEdge(int v, int e) {
        validateVertex(v);
        validateVertex(e);
        return adj[v].contains(e);
    }

    public ArrayList<Integer> adj(int v) {
        validateVertex(v);
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            if (adj[v].contains(i)) {
                arrayList.add(i);
            }
        }
        return arrayList;
    }

    public int degree(int v) {
        return adj(v).size();
    }

    /**
     * 生成树
     *
     * @param name
     */
    public AdjList(String name) {
        File file = new File(name);
        try (Scanner scanner = new Scanner(file)) {
            //有K个点
            V = scanner.nextInt();
            //有v条边
            E = scanner.nextInt();
            if (V < 0 || E < 0) {
                throw new IllegalArgumentException("V must be non-negative");
            }
            adj = new LinkedList[V];
            for (int i = 0; i < V; i++) {
                adj[i] = new LinkedList<>();
            }
            for (int i = 0; i < E; i++) {
                int a = scanner.nextInt();
                validateVertex(a);
                int b = scanner.nextInt();
                validateVertex(b);
                if (a == b) {
                    //检查自环边
                    throw new IllegalArgumentException("Self loop is detected");
                }
                if (adj[a].contains(b)) {
                    //检查平行边
                    throw new IllegalArgumentException("Parallel edges are detected");
                }
                adj[a].add(b);
                adj[b].add(a);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void validateVertex(int v) {
        if (v < 0 || v >= V) {
            throw new IllegalArgumentException("Vertex" + v + "is invalid");
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("V = %d, E = %d\n", V, E));
        for (int i = 0; i < V; i++) {
            sb.append(String.format("%d : ", i));
            for (Integer w : adj[i]) {
                sb.append(String.format("%d ", w));
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
