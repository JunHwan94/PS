package Level2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class P12981 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(3, new String[]{"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"})));
        System.out.println(Arrays.toString(solution(5, new String[]{"hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure", "establish", "hang", "gather", "refer", "reference", "estimate", "executive"})));
        System.out.println(Arrays.toString(solution(2, new String[]{"hello", "one", "even", "never", "now", "world", "draw"})));
    }

    public static int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        int player = 2;
        int[] turn = new int[n + 1];
        Arrays.fill(turn, 1);
        Set<String> set = new HashSet<>();
        set.add(words[0]);

        String prev = words[0];
        turn[1]++;
        for(int i = 1; i < words.length; i++){
            if(set.contains(words[i]) || prev.charAt(prev.length() - 1) != words[i].charAt(0)){
                answer[0] = player;
                answer[1] = turn[player];
                break;
            }
            set.add(words[i]);
            if(i == words.length - 1) {
                if(player == n) break;
                i = -1;
            }
            turn[player]++;
            player = (player + 1) % (n + 1);
            if(player == 0) player++;
            prev = words[i];
        }

        return answer;
    }
}
