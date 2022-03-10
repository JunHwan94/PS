package baekjoon.완전탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P17070 {

    static int N;
    static int[][] house, colored;
    static final int VER = 0, HOR = 1, DIA = 2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = stoi(br.readLine());
        house = new int[N][N];
        colored = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                house[i][j] = stoi(st.nextToken());
            }
        }

        dfs(1, 0, HOR);
        System.out.println(cnt);
    }

    static int cnt;
    static void dfs(int x, int y, int dir){
        if(x == N - 1 && y == N - 1){
            cnt++;
            return;
        }

        for (int d = 0; d < 3; d++) {
            if(dir == HOR && d == VER){
                continue;
            }
            if(dir == VER && d == HOR){
                continue;
            }

            switch (d) {
                case VER:
                    // 아래 빈칸이면 계속
                    if(y + 1 < N && x < N && house[y + 1][x] == 0) {
                        dfs(x, y + 1, d);
                    }
                    break;
                case HOR:
                    // 오른쪽 빈칸이면 계속
                    if(y < N && x + 1 < N && house[y][x + 1] == 0) {
                        dfs(x + 1, y, d);
                    }
                    break;
                case DIA:
                    // 오른쪽, 아래, 오른쪽아래 빈칸이면 계속
                    if(x + 1 < N && y + 1 < N && house[y][x + 1] + house[y + 1][x] + house[y + 1][x + 1] == 0) {
                        dfs(x + 1, y + 1, d);
                    }
                    break;
            }
        }
    }

    static int stoi(String s){
        return Integer.parseInt(s);
    }
}
