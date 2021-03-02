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
            for (int j = 0; j < N; j++) {
                paper[i][j] = Integer.parseInt(token.nextToken());
            }
        }
        checkPaper(0, 0, N);
        for (int i = 0; i < 3; i++) {
            System.out.println(cnts[i]);
        }
    }

    static void checkPaper(int x, int y, int n){
        if(n == 3) {
            boolean allSame = true;
            int tmp = paper[y][x];
            int[] tCnts = new int[3];
            for (int i = y; i < y + 3; i++) {
                for (int j = x; j < x + 3; j++) {
                    if(tmp != paper[i][j]) {
                        allSame = false;
                    }
                    tCnts[paper[i][j] + 1]++;
                }
            }
            if(allSame) {
                cnts[tmp + 1]++;
            }else{
                cnts[0] += tCnts[0];
                cnts[1] += tCnts[1];
                cnts[2] += tCnts[2];
            }
            return;
        }else{
            boolean allSame = true;
            int tmp = paper[y][x];
            Loop1 : for (int i = y; i < y + n; i++) {
                for (int j = x; j < x + n; j++) {
                    if(tmp != paper[i][j]) {
                        allSame = false;
                        break Loop1;
                    }
                }
            }
            if(allSame) {
                cnts[tmp + 1]++;
                return;
            }
        }

        int max = n / 3;
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                checkPaper(x + max * j, y + max * i, max);
            }
        }
    }
}
