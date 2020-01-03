package view;
import java.util.Scanner;
public class MainUI2 {
   public static void show(){
	   System.out.println("1-课程增加；2-课程删除；3-课程修改；4-课程查询；5-学生选课；0-退出");
	   Scanner scanner=new Scanner(System.in);
	   String option=scanner.nextLine();
	   switch(option) {
	   case"1":
		   courseAddUI.show();
		   break;
	   case"2":
		   courseRemoveUI.show();
		   break;
	   case"3":
		   courseModifyUI.show();
		   break;
	   case"4":
		   courseFindUI.show();
	   case"5":
		   MainUI3.show();
	   case "0":
			System.exit(0);
	   }
   }
}
