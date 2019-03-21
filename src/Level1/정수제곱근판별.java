package Level1;

public class 정수제곱근판별 {
    public long solution(long n) {
        if(Math.pow((long)Math.sqrt(n), 2) == n)
            return (long)Math.pow(Math.sqrt(n) + 1, 2);
        return -1;
    }
}
