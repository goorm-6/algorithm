package goorm_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1012 {
    static int M,N,K;
    static int [][] map; // 지도를 저장하는 2차원 배열
    static boolean [][] check; // 방문 여부를 저장하는 2차원 배열
    static int[] dx = {1, 0, -1, 0}; // 상하좌우 이동을 위한 배열
    static int[] dy = {0, -1, 0, 1};
    static int cnt;
    static void dfs (int x, int y){
        check[x][y]=true;
        for(int i=0;i<4;i++){
            int cx=x+dx[i];
            int cy=y+dy[i];
            if(cx >= 0 && cy >= 0 && cx < M && cy < N){
                if (!check[cx][cy] && map[cx][cy] == 1) {
                    dfs(cx, cy);
                }
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수

        for(int i=0;i<T;i++){
            cnt=0;
            StringTokenizer st =new StringTokenizer(br.readLine()," ");
            M=Integer.parseInt(st.nextToken()); // 밭의 가로길이
            N=Integer.parseInt(st.nextToken()); // 밭의 세로길이
            map=new int [M][N];
            check=new boolean[M][N];

            K=Integer.parseInt(st.nextToken()); // 밭에 심은 배추 개수

            for(int j=0;j<K;j++){
                st=new StringTokenizer(br.readLine()," ");
                int p1 = Integer.parseInt(st.nextToken());
                int p2 = Integer.parseInt(st.nextToken());
                map[p1][p2]=1;
            }

            for (int x = 0; x < M; x++) {
                for (int y = 0; y < N; y++) {
                    if (map[x][y] == 1 && !check[x][y]) {
                        dfs(x, y);
                        cnt++;
                    }
                }
            }
            System.out.println(cnt);
        }
    }
}
