
public class laoshi {
	public static void main(String[] args) {
		Teacher t = new Teacher();
		new Thread(t, "������ʦ").start();
	    new Thread(t, "��ѧ��ʦ").start();
	    new Thread(t, "Ӣ����ʦ").start();
	}
}
class Teacher implements Runnable {
	private int notes;
	public void run() {
		while (true) {
			if(notes<=80) {
				Thread th=Thread.currentThread();
				String th_name=th.getName();
				System.out.println(th_name+"��"+notes+++"��");
			}
		}
	}
}