//�ԡ����ɻ��ּ��㡱�ⲿ�ִ��������ع��ַ�
package customer;
import rental.*;
import java.util.Enumeration;
import java.util.Vector;

import move.Movie;
import rental.Rental2;

public class Customer6 {
     private String _name;
     private Vector _rentals=new Vector();
     public Customer6(String name) {
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
    		 totalAmount+=each.getCharge();
    		 
    	 }
    	 result += "Amount owed is" + String.valueOf(totalAmount)+"\n";
    	 result += "You earned"+ String.valueOf(frequentRenterPoints)+ "frequent renter points";
    	 return result;
     }


      private double amountFor(Rental2 aRental) {
	
	return aRental.getCharge();
}
}
