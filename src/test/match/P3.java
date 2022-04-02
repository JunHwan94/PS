package test.match;

import java.util.HashSet;
import java.util.Set;

public class P3 {
    public static void main(String[] args) {
        System.out.println(solution(8, new int[][]{{0,1},{1,2},{2,3},{4,0},{5,1},{6,1},{7,2},{7,3},{4,5},{5,6},{6,7}}, 4, 0, 3));
    }

    static int[][] connected;
    static int N, K, A, B;
    public static int solution(int n, int[][] edges, int k, int a, int b) {
        N = n;
        K = k;
        A = a;
        B = b;

        connected = new int[n][n];
        for (int i = 0; i < edges.length; i++) {
            int p1 = edges[i][0];
            int p2 = edges[i][1];
            connected[p1][p2] = 1;
            connected[p2][p1] = 1;
        }

        set = new HashSet<>();
        dfs(a, 0, new HashSet<>());

        for (Edge e : set) {
            System.out.println(e.hashCode);
        }
        return set.size();
    }

    static Set<Edge> set;
    static void dfs(int p, int d, HashSet<Edge> set1){
        if(d > K){
            return;
        }
        if(p == B){
            set.addAll(set1);
            return;
        }
        for (int i = 0; i < N; i++) {
            if(connected[p][i] == 1){
                set1.add(new Edge(p, i));
                dfs(i, d + 1, new HashSet<>(set1));
            }
        }
    }

    static class Edge{
        int p1, p2;
        String hashCode;
        Edge(int p1, int p2){
            this.p1 = p1;
            this.p2 = p2;

            int small = Math.min(p1, p2);
            int big = Math.max(p1, p2);
            hashCode = small + "" + big;
        }

        @Override
        public boolean equals(Object obj) {
            return p1 == ((Edge)obj).p1 && p2 == ((Edge)obj).p2 || p2 == ((Edge)obj).p1 && p1 == ((Edge)obj).p2;
        }

        @Override
        public int hashCode() {
            return Integer.parseInt(hashCode);
        }
    }
}
