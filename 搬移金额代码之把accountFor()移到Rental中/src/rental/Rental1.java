package rental;
import move.*;

public class Rental1 {
	private Movie _movie;
	private int _daysRented;
	//����Ӱ����ÿ������������
	public Rental1(Movie movie,int daysRented) {
		_movie = movie;
		_daysRented = daysRented;
	}
	public int getDaysRented() {
		// TODO Auto-generated method stub
		return _daysRented;
	}
	public Movie getMovie() {
		return _movie;
	}
	public double getCharge() {
		double reasult=0;
		   switch(getMovie().getPriceCode()) {
		 case Movie.REGULAR:
			 reasult+=2;
			 if(getDaysRented()>2)
				 reasult +=(getDaysRented() -2)*1.5;
			 break;
		 case Movie.NEW_RELEASE:
			 reasult += getDaysRented()*3;
			 break;
		 case Movie.CHILDRENS :
			 reasult += 1.5;
			 if(getDaysRented()>3)
				 reasult +=(getDaysRented() - 3)*1.5;
			 break;
	}
		   return reasult;
	}
}
