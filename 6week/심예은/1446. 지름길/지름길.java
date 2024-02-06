import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력 받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        // 지름길 정보 저장 배열
        int[][] shortcuts = new int[N][3];

        // 지름길 정보 입력 받기
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            shortcuts[i][0] = Integer.parseInt(st.nextToken()); // 시작 위치
            shortcuts[i][1] = Integer.parseInt(st.nextToken()); // 도착 위치
            shortcuts[i][2] = Integer.parseInt(st.nextToken()); // 지름길의 길이
        }

        // 최소 거리 계산
        int result = calculateMinDistance(D, shortcuts);

        // 결과 출력
        System.out.println(result);
    }

    private static int calculateMinDistance(int D, int[][] shortcuts) {
        int[] md = new int[D + 1]; // 최소 거리를 저장할 배열

        for (int i = 1; i <= D; i++) {
            md[i] = md[i - 1] + 1; // 직진하는 경우의 거리

            for (int j = 0; j < shortcuts.length; j++) {
                if (shortcuts[j][1] == i) {
                    // 지름길을 이용하는 경우
                    md[i] = Math.min(md[i], md[shortcuts[j][0]] + shortcuts[j][2]);
                }
            }
        }

        return md[D];
    }
}
