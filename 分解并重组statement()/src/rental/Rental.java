package rental;
import move.*;

public class Rental {
	private Movie _movie;
	private int _daysRented;
	//����Ӱ����ÿ������������
	public Rental(Movie movie,int daysRented) {
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

}
