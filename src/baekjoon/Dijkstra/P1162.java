package baekjoon.Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//public class P1162 {
//    static class Edge implements Comparable<Edge>{
//        int from, to, roadPackCnt;
//        long length;
//
//        public Edge(int to, long length) {
//            this.to = to;
//            this.length = length;
//        }
//
//        public Edge(int to, long length, int roadPackCnt) {
//            this.to = to;
//            this.length = length;
//            this.roadPackCnt = roadPackCnt;
//        }
//
//        @Override
//        public int compareTo(@NotNull Edge o) {
//            return Long.compare(length, o.length);
//        }
//    }
//
//    static int N, M, K;
//    static List<Edge>[] edgeList;
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        N = stoi(st.nextToken()); // 도시 수
//        M = stoi(st.nextToken()); // 도로 수
//        K = stoi(st.nextToken()); // 포장할 도로 수
//
//
//        edgeList = new ArrayList[N + 1];
//        for(int i = 0; i < N + 1; i++) edgeList[i] = new ArrayList<>();
//        for (int i = 0; i < M; i++){
//            st = new StringTokenizer(br.readLine());
//            edgeList[stoi(st.nextToken())].add(new Edge(stoi(st.nextToken()), stoi(st.nextToken())));
//        }
//
////        inEdges = new Edge[M];
////        for (int i = 0; i < M; i++){
////            st = new StringTokenizer(br.readLine());
////            inEdges[i] = new Edge(stoi(st.nextToken()), stoi(st.nextToken()), (long)stoi(st.nextToken()));
////        }
//
////        selected = new boolean[M];
////        supSet(0, 0);
//        selectEdges();
//
//        System.out.println(min);
//    }
//
//    static long min = Long.MAX_VALUE;
////    static boolean[] selected;
////    static void supSet(int cnt, int selCnt){
////        if(cnt == M || selCnt == K) {
////            selectEdges();
////            return;
////        }
////
////        selected[cnt] = true;
////        supSet(cnt + 1, selCnt + 1);
////        selected[cnt] = false;
////        supSet(cnt + 1, selCnt);
////    }
//
//    static void selectEdges(){
//
////        for (int i = 0; i < M; i++){
////            long length = selected[i] ? 0 : inEdges[i].length;
////            edgeList[inEdges[i].from].add(new Edge(inEdges[i].to, length));
////        }
//
//        long[] distance = new long[N + 1];
//        boolean[][] visited = new boolean[N + 1][K + 1];
//
//        Arrays.fill(distance, Integer.MAX_VALUE);
//        distance[1] = 0; // 서울 : 1
//        Queue<Edge> pq = new PriorityQueue<>();
//        pq.offer(new Edge(1, 0L, 0));
//        while(!pq.isEmpty()){
//            Edge curEdge = pq.poll();
//            int roadPackCnt = curEdge.roadPackCnt;
//            int cur = curEdge.to;
//            if(visited[cur][roadPackCnt]) continue;
//            int cnt = 0;
//            for(Edge edge : edgeList[cur]){
//                if(cnt == roadPackCnt) {
//                    if (distance[edge.to] > distance[cur] + edge.length) {
//                        distance[edge.to] = distance[cur] + edge.length;
//                        visited[cur][roadPackCnt] = true;
//                        pq.offer(new Edge(edge.to, distance[edge.to], roadPackCnt));
//                    }
//                }
//            }
//            if(roadPackCnt < K) {
//                cnt = 0;
//                for (Edge edge : edgeList[cur]) {
//                    if(cnt == roadPackCnt) {
////                    if (distance[edge.to] > distance[cur] + edge.length) {
//                        distance[edge.to] = distance[cur];
//                        visited[cur][roadPackCnt + 1] = true;
//                        pq.offer(new Edge(edge.to, distance[edge.to], roadPackCnt + 1));
////                    }
//                    }
//                }
//            }
//        }
//        min = Math.min(min, distance[N]);
//    }
//
//    static int stoi(String s){
//        return Integer.parseInt(s);
//    }
//}

public class P1162 {
    static final long INF = (long)1e18;
    static int n, m, k;
    static long dist[][];
    static List<Node>[] adj;
    static class Node implements Comparable<Node> {
        int u, k;
        long d;

        Node(int u, long d) {
            this.u = u;
            this.d = d;
        }
        Node(int u, long d, int k) {
            this.u = u;
            this.d = d;
            this.k = k; // 포장횟수
        }
        public int compareTo(Node o) {
            return Long.compare(this.d, o.d);
        }
    }
    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = stoi(st.nextToken());
        m = stoi(st.nextToken());
        k = stoi(st.nextToken())+1;
        dist = new long[n][k];
        adj = new List[n];
        for(int i = 0; i < n; i++) {
            for (int j = 0; j < k; j++) {
                dist[i][j] = INF;
            }
            adj[i] = new ArrayList<>();
        }
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u, v, d;
            u = stoi(st.nextToken())-1;
            v = stoi(st.nextToken())-1;
            d = stoi(st.nextToken());
            adj[u].add(new Node(v, d));
            adj[v].add(new Node(u, d));
        }
        dijkstra(0);
        long res = INF;
        for(int i = 0; i < k; i++) {
            res = Math.min(res, dist[n-1][i]);
        }
//		System.out.println(Arrays.deepToString(dist));
        System.out.println(res);
    }
    static int stoi(String s) {
        return Integer.parseInt(s);
    }
    static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0, 0));
        dist[0][0] = 0;
        while(!pq.isEmpty()) {
            Node curr = pq.poll();
            int nextK = curr.k + 1;
            if(dist[curr.u][curr.k] < curr.d) continue;
            for(Node next: adj[curr.u]) {
                // 포장 가능
                if( nextK < k) {
                    if(dist[next.u][nextK] > curr.d) {
                        dist[next.u][nextK] = curr.d;
                        pq.add(new Node(next.u, dist[next.u][nextK], nextK));
                    }
                }
                // 그냥 감
                if(dist[next.u][curr.k] > curr.d + next.d) {
                    dist[next.u][curr.k] = curr.d + next.d;
                    pq.add(new Node(next.u, dist[next.u][curr.k], curr.k));
                }
            }
        }
    }
}