package baekjoon.UnionFind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P16562{
    static int N, M, K;
    static int[] parents;
    static int[] costs;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = stoi(st.nextToken()); // 학생 수
        M = stoi(st.nextToken()); // 주어질 관계 수
        K = stoi(st.nextToken()); // 가진 돈
        st = new StringTokenizer(br.readLine());
        costs = new int[N + 1];
        costs[0] = 0;
        for (int i = 1; i <= N; i++) {
            int in = stoi(st.nextToken());
//            System.out.println(in);
            costs[i] = in;
        }
//        Arrays.stream(students).forEach(it -> System.out.println(it.cost));
        parents = new int[N + 1];
        make();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = stoi(st.nextToken());
            int b = stoi(st.nextToken());
//            if(findSet(a) != findSet(b))
                union(a, b); // 주어진 친구 맺기
        }

        System.out.println(Arrays.toString(parents));

        int min = 0;
        for (int i = 1; i <= N; i++) {
            if(findSet(i) != 0){
                min += costs[findSet(i)];
                union(0, findSet(i));
            }
        }
        System.out.println(min > K ? "Oh no" : min);
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
        if(costs[aRoot] < costs[bRoot]) parents[bRoot] = aRoot;
        else parents[aRoot] = bRoot;
        return true;
    }

    static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
