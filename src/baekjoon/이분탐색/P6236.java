package baekjoon.이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// 재귀
public class P6236 {
    static int days;
    static int withCnt;
    static int[] dMoney;
    static int sum;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        days = Integer.parseInt(token.nextToken());
        withCnt = Integer.parseInt(token.nextToken());
        dMoney = new int[days];
        for(int i = 0; i < days; i++){
            dMoney[i] = Integer.parseInt(br.readLine());
            sum += dMoney[i];
        }
        binarySearch(1, sum);
        System.out.println(min);
    }

    static int min = Integer.MAX_VALUE;
    static void binarySearch(int left, int right) {
        if(left > right) return;
        int mid = (left + right) / 2;
        if(isAvailable(mid)) {
            min = Math.min(min, mid);
            binarySearch(left, mid - 1);
        }else{
            binarySearch(mid + 1, right);
        }
    }

    static boolean isAvailable(int money){
        int cnt = 1;
        int inPocket = money;
        for(int i = 0; i < days; i++){
            if(money < dMoney[i]) return false;
            if(inPocket < dMoney[i]){
                inPocket = money;
                cnt++;
            }
            inPocket -= dMoney[i];
        }
        return cnt <= withCnt;
    }
// 반복
//    static int days;
//    static int withCnt;
//    static int[] dMoney;
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer token = new StringTokenizer(br.readLine());
//        days = Integer.parseInt(token.nextToken());
//        withCnt = Integer.parseInt(token.nextToken());
//        dMoney = new int[days];
//        int sum = 0;
//        for(int i = 0; i < days; i++){
//            sum += dMoney[i] = Integer.parseInt(br.readLine());
//        }
//        System.out.println(binarySearch(sum));
//    }
//
//    static int binarySearch(int right) {
//        int left = 1;
//        int ans = Integer.MAX_VALUE;
//        while(left <= right) {
//            int mid = (left + right) / 2;
//            if (isAvailable(mid)) {
//                right = mid - 1;
//                ans = Math.min(ans, mid);
//            } else {
//                left = mid + 1;
//            }
//        }
//        return ans;
//    }
//
//    static boolean isAvailable(int money){
//        int cnt = 1;
//        int inPocket = money;
//
//        for(int i = 0; i < days; i++){
//            if(money < dMoney[i]) return false;
//            if(inPocket < dMoney[i]){
//                inPocket = money;
//                cnt++;
//            }
//            inPocket -= dMoney[i];
//        }
//        return cnt <= withCnt;
//    }
}
