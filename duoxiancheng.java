public class duoxiancheng{
	public static void main(String[] args){
		Name a = new Name();
		Name2 b = new Name2();
	     a.setName("xianchneg1");
	     b.setName("xiancheng2");
	     a.start();
	     b.start();
	}
}
class Name extends Thread{	
	public void run(){
		System.out.println("xiancheng1 ");
	}
}
class Name2 extends Thread{	
	public void run(){
		System.out.println("xiancheng2 ");
	}
}