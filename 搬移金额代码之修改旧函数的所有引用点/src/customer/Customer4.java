//搬移“金额计算”代码后找出程序中对于旧函数的所有引用点，并修改它们
package customer;
import rental.*;
import java.util.Enumeration;
import java.util.Vector;

import move.Movie;
import rental.Rental1;

public class Customer4 {
     private String _name;
     private Vector _rentals=new Vector();
     public Customer4(String name) {
    	 _name=name;
    	 
     }
     //添加租赁的影片
     public void addRental(Rental1 arg) {
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
    		 Rental1 each=(Rental1)rentals.nextElement();
    	//找出程序中对于旧函数的所有引用点，并修改它们	 
    	    thisAmount=each.getCharge();
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


      private double amountFor(Rental1 aRental) {
	
	return aRental.getCharge();
}
}
