package remove;
public class Remove {
 public static void remove(StringBuffer p) {
	 p.delete(0, 14);
	 System.out.println("删除指定位置结果："+p);
 }
}
