package baekjoon.문자열;

import java.io.*;
import java.util.StringTokenizer;

// 상수
public class P2908 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        String first = token.nextToken();
        String second = token.nextToken();

        sb.append(first);
        int i = Integer.parseInt(sb.reverse().toString());

        sb = new StringBuilder();
        sb.append(second);
        int j = Integer.parseInt(sb.reverse().toString());

        if(i < j) System.out.println(j);
        else System.out.println(i);
    }
}
