import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] inputNums = new int[n];
        for(int i = 0; i < n; i++) {
            inputNums[i] = Integer.parseInt(br.readLine());
        }
        int[] triNum = new int[45];
        for(int i = 1; i < 45; i++){
            triNum[i] = i * (i + 1) / 2;
        }
        for(int i = 0; i < n; i++) {
            boolean found = false;
            for(int j = 1; j < 45; j++){
                for(int k = 1; k < 45; k++) {
                    for(int l = 1; l < 45; l++) {
                        if(inputNums[i] == triNum[j] + triNum[k] + triNum[l]) {
                            found = true;
                        }
                    }
                }
            }
            if(found) System.out.println(1);
            else System.out.println(0);
        }
    }
}
