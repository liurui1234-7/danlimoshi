//���˼Ʒѷ���

package rental;
import move.*;

public class Rental3 {
	private Movie1 _movie;
	private int _daysRented;
	//����Ӱ����ÿ������������
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
	//�ѼƷѷ�ʽ�Ž�Movie���У�Ȼ���޸�Rental��getCharge(),����ʹ������º�����
	public double getCharge() {
		return _movie.getCharge(_daysRented);
	}
	public int getFrequentRenterPoints() {
		return  _movie.getFrequenterPoints(_daysRented);
		
}
}
