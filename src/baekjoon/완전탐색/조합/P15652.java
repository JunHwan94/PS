package baekjoon.완전탐색.조합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P15652 {
    static int N;
    static int R;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());
        R = Integer.parseInt(token.nextToken());
        arr = new int[R];
        comb(0, 1);
        System.out.println(sb);
    }

    static void comb(int cnt, int start) {
        if(cnt == R) {
            for(int i = 0; i < arr.length; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append('\n');
            return;
        }

        for(int i = start; i <= N; i++) {
            arr[cnt] = i;
            comb(cnt + 1, i);
        }
    }
}