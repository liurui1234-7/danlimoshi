package student;
import add.*;
import remove.*;
import alter.*;
import find.*;
public class Student {
     public static void main(String[] args) {
    	 StringBuffer sb=new StringBuffer("����ϼ 184805019 -������ 184805010 -����184805011 -������184805013");
    	 System.out.println("-----��ӭ����ѧ������ϵͳ-----");
    	 System.out.println("1 ���---------");
    	 Add.add(sb);
    	 System.out.println("2 ɾ��---------");
    	 Remove.remove(sb);
    	 System.out.println("3 �޸�---------");
    	 Alter.alter(sb);
    	 System.out.println("4 ����---------");
    	 Find.find(sb);
    	 
     }
}
