package view;

import java.util.Scanner;

public class MainUI {
	public static void show() {
		System.out.println("----------��ӭ����ѧ��ѡ��ϵͳ----------");
		System.out.println("1-ע�᣻2-�޸����룻3-�γ̣�4-��¼��0-�˳�");
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
