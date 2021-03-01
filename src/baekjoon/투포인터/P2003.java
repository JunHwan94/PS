package baekjoon.투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P2003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(token.nextToken());
        int M = Integer.parseInt(token.nextToken());
        int[] arr = new int[N];
        token = new StringTokenizer(br.readLine());
        for(int n = 0; n < N; n++){
            arr[n] = Integer.parseInt(token.nextToken());
        }
        Arrays.sort(arr);
        int left = 0, right = arr.length - 1;
        int result = 0;
        while(left < right){
            int sum = 0;
            for(int i = left; i <= right; i++){
                sum += arr[i];
            }
//            System.out.println(sum);
            if(sum == M){
                right--;
                result++;
            }else if(sum > M){
                right--;
            }else{
                left++;
            }
        }
        System.out.println(result);
    }
}