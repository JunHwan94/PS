package test;

import java.util.Arrays;

public class skbe3 {
    public static void main(String[] args) {
        System.out.println(solution(2, 2, new int[][]{{1, 1},{2, 2}}));
        System.out.println(solution(51, 37, new int[][]{{17, 19}}));
    }

    static boolean[][] hasDia;
    public static int solution(int width, int height, int[][] diagonals) {
        hasDia = new boolean[height + 1][width + 1];
        for (int i = 0; i < diagonals.length; i++) {
            int x = diagonals[i][0];
            int y = diagonals[i][1];
            hasDia[y][x] = true;
        }
        answer = 0;
        w = width;
        h = height;
        dfs(0, 0, false);
        return (int)answer % 10000019;
    }

    static int w, h;
    static long answer;
    static void dfs(int x, int y, boolean usedDia){
        if(x == w && y == h){
            answer++;
            return;
        }

        // 가로 세로 이동
        if(x + 1 <= w) {
            dfs(x + 1, y, usedDia);
        }
        if(y + 1 <= h) {
            dfs(x, y + 1, usedDia);
        }

        // 대각선 사용안했으면
        if(!usedDia) {
            // 현재 위치가 대각선 가진 사각형의 아래인 경우
            if(y + 1 < h && hasDia[y + 1][x]) {
                // 대각선 위로 이동
                dfs(x - 1, y + 1, true);
            }

            // 현재 위치가 대각선 가진 사각형의 위인 경우
            if(x + 1 < w && hasDia[y][x + 1]) {
                // 대각선 아래로 이동
                dfs(x + 1, y - 1, true);
            }
        }
    }
}