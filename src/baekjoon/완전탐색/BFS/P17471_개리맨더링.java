package baekjoon.완전탐색.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P17471_개리맨더링 {

	static int N;
	static int[] pop;
	static boolean[][] connected;
	static boolean[] nVisited, vVisited;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = stoi(br.readLine()) ;// 구역의 개수
		pop = new int[N + 1]; // 구역별 인구수, 1 ~ N
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++)
			pop[i] = stoi(st.nextToken());
	
		connected = new boolean[N + 1][N + 1];
		for (int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int adjCnt = stoi(st.nextToken());
			for (int j = 0; j < adjCnt; j++) {
				int to = stoi(st.nextToken());
				connected[i][to] = connected[to][i] = true;
			}
		}
		
		nVisited = new boolean[N + 1];
		supSet(1);
		
		System.out.println(min == Integer.MAX_VALUE ? -1 : min);
	}
	
	static Set<Integer> sSet; // 조합 선택한 set
	static Set<Integer> nSet; // 선택안한 set
	static Set<Integer> tSet;
	// 부분집합 - 최대 N - 1 개 선택해야 2개로 나누기 가능
	static void supSet(int cnt) {
		if(cnt == N) {
			sSet = new HashSet<>();
			nSet = new HashSet<>();
			int sPopCnt = 0, nPopCnt = 0;
			
			// 방문 여부로 조합 선택 확인
			for (int i = 1; i < nVisited.length; i++) {
				if(nVisited[i]) {
					System.out.print(i);
					sPopCnt += pop[i];
					sSet.add(i);
				} else {
					nPopCnt += pop[i];
					nSet.add(i);
				}
			}
			for (int i : nSet) {
				System.out.print(i);
			}
			
			tSet = new HashSet<>();
			int selOne = 0;
			if(sSet.size() > 0) selOne = (int)sSet.toArray()[0];
			// bfs()로 선택한것들 연결돼있는지 확인
			vVisited = new boolean[N + 1];
			if(selOne > 0) bfs(selOne, sSet);
			
			// 선택한 구역들 연결 가능 여부
			boolean sConnected = false;
			// sSet에서 tSet을 빼서 확인
			sSet.removeAll(tSet);
			if(sSet.size() == 0) sConnected = true;
				
			tSet.clear();
			int notSelOne = 0;
			if(nSet.size() > 0) notSelOne = (int)nSet.toArray()[0];
			// 조합에 속하지않은 것들도 확인
			if(notSelOne > 0) bfs(notSelOne, nSet);
			else return;
			if(tSet.size() == 0) return;
			
			boolean nConnected = false;
			nSet.removeAll(tSet);
			if(nSet.size() == 0) nConnected = true;
			
			// 같은 선거구끼리 다 연결돼있으면 인구 차이 최소값 갱신
			if(sConnected && nConnected)
				min = Math.min(min, Math.abs(sPopCnt - nPopCnt));
			return;
		}

		nVisited[cnt] = true;
		supSet(cnt + 1);

		nVisited[cnt] = false;
		supSet(cnt + 1);
	}

	static int min = Integer.MAX_VALUE;
	static void bfs(int i, Set<Integer> originSet) {
		Queue<Integer> q = new ArrayDeque<>();
		q.offer(i);
		vVisited[i] = true;
		tSet.add(i);

		while(!q.isEmpty()) {
			int n = q.poll();
			// 탐색하며 연결된 것들은 tSet에 저장
			for (int j = 1; j <= N; j++) {
				if(n == j) continue;
				if(!connected[n][j] || vVisited[j] || !originSet.contains(j)) continue;
				vVisited[j] = true;
				q.offer(j);
				tSet.add(j);
			}
		}
	}
	
	static int stoi(String s) {
		return Integer.parseInt(s);
	}
}