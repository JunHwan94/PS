package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P16234 {
    static int N, L, R;
    static int[][] map, visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int rCnt = 0;
        while(true) {
            int num = 1, cnt = 0;
            visited = new int[N][N];
            // 연합 구축
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (visited[i][j] == 0) {
                        if(bfs(j, i, num++)) cnt++;
                    }
                }
            }

            // 인구 이동이 없었으면 끝
            if(cnt == 0) break;
            rCnt++;
        }
        System.out.println(rCnt);
    }

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static boolean bfs(int x, int y, int num){
        Queue<Integer> q = new LinkedList<>();
        Queue<Integer> dq = new LinkedList<>(); // 연합 좌표 큐
        q.offer(x);
        q.offer(y);
        dq.offer(x);
        dq.offer(y);
        int sum = map[y][x];
        visited[y][x] = num;
        int cnt = 1;
        while(!q.isEmpty()){
            x = q.poll();
            y = q.poll();
            for (int i = 0; i < 4; i++) {
                int xx = x + dx[i];
                int yy = y + dy[i];
                if(xx < 0 || xx >= N || yy < 0 || yy >= N) continue;
                if(visited[yy][xx] > 0) continue;
                int def = Math.abs(map[y][x] - map[yy][xx]); // 인구 차
                if(def < L || R < def) continue; // L미만이거나 R초과이면 연합ㄴ
                visited[yy][xx] = num; // 연합 표시
                sum += map[yy][xx]; // 인구 수 더하기
                System.out.println(map[yy][xx]);
                cnt++;
                q.offer(xx);
                q.offer(yy);
                dq.offer(xx);
                dq.offer(yy);
            }
        }

        // 인구 이동 불가
        if(cnt == 1) return false;

        int pop = sum / cnt;
        // 인구 이동
        while(!dq.isEmpty()){
            int xx = dq.poll();
            int yy = dq.poll();
            map[yy][xx] = pop;
        }
        return true;
    }
}