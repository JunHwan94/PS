package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2605 {
	static int[] oArr;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		oArr = new int[N];
		int[] nArr = new int[N];
		StringTokenizer token = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			oArr[i] = i + 1;
			nArr[i] = Integer.parseInt(token.nextToken());
		}
		
		for(int i = 1; i < N; i++) {
			for(int j = i; j - 1 >= i - nArr[i]; j--) {
				swap(j, j - 1);
			}
		}
		
		for(int i = 0; i < N; i++) {
			System.out.print(oArr[i] + " ");
		}
	}
	
	static void swap(int i, int j) {
		int temp = oArr[i];
		oArr[i] = oArr[j];
		oArr[j] = temp;
	}
}
