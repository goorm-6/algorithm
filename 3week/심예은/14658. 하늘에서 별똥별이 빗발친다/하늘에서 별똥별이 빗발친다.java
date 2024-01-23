import java.util.*;
import java.io.*;

public class Main {
    static int N, M, L, K;
    static int[][] stars;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        stars = new int[K][2];

        for(int i = 0; i < K; i++){
            st = new StringTokenizer(br.readLine());
            stars[i][0] = Integer.parseInt(st.nextToken());
            stars[i][1] = Integer.parseInt(st.nextToken());
        }

        // 별똥별 위치 정렬
        Arrays.sort(stars, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

        int res = 0;

        for(int i = 0; i < K; i++) {
            for(int j = 0; j < K; j++) {
                int count = 0;
                int xLimit = stars[i][0] + L;
                int yLimit = stars[j][1] + L;

                // 범위 내 별똥별 계산
                for(int k = 0; k < K; k++) {
                    if(stars[k][0] >= stars[i][0] && stars[k][0] <= xLimit && stars[k][1] >= stars[j][1] && stars[k][1] <= yLimit) {
                        count++;
                    }
                }

                res = Math.max(res, count);
            }
        }
        System.out.println(K - res);
    }
}
