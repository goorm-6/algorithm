package goorm_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1743 {
    static int n,m,k;
    static int res,temp;
    static boolean[][] map;
    static boolean[][] check;
    static int[] dr = {-1, 0, 1, 0};	//상우하좌
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        n= Integer.parseInt(st.nextToken());
        m= Integer.parseInt(st.nextToken());
        k= Integer.parseInt(st.nextToken());

        map=new boolean[n][m];
        check= new boolean[n][m];

        for(int i=0; i<k; i++){
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            map[r-1][c-1]=true;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(!check[i][j] && map[i][j]) {
                    temp=0;
                    dfs(i,j);
                    res = Math.max(res, temp);
                }
            }
        }
        System.out.println(res);
    }

    public static void dfs(int r,int c){
        temp++;
        check[r][c]=true;

        for(int i=0;i<4;i++){
            int nr = r + dr[i];
            int nc = c + dc[i];

            if(nr<0||nc<0||nr>=n||nc>=m) continue;
            if(!check[nr][nc]&&map[nr][nc]){
                dfs(nr,nc);
            }
        }
    }
}
