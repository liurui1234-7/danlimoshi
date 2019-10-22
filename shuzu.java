
public class shuzu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
   shuzi ab=new shuzi();
   new Thread(ab,"1hao").start();
   new Thread(ab,"2hao").start();
   
	}

}
class shuzi implements Runnable{
	public void run(){
		int[] a=new int[100];
		for(int j=0;j<100;j++)
		{
			a[j]=j;
		}
		for(int i=0;i<100;i++)
		{
			System.out.println(a[i]);
		}
		
	}
}
