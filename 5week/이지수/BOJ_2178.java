package goorm_study;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2178 {
    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int[] dy = {1, 0, -1, 0};
    static int[] dx = {0, 1, 0, -1};

    public static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x,y});

        while(!q.isEmpty()) {
            int now[] = q.poll();
            int nx = now[0];
            int ny = now[1];

            for(int i=0;i<4;i++) {
                int nextX = nx + dx[i];
                int nextY = ny + dy[i];

                if(nextX>=0 && nextX<N && nextY>=0 && nextY<M) {
                    if(map[nextX][nextY]==1 && !visited[nextX][nextY]) {
                        q.add(new int[] {nextX, nextY});
                        visited[nextX][nextY]=true;
                        map[nextX][nextY] = map[nx][ny]+1;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map= new int [N][M];
        visited = new boolean[N][M];

        String str;

        for (int i=0;i<N;i++){
            str=br.readLine();
            for(int j=0;j<M;j++){
                map[i][j]=str.charAt(j)-'0';
            }
        }
        visited[0][0] = true; //출발지
        bfs(0, 0);
        System.out.println(map[N-1][M-1]);
    }
}
