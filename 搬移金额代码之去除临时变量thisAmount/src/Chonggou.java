import customer.*;
import move.*;
import rental.*;
public class Chonggou {
	public static void main(String[] args) {
	    Customer5 customer = new Customer5("�");
	    Rental1 rental =new Rental1(new Movie("CHILDRENS",2),10);
	    customer.addRental(rental);
	    System.out.println(customer.statement());
	    
	}
}
