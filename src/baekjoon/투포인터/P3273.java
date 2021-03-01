package baekjoon.투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P3273 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer token = new StringTokenizer(br.readLine());
        for(int n = 0; n < N; n++){
            arr[n] = Integer.parseInt(token.nextToken());
        }
        int target = Integer.parseInt(br.readLine());
        Arrays.sort(arr);
        // 1 2 3 5 7 9 10 11 12
        // 1, 12
        // 1, 11 -> left++, 넘어감
        // 2, 11
        // 2, 10 -> left++, 넘어감
        int result = 0;
        int left = 0, right = arr.length - 1;
        while(left < right){
            int sum = arr[left] + arr[right];
            if(sum == target){
                right--;
                result++;
            }
            else if (sum > target) right--;
            else left++;
        }
        System.out.println(result);
    }
}
