package Level2;

public class 주식가격 {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        for(int i = 0; i < prices.length; i++)
            for(int j = i + 1; j < prices.length; j++){
                if(prices[j] < prices[i]){
                    answer[i] = j - i;
                    break;
                }else if(j == prices.length - 1){
                    answer[i] = prices.length - i - 1;
                }
            }
        return answer;
    }
}
