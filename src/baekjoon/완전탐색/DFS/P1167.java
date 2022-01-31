package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P1167 {

    static class Edge{
        int to, dist;
        public Edge(int to, int dist){
            this.to = to;
            this.dist = dist;
        }
    }

    static int V;
    static List<Edge>[] adjLists;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        V = stoi(br.readLine());
        adjLists = new ArrayList[V + 1];
        for (int i = 1; i < V + 1; i++) {
            adjLists[i] = new ArrayList<>();
        }

        for (int i = 0; i < V; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = stoi(st.nextToken());
            int to;
            while((to = stoi(st.nextToken())) != -1){ // -1 입력되면 끝
                int dist = stoi(st.nextToken());
                adjLists[from].add(new Edge(to, dist));
            }
        }

        // 한 정점에서 가장 먼 정점 탐색
        visited = new boolean[V + 1];
        dfs(1, 0);
        // 다시 가장 먼 정점 탐색
        visited = new boolean[V + 1];
        dfs(maxNo, 0);

        System.out.println(maxDist);
    }

    static boolean[] visited;
    static int maxDist;
    static int maxNo;
    static void dfs(int cur, int dist){
        // dfs 종료
        if(visited[cur]){
            return;
        }
        // 갱신
        if(maxDist < dist) {
            maxDist = dist;
            maxNo = cur;
        }
        visited[cur] = true;
        // 인접 정점 탐색
        for (Edge edge : adjLists[cur]) {
            int next = edge.to;
            dfs(next, dist + edge.dist);
        }
    }

    static int stoi(String s){
        return Integer.parseInt(s);
    }
}