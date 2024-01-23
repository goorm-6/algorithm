package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1157 {

	 public static void main(String[] args) throws IOException {
		 
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        int[] arr = new int[26];

	        String text = br.readLine().toUpperCase();

	        int max = -1;
	        char st = '?';

	        for(int i=0; i<text.length(); i++) {
	            arr[text.charAt(i)-65]++;

	            if(max < arr[text.charAt(i)-65]) {
	                max = arr[text.charAt(i)-65];
	                st = text.charAt(i);
	            } else if (max == arr[text.charAt(i)-65])
	                st = '?';
	        }
	        System.out.println(st);
	    }

}
