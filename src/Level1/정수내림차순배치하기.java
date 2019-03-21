package Level1;
import java.util.Arrays;

public class 정수내림차순배치하기 {
    public long solution(long n) {
        char[] cArr = new String(Long.toString(n)).toCharArray();
        Arrays.sort(cArr);
        return Long.parseLong(new StringBuilder(new String(cArr)).reverse().toString());
    }
}
