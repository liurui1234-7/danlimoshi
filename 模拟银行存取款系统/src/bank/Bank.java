package bank;
import java.util.Scanner;
import dbutils.*;
import user.*;
public class Bank {
int account;
private static User user;
public static void main(String[] args){
	Bank b = new Bank();
	b.login();
	b.operate();
}
	public void operate(){
	Bank b = new Bank();
	while(true){
		System.out.println("请输入您要进行的操作，按回车结束");
		System.out.println("存款，1"+"\t"+"取款,2"+"\t"+"余额，3"+"\t"+"退出,0");
		Scanner in = new Scanner(System.in);//System.in作为参数传递给Scanner的构造函数，使Scanner用键盘作为输入，然后用new在内存中实例化一个Scanner出来，使得其它变量能调用这块内存区
		String s = in.nextLine();//nextLine(); 这个函数会直接输出你输入的内容，即使你什么都没输入直接回车他也会输出。
		if("1".equals(s)||"2".equals(s)){
			int num = 0;
			try{
				System.out.print("输入存取的金额");
				num = Integer.parseInt(in.nextLine());//Integer是java中的一个内置类，parseInt()是这个类的一个静态方法，这个方法的作用是把括号里面的参数（args[0])转为int型的值，
			}catch(Exception e){
				System.out.println("金额输入错误");
				continue;
			}
			switch(s){
			case "1":
				b.income(num);
				break;
			case "2":
				b.takeout(num);
				break;
			}
		}else if("3".equals(s)){
			b.show();
		}else if("0".equals(s)){
			System.out.println("退出系统！");
			return;
		}else{
			System.out.println("请输入0~3之间的数字选择相关操作");
		}
	}
	}
	
	public void income(int num){
		account = user.getAccount()+num;
		user.setAccount(account);
		System.out.println("存入金额"+ num +"元成功！");
	}
	
	public void takeout(int num){
		if(user.getAccount()>= num){
			account = user.getAccount() - num;
			user.setAccount(account);
			System.out.println("取出金额" +num +"元成功");
		}else{
			System.out.println("余额不足，取款失败");
		}
	}
	
	public void show(){
		account = user.getAccount();
		System.out.println("账户总余额为" + account +"元");
	}
	
	public void login(){
		DBUtils dbutil = DBUtils.getInstance();
		System.out.println("登陆网上银行");
		while(true){
			Scanner in = new Scanner(System.in);
			System.out.println("请输入银行卡号");
			String cardId = in.nextLine();
			System.out.println("请输入银行卡密码");
			String cardPwd = in.nextLine();
			user = dbutil.getUser(cardId);
			//登录
			if( dbutil.getUsers().containsKey(cardId)&&user.getCardPwd().equals(cardPwd)){
				System.out.println("登陆成功！欢迎"+user.getUserName()+"先生");
				break;
			}
			else{
				System.out.println("银行卡号或密码错误！");
				continue;
			}
		}
	}
	
	
	
}
