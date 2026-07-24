package com.assignment2;

import java.util.*;

/**
 * Graph implementation using Adjacency List
 */
public class Graph {

    /**
     * Edge class
     */
    private static class Edge {

        String destination;
        int weight;

        public Edge(String destination, int weight) {
            this.destination = destination;
            this.weight = weight;
        }

    }

    /**
     * Adjacency List
     */
    private final Map<String, List<Edge>> adjacencyList;

    /**
     * Constructor
     */
    public Graph() {
        adjacencyList = new HashMap<>();
    }

    /**
     * Add Vertex
     */
    public void addVertex(String vertex) {

        if (adjacencyList.containsKey(vertex)) {

            System.out.println("Vertex already exists.");
            return;

        }

        adjacencyList.put(vertex, new ArrayList<>());

        System.out.println("Vertex added successfully.");

    }

    /**
     * Add Edge (Undirected Graph)
     */
    public void addEdge(String source, String destination, int weight) {

        if (!adjacencyList.containsKey(source)) {

            System.out.println("Source vertex does not exist.");
            return;

        }

        if (!adjacencyList.containsKey(destination)) {

            System.out.println("Destination vertex does not exist.");
            return;

        }

        adjacencyList.get(source).add(new Edge(destination, weight));
        adjacencyList.get(destination).add(new Edge(source, weight));

        System.out.println("Edge added successfully.");

    }

    /**
     * Display Graph
     */
    public void displayGraph() {

        if (adjacencyList.isEmpty()) {

            System.out.println("Graph is empty.");
            return;

        }

        System.out.println("\n========== GRAPH ==========");

        for (String vertex : adjacencyList.keySet()) {

            System.out.print(vertex + " -> ");

            List<Edge> edges = adjacencyList.get(vertex);

            if (edges.isEmpty()) {

                System.out.print("No Connections");

            } else {

                for (int i = 0; i < edges.size(); i++) {

                    Edge edge = edges.get(i);

                    System.out.print(edge.destination + "(" + edge.weight + ")");

                    if (i != edges.size() - 1) {
                        System.out.print(", ");
                    }

                }

            }

            System.out.println();

        }

    }

    /**
     * Breadth First Search
     */
    public void bfs(String startVertex) {

        if (!adjacencyList.containsKey(startVertex)) {

            System.out.println("Vertex not found.");
            return;

        }

        Set<String> visited = new HashSet<>();

        Queue<String> queue = new LinkedList<>();

        visited.add(startVertex);

        queue.offer(startVertex);

        System.out.println("\nBreadth First Search");

        while (!queue.isEmpty()) {

            String current = queue.poll();

            System.out.print(current + " ");

            for (Edge edge : adjacencyList.get(current)) {

                if (!visited.contains(edge.destination)) {

                    visited.add(edge.destination);

                    queue.offer(edge.destination);

                }

            }

        }

        System.out.println();

    }

    /**
     * Depth First Search
     */
    public void dfs(String startVertex) {

        if (!adjacencyList.containsKey(startVertex)) {

            System.out.println("Vertex not found.");
            return;

        }

        Set<String> visited = new HashSet<>();

        System.out.println("\nDepth First Search");

        dfsRecursive(startVertex, visited);

        System.out.println();

    }

    /**
     * Recursive DFS
     */
    private void dfsRecursive(String vertex, Set<String> visited) {

        visited.add(vertex);

        System.out.print(vertex + " ");

        for (Edge edge : adjacencyList.get(vertex)) {

            if (!visited.contains(edge.destination)) {

                dfsRecursive(edge.destination, visited);

            }

        }

    }

    /**
     * Helper class for Priority Queue
     */
    private static class Node implements Comparable<Node> {

        String vertex;
        int cost;

        public Node(String vertex, int cost) {
            this.vertex = vertex;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.cost, other.cost);
        }

    }

    /**
     * Dijkstra Shortest Path Algorithm
     */
    public void dijkstra(String source) {

        if (!adjacencyList.containsKey(source)) {

            System.out.println("Vertex not found.");
            return;

        }

        Map<String, Integer> distance = new HashMap<>();

        PriorityQueue<Node> priorityQueue = new PriorityQueue<>();

        for (String vertex : adjacencyList.keySet()) {
            distance.put(vertex, Integer.MAX_VALUE);
        }

        distance.put(source, 0);

        priorityQueue.offer(new Node(source, 0));

        while (!priorityQueue.isEmpty()) {

            Node current = priorityQueue.poll();

            if (current.cost > distance.get(current.vertex)) {
                continue;
            }

            for (Edge edge : adjacencyList.get(current.vertex)) {

                int newDistance = distance.get(current.vertex) + edge.weight;

                if (newDistance < distance.get(edge.destination)) {

                    distance.put(edge.destination, newDistance);

                    priorityQueue.offer(new Node(edge.destination, newDistance));

                }

            }

        }

        System.out.println("\n========== SHORTEST PATH ==========");

        for (String vertex : distance.keySet()) {

            System.out.print(source + " -> " + vertex + " = ");

            if (distance.get(vertex) == Integer.MAX_VALUE) {
                System.out.println("Unreachable");
            } else {
                System.out.println(distance.get(vertex));
            }

        }

    }

    /**
     * Prim Minimum Spanning Tree
     */
    public void primMST() {

        if (adjacencyList.isEmpty()) {

            System.out.println("Graph is empty.");
            return;

        }

        Set<String> visited = new HashSet<>();

        PriorityQueue<MSTEdge> priorityQueue = new PriorityQueue<>();

        String start = adjacencyList.keySet().iterator().next();

        visited.add(start);

        for (Edge edge : adjacencyList.get(start)) {
            priorityQueue.offer(new MSTEdge(start, edge.destination, edge.weight));
        }

        int totalCost = 0;

        System.out.println("\n========== MINIMUM SPANNING TREE ==========");

        while (!priorityQueue.isEmpty()) {

            MSTEdge edge = priorityQueue.poll();

            if (visited.contains(edge.destination)) {
                continue;
            }

            visited.add(edge.destination);

            totalCost += edge.weight;

            System.out.println(
                    edge.source + " -- " +
                            edge.destination +
                            " (" + edge.weight + ")");

            for (Edge next : adjacencyList.get(edge.destination)) {

                if (!visited.contains(next.destination)) {

                    priorityQueue.offer(
                            new MSTEdge(
                                    edge.destination,
                                    next.destination,
                                    next.weight));

                }

            }

        }

        System.out.println("--------------------------------");
        System.out.println("Total Cost : " + totalCost);

    }

    /**
     * Helper class for Prim MST
     */
    private static class MSTEdge implements Comparable<MSTEdge> {

        String source;
        String destination;
        int weight;

        public MSTEdge(String source,
                String destination,
                int weight) {

            this.source = source;
            this.destination = destination;
            this.weight = weight;

        }

        @Override
        public int compareTo(MSTEdge other) {
            return Integer.compare(this.weight, other.weight);
        }

    }
}