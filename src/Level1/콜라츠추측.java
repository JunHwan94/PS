package Level1;

public class 콜라츠추측 {
    public int solution(int num) {
        int answer = 0;
        while (answer < 450) {
            if (num == 1) return answer;
            num = num % 2 == 0 ? num / 2 : num * 3 + 1;
            answer++;
        }
        return -1;
    }
}
