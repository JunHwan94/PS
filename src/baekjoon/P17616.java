package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.function.Function;

public class P17616 {
    static class Node{
        int child;
        Node next;
        Node(int child, Node next){
            this.child = child;
            this.next = next;
        }
    }

    static int N, M, X, U, V;
    static Function<String, Integer> stoi = Integer::parseInt;
    static Node[] upAdj, downAdj;
    static boolean visited[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // N명의 학생 참가
        N = stoi.apply(st.nextToken());
        M = stoi.apply(st.nextToken());
        X = stoi.apply(st.nextToken());
        upAdj = new Node[100000];
        downAdj = new Node[100000];
        visited = new boolean[100000];

        // 두 학생 중 누가 더 잘했는지 알려줌
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = stoi.apply(st.nextToken());
            int v = stoi.apply(st.nextToken());
            downAdj[u] = new Node(v, downAdj[u]);
            upAdj[v] = new Node(u, upAdj[v]);
        }
        dfs(X, true, upAdj);
        visited[X] = false;
        dfs(X, false, downAdj);

        System.out.println(U + " " + (N - V + 1));
    }

    public static void dfs(int cur, boolean u, Node[] adj){
        if(visited[cur]) return;
        if(u) U++;
        else V++;

        visited[cur] = true;
        Node n = adj[cur];
        while(n != null){
            dfs(n.child, u, adj);
            n = n.next;
        }
    }
}
