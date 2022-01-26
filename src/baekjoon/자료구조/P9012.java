package baekjoon.자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class P9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++){
            Stack<Character> stack = new Stack<>();
            char[] inArr = br.readLine().toCharArray();
            for(char c : inArr) {
                if (c == '(') stack.push(c);
                else if(!stack.isEmpty() && stack.peek() == '(' && c == ')') stack.pop();
                else stack.push(c);
            }
            System.out.println(stack.size() == 0 ? "YES" : "NO");
        }
    }
}
