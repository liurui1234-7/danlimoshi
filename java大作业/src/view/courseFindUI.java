package view;
import biz.*;
import java.util.Scanner;

public class courseFindUI {
	public static void show() {
		Scanner scanner=new Scanner(System.in);
		System.out.println("������Ҫ���ҵ�ѧ��");
		String courseNo=scanner.nextLine();
		CourseBiz a =new CourseBiz();
		a.courseFind(courseNo);
		
	}
}
