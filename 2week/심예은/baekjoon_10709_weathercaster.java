import java.io.*;
import java.util.StringTokenizer;

public class Cloud{
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int h = Integer.parseInt(tokenizer.nextToken());
        int w = Integer.parseInt(tokenizer.nextToken());

        for(int i = 0; i < h; i++) {
            String line = reader.readLine();
            StringBuilder builder = new StringBuilder();
            int minutesToCloud = -1;

            for(int j = 0; j < w; j++) {
                if(line.charAt(j) == 'c') {
                    minutesToCloud = 0;
                } else if(minutesToCloud != -1) {
                    minutesToCloud++;
                }
                builder.append(minutesToCloud).append(j < w - 1 ? " " : "");
            }
            writer.write(builder.toString());
            writer.newLine();
        }

        reader.close();
        writer.flush();
        writer.close();
    }
}

