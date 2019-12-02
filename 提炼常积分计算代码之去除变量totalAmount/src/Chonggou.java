import customer.*;
import move.*;
import rental.*;
public class Chonggou {
	public static void main(String[] args) {
	    Customer7 customer = new Customer7("Àî»ª");
	    Rental2 rental =new Rental2(new Movie("CHILDRENS",2),10);
	    customer.addRental(rental);
	    System.out.println(customer.statement());
	    
	}
}
