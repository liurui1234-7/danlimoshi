package bank;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import dbutils.*;
import user.*;
public class Bank {
int account;
private static User user;
public static void main(String[] args) throws IOException{
	Bank b = new Bank();
	b.login();
	b.operate();
}
	public void operate() throws IOException{
	Bank b = new Bank();
	while(true){
		System.out.println("��������Ҫ���еĲ��������س�����");
		System.out.println("��1"+"\t"+"ȡ��,2"+"\t"+"��3"+"\t"+"ע�ᣬ4"+"\t"+"���̣�5"+"\t"+"�˳�,0");
		Scanner in = new Scanner(System.in);//System.in��Ϊ�������ݸ�Scanner�Ĺ��캯����ʹScanner�ü�����Ϊ���룬Ȼ����new���ڴ���ʵ����һ��Scanner������ʹ�����������ܵ�������ڴ���
		String s = in.nextLine();//nextLine(); ���������ֱ���������������ݣ���ʹ��ʲô��û����ֱ�ӻس���Ҳ�������
		if("1".equals(s)||"2".equals(s)){
			int num = 0;
			try{
				System.out.print("�����ȡ�Ľ��");
				num = Integer.parseInt(in.nextLine());//Integer��java�е�һ�������࣬parseInt()��������һ����̬��������������������ǰ���������Ĳ�����args[0])תΪint�͵�ֵ��
			}catch(Exception e){
				System.out.println("����������");
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
		}else if("4".equals(s)) {
			b.register();
		}else if("5".equals(s)) {
			b.save();
		}
		else if("0".equals(s)){
			System.out.println("�˳�ϵͳ��");
			return;
		}else{
			System.out.println("������0~4֮�������ѡ����ز���");
		}
	}
	}
	
	public void income(int num){
		account = user.getAccount()+num;
		user.setAccount(account);
		System.out.println("������"+ num +"Ԫ�ɹ���");
	}
	
	public void takeout(int num){
		if(user.getAccount() >= num){
			account =user.getAccount() - num;
			user.setAccount(account);
			System.out.println("ȡ�����" +num +"Ԫ�ɹ�");
		}else{
			System.out.println("���㣬ȡ��ʧ��");
		}
	}
	
	public void show(){
		account = user.getAccount();
		System.out.println("�˻������Ϊ" + account +"Ԫ");
	}
	
	public void login() throws FileNotFoundException{
		DBUtils dbutil = DBUtils.getInstance();
		System.out.println("��½��������");
		while(true){
			Scanner in = new Scanner(System.in);
			System.out.println("���������п���");
			String cardId = in.nextLine();
			System.out.println("���������п�����");
			String cardPwd = in.nextLine();
			user = dbutil.getUser(cardId);
			//��¼
			if( dbutil.getUsers().containsKey(cardId)&&user.getCardPwd().equals(cardPwd)){
				System.out.println("��½�ɹ�����ӭ"+user.getUserName()+"����");
				break;
			}
			else{
				System.out.println("���п��Ż��������");
				continue;
			}
		}
	}
	private void register() throws FileNotFoundException {
		User u = new User();
		Scanner scanner=new Scanner(System.in);
		System.out.println("���뿨�ţ�");
		u.setCardId(scanner.nextLine());
		System.out.println("�����û���:");
		u.setUserName(scanner.nextLine());
		System.out.println("��������");
		u.setCardPwd(scanner.nextLine());
		System.out.println("�����ֻ���:");
		u.setCall(scanner.nextLine());
		System.out.println("�������:");
		u.setAccount(Integer.parseInt(scanner.nextLine()));
		DBUtils dbutil =DBUtils.getInstance();
		dbutil.addUser(u);
		
	}
	private void save() throws IOException {
		DBUtils dbutil=DBUtils.getInstance();
		dbutil.update();
	}
	
	
	
}
