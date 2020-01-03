package view;
import biz.*;
import java.util.Scanner;

public class courseFindUI {
	public static void show() {
		Scanner scanner=new Scanner(System.in);
		System.out.println("请输入要查找的学号");
		String courseNo=scanner.nextLine();
		CourseBiz a =new CourseBiz();
		a.courseFind(courseNo);
		
	}
}
