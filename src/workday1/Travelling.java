package workday1;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class Travelling {

    static class Graph{
        private int V;
        private LinkedList <Integer> adj[];

        Graph(int v)
        {
            V = v;
            adj = new LinkedList[v];
            for (int i=0; i<v; ++i)
                adj[i] = new LinkedList();
        }

        void addEdge(int v,int w)  {   adj[v].add(w);   }

        Boolean isReachable(int s, int d)
        {
            LinkedList<Integer>temp;
            boolean visited[] = new boolean[V];

            LinkedList<Integer> queue = new LinkedList<Integer>();
            visited[s]=true;
            queue.add(s);

            Iterator<Integer> i;
            while (queue.size()!=0)
            {
                s = queue.poll();
                int n;
                i = adj[s].listIterator();
                while (i.hasNext())
                {
                    n = i.next();
                    if (n==d)
                        return true;

                    if (!visited[n])
                    {
                        visited[n] = true;
                        queue.add(n);
                    }
                }
            }
            return false;
        }
    }

    static int[] connectedCities(int n, int g, int[] originCities, int[] destinationCities) {

        Graph graph = new Graph(n + 1);
        int parent[] = new int[graph.V];
        Arrays.fill(parent, -1);

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                boolean roadExists = checkRoadExists(i, j, g);
                if (roadExists){
                    graph.addEdge(i, j);
                }
            }
        }

        int result[] = new int[originCities.length];
        for (int i = 0; i < originCities.length; i++) {
            int source = originCities[i];
            int dest = destinationCities[i];
            if (graph.isReachable(source, dest))
            //if (parent[source] == parent[dest])
                result[i] = 1;
            else
                result[i] = 0;
        }
        return result;
    }

    private static boolean checkRoadExists(int i, int j, int threshold) {
        int gcd = findGCD(i, j);
        if (gcd > threshold)
            return true;
        return false;
    }

    private static int findGCD(int number1, int number2) {
        if(number2 == 0){ return number1; }
        return findGCD(number2, number1%number2);
    }

    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int numCities = in.nextInt();
        int threshold = in.nextInt();
        int numOrigin = in.nextInt();
        int[] originCities = new int[numOrigin];
        for (int i = 0; i < originCities.length; i++) {
            originCities[i] = in.nextInt();
        }
        int destCities = in.nextInt();
        int[] destinationCities = new int[destCities];
        for (int i = 0; i < destCities; i++) {
            destinationCities[i] = in.nextInt();
        }
        int res[] = connectedCities(numCities, threshold, originCities, destinationCities);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i]);
        }
    }
}
