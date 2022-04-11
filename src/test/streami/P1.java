package test.streami;

public class P1 {
    public static void main(String[] args) {
        System.out.println(solution(10, 21));
        System.out.println("-");
        System.out.println(solution(13, 11));
        System.out.println("-");
        System.out.println(solution(1, 8));
        System.out.println("-");
        System.out.println(solution(10, 1000000000));
    }

    public static int solution(int A, int B){
        if(A + B < 4){
            return 0;
        }

        int min = Math.min(A, B);
        int max = Math.max(A, B);
        int left = 1;
        int right = max / 2;
        int mid;
        while(left < right){
            mid = (left + right) / 2;
            if(mid * 4 <= max || (mid * 3 <= max && mid <= min) || (mid * 2 <= min && mid * 2 <= max)){
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        return left - 1;
    }
}
