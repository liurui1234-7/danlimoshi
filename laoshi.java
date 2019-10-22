
public class laoshi {
	public static void main(String[] args) {
		Teacher t = new Teacher();
		new Thread(t, "语文老师").start();
	    new Thread(t, "数学老师").start();
	    new Thread(t, "英语老师").start();
	}
}
class Teacher implements Runnable {
	private int notes;
	public void run() {
		while (true) {
			if(notes<=80) {
				Thread th=Thread.currentThread();
				String th_name=th.getName();
				System.out.println(th_name+"发"+notes+++"本");
			}
		}
	}
}