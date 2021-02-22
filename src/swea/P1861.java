package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1861 {
    static int N;
    static int[][] map;
    static int init;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++) {
            init = 0;
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            for (int i = 0; i < N; i++) {
                StringTokenizer token = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(token.nextToken());
                }
            }

            int max = 1;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    dfs(j, i);
                    if(max < cnt) {
                        init = map[i][j];
                        max = cnt;
                    }else if(max == cnt && init > map[i][j]){
                        init = map[i][j];
                    }
                    cnt = 1;
                }
            }

            System.out.println("#" + t + " " + init + " " + max);
        }
    }

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int cnt;
    private static void dfs(int x, int y) {
        for(int k = 0; k < 4; k++){
            int nx = x + dx[k];
            int ny = y + dy[k];
            if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
            if(map[y][x] + 1 != map[ny][nx]) continue;
            cnt++;
            dfs(nx, ny);
        }
    }
}
