package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.function.Function;

/**
 * 가르침
 * 1. anta tica에 포함된 알파벳 antic 가르침 표시
 *    K - 5이 0미만이면 아무것도 읽을 수 없음
 * 2. 추가로 가르칠 알파벳 고르기. 조합
 * 3. 각 경우 읽을 수 있는 단어 개수 세고 최대값 갱신
 */
public class P1062 {
    static Function<String, Integer> stoi = Integer::parseInt;
    static int N, K;
    static int[] selected;
    static List<String> words;
    static boolean[] teached;
    static String antatica = "antic";
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = stoi.apply(st.nextToken()); // 주어진 단어 수 <= 50
        K = stoi.apply(st.nextToken()); // 가르칠 글자 수 <= 26

        selected = new int[K];
        teached = new boolean[26];
        words = new ArrayList<>();
        for (int i = 0; i < N; i++){
            String in = br.readLine();
            words.add(in);
        }

        for (int i = 0; i < antatica.length(); i++)
            teached[antatica.charAt(i) - 'a'] = true;

        // 가르쳐야 할 알파벳 수 (K - 5) 가 0 미만이면 아무것도 읽을 수 없음
        if(K - 5 < 0){
            System.out.println(0);
            return;
        }

        // 가르칠 알파벳 조합
        comb(0, 0);
        System.out.println(max);
    }

    public static void comb(int cnt, int start){
        if(cnt == K - 5){
            // 가르침 표시
            for (int i = 0; i < selected.length; i++)
                teached[selected[i]] = true;
            // 가르친 알파벳으로 읽을 수 있는 단어 개수 세기
            countWords();
            // 가르침 표시 해제
            for (int i = 0; i < selected.length; i++)
                teached[selected[i]] = false;
            return;
        }

        for(int i = start; i < 26; i++){
            if(teached[i]) continue; // antatica에 포함된 알파벳이면 가르칠 것에 추가하지 않음
            selected[cnt] = i;
            comb(cnt + 1, i + 1);
        }
    }

    static int max = 0;
    private static void countWords() {
        int cnt = 0;
        for (String word : words) {
            boolean readable = true;
            // 단어에 있는 알파벳이 가르친 것인지 체크
            for (int j = 0; j < word.length(); j++) {
                if (!teached[word.charAt(j) - 'a']) {
                    readable = false;
                    break;
                }
            }
            if (readable) cnt++;
        }
        // 최대값 계산
        max = Math.max(max, cnt);
    }
}