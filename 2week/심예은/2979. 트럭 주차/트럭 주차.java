import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[][] trucks = new int[3][2];

        for(int i=0; i<3; i++){
            st = new StringTokenizer(reader.readLine());

            trucks[i][0] = Integer.parseInt(st.nextToken());
            trucks[i][1] = Integer.parseInt(st.nextToken());
        }


        // 각 시간대별 주차된 트럭 수 계산
        int[] parkingTime = new int[102]; // 시간은 1부터 100까지이므로, 101개의 요소를 가진 배열 생성

        for (int[] truck : trucks) {
            parkingTime[truck[0]] += 1;   // 시작 시간에 +1
            parkingTime[truck[1]] -= 1;   // 끝나는 시간에 -1
        }

        // 요금 계산
        int totalCost=0;
        int currentTrucks = 0;

        for (int time = 1; time <= 100; time++) {
            currentTrucks += parkingTime[time]; // 누적 트럭 수 갱신

            if (currentTrucks == 1) {
                totalCost += a;
            } else if (currentTrucks == 2) {
                totalCost += 2 * b;
            } else if (currentTrucks == 3) {
                totalCost += 3 * c;
            }
        }
        System.out.print(totalCost);
    }
}