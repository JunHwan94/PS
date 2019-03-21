package Level1;

public class 하샤드수 {
    public boolean solution(int x) {
        String[] sa = String.valueOf(x).split("");
        int sum = 0;
        for(String s : sa) sum += Integer.parseInt(s);
        return x % sum == 0;
    }
}
