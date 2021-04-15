import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class P1953 {

	static int N, M, R, C, L;
	static int[][] tunnel, way;
	static Queue<Integer> queue;
	static boolean[][] visited;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = stoi(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = stoi(st.nextToken()); // 세로
			M = stoi(st.nextToken()); // 가로
			R = stoi(st.nextToken()); // 맨홀 y좌표
			C = stoi(st.nextToken()); // 	x좌표
			L = stoi(st.nextToken()); // 탈주 후 지난 시간
			tunnel = new int[N][M];
			way = new int[N][M];
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					tunnel[i][j] = stoi(st.nextToken());
				}
			}
			
			visited = new boolean[N][M];
			visited[R][C] = true; // 맨홀 위치 최초 방문
			way[R][C] = 1;
			
			queue = new ArrayDeque<>();
			queue.offer(R); // r , c 순서로 넣기( y , x )
			queue.offer(C);
			bfs();
			
			System.out.println("#" + t + " " + count());
		}
	}
	
	private static int count() {
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(way[i][j] > 0) cnt++;
			}
		}
		return cnt;
	}

	static int[] dc = {1, 0, -1, 0};
	static int[] dr = {0, 1, 0, -1};
	static int[][] dirs = {{}, {0, 1, 2, 3}, {1, 3}, {0, 2}, {0, 3}, {0, 1}, {1, 2}, {2, 3}}; // 터널 모양별 탐색 가능한 방향
	static void bfs() {
		while(!queue.isEmpty()) {
			int r = queue.poll();
			int c = queue.poll();
			// 최대 시간만큼 탐색
			if(way[r][c] == L) break;
			int tNum = tunnel[r][c];
			
			for(int dir : dirs[tNum]) {
				int nr = r + dr[dir];
				int nc = c + dc[dir];
				
				if(nr < 0 || nr >= N || nc < 0 || nc >= M || visited[nr][nc] || tunnel[nr][nc] == 0) continue;

				// 다음터널과 지금 터널 연결 확인
				int nextTnum = tunnel[nr][nc];
				boolean connected = false;
				
				// 현재 진행 방향의 반대가 다음 tnum의 방향에 포함돼있을때
				for (int nextDir : dirs[nextTnum]) {
					if(dir - 2 == nextDir || dir + 2 == nextDir) connected = true;
				}
				
				if(connected) {
					visited[nr][nc] = true;
					way[nr][nc] = way[r][c] + 1;
					queue.offer(nr);
					queue.offer(nc);
				}
			}
		}
	}

	static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
