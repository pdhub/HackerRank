package audiblesse;

import java.util.ArrayList;

public class ZombieCluster {

    static int zombieCluster(String[] zombies) {
        int n = zombies.length;
        ArrayList<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < zombies.length; i++) {
            String input = zombies[i];
            for (int j = 0; j < input.length(); j++) {
                if (input.charAt(j) == '1'){
                    adj[i].add(j);
                    adj[j].add(i);
                }
            }
        }
        return countConnectedComponents(adj);
    }

    private static int countConnectedComponents(ArrayList<Integer>[] adj) {
        int res = 0;
        boolean visited[] = new boolean[adj.length];
        for (int i = 0; i < adj.length; i++) {
            if (!visited[i]){
                doDFS(i, adj, visited);
                res++;
            }
        }
        return res;
    }

    private static void doDFS(int source, ArrayList<Integer>[] adj, boolean[] visited) {
        visited[source] = true;
        for (int i = 0; i < adj[source].size(); i++) {
            if (!visited[adj[source].get(i)]){
                doDFS(adj[source].get(i), adj, visited);
            }
        }
    }
}
