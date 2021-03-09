package baekjoon.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2491 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] incLengths = new int[N];
        int[] decLengths = new int[N];
        StringTokenizer token = new StringTokenizer(br.readLine());
        int max = 0;
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(token.nextToken());
            incLengths[i] = 1;
            decLengths[i] = 1;
            if(i > 0 && arr[i - 1] <= arr[i]) incLengths[i] = incLengths[i - 1] + 1;
            if(i > 0 && arr[i - 1] >= arr[i]) decLengths[i] = decLengths[i - 1] + 1;
            max = Math.max(max, incLengths[i]);
            max = Math.max(max, decLengths[i]);
        }
        System.out.println(max);
    }
}
