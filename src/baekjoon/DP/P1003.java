package baekjoon.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1003 {
    static int fibs[];
    static int cnts[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++){
            fibs = new int[41];
            fibs[0] = 0;
            fibs[1] = 1;
            cnts = new int[41][2];
            cnts[0][0] = 1;
            cnts[1][1] = 1;
            int n = Integer.parseInt(br.readLine());
            if(n >= 2) {
                fib(n);
                cnt(n);
            }
            System.out.println(cnts[n][0] + " " + cnts[n][1]);
        }
    }

    static int fib(int n){
        if(n != 0 && fibs[n] == 0) {
            if(fibs[n - 1] == 0) fibs[n - 1] = fib(n - 1);
            if(fibs[n - 2] == 0) fibs[n - 2] = fib(n - 2);
            fibs[n] = fibs[n - 1] + fibs[n - 2];
        }
        return fibs[n];
    }

    static int[] cnt(int n){
        if(n != 0 && cnts[n][0] == 0 && cnts[n][1] == 0){
            int[] cTmp1 = cnt(n - 1);
            int[] cTmp2 = cnt(n - 2);
            if(cnts[n - 1][0] == 0) cnts[n - 1][0] = cTmp1[0];
            if(cnts[n - 1][1] == 0) cnts[n - 1][1] = cTmp1[1];
            if(cnts[n - 2][0] == 0) cnts[n - 2][0] = cTmp2[0];
            if(cnts[n - 2][1] == 0) cnts[n - 2][1] = cTmp2[1];
            cnts[n][0] = cnts[n - 1][0] + cnts[n - 2][0];
            cnts[n][1] = cnts[n - 1][1] + cnts[n - 2][1];
        }
        return cnts[n];
    }
}
