package Level2;

public class 전화번호목록 {
    public static boolean solution(String[] phone_book) {
        boolean answer = true;
        for(String s1 : phone_book){
            for(String s2: phone_book){
                if(!s1.equals(s2) && s2.indexOf(s1) == 0)
                    return false;
            }
        }
        return answer;
    }

    public static void main(String[] args){
        boolean result = solution(new String[]{"119", "97674223", "1195524421"});
        System.out.println(result);
    }
}