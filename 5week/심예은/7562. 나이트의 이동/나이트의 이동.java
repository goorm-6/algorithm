import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {-2, -2, -1, -1, 1, 1, 2, 2};
    static int[] dy = {-1, 1, -2, 2, -2, 2, -1, 1};

    static class Position {
        int x, y, distance;

        public Position(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        while (testCase-- > 0) {
            int l = Integer.parseInt(br.readLine());
            boolean[][] visited = new boolean[l][l];

            StringTokenizer st = new StringTokenizer(br.readLine());
            Position start = new Position(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0);

            st = new StringTokenizer(br.readLine());
            Position end = new Position(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0);

            System.out.println(bfs(l, start, end, visited));
        }
    }

    public static int bfs(int l, Position start, Position end, boolean[][] visited) {
        Queue<Position> queue = new LinkedList<>();
        queue.add(start);
        visited[start.x][start.y] = true;

        while (!queue.isEmpty()) {
            Position current = queue.poll();

            if (current.x == end.x && current.y == end.y) {
                return current.distance;
            }

            for (int i = 0; i < 8; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < l && ny < l && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.add(new Position(nx, ny, current.distance + 1));
                }
            }
        }
        return -1;
    }
}
