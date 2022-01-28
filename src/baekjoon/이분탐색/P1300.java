package baekjoon.이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1300 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = stoi(br.readLine());
        int K = stoi(br.readLine());

        int left = 1; // B[k]의 최소값
        int right = K; // B[k]의 최대값

        // 이분탐색
        while(left < right){
            int mid = (left + right) / 2;
            int count = 0;

            for(int i = 1; i <= N; i++){
                // mid보다 작은 수 세기
                count += Math.min(mid / i, N); // N보다 많이 더할 수 있어서 둘 중 최소값 더하기
            }

            if(count < K){ // mid보다 작은 수의 개수가 K보다 적으면 오른쪽 탐색
               left = mid + 1;
            }else { // 아니면 왼쪽 탐색
                right = mid;
            }
        }

        System.out.println(left);
    }

    static int stoi(String s){
        return Integer.parseInt(s);
    }
}
