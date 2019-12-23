package Level2;

import java.util.*;

public class 큰수만들기{
    public static String solution(String number, int k){
        String answer = "";

        int left, right;
        int originLength = number.length();
        int returnLength = originLength - k;
        for(int i = 1; returnLength < number.length(); i++){
            left = Integer.parseInt(Character.toString(number.charAt(i - 1)));
            right = Integer.parseInt(Character.toString(number.charAt(i)));

            if(left < right) {
                number = number.replaceFirst(String.valueOf(left), "");
                if(number.length() != returnLength + 1)
                    i--;
            } else if(right < left){
                number = number.replaceFirst(String.valueOf(right), "");
                if(number.length() != returnLength + 1)
                    i--;
            }

//            System.out.println("인덱스 : " + i + ", 숫자 " + number);
        }
        System.out.println("결과 " + number);
        return answer;
    }

    @Override
    protected void finalize() throws Throwable{
        super.finalize();
    }
}
