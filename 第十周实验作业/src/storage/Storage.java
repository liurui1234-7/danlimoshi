package storage;
public class Storage{
	private String[] cells = new String[10];
	private int inPos,outPos;
	private int count;
	public synchronized void put(String s){
		try{
			while(count==cells.length){
				this.wait();
			}
			cells[inPos]=s;
			System.out.println("��cell["+inPos+"]���û���¼**"+cells[inPos]);
			inPos++;
			if(inPos==cells.length)
				inPos=0;
			count++;
			this.notify();
							
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public synchronized void get(){
		try{
			while(count==0){
				this.wait();
			}
			String data=cells[outPos];
			System.out.println("��cells["+outPos+"]��ȡ������"+data);
			cells[outPos]=null;
			outPos++;
			if(outPos==cells.length)
				outPos=0;
			count--;
			this.notify();
				
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
}