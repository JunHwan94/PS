package swea.D4;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P1238 {
	static int N, start;
	static int[][] connected;
	static int[] lengths;
	static boolean[] visited;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int t = 1; t <= 10; t++) {
			maxLength = 0;
			max = 0;
			String[] input = br.readLine().split(" ");
			N = stoi(input[0]);
			start = stoi(input[1]);
			connected = new int[101][101];
			lengths = new int[101];
			visited = new boolean[101];
			StringTokenizer token = new StringTokenizer(br.readLine());
			for(int i = 0; i < N / 2; i++) {
				int start = stoi(token.nextToken());
				int target = stoi(token.nextToken());
				connected[start][target] = 1;
			}
			bfs();
			for(int i = 1; i < 101; i++) {
				if(maxLength == lengths[i])
					max = Math.max(max, i);
			}
			System.out.println("#" + t + " " + max);
		}
	}
	
	static int maxLength;
	static int max;
	static void bfs() {
		// 방문체크
		visited[start] = true;
		// 큐생성
		Queue<Integer> q = new LinkedList<>();
		// 큐에 최초 값 넣기
		q.offer(start);
		// while 돌면서 연결된 거 큐에 넣기
		while(!q.isEmpty()) {
			int next = q.poll();
			for(int i = 1; i < 101; i++) {
				if(visited[i]) continue;
				if(connected[next][i] == 1) {
					lengths[i] = lengths[next] + 1;
					visited[i] = true;
					q.offer(i);
					maxLength = Math.max(maxLength, lengths[i]);
				}
			}
		}
	}

	static int stoi(String s) { return Integer.parseInt(s);	}
}
