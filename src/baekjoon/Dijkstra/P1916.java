package baekjoon.Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P1916 {
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

    static int N, M;
    static List<Edge>[] adjLists;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = stoi(br.readLine());
        M = stoi(br.readLine());
        adjLists = new ArrayList[N + 1];
        for (int i = 1; i < N + 1; i++) {
            adjLists[i] = new ArrayList<>();
        }
        StringTokenizer st;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = stoi(st.nextToken());
            int to = stoi(st.nextToken());
            int dist = stoi(st.nextToken());
            adjLists[from].add(new Edge(to, dist));
        }

        st = new StringTokenizer(br.readLine());
        int depart = stoi(st.nextToken());
        int arrive = stoi(st.nextToken());

        int[] dists = new int[N + 1];
        Arrays.fill(dists, Integer.MAX_VALUE);
        dists[depart] = 0;

        Queue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(depart, 0));
        while(!pq.isEmpty()){
            Edge e = pq.poll();
            int cur = e.to;
            int cDist = e.dist;
            if(dists[cur] < cDist) {
                continue;
            }
            for (Edge ne : adjLists[cur]) {
                int next = ne.to;
                int nDist = ne.dist;
                if(dists[next] > cDist + nDist){
                    dists[next] = cDist + nDist;
                    pq.offer(new Edge(next, dists[next]));
                }
            }
        }

        System.out.println(dists[arrive]);
    }

    static int stoi(String s){
        return Integer.parseInt(s);
    }
}
