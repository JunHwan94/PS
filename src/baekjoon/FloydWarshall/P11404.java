package baekjoon.FloydWarshall;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P11404 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = stoi(br.readLine());
        int M = stoi(br.readLine());
        long INF = 10000000000L;
        long[][] adjMatrix = new long[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if(i != j && adjMatrix[i][j] == 0) adjMatrix[i][j] = INF;
            }
        }

        StringTokenizer st;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = stoi(st.nextToken());
            int to = stoi(st.nextToken());
            int cost = stoi(st.nextToken());
            adjMatrix[from][to] = Math.min(adjMatrix[from][to], cost);
        }

        for(int k = 1; k <= N; ++k) {
            for(int i = 1; i <= N; ++i) {
                if(i == k) continue; // 출발지와 경유지가 같다면 다음 출발지
                for(int j = 1; j <= N; ++j) {
                    if(i == j || k == j) continue; // 경유지와 목적지가 같거나 출발지가 곧 목적지라면 패스
                    if(adjMatrix[i][j] > adjMatrix[i][k] + adjMatrix[k][j]) {
                        adjMatrix[i][j] = adjMatrix[i][k] + adjMatrix[k][j];
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= N; ++i) {
            for(int j = 1; j <= N; ++j) {
                sb.append(adjMatrix[i][j] == INF ? 0 : adjMatrix[i][j]).append(' ');
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

    static int stoi(String s){
        return Integer.parseInt(s);
    }
}