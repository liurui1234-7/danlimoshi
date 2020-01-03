package view;
import biz.*;
import java.util.Scanner;
public class courseAddUI {
	public static void show() {
		Scanner scanner=new Scanner(System.in);
		System.out.println("请输入课程的编号");
		String courseNo=scanner.nextLine();
		System.out.println("请输入课程的名字");
		String courseName=scanner.nextLine();
		System.out.println("请输入课程的成绩");
		int courseGrade= scanner.nextInt();
		CourseBiz coursebiz=new CourseBiz();
		coursebiz.courseAdd(courseNo,courseName,courseGrade);
		
	}
}
