package baekjoon.완전탐색.조합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P15655 {
    static int N;
    static int R;
    static int[] arr;
    static int[] inArr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());
        R = Integer.parseInt(token.nextToken());
        arr = new int[R];
        inArr = new int[N];
        token = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            inArr[i] = Integer.parseInt(token.nextToken());
        }
        Arrays.sort(inArr);

        comb(0, 0);
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

        for(int i = start; i < N; i++) {
            arr[cnt] = inArr[i];
            comb(cnt + 1, i + 1);
        }
    }
}