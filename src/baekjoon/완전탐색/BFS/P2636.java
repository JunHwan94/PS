package baekjoon.완전탐색.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P2636 {
	static class Node{
		int r, c; 
		boolean isCheese, erasable;
		Node(int r, int c){
			this.r = r;
			this.c = c;
		}
		Node(int r, int c, boolean isCheese, boolean erasable){
			this.r = r;
			this.c = c;
			this.isCheese = isCheese;
			this.erasable = erasable;
		}
	}
	
	static int R, C;
	static Node[][] plate;
	static boolean[][] visited;
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = stoi(st.nextToken());
		C = stoi(st.nextToken());

		plate = new Node[R][C];
		visited = new boolean[R][C];
		int oneCnt = 0;
		for(int r = 0; r < R; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < C; c++) {
				int input = stoi(st.nextToken());
				plate[r][c] = new Node(r, c, input == 1, false);
				if(input == 1) oneCnt++;
			}
		}
		int initCnt = oneCnt; // 처음 갯수
		
		// 끝 Node들이 들어있는 큐
		Queue<Node> q = new LinkedList<>();
		for(int c = 0; c < C; c++) { // 위, 아래 변
			q.offer(new Node(0, c));
			q.offer(new Node(R - 1, c));
		}
		for(int r = 1; r < R - 1; r++) { // 맨위, 맨아래 Node 제외한 왼쪽, 오른쪽 변
			q.offer(new Node(r, 0));
			q.offer(new Node(r, C - 1));
		}
		
		int time = 0;
		while(oneCnt > 0) {
			Queue<Node> nq = new LinkedList<>(q);
			visited = new boolean[R][C];
			findEndOfCheese(nq);
			// 2중 for 돌면서 지우기 표시된 애들 지우기
			for(int r = 0; r < R; r++) {
				for (int c = 0; c < C; c++) {
					if(plate[r][c].erasable) {
						plate[r][c].isCheese = false;
						plate[r][c].erasable = false;
					}
				}
			}

			oneCnt = 0;
			// 녹고 남은 치즈조각의 수 저장
			for(int r = 0; r < R; r++) {
				for (int c = 0; c < C; c++) {
					if(plate[r][c].isCheese) oneCnt++;
				}
			}
			
			if(oneCnt > 0) min = Math.min(min, oneCnt);
			time++;
		}

		System.out.println(time);
		System.out.println(min == Integer.MAX_VALUE ? initCnt : min);
	}

	static int[] dc = {1, 0, -1, 0};
	static int[] dr = {0, 1, 0, -1};
	static void findEndOfCheese(Queue<Node> q) {
		while(!q.isEmpty()) {
			int r = q.peek().r;
			int c = q.poll().c;
			// 끝 변에서 도달할 수 있는 치즈(1)들 지우기 erasable 표시
			for(int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				if(nc < 0 || nc >= C || nr < 0 || nr >= R) continue;
				if(visited[nr][nc]) continue;
				if(plate[nr][nc].isCheese) {
					visited[nr][nc] = true;
					plate[nr][nc].erasable = true;
				}else {
					visited[nr][nc] = true;
					q.offer(new Node(nr, nc));
				}
			}
		}
	}
	
	static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
