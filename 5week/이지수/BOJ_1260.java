package goorm_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1260 {
    public static int N; // 정점의 개수
    public static int M; // 간선의 개수
    public static int V; // 시작 정점
    public static boolean[] visited; // 방문 여부
    public static int[][] arr; // 인접 행렬
    public static StringBuilder sb = new StringBuilder();
    public static Queue<Integer> q = new LinkedList<>();
    public static void dfs(int num) {
        visited[num] = true;
        sb.append(num).append(" ");
        for (int i = 1; i <= N; i++) {
            if(arr[num][i] == 1 && !visited[i]){
                dfs(i);
            }
        }
    }
    public static void bfs(int num) {
        q.add(num);
        visited[num] = true;
        sb.append('\n').append(num).append(" ");
        while (!q.isEmpty()) {
            int idx = q.poll();
            for (int i = 1; i <= N; i++) {
                if (arr[idx][i] == 1 && !visited[i]) {
                    q.add(i);
                    visited[i] = true;
                    sb.append(i).append(" ");
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        arr = new int[N+1][N+1];
        visited = new boolean[N+1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            arr[x][y] = arr[y][x] = 1;
        }

        dfs(V);
        Arrays.fill(visited, false);
        bfs(V);
        System.out.println(sb);

    }
}
