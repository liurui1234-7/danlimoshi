
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
/*threadList[i].join()语句的作用是（本题共十个线程，如果线程二执行了此语句，就意味着线程二必须等待线程一执行完了
才可以从join发法中返回。而线程0需要等待main线程结 
 束。)
每个线程终止的前提是前驱线程的终止，每个线程等待前驱线程 
 终止后，才从join()方法返回。*/