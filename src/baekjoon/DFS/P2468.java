package baekjoon.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P9663 {
    static int N;
    static int[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        qCnt = 0;
        for (int i = 0; i < (N / 2) + 1; i++) {
            for (int j = 0; j < N; j++) {
                board = new int[N][N];
                dfs(j, i, 0);
            }
        }
        System.out.println(qCnt);
    }

    static int qCnt;
    static int[] dx = {1, 0, -1, 0, 1, 1, -1, -1}, dy = {0, 1, 0, -1, -1, 1, 1, -1};
    static void dfs(int x, int y, int cnt){
        // 끝지점이거나 N개 다 놓았으면 끝
        if(x == N - 1 && y == N - 1) return;
        if(cnt == N) {
            qCnt++;
            return;
        }
        if(x == N - 1) x = 0;
//        System.out.println("x : " + x + " y : " + y);
//        System.out.println("cnt : " + cnt);
//        System.out.println("qCnt : " + qCnt);

        boolean canPut = true;
        // 놓을 수 있는지 검사
        for (int i = 1; i < N - 1; i++) {
            for (int k = 0; k < 8; k++) {
                int xx = x + dx[k] * i;
                int yy = y + dy[k] * i;
                if(xx < 0 || xx > N - 1 || yy < 0 || yy > N - 1) continue;
                if(board[yy][xx] == 1) {
                    canPut = false;
                    break;
                }
            }
        }

        System.out.println(canPut);
        // 놓기
        if(canPut) {
            System.out.println("x : " + x + " y : " + y);
            board[y][x] = 1;
            x = N - 1;
            y++;
            cnt++;
        }else return;

        // 다음 위치로
        dfs(x, y, cnt);
    }
}
