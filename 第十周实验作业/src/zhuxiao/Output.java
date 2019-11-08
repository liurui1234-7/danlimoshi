package zhuxiao;
import storage.*;
import java.util.Random;
public class Output implements Runnable{
	private Storage st;
	Random b= new Random();
	public Output(Storage st){
		this.st=st;
		
	}
	public void run(){
	while(true){
		st.get();
		try {
			Thread.sleep(b.nextInt(2000));
			} catch (InterruptedException e) {
			e.printStackTrace();
			}
	}
	}
}
