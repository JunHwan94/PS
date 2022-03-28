package baekjoon.완전탐색.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1987 {

    static int R, C;
    static char[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = stoi(st.nextToken());
        C = stoi(st.nextToken());
        board = new char[R][C];

        for (int i = 0; i < R; i++) {
            board[i] = br.readLine().toCharArray();
        }
        used = new boolean[100];
        used[board[0][0]] = true;
        dfs(0, 0, 1);
        System.out.println(max);
    }

    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};
    static boolean[] used;
    static int max;
    static void dfs(int r, int c, int d){
        max = Math.max(max, d);
        for (int i = 0; i < 4; i++) {
            int rr = r + dr[i];
            int cc = c + dc[i];
            if(rr < 0 || rr >= R || cc < 0 || cc >= C){
                continue;
            }
            // 체크 안돼있으면
            if(!used[board[rr][cc]]) {
                // 체크
                used[board[rr][cc]] = true;
                dfs(rr, cc, d + 1);
                // 체크 해제
                used[board[rr][cc]] = false;
            }
        }
    }

    static int stoi(String s){
        return Integer.parseInt(s);
    }
}
