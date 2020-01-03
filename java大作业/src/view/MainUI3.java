package view;
import java.util.Scanner;
public class MainUI3 {
	public static void show(){
		System.out.println("1-ีýักฃป2-อหักฃป");
		Scanner scanner=new Scanner(System.in);
		   String option=scanner.nextLine();
		   switch(option) {
		   case"1":
			   zhengXuan.show();
		   case"2":
			   tuiXuan.show();
		   case "0":
				System.exit(0);
		   }
	}
}
