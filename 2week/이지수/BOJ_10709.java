package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_10709 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		StringBuilder sb = new StringBuilder();
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int H = Integer.parseInt(st.nextToken());	
		int W = Integer.parseInt(st.nextToken());	
		char[][] arr = new char[H][W];
		for(int i=0; i<H; i++) {
			String str = bf.readLine();
			
			for(int j=0; j<W; j++) {
				arr[i][j] = str.charAt(j);
			}
		}
		
		for(int i=0; i<H; i++) {
			int time = 0;
			
			for(int j=0; j<W; j++) {
				
				if(arr[i][j] == 'c') {
					time = 1;
					sb.append("0 ");
				}
				
				else if(arr[i][j] == '.') {
					
					if(time == 0) {
						sb.append("-1 ");
					}
					else {
						sb.append(time + " ");
						time ++;
					}
				}
			}
			sb.append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bf.close();
		bw.close();
	}
}
