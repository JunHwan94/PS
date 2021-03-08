package baekjoon.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2748 {
    static long[] fNums;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        fNums = new long[90];
        fNums[0] = 0;
        fNums[1] = 1;
        System.out.println(fib(N));
    }

    static long fib(int n){
        if(n < 2) return fNums[n];
        if(fNums[n - 1] == 0) fNums[n - 1] = fib(n - 1);
        if(fNums[n - 2] == 0) fNums[n - 2] = fib(n - 2);
        return fNums[n] = fNums[n - 1] + fNums[n - 2];
    }
}
