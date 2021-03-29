package baekjoon.MST;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P6497 {
    static class Edge implements Comparable<Edge>{
        int from, to, length;
        public Edge(int from, int to, int length) {
            this.from = from;
            this.to = to;
            this.length = length;
        }

        @Override
        public int compareTo(Edge o) {
            return length - o.length;
        }
    }

    static int N, M;
    static int[] parents;
    static Queue<Edge> edgeQueue;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = "";
        while((input = br.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(input);
            M = stoi(st.nextToken());
            N = stoi(st.nextToken());
            if(M * N == 0) break;
            parents = new int[200001];
            edgeQueue = new PriorityQueue<>();
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                edgeQueue.offer(new Edge(stoi(st.nextToken()), stoi(st.nextToken()), stoi(st.nextToken())));
            }

            make();
            int allSum = 0, onSum = 0, count = 0;
            while(!edgeQueue.isEmpty()){
                Edge e = edgeQueue.poll();
                allSum += e.length;
                if(union(e.from, e.to)){
                    if(++count > M - 1) continue;
                    onSum += e.length;
                }
            }
            System.out.println(allSum - onSum);
        }
    }

    static void make(){
        for (int i = 0; i < 200001; i++)
            parents[i] = i;
    }

    static int findSet(int a){
        if(parents[a] == a) return a;
        return parents[a] = findSet(parents[a]);
    }

    static boolean union(int a, int b){
        int aRoot = findSet(a);
        int bRoot = findSet(b);
        if(aRoot == bRoot) return false;
        parents[bRoot] = aRoot;
        return true;
    }

    static int stoi(String s){
        return Integer.parseInt(s);
    }
}