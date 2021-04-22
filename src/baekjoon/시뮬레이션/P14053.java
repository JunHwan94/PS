package baekjoon.시뮬레이션;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P14053 {
    static int N, M, r, c, d;
    static int[][] map;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = stoi(st.nextToken());
        M = stoi(st.nextToken());
        st = new StringTokenizer(br.readLine());
        r = stoi(st.nextToken());
        c = stoi(st.nextToken());
        d = stoi(st.nextToken());
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = stoi(st.nextToken());
            }
        }

        visited = new boolean[N][M];
        visited[r][c] = true;
        move(c, r);

        int res = 0;
        for (int i = 0; i < N; i++)
            for (int j = 0; j < M; j++)
                if(visited[i][j]) res++;

        System.out.println(res);
    }

    static int[] dx = {0, 1, 0, -1}; // 상 우 하 좌
    static int[] dy = {-1, 0, 1, 0};
    static void move(int x, int y){
        // 이동 가능한지 체크
        boolean canMove = false;
        int bd = (d + 2) % 4;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx < 0 || nx >= M || ny < 0 || ny > N) continue;
            if(map[ny][nx] == 1 || visited[ny][nx]) continue;
            canMove = true;
        }
        // 사방이 벽 또는 모두 청소됨
        if(!canMove) {
            int bx = x + dx[bd];
            int by = y + dy[bd];
            // 뒤가 범위를 벗어나거나 뒤가 벽이면 끝
            if (bx < 0 || bx >= M || by < 0 || by >= N || map[by][bx] == 1) return;
            // 후진
            move(bx, by);
        }else {
            int ld = (d + 3) % 4;
            int lx = x + dx[ld];
            int ly = y + dy[ld];
            // 왼쪽이 범위를 벗어나면 진행안함
            if (lx < 0 || lx >= M || ly < 0 || ly > N) return;

            d = ld; // 방향 전환
            // 왼쪽이 청소안했고 벽이 아니면 왼쪽 진행
            if(!visited[ly][lx] && map[ly][lx] != 1) {
                visited[ly][lx] = true;
                move(lx, ly);
            }else{ // 아니면 제자리
                move(x, y);
            }
        }
    }

    static int stoi(String s){
        return Integer.parseInt(s);
    }
}
