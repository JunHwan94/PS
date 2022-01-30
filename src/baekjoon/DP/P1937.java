package baekjoon.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1937 {
    static int N;
    static int[][] forest;
    static int[][] memo;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = stoi(br.readLine());
        forest = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                forest[i][j] = stoi(st.nextToken());
            }
        }

        memo = new int[N][N];
        int max = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                max = Math.max(max, dfs(j, i));
            }
        }

        System.out.println(max);
    }

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int dfs(int x, int y){
        // 저장한 값 있으면 반환
        if(memo[y][x] != 0) {
            return memo[y][x];
        }

        memo[y][x] = 1;

        for (int i = 0; i < 4; i++) {
            int xx = x + dx[i];
            int yy = y + dy[i];
            if(xx < 0 || xx >= N || yy < 0 || yy >= N) {
                continue;
            }
            if (forest[yy][xx] <= forest[y][x]) {
                continue;
            }

            // 좌표에서 갈 수 있는 최대 거리 저장
            memo[y][x] = Math.max(memo[y][x], dfs(xx, yy) + 1);
        }

        return memo[y][x];
    }

    static int stoi(String s){
        return Integer.parseInt(s);
    }
}