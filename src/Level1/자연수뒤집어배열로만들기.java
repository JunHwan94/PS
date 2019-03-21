package Level1;

public class 자연수뒤집어배열로만들기 {

    public int[] solution(long n) {
        String s = "" + n;
        int[] iArr = new int[s.length()];
        for(int i = 0; i < s.length(); i++)
            iArr[i] = Integer.parseInt(Character.toString(s.charAt(s.length() - i - 1)));

        return iArr;
    }
}
