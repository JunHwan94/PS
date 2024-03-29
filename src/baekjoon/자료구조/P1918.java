package baekjoon.자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class P1918 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        Stack<Character> operators = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < line.length(); i++){
            char c = line.charAt(i);
            if(c == '+' || c == '-'){
                while(!operators.isEmpty() && operators.peek() != '('){
                    sb.append(operators.pop());
                }
                operators.push(c);
            }else if(c == '*' || c == '/'){
                while(!operators.isEmpty() && (operators.peek() == '*' || operators.peek() == '/')){
                    sb.append(operators.pop());
                }
                operators.push(c);
            }else if(c == '('){
                operators.push(c);
            }else if(c == ')'){
                while(!operators.isEmpty() && operators.peek() != '('){
                    sb.append(operators.pop());
                }
                operators.pop();
            }else sb.append(c); // 피연산자
        }
        while(!operators.isEmpty()) {
            if(operators.peek() == '(') operators.pop();
            else sb.append(operators.pop());
        }
        System.out.println(sb);
    }
}
