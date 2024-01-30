package goorm_study;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2644 {
    static int n, m, p1, p2;
    static int[][] map;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        map = new int[n + 1][n + 1];
        visited = new boolean[n + 1];

        st = new StringTokenizer(br.readLine()," ");
        p1 = Integer.parseInt(st.nextToken());
        p2= Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine()," ");
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            map[parent][child] = 1;
            map[child][parent] = 1;
        }
        bw.write(String.valueOf(bfs(p1, p2)));
        bw.close();

    }
    static Integer bfs(int x, int y){
        int res = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(x);

        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i<size;i++){
                int cur = q.poll();
                visited[cur] = true;
                if(cur == y) return res;
                for(int child = 1; child <=n;child++){
                    if(map[cur][child]==1){
                        if(!visited[child])
                            q.add(child);
                    }
                }
            }
            res++;
        }
        return -1;
    }
}
