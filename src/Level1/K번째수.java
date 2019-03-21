package Level1;
import java.util.Arrays;

public class K번째수 {
    public int[] solution(int[] array, int[][] commands) {
    int[] answer = new int[commands.length];

    for(int i = 0 ; i < commands.length; i++){
        int firstIndex = commands[i][0];
        int lastIndex = commands[i][1];
        int[] cutArray = new int[lastIndex-firstIndex+1];
        int k = 0;
        for(int j = firstIndex-1; j < lastIndex; j++){
            cutArray[k] = array[j];
            k++;
        }
        Arrays.sort(cutArray);
        answer[i] = cutArray[commands[i][2]-1];
    }
    return answer;
}
}
