package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.function.Function;

public class P15591 {
    static class Edge implements Comparable<Edge>{
        int to;
        long dist;
        Edge(int to, long dist){
            this.to = to;
            this.dist = dist;
        }
        @Override
        public int compareTo(Edge o) {
            return Long.compare(dist, o.dist);
        }
    }

    static int N;
    static Function<String, Integer> stoi = Integer::parseInt;
    static List<Edge>[] edgeList;
    static long[] dists;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = stoi.apply(st.nextToken());
        int Q = stoi.apply(st.nextToken());
        long INF = 1000000001;
        edgeList = new ArrayList[N + 1];
        dists = new long[N + 1];

        for (int i = 1; i < N + 1; i++) {
            edgeList[i] = new ArrayList<>();
        }

        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int from = stoi.apply(st.nextToken());
            int to = stoi.apply(st.nextToken());
            int dist = stoi.apply(st.nextToken());
            edgeList[from].add(new Edge(to, dist));
            edgeList[to].add(new Edge(from, dist));
            dists[i] = INF;
        }

        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int k = stoi.apply(st.nextToken());
            int v = stoi.apply(st.nextToken());
            int cnt = 0;
            Arrays.fill(dists, INF);
            dijkstra(v);
            for (int j = 1; j < N + 1; j++) {
                if(dists[j] >= k) cnt++;
            }
            System.out.println(cnt);
        }
    }

    static void dijkstra(int k){
        boolean[] visited = new boolean[N + 1];
        Queue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(k, 0));
        dists[k] = 0;
        while(!pq.isEmpty()){
            Edge e = pq.poll();
            int cur = e.to;
            if(visited[cur]) continue;
            visited[cur] = true;
            for(Edge edge : edgeList[cur]){
                if(dists[edge.to] > edge.dist){
                    dists[edge.to] = edge.dist;
                    pq.offer(new Edge(edge.to, dists[edge.to]));
                }
            }
        }
    }
}