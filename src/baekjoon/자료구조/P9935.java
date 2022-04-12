package baekjoon.자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class P9935 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String bomb = br.readLine();
        int bombLength = bomb.length();

        Stack<Character> s = new Stack<>();
        for (int i = 0; i < input.length(); i++) {
            s.push(input.charAt(i));

            if(s.size() >= bombLength) {
                boolean isSame = true;
                for (int j = 0; j < bombLength; j++) {
                    if (s.get(s.size() - bombLength + j) != bomb.charAt(j)) {
                        isSame = false;
                        break;
                    }
                }
                if(isSame){
                    for (int j = 0; j < bombLength; j++) {
                        s.pop();
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(char c : s){
            sb.append(c);
        }
        if(sb.length() == 0){
            sb.append("FRULA");
        }
        System.out.println(sb);
    }
}
