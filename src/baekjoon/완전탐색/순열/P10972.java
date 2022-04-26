package baekjoon.완전탐색.순열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P10972 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = stoi(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = stoi(st.nextToken());
        }

        if(N == 1){
            System.out.println(-1);
            return;
        }

        int x = -1;
        for (int i = N - 1; i > 0; i--) {
            if(arr[i - 1] < arr[i]){
                x = i - 1;
                break;
            }
        }

        if(x == -1){
            x = N - 2;
        }

        int y = 0;
        for (int i = N - 1; i > x; i--) {
            if(arr[x] < arr[i]){
                y = i;
                break;
            }
        }

        if(y == 0){
            y = N - 1;
        }

        boolean isLast = true;
        for (int i = 0; i < N - 1; i++) {
            if(arr[i] < arr[i + 1]){
                isLast = false;
                break;
            }
        }

        if(isLast) {
            System.out.println(-1);
        }else{
            int tmp = arr[x];
            arr[x] = arr[y];
            arr[y] = tmp;

            for (int i = 1; x + i < (x + N) / 2 + 1; i++) {
                tmp = arr[x + i];
                arr[x + i] = arr[N - i];
                arr[N - i] = tmp;
            }

            for (int i = 0; i < N; i++) {
                System.out.print(arr[i] + " ");
            }
        }

    }

    static int stoi(String s){
        return Integer.parseInt(s);
    }
}
