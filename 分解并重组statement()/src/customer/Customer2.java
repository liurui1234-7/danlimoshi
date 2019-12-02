//���ı������ƣ���������������룬���Ӵ���Ŀɶ���

package customer;
import rental.*;
import java.util.Enumeration;
import java.util.Vector;

import move.Movie;
import rental.Rental;

public class Customer2 {
     private String _name;
     private Vector _rentals=new Vector();
     public Customer2(String name) {
    	 _name=name;
    	 
     }
     //������޵�ӰƬ
     public void addRental(Rental arg) {
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
    		 double thisAmount=0;
    		 Rental each=(Rental)rentals.nextElement();
    		 //each���ᱻ�޸ĵ������������µú���
    		 thisAmount=amountFor(each);
    		 frequentRenterPoints++;
    		 if((each.getMovie().getPriceCode()==Movie.NEW_RELEASE)&&each.getDaysRented()>1)
    			 frequentRenterPoints++;
    		 result +="\t"+each.getMovie().getTitle()+"\t"+String.valueOf(thisAmount)+"\n";
    		 totalAmount+=thisAmount;
    		 
    	 }
    	 result += "Amount owed is" + String.valueOf(totalAmount)+"\n";
    	 result += "You earned"+ String.valueOf(frequentRenterPoints)+ "frequent renter points";
    	 return result;
     }

//�޸�amountFor�е����֣�Ŀ������ߴ���������ȣ�ʹ������ӶԵ��������
     
     private double amountFor(Rental aRental) {
  	   double reasult=0;
  	   switch(aRental.getMovie().getPriceCode()) {
  	 case Movie.REGULAR:
  		reasult+=2;
  		 if(aRental.getDaysRented()>2)
  			reasult +=(aRental.getDaysRented() -2)*1.5;
  		 break;
  	 case Movie.NEW_RELEASE:
  		reasult += aRental.getDaysRented()*3;
  		 break;
  	 case Movie.CHILDRENS :
  		reasult += 1.5;
  		 if(aRental.getDaysRented()>3)
  			reasult +=(aRental.getDaysRented() - 3)*1.5;
  		 break;
  		 
  	 }
  	   //thisAmount�ᱻ�޸ĵ����º����ķ���ֵ
  	return reasult;
  }
}
