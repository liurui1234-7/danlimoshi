package find;
public class Find {
  public static void find(StringBuffer p) {
	  String str=p.toString();
	  System.out.println("�����һ��ѧ����Ϣ��"+str.substring(0, 14));
	  System.out.println("���ÿһ��ѧ������Ϣ��");
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
