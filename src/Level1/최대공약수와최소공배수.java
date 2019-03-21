package Level1;
import java.math.BigInteger;

public class 최대공약수와최소공배수 {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        BigInteger a = BigInteger.valueOf(n);
        BigInteger b = BigInteger.valueOf(m);
        BigInteger gcd = a.gcd(b);
        answer[0] = Integer.parseInt(gcd.toString());
        answer[1] = n * m / answer[0];
        return answer;
    }
}
