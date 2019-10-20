
public class dayin {
	public static void main(String[] args) {
		MyThread a = new MyThread();
		Thread b = new Thread(a);
		b.start();
		for(int j=0;j<100;j++)
		{
			System.out.println("main");
		}
	}

}
class MyThread implements Runnable{
	public void run(){
		for(int i=0;i<50;i++)
		{
			System.out.println("new");
		}
	}
}