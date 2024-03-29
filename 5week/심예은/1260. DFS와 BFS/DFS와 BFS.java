import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] adjList;
    static boolean[] visited;
    static StringBuilder dfsResult = new StringBuilder();
    static StringBuilder bfsResult = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        int V = Integer.parseInt(input[2]);

        adjList = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);

            adjList[a].add(b);
            adjList[b].add(a);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(adjList[i]);
        }

        visited = new boolean[N + 1];
        dfs(V);

        visited = new boolean[N + 1];
        bfs(V);

        System.out.println(dfsResult.toString().trim());
        System.out.println(bfsResult.toString().trim());
    }

    public static void dfs(int node) {
        if (visited[node]) return;

        visited[node] = true;
        dfsResult.append(node).append(" ");

        for (int nextNode : adjList[node]) {
            if (!visited[nextNode]) {
                dfs(nextNode);
            }
        }
    }

    public static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            bfsResult.append(node).append(" ");

            for (int nextNode : adjList[node]) {
                if (!visited[nextNode]) {
                    visited[nextNode] = true;
                    queue.add(nextNode);
                }
            }
        }
    }
}
