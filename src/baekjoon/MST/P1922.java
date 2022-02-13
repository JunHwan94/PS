package baekjoon.MST;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class P1922 {
    static class Edge implements Comparable<Edge>{
        int from, to, dist;

        Edge(int from, int to, int dist){
            this.from = from;
            this.to = to;
            this.dist = dist;
        }

        @Override
        public int compareTo(Edge o) {
            return dist - o.dist;
        }
    }

    static int[] id, size;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = stoi(br.readLine());
        int M = stoi(br.readLine());

        Queue<Edge> pq = new PriorityQueue<>();
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = stoi(st.nextToken());
            int to = stoi(st.nextToken());
            int dist = stoi(st.nextToken());
            pq.offer(new Edge(from, to, dist));
        }

        id = new int[N + 1];
        size = new int[N + 1];
        for (int i = 1; i < N + 1; i++) {
            id[i] = i;
            size[i] = 1;
        }

        int sum = 0;
        while(!pq.isEmpty()){
            Edge e = pq.poll();
            if(!check(e.from, e.to)){
                union(e.from, e.to);
                sum += e.dist;
            }
        }

        System.out.println(sum);
    }

    static void union(int p, int q){
        int a = root(p);
        int b = root(q);
        if(a == b) {
            return;
        }
        if(size[a] < size[b]){
            id[a] = b;
            size[b] += size[a];
        }else{
            id[b] = a;
            size[a] += size[b];
        }
    }

    static boolean check(int p, int q){
        return root(p) == root(q);
    }

    static int root(int p){
        while(p != id[p]){
            p = id[p];
        }
        return p;
    }

    static int stoi(String s){
        return Integer.parseInt(s);
    }
}
