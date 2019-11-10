package find;
public class Find {
  public static void find(StringBuffer p) {
	  String str=p.toString();
	  System.out.println("输出第一个学生信息："+str.substring(0, 14));
	  System.out.println("输出每一个学生的信息：");
	  String[] strArray=str.split("-");
	  for(int i=0;i<strArray.length;i++) {
		  if(i!=strArray.length-1) {
			  System.out.print(strArray[i]+",");
		  }else {
			  System.out.println(strArray[i]);
		  }
	  }
  }
}
