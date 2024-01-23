package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2979 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int[] arr = new int[101]; 

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int sum = 0;

        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            min = Math.min(min, start);
            max = Math.max(max, end);

            for (int j = start; j < end; j++) {
                arr[j]++;
            }
        }

        for (int i = min; i < max; i++) {
            switch (arr[i]) {
                case 1:
                    sum += A;
                    break;
                case 2:
                    sum += B * 2; 
                    break;
                case 3:
                    sum += C * 3; 
            }
        }

        System.out.println(sum);
    }
}