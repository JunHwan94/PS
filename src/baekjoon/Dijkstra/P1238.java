package baekjoon.Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P1238 {
    static class Edge implements Comparable<Edge>{
        int to, dist;

        Edge(int to, int dist){
            this.to = to;
            this.dist = dist;
        }

        @Override
        public int compareTo(Edge o) {
            return dist - o.dist;
        }
    }

    static int N, M, X, INF = Integer.MAX_VALUE;
    static List<Edge>[] adjLists;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = stoi(st.nextToken());
        M = stoi(st.nextToken());
        X = stoi(st.nextToken());

        adjLists = new ArrayList[N + 1];
        for (int i = 1; i < N + 1; i++) {
            adjLists[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = stoi(st.nextToken());
            int to = stoi(st.nextToken());
            int dist = stoi(st.nextToken());
            adjLists[from].add(new Edge(to, dist)); // 단방향
        }

        int[] totalDists = new int[N + 1];

        for (int i = 1; i < N + 1; i++) {
            int[] dists = new int[N + 1];
            Arrays.fill(dists, INF);
            dists[i] = 0;

            Queue<Edge> pq = new PriorityQueue<>();
            pq.offer(new Edge(i, 0));

            while(!pq.isEmpty()){
                Edge e = pq.poll();
                int cur = e.to;
                int dist = e.dist;
                if(dists[cur] < dist) continue;
                for (Edge ne : adjLists[cur]){
                    if(dists[ne.to] > dist + ne.dist){
                        dists[ne.to] = dist + ne.dist;
                        pq.offer(new Edge(ne.to, dists[ne.to]));
                    }
                }
            }
            totalDists[i] = dists[X];
        }

        int[] dists = new int[N + 1];
        Arrays.fill(dists, INF);
        dists[X] = 0;

        Queue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(X, 0));

        while(!pq.isEmpty()){
            Edge e = pq.poll();
            int cur = e.to;
            int dist = e.dist;
            if(dists[cur] < dist) continue;
            for (Edge ne : adjLists[cur]){
                if(dists[ne.to] > dist + ne.dist){
                    dists[ne.to] = dist + ne.dist;
                    pq.offer(new Edge(ne.to, dists[ne.to]));
                }
            }
        }
        for (int i = 1; i < N + 1; i++) {
            totalDists[i] += dists[i];
        }

        int max = 0;
        for (int i = 1; i < N + 1; i++) {
            max = Math.max(max, totalDists[i]);
        }
        System.out.println(max);
    }

    static int stoi(String s){
        return Integer.parseInt(s);
    }
}