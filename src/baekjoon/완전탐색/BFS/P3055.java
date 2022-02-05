package baekjoon.완전탐색.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class P3055 {

    static int R, C, bx, by;
    static char[][] forest;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = stoi(st.nextToken());
        C = stoi(st.nextToken());
        forest = new char[R][C];

        int hx = 0, hy = 0;
        for (int i = 0; i < R; i++) {
            forest[i] = br.readLine().toCharArray();
            for (int j = 0; j < forest[i].length; j++) {
                if(forest[i][j] == 'S'){
                    hx = j;
                    hy = i;
                }else if(forest[i][j] == 'D'){
                    bx = j;
                    by = i;
                }
            }
        }

        Queue<Integer> q = new ArrayDeque<>();
        q.offer(hx);
        q.offer(hy);
        boolean[][] visited = new boolean[R][C];
        int[][] times = new int[R][C];
        loop : while(!q.isEmpty()){
            int size = q.size();
            for (int sz = 0; sz < size; sz += 2) {
                int x = q.poll();
                int y = q.poll();
                visited[y][x] = true;
                for (int i = 0; i < 4; i++) {
                    int xx = x + dx[i];
                    int yy = y + dy[i];
                    if (xx < 0 || xx >= C || yy < 0 || yy >= R) {
                        continue;
                    }
                    // 방문했거나 물 또는 돌이면 넘어감
                    if (visited[yy][xx] || forest[yy][xx] == '*' || forest[yy][xx] == 'X') {
                        continue;
                    }
                    boolean canGo = true;
                    for (int j = 0; j < 4; j++) {
                        int xxx = xx + dx[j];
                        int yyy = yy + dy[j];
                        if (xxx < 0 || xxx >= C || yyy < 0 || yyy >= R) {
                            continue;
                        }
                        if (forest[yyy][xxx] == '*') {
                            canGo = false;
                            break;
                        }
                    }

                    if (xx == bx && yy == by) {
                        processMove(x, y, xx, yy, times);
                        break loop;
                    }
                    // 물 찰 곳이라 못감
                    if (!canGo) {
                        continue;
                    }

                    processMove(x, y, xx, yy, times);
                    visited[yy][xx] = true;
                    q.offer(xx);
                    q.offer(yy);
                }
            }
            incWater();
        }

        if(times[by][bx] > 0){
            System.out.println(times[by][bx]);
        }else{
            System.out.println("KAKTUS");
        }
    }

    static void processMove(int x, int y, int xx, int yy, int[][] times){
        forest[y][x] = '.';
        forest[yy][xx] = 'S';
        times[yy][xx] = times[y][x] + 1;
    }

    static void incWater(){
        Queue<Integer> wq = new ArrayDeque<>();
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if(forest[i][j] == '*') {
                    wq.offer(j);
                    wq.offer(i);
                }
            }
        }

        while(!wq.isEmpty()) {
            int x = wq.poll();
            int y = wq.poll();
            for (int i = 0; i < 4; i++) {
                int xx = x + dx[i];
                int yy = y + dy[i];
                if(xx < 0 || xx >= C || yy < 0 || yy >= R){
                    continue;
                }
                if(forest[yy][xx] == 'X' || forest[yy][xx] == 'D'){
                    continue;
                }

                forest[yy][xx] = '*';
            }
        }
    }

    static int stoi(String s){
        return Integer.parseInt(s);
    }
}
