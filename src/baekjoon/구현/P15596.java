package baekjoon.구현;

public class P15596 {
    static long sum(int[] a){
        long ans = 0;
        for (int i1 : a) {
            ans += i1;
        }
        return ans;
    }

    public static void main(String[] args){
        int[] a = {1,2,3,4,5};
        System.out.println(sum(a));
    }
}