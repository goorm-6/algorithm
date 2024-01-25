import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static char[][] grid;
    static boolean[][] visited;
    static int N;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        grid = new char[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                grid[i][j] = line.charAt(j);
            }
        }

        int normalCount = countRegions(false);
        int colorBlindCount = countRegions(true);

        System.out.println(normalCount + " " + colorBlindCount);
    }

    public static int countRegions(boolean colorBlind) {
        int count = 0;
        visited = new boolean[N][N]; // Reset visited array

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    dfs(i, j, grid[i][j], colorBlind);
                    count++;
                }
            }
        }
        return count;
    }

    public static void dfs(int x, int y, char color, boolean colorBlind) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < N && ny < N && !visited[nx][ny]) {
                if (colorBlind && (color == 'R' || color == 'G')) {
                    if (grid[nx][ny] == 'R' || grid[nx][ny] == 'G') {
                        dfs(nx, ny, color, colorBlind);
                    }
                } else {
                    if (grid[nx][ny] == color) {
                        dfs(nx, ny, color, colorBlind);
                    }
                }
            }
        }
    }
}
