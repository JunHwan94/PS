package baekjoon.UnionFind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1717 {
    static int N, M;
    static int parents[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer token = new StringTokenizer(br.readLine());
        N = stoi(token.nextToken());
        M = stoi(token.nextToken());
        parents = new int[N + 1];
        make();
        for(int m = 0; m < M; m++) {
            token = new StringTokenizer(br.readLine());
            int cmd = stoi(token.nextToken());
            int a = stoi(token.nextToken());
            int b = stoi(token.nextToken());
            if(cmd == 0) union(a, b); // 0 : union, 1 : find
            else sb.append(findSet(a) == findSet(b) ? "YES" : "NO").append('\n');
        }
        sb.append('\n');
        System.out.println(sb);
    }

    static void make() {
        for (int i = 1; i <= N; i++) {
            parents[i] = i;
        }
    }

    static int findSet(int a) {
        if(parents[a] == a) return a;
        return parents[a] = findSet(parents[a]);
    }

    static boolean union(int a, int b) {
        int aRoot = findSet(a);
        int bRoot = findSet(b);
        if(aRoot == bRoot) return false;
        parents[bRoot] = aRoot;
        return true;
    }

    static int stoi(String s) { return Integer.parseInt(s); }
}
