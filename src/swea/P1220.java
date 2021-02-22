package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1220 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int t = 1; t <= 10; t++){
            int N = Integer.parseInt(br.readLine());
            int[][] board = new int[N][N];
            for(int i = 0; i < N; i++){
                StringTokenizer token = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    board[i][j] = Integer.parseInt(token.nextToken());
                }
            }

            int cnt = 0;
            for(int j = 0; j < N; j++){
                for(int i = 0; i < N; i++){
                    // 1이 내려가다가 1을 만나면 버리고 그 1로 내려가기
                    if(i < N - 1) {
                        int next = board[i + 1][j];
                        if (board[i][j] == 1) {
                            if (next == 2) {
                                cnt++;
                            }else if(next == 0){
                                board[i][j] = 0;
                                board[i + 1][j] = 1;
                            }else board[i][j] = 0;
                        }
                    }else board[i][j] = 0;
                }
            }
            System.out.println("#" +  t + " " + cnt);
        }
    }
}
