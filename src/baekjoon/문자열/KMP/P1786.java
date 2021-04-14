package baekjoon.문자열.KMP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class P1786 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] t = br.readLine().toCharArray();
        char[] p = br.readLine().toCharArray();
        int tLength = t.length;
        int pLength = p.length;

        int[] k = new int[pLength];
        for (int i = 1, j = 0; i < pLength; i++) {
            while(j > 0 && p[i] != p[j]) j = k[j - 1];
            if(p[i] == p[j]) k[i] = ++j;
        }

        int cnt = 0;
        List<Integer> list = new ArrayList<>();
        for(int i = 0, j = 0; i < tLength; i++){
            while(j > 0 && t[i] != p[j]) j = k[j - 1];
            if(t[i] == p[j]){
                if(j == pLength - 1){
                    cnt++;
                    list.add(i + 1 - pLength + 1);
                    j = k[j];
                }else j++;
            }
        }

        System.out.println(cnt);
        if(cnt > 0){
            for(int i = 0; i < list.size(); i++) {
                System.out.print(list.get(i) + " ");
            }
        }
    }
}
