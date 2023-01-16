package sk000801.백준.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 학점계산 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String C = br.readLine();
		
		switch(C) {
		//꼭 break를 해줘야 해당 값을 출력후 switch를 종료시킨다.
		//없다면 그 아래 케이스를 다 출력해 버리기때문이다.
		case "A+": System.out.println(4.3);
		break;
		case "A0": System.out.println(4.0);
		break;
		case "A-": System.out.println(3.7);
		break;
		case "B+": System.out.println(3.3);
		break;
		case "B0": System.out.println(3.0);
		break;
		case "B-": System.out.println(2.7);
		break;
		case "C+": System.out.println(2.3);
		break;
		case "C0": System.out.println(2.0);
		break;
		case "C-": System.out.println(1.7);
		break;
		case "D+": System.out.println(1.3);
		break;
		case "D0": System.out.println(1.0);
		break;
		case "D-": System.out.println(0.7);
		break;
		case "F": System.out.println(0.0);
		break;
		}
	}

}