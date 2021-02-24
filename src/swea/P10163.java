package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P10163 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[][] board = new int[101][101];
        for(int n = 1; n <= N; n++){
            StringTokenizer token = new StringTokenizer(br.readLine());
            int sx = Integer.parseInt(token.nextToken());
            int sy = Integer.parseInt(token.nextToken());
            int width = Integer.parseInt(token.nextToken());
            int height = Integer.parseInt(token.nextToken());
            for(int y = sy; y < sy + height; y++){
                for(int x = sx; x < sx + width; x++){
                    board[y][x] = n;
                }
            }
        }

        for(int n = 1; n <= N; n++){
            int cnt = 0;
            for(int y = 0; y < 101; y++){
                for(int x = 0; x < 101; x++){
                    if(board[y][x] == n)
                        cnt++;
                }
            }
            sb.append(cnt).append("\n");
        }
        System.out.println(sb);
    }
}
