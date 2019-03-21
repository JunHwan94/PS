package Level1;
import java.util.*;

public class 모의고사 {
    public int[] solution(int[] answers) {
        int[] answer = new int[3];
        int[] score = {0, 0, 0};
        int[] answer1 = {1, 2, 3, 4, 5};
        int[] answer2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] answer3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int index1 = 0;
        int index2 = 0;
        int index3 = 0;
        for(int i = 0; i < answers.length; i++){
            if(4 < index1) index1 -= 5;
            if(answers[i] == answer1[index1])
                score[0]++;
            index1++;

            if(7 < index2) index2 -= 8;
            if(answers[i] == answer2[index2])
                score[1]++;
            index2++;

            if(9 < index3) index3 -= 10;
            if(answers[i] == answer3[index3])
                score[2]++;
            index3++;
        }

        int max = 0;
        for(int i : score) {
            if (max < i) max = i;
        }

        for(int i = 0; i < score.length; i++) {
            if (max == score[i])
                answer[i] = i + 1;
        }


        List<Integer> list = new ArrayList<>();
        for(int i : answer){
            if(i != 0)
                list.add(i);
        }
        Collections.sort(list);
        answer = new int[list.size()];

        for(int i = 0; i < list.size(); i++)
            answer[i] = list.get(i);

        return answer;
    }
}
