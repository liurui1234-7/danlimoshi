//分组并重构statement(),each不会被修改当做参数传入心得函数， thisAmount会被修改当做新函数的返回值



package customer;

import java.util.Enumeration;
import java.util.Vector;

import move.Movie;
import rental.Rental;

public class Customer1 {
     private String _name;
     private Vector _rentals=new Vector();
     public Customer1(String name) {
    	 _name=name;
    	 
     }
     //添加租赁的影片
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
    		 //each不会被修改当做参数传入新得函数
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


      private double amountFor(Rental each) {
	   double thisAmount=0;
	   switch(each.getMovie().getPriceCode()) {
	 case Movie.REGULAR:
		 thisAmount+=2;
		 if(each.getDaysRented()>2)
			 thisAmount +=(each.getDaysRented() -2)*1.5;
		 break;
	 case Movie.NEW_RELEASE:
		 thisAmount += each.getDaysRented()*3;
		 break;
	 case Movie.CHILDRENS :
		 thisAmount += 1.5;
		 if(each.getDaysRented()>3)
			 thisAmount +=(each.getDaysRented() - 3)*1.5;
		 break;
		 
	 }
	   //thisAmount会被修改当做新函数的返回值
	return thisAmount;
}
}
