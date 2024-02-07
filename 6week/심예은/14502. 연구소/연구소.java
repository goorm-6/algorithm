import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static int N, M;
    static int maxSafeZone = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        buildWall(0, 0);

        System.out.println(maxSafeZone);
    }

    static void buildWall(int count, int start) {
        if (count == 3) { // 벽을 3개 세웠을 때
            int[][] tempMap = new int[N][M];
            copyMap(tempMap, map);

            // 바이러스 퍼뜨리기
            spreadVirus();

            // 안전 영역 크기 계산
            maxSafeZone = Math.max(maxSafeZone, countSafeZone());

            // 원래 지도로 복구
            copyMap(map, tempMap);
            return;
        }

        for (int i = start; i < N * M; i++) {
            int row = i / M;
            int col = i % M;

            if (map[row][col] == 0) {
                map[row][col] = 1;
                buildWall(count + 1, i + 1);
                map[row][col] = 0;
            }
        }
    }

    static void copyMap(int[][] dest, int[][] src) {
        for (int i = 0; i < N; i++) {
            System.arraycopy(src[i], 0, dest[i], 0, M);
        }
    }

    static void spreadVirus() {
        List<int[]> virusList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 2) {
                    virusList.add(new int[]{i, j});
                }
            }
        }

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        for (int[] virus : virusList) {
            int row = virus[0];
            int col = virus[1];

            for (int i = 0; i < 4; i++) {
                int nr = row + dr[i];
                int nc = col + dc[i];

                if (nr >= 0 && nr < N && nc >= 0 && nc < M) {
                    if (map[nr][nc] == 0) {
                        map[nr][nc] = 2;
                        spreadVirus();
                    }
                }
            }
        }
    }

    static int countSafeZone() {
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    count++;
                }
            }
        }
        return count;
    }
}
