package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1949 {
    static int N, K;
    static int[][] field;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++){
            max = 0;
            StringTokenizer token = new StringTokenizer(br.readLine());
            N = Integer.parseInt(token.nextToken());
            K = Integer.parseInt(token.nextToken());
            field = new int[N][N];
            visited = new boolean[N][N];
            int maxHeight = 0;
            for(int i = 0; i < N; i++){
                token = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    field[i][j] = Integer.parseInt(token.nextToken());
                    maxHeight = Math.max(maxHeight, field[i][j]);
                }
            }
            for(int i = 0; i < N; i++){
                for (int j = 0; j < N; j++) {
                    if(maxHeight == field[i][j]) {
                        visited[i][j] = true;
                        dfs(j, i, 1, true);
                        visited[i][j] = false;
                    }
                }
            }

            System.out.println("#" + t + " " + max);
        }
    }

    static int max;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static void dfs(int x, int y, int length, boolean canCut){
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
            if(visited[ny][nx]) continue;
            if(field[y][x] <= field[ny][nx] && !canCut) continue;
            if(field[y][x] <= field[ny][nx] && canCut) {
                canCut = false;
                int tHeight = field[ny][nx];
                for(int k = 1; k <= K; k++) {
                    if(tHeight - k < field[y][x]) {
                        tHeight -= k;
                        break;
                    }
                }
                if(tHeight >= field[y][x]){
                    max = Math.max(max, length);
                    canCut = true;
                    continue;
                }
                int save = field[ny][nx];
                visited[ny][nx] = true;
                field[ny][nx] = tHeight;
                dfs(nx, ny, length + 1, canCut);
                field[ny][nx] = save;
                canCut = true;
                visited[ny][nx] = false;
            }else {
                visited[ny][nx] = true;
                dfs(nx, ny, length + 1, canCut);
                visited[ny][nx] = false;
            }
        }
        max = Math.max(max, length);
    }
}