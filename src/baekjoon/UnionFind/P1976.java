package baekjoon.UnionFind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1976 {

    static int N, M;
    static int[] roots, size;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = stoi(br.readLine());
        M = stoi(br.readLine());
        roots = new int[N + 1];
        size = new int[N + 1];

        for (int i = 1; i < N + 1; i++) {
            roots[i] = i;
            size[i] = 1;
        }

        StringTokenizer st;
        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < N + 1; j++) {
                int connected = stoi(st.nextToken());
                if(connected == 1) {
                    union(i, j);
                }
            }
        }

        for (int i = 1; i < N + 1; i++) {
            System.out.print(roots[i] + " ");
        }

        st = new StringTokenizer(br.readLine());
        int p = stoi(st.nextToken());
        int q;
        while(st.hasMoreTokens()){
            q = stoi(st.nextToken());
            if(!check(p, q)){
                System.out.println("NO");
                return;
            }
            p = q;
        }

        System.out.println("YES");
    }

    static void union(int p, int q){
        int a = find(p);
        int b = find(q);
        if(a == b){
            return;
        }
        roots[a] = b;
        if(size[a] < size[b]){
            roots[a] = find(b);
            size[b] += size[a];
        }else{
            roots[b] = find(a);
            size[a] += size[b];
        }
    }

    static int find(int p){
        while(roots[p] != p){
            roots[p] = roots[roots[p]];
            p = roots[p];
        }
        return p;
    }

    static boolean check(int p, int q){
        return find(p) == find(q);
    }

    static int stoi(String s){
        return Integer.parseInt(s);
    }
}
