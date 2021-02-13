package baekjoon.완전탐색.순열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.function.Function;
// 순열
// 풀이중
// 메모리초과
public class P1115 {
	static int N;
	static int[] oArr; // 원래 배열
	static int[] tArr; // 비교대상
	static int[] childArr; // 제시된 식에 따라 비교대상 배열로부터 만들어진 배열
	static boolean[] visited;
	static Function<String, Integer> stoi = Integer::parseInt;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = stoi.apply(br.readLine());
		oArr = new int[N];
		tArr = new int[N];
		childArr = new int[N];
		visited = new boolean[N + 1];
		StringTokenizer token = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			oArr[i] = stoi.apply(token.nextToken());
		}
		
		perm(0); // p와 같은 원소로 c만들기
		
		System.out.println(mq.size());
		System.out.println(mq.poll());
	}

	static Queue<Integer> mq = new PriorityQueue<>();
	static boolean isOver;
	static void perm(int depth) {
		if(isOver) return;
		if(depth == N) {
//			System.out.println(Arrays.toString(tArr));
			cPerm(0);
			if(isPerfect) {
				int cnt = 0;
				for(int i = 0; i < N; i++) {
					if(oArr[i] != tArr[i]) cnt++;
				}
				mq.offer(cnt);
			}
			return;
		}
			
		for(int i = 0; i < N; i++) {
			if(visited[i]) continue;
			visited[i] = true;
			tArr[depth] = oArr[i];
			perm(depth + 1);
			visited[i] = false;
		}
	}
	
	static boolean isPerfect;
	static void cPerm(int depth) {
		isPerfect = false;
		Set<Integer> cSet = new HashSet<>();
		childArr[0] = 0;
		cSet.add(0);
		for(int i = 1; i < N; i++) {
			childArr[i] = tArr[childArr[i - 1]];
			cSet.add(childArr[i]);
		}
//		System.out.println(Arrays.toString(childArr));
		if(cSet.size() == N) {
			isPerfect = true;
			isOver = true;
		}
//		System.out.println(isPerfect);
	}
}
