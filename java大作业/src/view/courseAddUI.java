package view;
import biz.*;
import java.util.Scanner;
public class courseAddUI {
	public static void show() {
		Scanner scanner=new Scanner(System.in);
		System.out.println("������γ̵ı��");
		String courseNo=scanner.nextLine();
		System.out.println("������γ̵�����");
		String courseName=scanner.nextLine();
		System.out.println("������γ̵ĳɼ�");
		int courseGrade= scanner.nextInt();
		CourseBiz coursebiz=new CourseBiz();
		coursebiz.courseAdd(courseNo,courseName,courseGrade);
		
	}
}
