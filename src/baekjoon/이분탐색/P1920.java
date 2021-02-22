package baekjoon.이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1920 {
    static int N;
    static int[] inArr;
    static int M;
    static int[] tArr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        inArr = new int[N];
        StringTokenizer token = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            inArr[i] = Integer.parseInt(token.nextToken());
        }
        M = Integer.parseInt(br.readLine());
        tArr = new int[M];
        token = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            tArr[i] = Integer.parseInt(token.nextToken());
        }

        Arrays.sort(inArr);
        for (int i = 0; i < M; i++) {
            System.out.println(binarySearch(0, N - 1, tArr[i]));
        }
    }

    static int binarySearch(int x, int y, int target){
        if(x > y) return 0;
        if(inArr[x] == target || inArr[y] == target) return 1;

        int mid = (x + y) / 2;
        if(inArr[mid] == target) return 1;
        else if(inArr[mid] < target) return binarySearch(mid + 1, y, target);
        else if(inArr[mid] > target) return binarySearch(x, mid - 1, target);
        return 0;
    }
}