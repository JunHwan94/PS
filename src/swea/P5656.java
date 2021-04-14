package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P5656 {
    static int N, W, H, map[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = stoi(br.readLine());
        for (int t = 1; t <= T; t++) {
            min = Integer.MAX_VALUE;

            StringTokenizer st = new StringTokenizer(br.readLine());
            N = stoi(st.nextToken());
            W = stoi(st.nextToken());
            H = stoi(st.nextToken());

            map = new int[H][W];
            for (int i = 0; i < H; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < W; j++) {
                    map[i][j] = stoi(st.nextToken());
                }
            }

            selected = new int[N][2];
            supSet(0, 0, 0);

            int result = 0;
            System.out.println("#" + t + " " + result);
        }
    }

    static int[][] selected;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] tMap;
    static int min;
    static boolean[][] visited;
    static void supSet(int cnt, int x, int y){
        if(cnt == N || y == H - 1){
            System.out.println(cnt);
            tMap = new int[H][W];
            for (int i = 0; i < H; i++) {
                tMap[i] = Arrays.copyOf(map[i], map[i].length);
            }
            visited = new boolean[H][W];
            for (int[] s : selected) {
                boom(s[0], s[1]);
                // 칸 정리

                for (int i = 0; i < tMap.length; i++) {
                    System.out.println(Arrays.toString(tMap[i]));
                }
            }
            // 남은거 갯수 세기 -> min 값 갱신

            return;
        }

        if(x == W){
            y++;
            x = 0;
        }
        if(y == H) return;

        if(map[y][x] > 0) { // 0이 아닐때 선택 가능
            selected[cnt][0] = x;
            selected[cnt][1] = y;
            supSet(cnt + 1, x + 1, y);
        }

        selected[cnt] = new int[2];
        supSet(cnt, x + 1, y);
    }

    private static void boom(int x, int y) {
        for (int dir = 0; dir < 4; dir++) {
            for (int i = 1; i < tMap[y][x]; i++) { // 벽돌숫자 - 1 만큼 사방으로 탐색
                int xx = x + dx[dir] * i;
                int yy = y + dy[dir] * i;
                if(xx < 0 || xx >= W || yy < 0 || yy >= H || visited[y][x]) continue;
                visited[y][x] = true;
                boom(xx, yy); // 범위 내에 있는거 부수기
            }
        }
        tMap[y][x] = 0;
    }

    static int stoi(String s){
        return Integer.parseInt(s);
    }
}