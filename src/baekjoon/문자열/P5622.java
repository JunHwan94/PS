package baekjoon.문자열;

import java.io.*;

public class P5622 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] chars = br.readLine().toCharArray();
        int seconds = 0;
        for(char c : chars){
            seconds += (c - 'A') / 3 + 3;
            if(c == 'S' || c == 'V' || c == 'Y' || c == 'Z')
                seconds--;
        }
        System.out.println(seconds);
    }
}
