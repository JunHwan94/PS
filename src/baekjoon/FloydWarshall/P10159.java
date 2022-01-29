package baekjoon.FloydWarshall;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P10159 {

    static int N, M, INF = 9999;
    static int[][] adjArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = stoi(br.readLine());
        M = stoi(br.readLine());

        adjArr = new int[N + 1][N + 1];
        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < N + 1; j++) {
                if(i != j) {
                    adjArr[i][j] = INF;
                }
            }
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int heavy = stoi(st.nextToken());
            int light = stoi(st.nextToken());

            adjArr[heavy][light] = 1; // 간선 표시
            adjArr[light][heavy] = -1; // 간선 표시
        }

        floydWarshall();

        for (int i = 1; i < N + 1; i++) {
            int count = 0;
            for (int j = 1; j < N + 1; j++) {
                if(adjArr[i][j] == INF){
                    count++;
                }
            }
            System.out.println(count);
        }
    }

    private static void floydWarshall() {
        for (int k = 1; k < N + 1; k++) {
            for (int i = 1; i < N + 1; i++) {
                if(k == i || adjArr[i][k] == INF) continue;
                for (int j = 1; j < N + 1; j++) {
                    if(k == j || i == j) continue;
                    int newDist = adjArr[i][k] + adjArr[k][j];
                    if(adjArr[i][k] < 0 && adjArr[k][j] < 0){ // 무거운쪽은 가벼운쪽으로만 탐색
                        adjArr[i][j] = Math.min(adjArr[i][j], newDist);
                    }else if(adjArr[i][k] > 0 && adjArr[k][j] > 0){ // 가벼운쪽은 무거운쪽으로만 탐색
                        adjArr[i][j] = Math.min(adjArr[i][j], newDist);
                    }
                }
            }
        }
    }

    static int stoi(String s){
        return Integer.parseInt(s);
    }
}
