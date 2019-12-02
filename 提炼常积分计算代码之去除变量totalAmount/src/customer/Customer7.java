//ȥ����ʱ����totalAmount������getTotalCharge()��ѯ������ȡ��������totalAmount��ѭ���ڲ����ϱ��ӣ����԰�ѭ�����Ƶ���ѯ������
package customer;
import rental.*;
import java.util.Enumeration;
import java.util.Vector;

import move.Movie;
import rental.Rental2;

public class Customer7 {
     private String _name;
     private Vector _rentals=new Vector();
     public Customer7(String name) {
    	 _name=name;
    	 
     }
     //������޵�ӰƬ
     public void addRental(Rental2 arg) {
    	 _rentals.addElement(arg);
    	 
     }
     public String getName() {
    	 return _name;
     }
     public String statement() {
    	 double totalAmount=0;
    	 int frequentRenterPoints=0;
    	 Enumeration rentals=_rentals.elements();
    	 String result="Rental Record for"+getName()+"\n";
    	 while(rentals.hasMoreElements()) {
    		
    		 Rental2 each=(Rental2)rentals.nextElement();	 
    //����frequentRenterPoints��ʱ��������ǰ��ȡ�����º����в�û�ж�ȡ��ȡֵ�����Բ���Ҫ������������ȥ��ֻ��Ҫ���º����ķ���ֵ�ۼ���ȥ������
    		 frequentRenterPoints += each.getFrequentRenterPoints();
    		 result +="\t"+each.getMovie().getTitle()+"\t"+String.valueOf(each.getCharge())+"\n";
    		
    		 
    	 }
    	 result += "Amount owed is" + String.valueOf(getTotalCharge())+"\n";
    	 result += "You earned"+ String.valueOf(frequentRenterPoints)+ "frequent renter points";
    	 return result;
     }


      private double amountFor(Rental2 aRental) {
	
	    return aRental.getCharge();
    }
      private double getTotalCharge() {
    	  double result=0;
    	  Enumeration rentals=_rentals.elements();
    	  while(rentals.hasMoreElements()) {
    		  Rental2 each =(Rental2)rentals.nextElement();
    		  result+=each.getCharge();
    		  }
    	  return result;
    	  }
}
