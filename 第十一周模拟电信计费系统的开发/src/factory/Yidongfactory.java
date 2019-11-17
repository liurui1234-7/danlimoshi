package factory;
import dianxinyonghu .*;
import telcomuser.*;
public class Yidongfactory implements Yonghufactory{
	@Override
	public Yonghu produceYonghu() {
		// TODO Auto-generated method stub
		return new Yidong();
	}

}
