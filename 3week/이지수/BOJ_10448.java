package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_10448 {
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int triangle[] = new int[45];
		for(int i = 0; i<45; i++) {
			triangle[i] = i*(i+1)/2;
		}
		
		int n =Integer.parseInt(br.readLine());
			
		for(int t=0; t<n; t++){
            int N = Integer.parseInt(br.readLine());

            if(triangleSum(N, triangle)) bw.write("1");
            else bw.write("0");

            bw.write("\n");
        }
        bw.flush();
		
	}
	
	public static Boolean triangleSum (int n, int triangle[]) {
		for(int i = 1; i<45; i++) {
			for(int j = 1; j<45; j++) {
				for(int k = 1; k<45; k++) {
					if( triangle[i] + triangle[j] + triangle[k]==n) return true;
				}
			}
		}
		return false;
	}
}
