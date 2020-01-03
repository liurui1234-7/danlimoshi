package view;

import java.util.Scanner;

public class MainUI {
	public static void show() {
		System.out.println("----------欢迎来到学生选课系统----------");
		System.out.println("1-注册；2-修改密码；3-课程；4-登录；0-退出");
		Scanner scanner = new Scanner(System.in);
		String option = scanner.nextLine();
		switch (option) {
		case "1":
			RegisterUI.show();
			break;
		case "2":
			ModifyPasswordUI.show();
			break;
		case "3":
			CourseUI.show();
			break;
		case "4":
			LoginUI.show();
		case "0":
			System.exit(0);
		}
	}
}
