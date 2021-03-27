package baekjoon.MST;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class P17472 {
	static class Edge implements Comparable<Edge>{
		int from, to;
		double cost;
		public Edge(int from, int to, double cost) {
			super();
			this.from = from;
			this.to = to;
			this.cost = cost;
		}
		@Override
		public int compareTo(Edge o) {
			return Double.compare(this.cost, o.cost);
		}
	}
	
	static int N, M, V;
	static int[][] map;
	static boolean[][] visited;
	static int parents[];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = stoi(st.nextToken());
		M = stoi(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++)
				map[i][j] = stoi(st.nextToken());
		}
		int iCnt = 2;
		for (int i = 0; i < N; i++)
			for (int j = 0; j < M; j++)
				if(map[i][j] == 1 && !visited[i][j])
					numbering(j, i, iCnt++);
		V = iCnt - 2; // 섬 갯수
		
		// 다리 연결
		visited = new boolean[N][M];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j] != 0) {
					for(int dir = 0; dir < 4; dir++) {
						// dfs 수행,
						buildBridge(j, i, dir, map[i][j], 0, 0);
					}
				}
			}
		}
		
		// 길이로 오름차순 정렬
		Collections.sort(edgeList);
		parents = new int[V + 2]; // 섬번호로 unionfind하므로 섬 갯수보다 2크게
		make();
		int result = 0;
		 // 선택한 다리 수
		int count = 0;
		for(Edge edge : edgeList) {
			if(union(edge.from, edge.to)) { // 사이클이 발생하지 않으면
				result += edge.cost; // 비용 누적
				if(++count == V - 1) break;
			}
		}
		if(V - 1 != count) result = -1; // 섬갯수 - 1만큼 다리 못놓으면 모두 연결 실패
		System.out.println(result == 0 ? -1 : result);
	}
	
	static void make() {
		for (int i = 0; i < V + 2; i++) {
			parents[i] = i;
		}
	}
	
	static int findSet(int a) {
		if(parents[a] == a) return a;
		return parents[a] = findSet(parents[a]);
	}
	
	static boolean union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		if(aRoot == bRoot) return false;
		parents[bRoot] = aRoot;
		return true;
	}
	
	static List<Edge> edgeList = new ArrayList<>();
	static void buildBridge(int x, int y, int dir, int from, int to, int length) {
		if(to != 0) {
			// 도착지까지 포함한 길이가 2초과인 다리 간선으로 더하기.
			if(length > 2)
				edgeList.add(new Edge(from, to, length - 1)); // 길이는 도착지까지 포함하므로 -1 해줌
			return;
		}
		
		int nx = x + dx[dir];
		int ny = y + dy[dir];
		if(nx < 0 || nx >= M || ny < 0 || ny >= N) return;
		if(visited[ny][nx]) return;
		visited[ny][nx] = true;
		to = map[ny][nx];		
		buildBridge(nx, ny, dir, from, to, length + 1);
		visited[ny][nx] = false;
	}

	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	static void numbering(int x, int y, int iNum) {
		map[y][x] = iNum;
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {x, y});
		while(!q.isEmpty()) {
			x = q.peek()[0];
			y = q.poll()[1];
			for(int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(nx < 0 || nx >= M || ny < 0 || ny >= N) continue;
				if(visited[ny][nx]) continue;
				if(map[ny][nx] == 1) {
					visited[ny][nx] = true;
					q.offer(new int[] {nx, ny});
					map[ny][nx] = iNum;
				}
			}
		}
	}
	
	private static int stoi(String s) {
		return Integer.parseInt(s);
	}
}