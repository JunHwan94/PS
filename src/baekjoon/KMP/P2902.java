package baekjoon.KMP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2902 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        char[] t = br.readLine().toCharArray();
        sb.append(t[0]);
        for (int i = 1; i < t.length; i++)
            if(t[i - 1] == '-') sb.append(t[i]);
        System.out.println(sb);
    }
}
