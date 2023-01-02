package day03;

import java.util.Scanner;

public class IfEx06 {

	public static void main(String[] args) {
		/* Scanner를 이용하여 문자를 하나 입력받아
		 * 입력받은 문자가 +,-,*,/,%이면 산술연산자라고 출력하고 아니면
		 * 산술연산자가 아닙니다라고 출력하는 코드를 작성
		 * */
		Scanner sc  = new Scanner(System.in);
		System.out.println("문자를 입력하세요 : ");
		char ch = sc.next().charAt(0);
		//ch가 '+'와 같거나 ch가 '-'와 같거나 ch가 '*'와 같거나 ch가 '/'와 같거나
		//ch가 '%'와 같다면 산술연산자라고 출력
		if(ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '%') {
			System.out.println(ch + "는 산술연산자입니다.");
		}
		// 아니면 산술연산자가 아닙니다라고 출력
		else {
			System.out.println(ch + "는 산술연산자가 아닙니다.");
		}
		
		/*
		// 내가한거
		Scanner sc = new Scanner(System.in);
		char ch;
		System.out.print("문자를 입력하세요 : ");
		ch = sc.next().charAt(0);
		if(ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '%') {
			System.out.println(ch + "산술연산자입니다.");
		}else {
			System.out.println("산술연산자가 아닙니다.");
		}*/
	}

}
