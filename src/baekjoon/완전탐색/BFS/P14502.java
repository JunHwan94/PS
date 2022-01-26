package baekjoon.완전탐색.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P14502 {
    static int N, M;
    static int[][] lab;
    static boolean[][] visited;
    static int max = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());
        lab = new int[N][M];
        visited = new boolean[N][M];
        for(int n = 0; n < N; n++){
            token = new StringTokenizer(br.readLine());
            for(int m = 0; m < M; m++){
                lab[n][m] = Integer.parseInt(token.nextToken());
            }
        }

        buildWall(0, 0, 0);
        System.out.println(max);
    }

    static void buildWall(int x, int y, int cnt){
        if(cnt == 3 || y >= N){
//            bfs돌리기
            for(int n = 0; n < N; n++){
                for(int m = 0; m < M; m++){
                    if(lab[n][m] == 2) bfs(m, n);
                }
            }
            Arrays.stream(lab).forEach(it -> {
                int zCnt = (int)Arrays.stream(it).filter(n -> n == 0).count();
                max = Math.max(zCnt, max);
            });
            return;
        }

        int nx = x + 1;
        int ny = y;
        if(nx > M - 1){
            nx = 0;
            ny += 1;
        }
        // 0이면 벽세우기 선택, 미선택
        if(lab[y][x] == 0) {
            lab[y][x] = 1;
            buildWall(nx, ny, cnt + 1);
            lab[y][x] = 0;
            buildWall(nx, ny, cnt);
        }
        buildWall(nx, ny, cnt);
    }

    static int[] dx = {-1, 1, 0 ,0};
    static int[] dy = {0, 0, -1, 1};
    static void bfs(int x, int y){
        int[][] temp = lab;
        visited[y][x] = true;
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(x, y));
        while(!q.isEmpty()) {
            x = q.peek().x;
            y = q.poll().y;
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx < 0 || nx >= M || ny < 0 || ny >= N) continue;
                if(visited[ny][nx] || temp[ny][nx] == 1 || temp[ny][nx] == 2) continue;
                q.offer(new Pair(nx, ny));
                visited[ny][nx] = true;
                temp[ny][nx] = 2;
            }
        }
    }

    static class Pair{
        int x, y;
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}