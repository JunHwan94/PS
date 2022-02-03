package baekjoon.완전탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1107 {

    static String sn;
    static int N;
    static boolean[] isBroken;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sn = br.readLine();
        N = stoi(sn);
        int brokenCount = stoi(br.readLine());
        isBroken = new boolean[10];
        if(brokenCount > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < brokenCount; i++) {
                int brokenButton = stoi(st.nextToken());
                isBroken[brokenButton] = true;
            }
        }

        min = Math.min(min, Math.abs(N - 100));
        if(min > 0) {
            for (int i = 0; i < 10; i++) {
                if(!isBroken[i]) {
                    pushButton(i, 1);
                }
            }
        }

        System.out.println(min);
    }

    static int min = 1000000;
    static void pushButton(int n, int length){
        if(n < 0) return;

        // 차이만큼 더하기
        int diff = Math.abs(n - N);
        min = Math.min(min, length + diff);
        if(length > sn.length()){
            return;
        }

        for (int i = 0; i < 10; i++) {
            if(!isBroken[i]){
                pushButton(n * 10 + i, length + 1); // 다음 버튼 누름
            }
        }
    }

    static int stoi(String s){
        return Integer.parseInt(s);
    }
}