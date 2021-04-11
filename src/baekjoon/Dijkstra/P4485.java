package baekjoon.Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 녹색 옷 입은 애가 젤다지? 아니
public class P4485 {
    static class Edge implements Comparable<Edge>{
        int toX, toY, length;

        public Edge(int toX, int toY, int length) {
            this.toX = toX;
            this.toY = toY;
            this.length = length;
        }

        @Override
        public int compareTo(Edge o) {
            return length - o.length;
        }
    }

    static int[] dx = {1, 0, -1 ,0};
    static int[] dy = {0, 1, 0 ,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = null;
        int cnt = 1;
        while((input = br.readLine()) != null) {
            int N = stoi(input);
            if(N == 0) break;

            int[][] map = new int[N][N];
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++)
                    map[i][j] = stoi(st.nextToken());
            }

            List<Edge>[][] edgeList = new ArrayList[N][N];
            for (int i = 0; i < N; i++)
                for (int j = 0; j < N; j++)
                    edgeList[i][j] = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    for (int k = 0; k < 4; k++) {
                        int nx = j + dx[k];
                        int ny = i + dy[k];
                        if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                        edgeList[ny][nx].add(new Edge(j, i, map[i][j])); // 사방에서 이쪽을 가리키는 간선 추가, 비용은 이 칸의 값
                    }
                }
            }

            int[][] distance = new int[N][N];
            for (int i = 0; i < N; i++)
                Arrays.fill(distance[i], Integer.MAX_VALUE);

            boolean[][] visited = new boolean[N][N];
            distance[0][0] = map[0][0];
            Queue<Edge> pq = new PriorityQueue<>();
            pq.offer(new Edge(0, 0, 0));
            int curX = 0, curY = 0;
            while(!pq.isEmpty()){
                Edge curEdge = pq.poll();
                curX = curEdge.toX;
                curY = curEdge.toY;
                if(visited[curY][curX]) continue;
                visited[curY][curX] = true;
                for(Edge edge : edgeList[curY][curX]){
                    if(distance[edge.toY][edge.toX] > distance[curY][curX] + edge.length){
                        distance[edge.toY][edge.toX] = distance[curY][curX] + edge.length;
                        pq.offer(new Edge(edge.toX, edge.toY, distance[edge.toY][edge.toX]));
                    }
                }
            }

            int result = distance[N - 1][N - 1];
            System.out.println("Problem " + cnt++ + ": " + result);
        }

    }

    static int stoi(String s){
        return Integer.parseInt(s);
    }
}