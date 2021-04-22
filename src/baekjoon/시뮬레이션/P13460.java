package baekjoon.시뮬레이션;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P13460 {
    static int N, M, rx, ry, bx, by;
    static char[][] board;
    static boolean[][] visited;
    static boolean rCanBePut, bCanBePut;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new char[N][M];

        for (int i = 0; i < N; i++) {
            board[i] = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                if(board[i][j] == 'B') {
                    bx = j;
                    by = i;
                }else if(board[i][j] == 'R'){
                    rx = j;
                    ry = i;
                }
            }
        }

        // dfs로 탐색하여 O으로 도달 가능한지 판단, 방향바꾼 횟수 세기
        visited = new boolean[N][M];
        visited[ry][rx] = true;
        dfs(rx, ry, -1, 0, new ArrayList<>(), 'r');

        // B가 0으로 도달 가능한지 판단
        visited = new boolean[N][M];
        dfs(bx, by, -1, 0, null, 'b');

        if(!rCanBePut) { // 빨간색이 구멍에 도달 불가
            print(-1);
            return;
        }
        if(!bCanBePut) { // 빨간색은 구멍에 도달 가능, 파란색은 도달 불가
            print(cnt);
            return;
        }

        // 빨간색은 구멍에 도달 가능
        // 이후 그 방향대로 기울여서 R, B 구슬 두개가 같이 들어가는지 판단
        for (int i = 0; i < dList.size(); i++) {
            boolean rPut = false, bPut = false;
            int dir = dList.get(i);
            int rxx = rx + dx[dir], ryy = ry + dy[dir];

            while(board[ryy][rxx] == '.'){
                rxx += dx[dir];
                ryy += dy[dir];
            }
            board[ry][rx] = '.';
            if(board[ryy][rxx] == 'O') rPut = true;
            else board[ryy][rxx] = 'R';

            int bxx = bx + dx[dir], byy = by + dy[dir];
            while(board[byy][bxx] == '.'){
                bxx += dx[dir];
                byy += dy[dir];
            }
            board[by][bx] = '.';
            if(board[byy][bxx] == 'O') bPut = true;
            else board[byy][bxx] = 'B';
            if(rPut && bPut){
                cnt = -1;
                break;
            }
        }

        print(cnt);
    }

    static void print(int res){ System.out.println(res > 10 ? -1 : res); }

    static int[] dx = {1, 0, -1 ,0};
    static int[] dy = {0, 1 ,0, -1};
    static int cnt = Integer.MAX_VALUE;
    static List<Integer> dList;
    static void dfs(int x, int y, int dir, int dcCnt, List<Integer> list, char rb){
        if(board[y][x] == 'O') {
            if(rb == 'r') {
                if(cnt > dcCnt){
                    cnt = dcCnt;
                    dList = list;
                }
                rCanBePut = true;
            }else{
                bCanBePut = true;
            }
            return;
        }

        for (int i = 0; i < 4; i++) {
            int xx = x + dx[i];
            int yy = y + dy[i];
            if(xx < 0 || xx >= M || yy < 0 || yy >= N) continue;
            if(visited[yy][xx] || board[yy][xx] == '#') continue;
            if(board[yy][xx] == '.' || board[yy][xx] == 'O' || rb == 'b') {
                visited[yy][xx] = true;
                if (dir != i && rb == 'r') { // 기울이는 위치 바뀌면 방향 바뀐 횟수 더해줌
                    list.add(i);
                    dfs(xx, yy, i, dcCnt + 1, list, rb);
                }else dfs(xx, yy, i, dcCnt, list, rb);
            }
        }
    }
}
