package view;
import entity.*;
import java.util.Scanner;
import biz.*;
public class zhengXuan {
	public static void show(){
		Scanner scanner=new Scanner(System.in);
		System.out.println("请输入学生的学号");
		String studentNo=scanner.nextLine();
		System.out.println("请输入课程的编号");
		String courseNo=scanner.nextLine();
		System.out.println("请输入课程的绩点");
		int gradeNo=scanner.nextInt();
		SCBiz scbiz = new SCBiz();
		scbiz.zhengxuan(studentNo,courseNo,gradeNo);
	}
}
