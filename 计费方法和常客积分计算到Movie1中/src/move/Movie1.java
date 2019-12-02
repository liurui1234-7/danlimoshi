//�Ʒѷ����ͳ��ͻ��ּ��㵽Movie1��
//switch�����ò�Ҫ����һ����������Ի��������ã�������ò�ʹ�ã�ҲӦ���ڶ����Լ���������ʹ�ã����Խ�getCharge()�Ƶ�Movie����

//Ϊ�˿��Ƽ�����ӰƬ�������ֱ仯��ɵĲ��ȶ���������������ڳ��ȴ���Movie1���󣬶����ǽ�ӰƬ���ʹ���Rental����

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
