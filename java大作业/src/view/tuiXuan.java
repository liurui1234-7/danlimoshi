package view;

import java.util.Scanner;

import biz.SCBiz;

public class tuiXuan {
	public static void show(){
		Scanner scanner=new Scanner(System.in);
		System.out.println("������ѧ����ѧ��");
		String studentNo=scanner.nextLine();
		System.out.println("������γ̵ı��");
		String courseNo=scanner.nextLine();
		System.out.println("������γ̵ļ���");
		int gradeNo=scanner.nextInt();
		SCBiz scbiz = new SCBiz();
		scbiz.tuixuan(studentNo,courseNo,gradeNo);
	}
}
