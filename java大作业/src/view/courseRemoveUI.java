package view;
import biz.*;
import java.util.Scanner;
public class courseRemoveUI {
	public static void show() {
		Scanner scanner=new Scanner(System.in);
		System.out.println("������γ̵ı��");
		String courseNo=scanner.nextLine();
		System.out.println("������γ̵�����");
		String courseName=scanner.nextLine();
		System.out.println("������γ̵ĳɼ�");
		String courseGrade=scanner.nextLine();
		CourseBiz coursebiz=new CourseBiz();
		coursebiz.courseRemove(courseNo,courseName,courseGrade);
	}
}
