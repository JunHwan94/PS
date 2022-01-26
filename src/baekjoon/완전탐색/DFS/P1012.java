package baekjoon.완전탐색.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1012 {
    static boolean[][] field = new boolean[50][50];
    static boolean[][] visited = new boolean[50][50];
    static int width;
    static int height;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int reps = Integer.parseInt(br.readLine());
        for(int r = 0; r < reps; r++) {
            StringTokenizer token = new StringTokenizer(br.readLine());
            width = Integer.parseInt(token.nextToken());
            height = Integer.parseInt(token.nextToken());
            int cabCnt = Integer.parseInt(token.nextToken());

            for (int c = 0; c < cabCnt; c++) {
                StringTokenizer cToken = new StringTokenizer(br.readLine());
                field[Integer.parseInt(cToken.nextToken())][Integer.parseInt(cToken.nextToken())] = true;
            }

            int cnt = 0;
            for (int i = 0; i < width; i++) {
                for (int j = 0; j < height; j++) {
                    if (field[i][j] && !visited[i][j]) {
                        dfs(i, j);
                        cnt++;
                    }
                }
            }
            System.out.println(cnt);
            // 밭, 방문 초기화
            field = new boolean[50][50];
            visited = new boolean[50][50];
        }
        br.close();
    }

    // 사방탐색하며 방문 표시
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    /**
     * @param x x좌표
     * @param y y좌표
     */
    public static void dfs(int x, int y){
        visited[x][y] = true;

        for(int k = 0; k < 4; k++){
            int nx = x + dx[k];
            int ny = y + dy[k];
            // 다음 인덱스가 밭을 벗어나면 넘어가기
            if(nx < 0 || nx >= width || ny < 0 || ny >= height)
                continue;
            // 배추 없거나 방문했으면 넘어가기
            if(!field[nx][ny] || visited[nx][ny])
                continue;
            dfs(nx, ny); // 계속 탐색
        }
    }
}
