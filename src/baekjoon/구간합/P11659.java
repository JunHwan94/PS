package baekjoon.구간합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P11659 {
    static int N, M;
    static int[] arr;
    static int[] accs;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());
        arr = new int[N + 1];
        accs = new int[N + 1];
        token = new StringTokenizer(br.readLine());
        for(int n = 1; n <= N; n++){
            arr[n] = Integer.parseInt(token.nextToken());
            if(n == 1) accs[n] = arr[n];
            else accs[n] = accs[n - 1] + arr[n];
        }

        int result;
        for(int m = 1; m <= M; m++){
            token = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(token.nextToken());
            int j = Integer.parseInt(token.nextToken());
            if(i == 1) result = accs[j];
            else result = accs[j] - accs[i - 1];
            sb.append(result).append('\n');
        }
        System.out.println(sb);
    }
}
