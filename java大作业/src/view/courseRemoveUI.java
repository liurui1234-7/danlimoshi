package view;
import biz.*;
import java.util.Scanner;
public class courseRemoveUI {
	public static void show() {
		Scanner scanner=new Scanner(System.in);
		System.out.println("请输入课程的编号");
		String courseNo=scanner.nextLine();
		System.out.println("请输入课程的名字");
		String courseName=scanner.nextLine();
		System.out.println("请输入课程的成绩");
		String courseGrade=scanner.nextLine();
		CourseBiz coursebiz=new CourseBiz();
		coursebiz.courseRemove(courseNo,courseName,courseGrade);
	}
}
