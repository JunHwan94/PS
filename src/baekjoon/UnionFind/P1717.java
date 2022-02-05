package baekjoon.UnionFind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1717 {

    static int N, M;
    static int[] id, size;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = stoi(st.nextToken());
        M = stoi(st.nextToken());
        id = new int[N + 1];
        size = new int[N + 1];

        for (int i = 0; i < N + 1; i++) {
            id[i] = i;
            size[i] = 1;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int cmd =  stoi(st.nextToken());
            int p = stoi(st.nextToken());
            int q = stoi(st.nextToken());
            if(cmd == 0){
                union(p, q);
            }else{
                if(check(p, q)){
                    System.out.println("YES");
                }else{
                    System.out.println("NO");
                }
            }
        }
    }

    static void union(int p, int q){
        int i = root(p);
        int j = root(q);
        if(i == j) return;
        id[i] = j;
        if(size[i] < size[j]){
            size[j] += size[i];
            id[i] = root(j);
        }else{
            size[i] += size[j];
            id[j] = root(i);
        }
    }

    static int root(int p){
        while(p != id[p]){
            id[p] = id[id[p]];
            p = id[p];
        }
        return p;
    }

    static boolean check(int p, int q){
        return root(p) == root(q);
    }

    static int stoi(String s){
        return Integer.parseInt(s);
    }
}
