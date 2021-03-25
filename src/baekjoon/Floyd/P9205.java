package baekjoon.Floyd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 맥주 마시면서 걸어가기 - 플로이드 워셜
public class P9205 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = stoi(br.readLine());
		for(int t = 1; t <= T; t++) {
			int N = stoi(br.readLine());
			int[][] loc = new int[N + 2][2];
			boolean[][] reachable = new boolean[N + 2][N + 2];
			StringTokenizer st;
			for(int i = 0; i < N + 2; i++) {
				st = new StringTokenizer(br.readLine());
				loc[i][0]= stoi(st.nextToken());
				loc[i][1]= stoi(st.nextToken());
			}
			
			int[][] matrix = new int[N + 2][N + 2];
			for (int i = 0; i < N + 2; i++) {
				for (int j = i + 1; j < N + 2; j++) {
					// 각 좌표로 정점 간의 거리 계산
					int dist = Math.abs(loc[i][0] - loc[j][0]) + Math.abs(loc[i][1] - loc[j][1]);
					matrix[i][j] = matrix[j][i] = dist; 
				}
			}

			for (int i = 0; i < N + 2; i++) {
				for (int j = i + 1; j < N + 2; j++) {
					if(matrix[i][j] <= 1000) { // 1000 이하면 갈 수 있음
						reachable[i][j] = reachable[j][i] = true;
					}
				}
			}
			
			for(int k = 0; k < N + 2; k++) { // 경유지
				for(int i = 0; i < N + 2; i++) { // 출발지
					if(i == k) continue;
					for(int j = i + 1; j < N + 2; j++) { // 도착지
						if(reachable[i][k] && reachable[k][j])
							reachable[i][j] = reachable[j][i] = true;
					}
				}
			}
			System.out.println(reachable[0][N + 1] ? "happy" : "sad");
		}
	}
	
	static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
