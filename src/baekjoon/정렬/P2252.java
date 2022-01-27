package baekjoon.정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P2252 {

    static int N, M;
    static int[] inCounts;
    static ArrayList<Integer>[] adjLists;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        M = stoi(st.nextToken());

        // 노드 초기화
        adjLists = new ArrayList[N + 1];
        for (int i = 1; i < N + 1; i++) {
            adjLists[i] = new ArrayList<>();
        }
        inCounts = new int[N + 1];

        // 전, 후 설정
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int prev = stoi(st.nextToken());
            int next = stoi(st.nextToken());
            adjLists[prev].add(next); // 다음 번호 저장
            inCounts[next]++; // 다음노드가 받는 이전 노드 갯수 증가
        }

        topologySort();
    }

    static void topologySort(){
        Queue<Integer> q = new ArrayDeque<>();
        // 초기 진입 차수 0인거 큐에 넣음
        for (int i = 1; i < inCounts.length; i++) {
            if(inCounts[i] == 0){
                q.offer(i);
            }
        }

        StringBuilder sb = new StringBuilder();

        while(!q.isEmpty()){
            int cur = q.poll();
            sb.append(cur).append(" ");
            // 다음 노드의 진입 차수 감소
            for (int next : adjLists[cur]) {
                inCounts[next]--;
                // 진입 차수 0이면 큐에 넣기
                if(inCounts[next] == 0) {
                    q.offer(next);
                }
            }
        }

        System.out.print(sb);
    }

    static int stoi(String s){
        return Integer.parseInt(s);
    }
}