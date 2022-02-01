package baekjoon.완전탐색.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P1967 {

    static class Edge{
        int to, dist;
        Edge(int to, int dist){
            this.to = to;
            this.dist = dist;
        }
    }

    static int N;
    static List<Edge>[] edgeLists;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = stoi(br.readLine());

        if(N == 1) {
            System.out.println(0);
            return;
        }

        edgeLists = new ArrayList[N + 1];
        for (int i = 1; i < N + 1; i++) {
            edgeLists[i] = new ArrayList<>();
        }

        for (int i = 1; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = stoi(st.nextToken());
            int to = stoi(st.nextToken());
            int dist = stoi(st.nextToken());
            edgeLists[from].add(new Edge(to, dist));
            edgeLists[to].add(new Edge(from, dist));
        }

        visited = new boolean[N + 1];
        dfs(N, 0);

        visited = new boolean[N + 1];
        dfs(maxNo, 0);

        System.out.println(maxDist);
    }

    static int maxNo, maxDist;
    static void dfs(int to, int dist){
        if(visited[to]){
            return;
        }
        if(maxDist < dist){
            maxDist = dist;
            maxNo = to;
        }
        visited[to] = true;
        for(Edge edge : edgeLists[to]){
            dfs(edge.to, dist + edge.dist);
        }
    }

    static int stoi(String s){
        return Integer.parseInt(s);
    }
}
