
 public class xiangjia extends Thread{
	public static int sum;
	private int count;
	public xiangjia(int count) {
		this.count=count;
	}
	public static synchronized void add(int num) {
		sum=sum+num;
	}
	public void run() {
		int sum=0;
		for(int i=0;i<10;i++)
		{
			sum=sum+(count+i);
		}
		add(sum);
	}
	public static void main(String[] args) throws Exception{
		Thread[] threadList = new Thread[10];
		for(int i=0;i<10;i++)
		{
			threadList[i]=new xiangjia((10*i)+1);
			threadList[i].start();
		}
		for(int i=0;i<10;i++)
		{
			threadList[i].join();
		}
		System.out.println("Sum is : " + sum);
	}
}
/*threadList[i].join()���������ǣ����⹲ʮ���̣߳�����̶߳�ִ���˴���䣬����ζ���̶߳�����ȴ��߳�һִ������
�ſ��Դ�join�����з��ء����߳�0��Ҫ�ȴ�main�߳̽� 
 ����)
ÿ���߳���ֹ��ǰ����ǰ���̵߳���ֹ��ÿ���̵߳ȴ�ǰ���߳� 
 ��ֹ�󣬲Ŵ�join()�������ء�*/