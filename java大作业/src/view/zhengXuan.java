package view;
import entity.*;
import java.util.Scanner;
import biz.*;
public class zhengXuan {
	public static void show(){
		Scanner scanner=new Scanner(System.in);
		System.out.println("������ѧ����ѧ��");
		String studentNo=scanner.nextLine();
		System.out.println("������γ̵ı��");
		String courseNo=scanner.nextLine();
		System.out.println("������γ̵ļ���");
		int gradeNo=scanner.nextInt();
		SCBiz scbiz = new SCBiz();
		scbiz.zhengxuan(studentNo,courseNo,gradeNo);
	}
}
