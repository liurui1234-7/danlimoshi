package view;
import java.util.Scanner;
public class MainUI2 {
   public static void show(){
	   System.out.println("1-�γ����ӣ�2-�γ�ɾ����3-�γ��޸ģ�4-�γ̲�ѯ��5-ѧ��ѡ�Σ�0-�˳�");
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
