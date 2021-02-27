package baekjoon.이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2512 {
    static int N;
    static int tBudget;
    static int[] budgets;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        budgets = new int[N];
        StringTokenizer token = new StringTokenizer(br.readLine());
        int max = 0;
        for(int n = 0; n < N; n++){
            budgets[n] = Integer.parseInt(token.nextToken());
            max = Math.max(max, budgets[n]);
        }
        tBudget = Integer.parseInt(br.readLine());

        binarySearch(1, max);
        System.out.println(upLimit);
    }

    static int upLimit;
    static void binarySearch(int left, int right){
        if(left > right) return;
        int mid = (left + right) / 2;
        if(isAvailable(mid)) {
            upLimit = mid;
            binarySearch(mid + 1, right);
        }
        else binarySearch(left, mid - 1);
    }

    static boolean isAvailable(int mid){
        int sum = 0;
        for(int i = 0; i < N; i++)
            sum += Math.min(budgets[i], mid);
        return sum <= tBudget;
    }
}
