package baekjoon.Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P1753 {
    static class Edge implements Comparable<Edge>{
        int to, length;

        public Edge(int to, int length) {
            this.to = to;
            this.length = length;
        }

        @Override
        public int compareTo(Edge o) {
            return length - o.length;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = stoi(st.nextToken());
        int E = stoi(st.nextToken());
        int K = stoi(br.readLine());
        List<Edge>[] edgeList = new ArrayList[V + 1];
        for(int i = 0; i < V + 1; i++)
            edgeList[i] = new ArrayList<>();

        for(int i = 0; i < E; i++){
            st = new StringTokenizer(br.readLine());
            int from = stoi(st.nextToken());
            int to = stoi(st.nextToken());
            int length = stoi(st.nextToken());
            edgeList[from].add(new Edge(to, length));
        }

        int[] distance = new int[V + 1];
        boolean[] visited = new boolean[V + 1];

        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[K] = 0; // 시작점에서 시작점까지 거리는 0
        Queue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(K, 0));
        while(!pq.isEmpty()){
            Edge curEdge = pq.poll();
            int current = curEdge.to;
            if(visited[current]) continue;
            visited[current] = true;
            for(Edge edge : edgeList[current]){
                if(distance[edge.to] > distance[current] + edge.length){
                    distance[edge.to] = distance[current] + edge.length;
                    pq.offer(new Edge(edge.to, distance[edge.to]));
                }
            }
        }
        for (int i = 1; i < V + 1; i++)
            System.out.println(distance[i] == Integer.MAX_VALUE ? "INF" : distance[i]);
    }

    static int stoi(String s){
        return Integer.parseInt(s);
    }
}
