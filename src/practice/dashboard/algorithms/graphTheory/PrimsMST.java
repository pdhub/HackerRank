//package practice.dashboard.algorithms.graphTheory;
//
//import java.util.*;
//
///**
// * Created by PDeb on 10/26/2017.
// */
//public class PrimsMST {
//
//    private static int V = 5;
//
//    public static int minKey(int key[], Boolean mst[])
//    {
//        int min = Integer.MAX_VALUE, min_index = -1;
//        for (int v = 0; v < V+1; v++) {
//            if(mst[v] == false && key[v] < min)
//            {
//                min = key[v];
//                min_index = v;
//            }
//        }
//        return min_index;
//    }
//
//    static void primMST(int graph[][], int startingSource){
//        int parent[] = new int[V+1];
//        int key[] = new int[V+1];
//        Boolean mstSet[] = new Boolean[V+1];
//        for (int i = 0; i < V+1; i++) {
//            key[i] = Integer.MAX_VALUE;
//            mstSet[i] = false;
//        }
//
//        int mstSum = 0;
//
//        key[startingSource] = 0;
//        parent[startingSource] = -1;
//
//        for (int count = 0; count < V; count++) {
//            int u = minKey(key, mstSet);
//            mstSet[u] = true;
//            for (int v = 0; v < V+1; v++) {
//                if(graph[u][v]!=0 && mstSet[v]==false && graph[u][v] < key[v])
//                {
//                    parent[v]=u;
//                    key[v] = graph[u][v];
//                    mstSum += key[v];
//                }
//            }
//        }
//
//        System.out.println(mstSum);
//    }
//
//    public static void main(String[] args) {
//
//        Scanner in = new Scanner(System.in);
//        int totalNodes = in.nextInt();
//        Graph graph = new Graph(totalNodes);
//        int totalEdges = in.nextInt();
//        for (int i = 0; i < totalEdges; i++) {
//            int source = in.nextInt();
//            int dest = in.nextInt();
//            int weight = in.nextInt();
//            graph.addEdge(source, dest, weight);
//        }
//        int startingSource = in.nextInt();
//        primMST(startingSource, graph);
//    }
//
//    private static void primMST(int startingSource, Graph graph) {
//        Queue<Node> priorityQueue = new PriorityQueue<Node>();
//        priorityQueue.offer(graph.list[startingSource]);
//        while(!priorityQueue.isEmpty())
//        {
//            Node nodeToConsider = priorityQueue.poll();
//            for (int i = 0; i < nodeToConsider.adjacencyList.size(); i++) {
//
//            }
//        }
//    }
//}
//
//
//
//class Graph{
//    Node[] list;
//    int vertices;
//    Graph(int vertices)
//    {
//        this.vertices = vertices;
//        for (int i = 0; i < vertices; i++) {
//            list[i] = new Node(new ArrayList<Edge>());
//        }
//    }
//
//    void addEdge(int source, int dest, int weight){
//        Edge edgeSouce = new Edge(source, dest, weight);
//        list[source].adjacencyList.add(edgeSouce);
//
//        //For Undirected graph
//        Edge edgeDest = new Edge(dest, source, weight);
//        list[dest].adjacencyList.add(edgeDest);
//    }
//}
//
//class Node{
//    List<Edge> adjacencyList;
//    boolean visited;
//
//    public Node(List<Edge> adjacencyList) {
//        this.adjacencyList = adjacencyList;
//    }
//}
//class Edge{
//    int source;
//    int destination;
//    int weight;
//
//    public Edge(int source, int destination, int weight) {
//        this.source = source;
//        this.destination = destination;
//        this.weight = weight;
//    }
//}
