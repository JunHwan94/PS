package baekjoon.완전탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P17142 {
    static class Loc{
        int x, y;
        Loc(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static int N, M, V, infCnt;
    static int[] selected;
    static int[][] lab, times;
    static List<Loc> viruses;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = stoi(st.nextToken());
        M = stoi(st.nextToken());

        lab = new int[N][N];
        viruses = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                lab[i][j] = stoi(st.nextToken());
                if(lab[i][j] == 2){
                    V++;
                    viruses.add(new Loc(j, i));
                }
                if(lab[i][j] != 1){
                    infCnt++;
                }
            }
        }

        if(infCnt == V){
            System.out.println(0);
            return;
        }
        min = 99999999;
        selected = new int[M];
        comb(0, 0);
        System.out.println(min == 99999999 ? -1 : min);
    }

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static boolean[][] visited;
    static int min;

    static void bfs(){
        int infected = V;
        Queue<Loc> q = new ArrayDeque<>();
        for (int i = 0; i < M; i++) {
            Loc loc = viruses.get(selected[i]);
            q.offer(loc);
            visited[loc.y][loc.x] = true;
        }
        int max = 0;
        loop: while(!q.isEmpty()){
            int x = q.peek().x;
            int y = q.poll().y;
            for (int i = 0; i < 4; i++) {
                int xx = x + dx[i];
                int yy = y + dy[i];
                if(xx < 0 || xx >= N || yy < 0 || yy >= N){
                    continue;
                }
                if(visited[yy][xx] || lab[yy][xx] == 1){
                    continue;
                }
                if(lab[yy][xx] == 0){
                    infected++;
                }
                visited[yy][xx] = true;
                times[yy][xx] = times[y][x] + 1;
                q.offer(new Loc(xx, yy));
                max = Math.max(max, times[yy][xx]);
                if(infected == infCnt){
                    break loop;
                }
            }
        }
//        System.out.println("===============");
        int zCnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
//                System.out.print(times[i][j] + " ");
                if(lab[i][j] == 0 && times[i][j] == 0){
                    return;
//                    zCnt++;
                }
            }
//            System.out.println();
        }
//        System.out.println("===============");
        min = Math.min(min, max);
    }

    static void comb(int cnt, int start){
        if(cnt == M){
//            for (int i = 0; i < M; i++) {
//                System.out.print(selected[i] + " ");
//            }
//            System.out.println();
            visited = new boolean[N][N];
            times = new int[N][N];
            bfs();
            return;
        }

        for (int i = start; i < V; i++) {
            selected[cnt] = i;
            comb(cnt + 1, i + 1);
        }
    }

    static int stoi(String s){
        return Integer.parseInt(s);
    }
}
