package swea;

import java.util.Scanner;

public class P2072 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int sum = 0;
            for(int i = 0; i < 10; i++){
                int input = sc.nextInt();
                sum += input % 2 == 1 ? input : 0;
            }
            System.out.println("#" + test_case + " " + sum);
        }
    }
}