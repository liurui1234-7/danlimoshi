package class1;
import denglu.*;
import storage.*;
import zhuxiao.*;
public class Class1{
	public static void main(String[] args){
		Storage st=new Storage();
		Input input = new Input(st);
		Output output = new Output(st);
		new Thread(input).start();
		new Thread(output).start();			
	}
}

