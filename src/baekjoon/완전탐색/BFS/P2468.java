package baekjoon.완전탐색.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class P2468 {
    static int N;
    static int[][] map, safeMap;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        // 입력
        int max = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(max, map[i][j]);
            }
        }

        int maxCnt = 0;
        // 높이 최소부터 최대값까지 반복
        for (int h = 0; h < max; h++) {
            int cnt = 0;
            safeMap = new int[N][N];
            visited = new boolean[N][N];
            // 물에 잠기는 지역 체크
            checkMap(h);

            // bfs로 탐색하여 안잠긴지역 표시, 개수 세기
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    // 안잠겼을떄, 체크안했을때 진입
                    if(safeMap[i][j] == 1 || visited[i][j]) continue;
                    bfs(j, i);
                    cnt++;
                }
            }
            maxCnt = Math.max(maxCnt, cnt);
        }

        System.out.println(maxCnt);
    }

    public static void checkMap(int h){
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(map[i][j] <= h) safeMap[i][j] = 1;
            }
        }
    }

    static boolean[][] visited;
    static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
    public static void bfs(int x, int y){
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(x);
        q.offer(y);

        while(!q.isEmpty()){
            x = q.poll();
            y = q.poll();
            for (int i = 0; i < 4; i++) {
                int xx = x + dx[i];
                int yy = y + dy[i];
                if(xx < 0 || xx > N - 1 || yy < 0 || yy > N - 1 || visited[yy][xx] || safeMap[yy][xx] == 1) continue;
                visited[yy][xx] = true;
                q.offer(xx);
                q.offer(yy);
            }
        }
    }
}
