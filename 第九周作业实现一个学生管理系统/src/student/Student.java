package student;
import add.*;
import remove.*;
import alter.*;
import find.*;
public class Student {
     public static void main(String[] args) {
    	 StringBuffer sb=new StringBuffer("刘玉霞 184805019 -郭珍珍 184805010 -胡娜184805011 -金卫杰184805013");
    	 System.out.println("-----欢迎来到学生管理系统-----");
    	 System.out.println("1 添加---------");
    	 Add.add(sb);
    	 System.out.println("2 删除---------");
    	 Remove.remove(sb);
    	 System.out.println("3 修改---------");
    	 Alter.alter(sb);
    	 System.out.println("4 查找---------");
    	 Find.find(sb);
    	 
     }
}
