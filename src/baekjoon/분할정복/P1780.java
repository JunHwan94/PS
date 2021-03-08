package baekjoon.분할정복;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1780 {
    static int N;
    static int[][] paper;
    static int[] cnts;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        paper = new int[N][N];
        cnts = new int[3];
        StringTokenizer token;
        for(int i = 0; i < N; i++){
            token = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++)
                paper[i][j] = Integer.parseInt(token.nextToken());
        }
        checkPaper(0, 0, N);
        for (int i = 0; i < 3; i++)
            System.out.println(cnts[i]);
    }

    /**
     *
     * @param x 좌표
     * @param y 좌표
     * @param n 2차원 배열 크기
     */
    static void checkPaper(int x, int y, int n){
        boolean allSame = true;
        int tmp = paper[y][x];
        // 3 * 3 배열 검사
        if(n == 3) {
            // 각 숫자 갯수 세기
            int[] tCnts = new int[3];
            for (int i = y; i < y + 3; i++) {
                for (int j = x; j < x + 3; j++) {
                    if(tmp != paper[i][j])
                        allSame = false;
                    tCnts[paper[i][j] + 1]++;
                }
            }
            // -1, 0, 1을 인덱스 0, 1, 2로 보고 배열에 더하기
            if(allSame) { // 하나면 그 수에 해당하는 위치만 1증가
                cnts[tmp + 1]++;
            }else{
                cnts[0] += tCnts[0];
                cnts[1] += tCnts[1];
                cnts[2] += tCnts[2];
            }
            return;
        }else{ // 3보다 큰 n * n 배열 검사 (9, 27, ...)
            for (int i = y; allSame && i < y + n; i++) {
                for (int j = x; j < x + n; j++) {
                    // 다른게 나오면 다시 작은 단위의 배열로 검사해야 하므로 중단
                    if (tmp != paper[i][j]) {
                        allSame = false;
                        break;
                    }
                }
            }
            // 전부 같으면 1증가, 끝
            if(allSame) {
                cnts[tmp + 1]++;
                return;
            }
        }

        // 부분으로 나눠서 재귀 수행
        int max = n / 3;
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                checkPaper(x + max * j, y + max * i, max);
            }
        }
    }
}
