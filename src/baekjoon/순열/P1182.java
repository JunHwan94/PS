package baekjoon.순열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.function.Function;

public class P1182 {
	static int N;
	static int S;
	static int[] inArr;
	static boolean[] selected;
	static Function<String, Integer> stoi = Integer::parseInt;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		
		N = stoi.apply(token.nextToken());
		S = stoi.apply(token.nextToken());
		inArr = new int[N];
		selected = new boolean[N + 1];
		
		token = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++)
			inArr[i] = stoi.apply(token.nextToken());
		
		part(0);
		System.out.println(cnt);
	}

	static int cnt;
	static void part(int idx) {
		if(idx == N) {
			int sum = 0;
			boolean selectNothing = true;
			for(int i = 0; i < N; i++) {
				if(selected[i]) {
					sum += inArr[i];
					selectNothing = false;
				}
			}
			if(sum == S && !selectNothing) cnt++;
			return;
		}

		selected[idx] = true;
		part(idx + 1);
		
		selected[idx] = false;
		part(idx + 1);
	}
}
