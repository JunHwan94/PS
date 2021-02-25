package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2563 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] board = new int[100][100];
		int N = Integer.parseInt(br.readLine());
		StringTokenizer token;
		int cnt = 0;
		for(int n = 0; n < N; n++) {
			token = new StringTokenizer(br.readLine());
			int sx = Integer.parseInt(token.nextToken());
			int sy = Integer.parseInt(token.nextToken());
			for(int i = sy; i < sy + 10; i++) {
				for(int j = sx; j < sx + 10; j++) {
					if(board[i][j] == 0) cnt++;
					board[i][j] = 1;
				}
			}
		}
		System.out.println(cnt);
	}

}
