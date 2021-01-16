package Level2;

public class 카펫 {
    public int[] solution(int brown, int red) {
        int[] answer = new int[2];
            for(int i = 3; i < brown / 2; i++){
            for(int j = 3; j <= i; j++){
                if((i - 2) * (j - 2) == red && i + j == brown / 2 + 2){
                    answer[0] = i;
                    answer[1] = j;
                }
            }
        }
            return answer;
    }
}
