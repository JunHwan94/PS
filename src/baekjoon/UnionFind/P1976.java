package baekjoon.UnionFind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1976 {
    static int N, M; // 도시 수, 여행계획에 속한 도시 수(중복가능)
    static int[] cities;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = stoi(br.readLine());
        M = stoi(br.readLine());
        cities = new int[N + 1];
        make();

        StringTokenizer st;
        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++) {
                if(stoi(st.nextToken()) == 1)
                    union(i, j);
            }
        }
        st = new StringTokenizer(br.readLine());
        int start = stoi(st.nextToken());
        for(int i = 1; i < M; i++){
            int end = stoi(st.nextToken());
            if(findSet(start) != findSet(end)) { // 연결되어있지 않으면 수행
                System.out.println("NO");
                return;
            }
            start = end;
        }
        System.out.println("YES");
    }

    static void make() {
        for (int i = 1; i <= N; i++) {
            cities[i] = i;
        }
    }

    static int findSet(int a) {
        if(cities[a] == a) return a;
        return cities[a] = findSet(cities[a]);
    }

    static boolean union(int a, int b) {
        int aRoot = findSet(a);
        int bRoot = findSet(b);
        if(aRoot == bRoot) return false;
        cities[bRoot] = aRoot;
        return true;
    }

    static int stoi(String s){
        return Integer.parseInt(s);
    }
}
