package baekjoon.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P14500 {
    static int N, M;
    static int[][] field;
    static int[] arr;
    static boolean[][] visited;
    static int max;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++) {
            max = 0;
            StringTokenizer token = new StringTokenizer(br.readLine());
            N = Integer.parseInt(token.nextToken());
            M = Integer.parseInt(token.nextToken());
            arr = new int[4];
            visited = new boolean[N][M];
            field = new int[N][M];
            for (int n = 0; n < N; n++) {
                token = new StringTokenizer(br.readLine());
                for (int m = 0; m < M; m++)
                    field[n][m] = Integer.parseInt(token.nextToken());
            }

            for (int n = 0; n < N; n++) {
                for (int m = 0; m < M; m++) {
                    visited[n][m] = true;
                    arr[0] = field[n][m];
                    dfs(m, n, 0);
                }
            }

            visited = new boolean[N][M];
            for (int y = 0; y < N; y++) {
                for (int x = 0; x < M; x++) {
                    int sum = 0;
                    if(x > 0 && x < M - 1 && y < N - 1){ // ㅜ
                        sum = field[y][x] + field[y + 1][x] + field[y][x - 1] + field[y][x + 1];
                        max = Math.max(sum, max);
                    }
                    if(x > 0 && x < M - 1 && y > 0){ // ㅗ
                        sum = field[y][x] + field[y - 1][x] + field[y][x - 1] + field[y][x + 1];
                        max = Math.max(sum, max);
                    }
                    if(x < M - 1 && y < N - 1 && y > 0){ // ㅏ
                        sum = field[y][x] + field[y - 1][x] + field[y + 1][x] + field[y][x + 1];
                        max = Math.max(sum, max);
                    }
                    if(x > 0 && y < N - 1 && y > 0){ // ㅓ
                        sum = field[y][x] + field[y - 1][x] + field[y + 1][x] + field[y][x - 1];
                        max = Math.max(sum, max);
                    }
                }
            }

            sb.append(max).append("\n");
        }
        System.out.println(sb);
    }

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static void dfs(int x, int y, int cnt){
        if(cnt == 3){
            int sum = 0;
            for(int i = 0; i < 4; i++)
                sum += arr[i];
            max = Math.max(max, sum);
            return;
        }
        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx < 0 || nx >= M || ny < 0 || ny >= N) continue;
            if(visited[ny][nx]) continue;
            visited[ny][nx] = true;
            arr[cnt + 1] = field[ny][nx];
            dfs(nx, ny, cnt + 1);
            visited[ny][nx] = false;
        }
    }
}
