//搬运计费方法

package rental;
import move.*;

public class Rental3 {
	private Movie1 _movie;
	private int _daysRented;
	//将电影名和每日租金收入存入
	public Rental3(Movie1 movie,int daysRented) {
		_movie = movie;
		_daysRented = daysRented;
	}
	public int getDaysRented() {
		// TODO Auto-generated method stub
		return _daysRented;
	}
	public Movie1 getMovie() {
		return _movie;
	}
	//把计费方式放进Movie类中，然后修改Rental的getCharge(),让它使用这个新函数。
	public double getCharge() {
		return _movie.getCharge(_daysRented);
	}
	public int getFrequentRenterPoints() {
		return  _movie.getFrequenterPoints(_daysRented);
		
}
}
