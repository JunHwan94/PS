package baekjoon.정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P1766 {

    static int N, M;
    static List<Integer>[] adjLists;
    static int[] inCounts;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        M = stoi(st.nextToken());

        adjLists = new ArrayList[N + 1];
        inCounts = new int[N + 1];
        for (int i = 1; i < N + 1; i++) {
            adjLists[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int prev = stoi(st.nextToken());
            int next = stoi(st.nextToken());
            adjLists[prev].add(next);
            inCounts[next]++;
        }

        topologySort();
    }

    private static void topologySort() {
        Queue<Integer> pq = new PriorityQueue<>();

        for (int i = 1; i < N + 1; i++) {
            if(inCounts[i] == 0){
                pq.offer(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
            int cur = pq.poll();
            sb.append(cur).append(" ");
            for (int next : adjLists[cur]) {
                if(--inCounts[next] == 0){
                    pq.offer(next);
                }
            }
        }

        System.out.println(sb);
    }

    static int stoi(String s){
        return Integer.parseInt(s);
    }
}