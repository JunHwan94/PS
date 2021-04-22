package baekjoon.시뮬레이션;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P14499 {
    static class Dice{
        int x, y, north, east, west, south, up, down;

        public Dice(int x, int y, int north, int east, int west, int south, int up, int down) {
            this.x = x;
            this.y = y;
            this.north = north;
            this.east = east;
            this.west = west;
            this.south = south;
            this.up = up;
            this.down = down;
        }

        void goEast(){
            int tmp = up;
            up = west;
            west = down;
            down = east;
            east = tmp;
            update();
        }

        void goWest(){
            int tmp = up;
            up = east;
            east = down;
            down = west;
            west = tmp;
            update();
        }

        void goNorth(){
            int tmp = up;
            up = south;
            south = down;
            down = north;
            north = tmp;
            update();
        }

        void goSouth(){
            int tmp = up;
            up = north;
            north = down;
            down = south;
            south = tmp;
            update();
        }

        void update(){
            if(map[x][y] == 0) setMapNum();
            else setDownNum();
            System.out.println(up);
        }

        void setMapNum(){
            map[x][y] = down;
        }

        void setDownNum(){
            down = map[x][y];
            map[x][y] = 0;
        }

        void move(int cnt){
            if (cnt == K) return;
            int nx = x + dx[cmd[cnt]];
            int ny = y + dy[cmd[cnt]];
            if(nx >= 0 && nx < N && ny >= 0 && ny < M){
                x = nx; y = ny;
                switch(cmd[cnt]){
                    case 1: goEast(); break; // 동
                    case 2: goWest(); break; // 서
                    case 3: goNorth(); break; // 북
                    case 4: goSouth(); break; // 남
                }
            }
            move(cnt + 1);
        }
    }

    static int N, M, X, Y, K;
    static int[][] map;
    static int[] cmd;
    static int[] dx = {0, 0, 0, -1, 1};
    static int[] dy = {0, 1, -1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = stoi(st.nextToken());
        M = stoi(st.nextToken());
        X = stoi(st.nextToken());
        Y = stoi(st.nextToken());
        K = stoi(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = stoi(st.nextToken());
            }
        }
        cmd = new int[K];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            cmd[i] = stoi(st.nextToken());
        }

        new Dice(X, Y, 0, 0, 0, 0, 0, 0).move(0);
    }

    static int stoi(String s){
        return Integer.parseInt(s);
    }
}