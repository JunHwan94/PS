package baekjoon.구간합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P11660 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(token.nextToken());
        int M = Integer.parseInt(token.nextToken());
        int[][] area = new int[N + 1][N + 1];
        int[][] accs = new int[N + 1][N + 1];
        for(int i = 1; i <= N; i++){
            token = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++){
                area[i][j] = Integer.parseInt(token.nextToken());
                if(j == 1) accs[i][j] = area[i][j];
                else accs[i][j] = accs[i][j - 1] + area[i][j];
            }
        }

        for(int m = 0; m < M; m++){
            token = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(token.nextToken());
            int y1 = Integer.parseInt(token.nextToken());
            int x2 = Integer.parseInt(token.nextToken());
            int y2 = Integer.parseInt(token.nextToken());

            int result = 0;
            for(int x = x1; x <= x2; x++){
                if(y1 == 1) result += accs[x][y2];
                else result += accs[x][y2] - accs[x][y1 - 1];
            }
            System.out.println(result);
        }
    }
}
