package baekjoon.완전탐색.부분집합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P1759 {

	static int L, C;
	static char[] inArr;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		L = stoi(input[0]);
		C = stoi(input[1]);
		inArr = new char[C];
		input = br.readLine().split(" ");
		for(int i = 0; i < C; i++) {
			inArr[i] = input[i].toCharArray()[0];
		}
		Arrays.sort(inArr);
		supSet(0, "", 0, 0);
	}
	
	static String aeiou = "aeiou";
	static void supSet(int cnt, String result, int conCnt, int vowCnt) {
		if(cnt == C) {
			if(result.length() == L) {
				if(conCnt > 1 && vowCnt > 0)
					System.out.println(result);
			}
			return;
		}

		int nc = conCnt, nv = vowCnt;
		if(aeiou.indexOf(inArr[cnt]) == -1) nc++;
		else nv++;
		supSet(cnt + 1, result + inArr[cnt], nc, nv);
		
		supSet(cnt + 1, result, conCnt, vowCnt);
	}

	static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
