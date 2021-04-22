package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class P1868 {
    static int N;
    static char[][] map;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String nums = "0123456789";
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            map = new char[N][N];
            for (int i = 0; i < N; i++)
                map[i] = br.readLine().toCharArray();

            visited = new boolean[N][N];

            // 각 칸에서 8방 탐색하여 지뢰 갯수를 자리에 표시 0 ~ 8
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(map[i][j] == '.') {
                        int cnt = 0;
                        for (int d = 0; d < 8; d++) {
                            int xx = j + dx[d];
                            int yy = i + dy[d];
                            if (xx < 0 || xx >= N || yy < 0 || yy >= N) continue;
                            if (map[yy][xx] == '*') cnt++;
                        }
                        map[i][j] = nums.charAt(cnt);
                    }
                }
            }

            // 0 주변 8방 탐색, 방문 체크
            int cnt = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    // 클릭
                    if(visited[i][j] || map[i][j] == '*' || map[i][j] != '0') continue;
                    bfs(j, i);
                    cnt++;
                }
            }

            // 방문하지 않은 모든 숫자 칸 갯수 더하기
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    // 클릭
                    if(visited[i][j] || map[i][j] == '*') continue;
                    visited[i][j] = true;
                    cnt++;
                }
            }

            System.out.println("#" + t + " " + cnt);
        }
    }

    static int[] dx = {1, 0, -1, 0, 1, 1, -1, -1};
    static int[] dy = {0, 1, 0, -1, -1, 1, 1, -1};
    static void bfs(int x, int y){
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(x);
        q.offer(y);
        visited[y][x] = true;
        while(!q.isEmpty()){
            x = q.poll();
            y = q.poll();

            for (int i = 0; i < 8; i++) {
                int xx = x + dx[i];
                int yy = y + dy[i];
                if(xx < 0 || xx >= N || yy < 0 || yy >= N) continue;
                if(visited[yy][xx] || map[yy][xx] == '*') continue;
                visited[yy][xx] = true;
                if(map[yy][xx] == '0') {
                    q.offer(xx);
                    q.offer(yy);
                }
            }
        }
    }
}
