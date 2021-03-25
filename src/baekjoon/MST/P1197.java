package baekjoon.MST;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
// 최소 스패닝 트리 - 크루스칼
public class P1197 {
    static class Edge implements Comparable<Edge>{
        int from, to, cost;
        Edge(int from, int to, int cost){
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }

    static int V, E;
    static List<Edge> edgeList;
    static int[] parents;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = stoi(st.nextToken());
        E = stoi(st.nextToken());

        parents = new int[V + 1];
        edgeList = new ArrayList<>();
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            edgeList.add(new Edge(stoi(st.nextToken()), stoi(st.nextToken()), stoi(st.nextToken())));
        }
        Collections.sort(edgeList);
        make();
        int result = 0;
        // 선택한 간선 수
        int count = 0;
        for(Edge edge : edgeList) {
            if(union(edge.from, edge.to)) { // 사이클이 발생하지 않으면
                result += edge.cost; // 비용 누적
                if(++count == V - 1) break;
            }
        }
        System.out.println(result);
    }

    static void make() {
        for (int i = 1; i < V; i++) {
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

    static int stoi(String s){
        return Integer.parseInt(s);
    }
}