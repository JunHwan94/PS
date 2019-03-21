package Level1;

import java.util.Scanner;

public class 직사각형별찍기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        String stars = new String(new char[a]).replace("\0", "*").substring(0,a);

        for(int j =0; j < b; j++)
            System.out.println(stars);
    }
}
