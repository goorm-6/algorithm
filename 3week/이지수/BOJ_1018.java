package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1018 {
	
	public static boolean[][] arr;
	public static int min = 64;
 
	public static void main(String[] args) throws IOException {
 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
 
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
 
		String[] board = new String[n];
		for (int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			board[i]=st.nextToken();}
		
		int sol = Integer.MAX_VALUE;
		
		for(int i=0;i<n-7;i++) {
			for(int j=0;j<m-7;j++) {
				int curSol = getSolution(i,j,board);
				
				if(sol >curSol) sol= curSol;
			}
		}
		System.out.println(sol);
		
	}
 
	
	public static int getSolution (int startRow, int startCol, String[] board) {
		String[] orgBoard = {"WBWBWBWB","BWBWBWBW"};
		int whiteSol=0;
		for(int i=0;i<8;i++) {
			int row=startRow+i;
			for (int j=0;j<8;j++) {
				int col = startCol+j;
				if(board[row].charAt(col) != orgBoard[row % 2].charAt(j)) whiteSol++;
			}
		}
		return Math.min(whiteSol, 64-whiteSol);
	}
}
