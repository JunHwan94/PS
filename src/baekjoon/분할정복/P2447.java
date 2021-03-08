package baekjoon.분할정복;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2447 {
    static char[][] stars;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        stars = new char[N][N];
        for(int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                stars[i][j] = '*';

        checkPaper(0, 0, N, false);
        for (int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++)
                sb.append(stars[i][j]);
            sb.append('\n');
        }
        System.out.println(sb);
    }

    /**
     *
     * @param x 좌표
     * @param y 좌표
     * @param n 2차원 배열 크기
     * @param blank 부분 중 가운데인지 판단
     */
    static void checkPaper(int x, int y, int n, boolean blank){
        if(blank) {
            for (int i = y; i < y + n; i++)
                for (int j = x; j < x + n; j++)
                    stars[i][j] = ' ';
            return;
        }
        if(n == 1){
            stars[y][x] = '*';
            return;
        }

        int max = n / 3;
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                int nx = x + j * max;
                int ny = y + i * max;
                checkPaper(nx, ny, max, i * j == 1);
            }
        }
    }
}