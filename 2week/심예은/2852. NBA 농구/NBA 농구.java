import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader((System.in)));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());

        int team1Score = 0;
        int team2Score = 0;
        int team1Time = 0;
        int team2Time = 0;
        int teamNumber = 0;
        int prevGoalTime = 0;
        int currGoalTime = 0;
        int currentWinner = 0;

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(reader.readLine());
            teamNumber = Integer.parseInt(st.nextToken());
            String timeString = st.nextToken();

            int minutes = Integer.parseInt(timeString.split(":")[0]);
            int seconds = Integer.parseInt(timeString.split(":")[1]);

            currGoalTime = minutes * 60 + seconds;

            if(currentWinner == 1){
                team1Time += currGoalTime - prevGoalTime;
            } else if(currentWinner == 2) {
                team2Time += currGoalTime - prevGoalTime;
            }

            prevGoalTime = currGoalTime;

            if(teamNumber == 1){
                team1Score++;
            } else {
                team2Score++;
            }

            if (team1Score > team2Score) {
                currentWinner = 1;
            } else if(team2Score>team1Score){
                currentWinner = 2;
            } else {
                currentWinner = 0;
            }
        }

        if(currentWinner == 1){
            team1Time += 48 * 60 - currGoalTime;
        } else if(currentWinner == 2) {
            team2Time += 48*60 - currGoalTime;
        }

        writer.write(String.format("%02d:%02d\n", team1Time / 60, team1Time % 60));
        writer.write(String.format("%02d:%02d", team2Time / 60, team2Time % 60));

        reader.close();
        writer.flush();
        writer.close();
    }
}
