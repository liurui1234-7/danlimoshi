//去除临时变量totalAmount，利用getTotalCharge()查询函数来取代，由于totalAmount在循环内部不断被加，所以把循环复制到查询函数中
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
     //添加租赁的影片
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
    //由于frequentRenterPoints临时变量在先前提取出的新函数中并没有读取该取值，所以不需要当做参数传进去，只需要吧新函数的返回值累加上去就行了
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
