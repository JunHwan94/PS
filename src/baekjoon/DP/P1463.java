package baekjoon.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1463 {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        int start = 1;
        int cnt = 0;
        while(true){
            System.out.println(start);
            if(start == N) break;
            if(start * 3 < N) start *= 3;
            else if(start * 2 < N) start *= 2;
            else start += 1;
            cnt++;
        }
        System.out.println(cnt);
    }
}
