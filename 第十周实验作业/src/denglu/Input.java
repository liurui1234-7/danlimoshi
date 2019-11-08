package denglu;
import storage.*;
import java.util.Random;
public class Input implements Runnable{
	private Storage st;
	Random a =new Random();
    public Input(Storage st) {
    	this.st=st;
	}
	public void run(){
    	while(true){
    		st.put(String.valueOf(a.nextInt(100)));
    		try {
    			Thread.sleep(a.nextInt(2000));
    			} catch (InterruptedException e) {
    			e.printStackTrace();
    			}
    		
    	}
    }
}