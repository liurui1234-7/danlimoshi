package view;

import java.util.Scanner;

import biz.CourseBiz;

public class courseModifyUI {
	public static void show() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("������γ̵ı�ţ�");
		String courseNo = scanner.nextLine();
		System.out.println("������ԭ���γ̵����֣�");
		String oldcourseName = scanner.nextLine();
		System.out.println("�������¿γ̵�����");
		String newcourseName = scanner.nextLine();
		System.out.println("�������¿γ̵ĳɼ�: ");
		int newcourseGrade = scanner.nextInt();
		
		CourseBiz coursebiz = new CourseBiz();
		coursebiz.courseModify(courseNo, oldcourseName, newcourseName,newcourseGrade);
	}
}
