package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class BOJ_2852 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); 
        int team1Score = 0, team2Score = 0; 
        int team1Time = 0, team2Time = 0; 

        int lastMinute = 0, lastSecond = 0; 

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            int teamNumber = Integer.parseInt(input[0]);
            String[] time = input[1].split(":");
            int minute = Integer.parseInt(time[0]);
            int second = Integer.parseInt(time[1]);

            int elapsedTime = calculateElapsedTime(minute, second) - calculateElapsedTime(lastMinute, lastSecond);

            if (team1Score > team2Score) {
                team1Time += elapsedTime;
            } else if (team1Score < team2Score) {
                team2Time += elapsedTime;
            }

            if (teamNumber == 1) {
                team1Score++;
            } else if (teamNumber == 2) {
                team2Score++;
            }

            lastMinute = minute;
            lastSecond = second;
        }

        int remainingTime = calculateElapsedTime(48, 0) - calculateElapsedTime(lastMinute, lastSecond);
        if (team1Score > team2Score) {
            team1Time += remainingTime;
        } else if (team1Score < team2Score) {
            team2Time += remainingTime;
        }

        System.out.printf("%02d:%02d\n", team1Time / 60, team1Time % 60);
        System.out.printf("%02d:%02d\n", team2Time / 60, team2Time % 60);
    }

    private static int calculateElapsedTime(int minute, int second) {
        return minute * 60 + second;
    }
}