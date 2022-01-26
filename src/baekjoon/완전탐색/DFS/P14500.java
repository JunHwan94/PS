package baekjoon.완전탐색.DFS;

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

        // 모든 칸에서 dfs 수행
        for (int n = 0; n < N; n++) {
            for (int m = 0; m < M; m++) {
                visited[n][m] = true;
                arr[0] = field[n][m];
                dfs(m, n, 0);
                visited[n][m] = false;
            }
        }

        visited = new boolean[N][M];
        for (int y = 0; y < N; y++) { // ㅏㅓㅗㅜ 처리
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
        System.out.println(max);
    }

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
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
            if(visited[ny][nx] || field[ny][nx] == 0) continue;
            visited[ny][nx] = true;
            arr[cnt + 1] = field[ny][nx];
            dfs(nx, ny, cnt + 1);
            visited[ny][nx] = false;
        }
    }
}
