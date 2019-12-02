//计费方法和常客积分计算到Movie1中
//switch语句最好不要再另一个对象的属性基础上运用，如果不得不使用，也应该在对象自己的数据上使用，所以将getCharge()移到Movie类中

//为了控制即如新影片类型这种变化造成的不稳定后果，所以请租期长度传给Movie1对象，而不是将影片类型传给Rental对象

package move;

public class Movie1 {
     public static final int CHILDRENS=2;
     public static final int REGULAR=0;
     public static final int NEW_RELEASE=1;
     private String _title;
     private int _priceCode;
     public Movie1(String title,int priceCode) {
    	 _title=title;
    	 _priceCode=priceCode;
     }
     public int getPriceCode() {
    	 return _priceCode;
     }
     public void setPriceCode(int arg) {
    	 _priceCode=arg;
     }
     public String getTitle() {
    	 return _title;
     }
     public double getCharge(int daysRented) {
    	 double reasult=0;
		   switch(getPriceCode()) {
		 case Movie1.REGULAR:
			 reasult+=2;
			 if(daysRented>2)
				 reasult +=(daysRented -2)*1.5;
			 break;
		 case Movie1.NEW_RELEASE:
			 reasult += daysRented*3;
			 break;
		 case Movie1.CHILDRENS :
			 reasult += 1.5;
			 if(daysRented>3)
				 reasult +=(daysRented - 3)*1.5;
			 break;
	}
		   return reasult;
     }
     public int getFrequenterPoints(int daysRented) {
    	 if((getPriceCode()==Movie1.NEW_RELEASE)&&daysRented>1) return 2;
 		else
 			return 1;
     }
}
