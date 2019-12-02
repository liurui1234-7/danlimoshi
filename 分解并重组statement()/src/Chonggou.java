import customer.*;
import move.*;
import rental.*;
public class Chonggou {
	public static void main(String[] args) {
	    Customer customer = new Customer("Àî»ª");
	    Rental rental =new Rental(new Movie("CHILDRENS",2),10);
	    customer.addRental(rental);
	    System.out.println(customer.statement());
	    
	}
}
