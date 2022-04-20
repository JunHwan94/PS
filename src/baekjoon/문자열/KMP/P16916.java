package baekjoon.문자열.KMP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class P16916 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] S = br.readLine().toCharArray();
        char[] P = br.readLine().toCharArray();

        int[] k = new int[P.length];
        for (int i = 1, j = 0; i < P.length; i++) {
            while(j > 0 && P[i] != P[j]){
                j = k[j - 1];
            }
            if(P[i] == P[j]){
                k[i] = ++j;
            }
        }

        int p = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 0, j = 0; i < S.length; i++) {
            while(j > 0 && S[i] != P[j]){
                j = k[j - 1];
            }
            if(S[i] == P[j]){
                if(j == P.length - 1){
                    p = 1;
                    list.add(i + 1 - P.length + 1);
                    j = k[j];
                }else{
                    j++;
                }
            }
        }

        System.out.println(p);
    }
}
