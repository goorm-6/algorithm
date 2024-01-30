import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<Integer>[] family;
    static boolean[] visited;
    static int[] distance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int person1 = Integer.parseInt(st.nextToken());
        int person2 = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(br.readLine());

        family = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            family[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            family[parent].add(child);
            family[child].add(parent); 
        }

        visited = new boolean[n + 1];
        distance = new int[n + 1];

        System.out.println(bfs(person1, person2));
    }

    static int bfs(int start, int end) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;
        distance[start] = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            if (current == end) {
                return distance[current];
            }
            for (int next : family[current]) {
                if (!visited[next]) {
                    queue.add(next);
                    visited[next] = true;
                    distance[next] = distance[current] + 1;
                }
            }
        }
        return -1;
    }
}
