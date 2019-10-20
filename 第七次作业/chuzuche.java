
public class chuzuche {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      Siji a = new Siji();
      new Thread(a,"1haochuzu").start();
		new Thread(a,"2haochuzu").start();
		new Thread(a,"3haochuzu").start();
		new Thread(a,"4haochuzu").start();
		new Thread(a,"5haochuzu").start();
		
	}

}
class Siji extends Thread{
	private int chengke=100;
	public void run() {
		while(true) {
			if (chengke>0) {
				Thread th =Thread.currentThread();
				String th_name=th.getName();
				System.out.println(th_name  +"ฝำหอ"+chengke--+"");
			}
		}
	}
}