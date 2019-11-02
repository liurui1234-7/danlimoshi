
public class tongbu2 {
	public static void main(String[] args) {
		Ticket2 ticket = new Ticket2();		
		new Thread(ticket,"1").start();
		new Thread(ticket,"3").start();
		new Thread(ticket,"2").start();
	}
}
class Ticket2 implements Runnable{
	private int tickets=10;
	public void run() {
		while(true) {
			saleTicket();
			if(tickets<=0) {
				break;
			}
		}
		
	}
private synchronized void saleTicket() {
	if(tickets>0) {
		try {
			Thread.sleep(10);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+"---Âô³öµÄÆ±"+tickets--);
	}
}
}