package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P11315 {
    static int N;
    static char[][] board;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++){
            gameOver = false;
            N = Integer.parseInt(br.readLine());
            board = new char[N][N];
            visited = new boolean[N][N];
            StringTokenizer token;
            for(int i = 0; i < N; i++){
                token = new StringTokenizer(br.readLine());
                board[i] = token.nextToken().toCharArray();
            }
            for(int i = 0; i < N; i++){
                for (int j = 0; j < N; j++) {
                    for (int k = 0; k < 4; k++) {
                        if (!visited[i][j] && board[i][j] == 'o')
                            dfs(j, i, k, 1);
                    }
                }
            }

            System.out.println("#" + t + " " + (gameOver ? "YES" : "NO"));
        }
    }

    static int[] dx = {1, 1, 1, 0}; // 우상, 우, 우하, 하
    static int[] dy = {-1, 0, 1, 1};
    static boolean gameOver = false;
    static void dfs(int x, int y, int dir, int cnt){
        if(gameOver) return;
        if(cnt == 5){
            gameOver = true;
            return;
        }

        int nx = x + dx[dir];
        int ny = y + dy[dir];
        if(nx < 0 || nx >= N || ny < 0 || ny >= N) return;
        if(visited[ny][nx] || board[ny][nx] == '.') return;
        visited[ny][nx] = true;
        dfs(nx, ny, dir, cnt + 1);
        visited[ny][nx] = false;
    }
}
