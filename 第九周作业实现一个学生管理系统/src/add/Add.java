package add;
public class Add {
	public static void add(StringBuffer p) {
    	  p.append(" -刘锐 184805017");
    	  System.out.println("添加指定位置结果为: "+p);
    	  p.insert(14, "-刘宇航  184805018 ");
    	  System.out.println("添加指定位置结果为: "+p);
      }
}
