package swea.D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class P1249 {
    static class Edge implements Comparable<Edge>{
        int toX, toY, cost;

        public Edge(int toX, int toY, int cost) {
            super();
            this.toX = toX;
            this.toY = toY;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return cost - o.cost;
        }
    }

    static int N;
    static int[][] map, adjMatrix;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = stoi(br.readLine());

        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        for (int t = 1; t <= T; t++) {
            N = stoi(br.readLine());
            map = new int[N][N];

            StringTokenizer st;
            for (int i = 0; i < N; i++) {
                String in = br.readLine();
                for (int j = 0; j < N; j++) {
                    map[i][j] = in.charAt(j) - '0';
                }
            }

            List<Edge>[][] edgeList = new ArrayList[N][N];
            for (int i = 0; i < N; i++)
                for (int j = 0; j < N; j++)
                    edgeList[i][j] = new ArrayList<>();

            // 사방에서 이쪽 점으로 오는 간선 추가
            for (int y = 0; y < N; y++) {
                for (int x = 0; x < N; x++) {
                    int cost = map[y][x];
                    for (int dir = 0; dir < 4; dir++) {
                        int nx = x + dx[dir];
                        int ny = y + dy[dir];
                        if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                        edgeList[y][x].add(new Edge(nx, ny, cost));
                    }
                }
            }

            int[][] distance = new int[N][N];
            for (int i = 0; i < N; i++)
                Arrays.fill(distance[i], Integer.MAX_VALUE);

            boolean[][] visited = new boolean[N][N];
            distance[0][0] = 0;
            Queue<Edge> pq = new PriorityQueue<>();
            pq.offer(new Edge(0, 0, 0));
            int curX = 0, curY = 0;
            while(!pq.isEmpty()) {
                Edge curEdge = pq.poll();
                curX = curEdge.toX;
                curY = curEdge.toY;
                if(visited[curY][curX]) continue;
                visited[curY][curX] = true;

                for (Edge edge : edgeList[curY][curX]) {
                    if(distance[edge.toY][edge.toX] > distance[curY][curX] + edge.cost){
                        distance[edge.toY][edge.toX] = distance[curY][curX] + edge.cost;
                        pq.offer(new Edge(edge.toX, edge.toY, distance[edge.toY][edge.toX]));
                    }
                }
            }

            int result = distance[N - 1][N - 1];
            System.out.println("#" + t + " " + result);
        }
    }

    static int stoi(String s) {
        return Integer.parseInt(s);
    }
}