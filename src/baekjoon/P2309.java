package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P2309 {
	static int[] dwarfs;
	static int[] selected;
	static boolean[] visited;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		dwarfs = new int[9];
		selected = new int[7];
		visited = new boolean[9];
		for(int i = 0; i < 9; i++) {
			dwarfs[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(dwarfs);
		perm(0, 0);
		for(int i = 0; i < 7; i++) {			
			System.out.println(selected[i]);
		}
	}

	static void perm(int cnt, int sum) {
		if(cnt == 7 && sum == 100) {
			int dCnt = 0;
			for(int i = 0; i < 9; i++) {
				if(visited[i]) selected[dCnt++] = dwarfs[i];
			}
			return;
		}else if(cnt == 7) {
			return;
		}
		
		for(int i = 0; i < 9; i++) {
			if(visited[i]) continue;
			visited[i] = true;
			perm(cnt + 1, sum + dwarfs[i]);
			visited[i] = false;
		}
	}
}
