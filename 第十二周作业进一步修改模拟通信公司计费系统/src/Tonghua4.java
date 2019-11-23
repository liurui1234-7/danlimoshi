import java.text.SimpleDateFormat;

import java.util.*;

public class Tonghua4 {



	public static void main(String[] args) {

		// TODO Auto-generated method stub

		TelcomUser5 telcomUser = new TelcomUser5("15515157782");

		telcomUser.generateCommunicateRecord();

		telcomUser.printDetails();
		telcomUser.printCallToNumber();


	}



}

class TelcomUser5{

	private String phoneNumber;

	private String callTo;

	private Vector communicationRecords;
	private HashSet callToNumbers;
	private ArrayList callToNumbers1;

	public TelcomUser5(String phoneNumber) {

		this.phoneNumber =phoneNumber;

		this.communicationRecords =new Vector();
		this.callToNumbers=new HashSet();
		this.callToNumbers1=new ArrayList();

		

	}

	void generateCommunicateRecord() {

		int recordNum=new Random().nextInt(10);

		for(int i=0;i<=recordNum;i++) {

			long timeStart=System.currentTimeMillis()-new Random().nextInt(36000000);

			long timeEnd=timeStart+60000+new Random().nextInt(600000);

			this.callTo = getCallToPhoneNumber();
			this.callToNumbers.add(this.callTo);
			this.callToNumbers1.add(this.callTo);
			this.communicationRecords.add(this.phoneNumber +","+timeStart+","+timeEnd+","+this.callTo);

			

		}

		

	}

	private String getCallToPhoneNumber() {

		return "1380372"+String.valueOf("0")

		+String.valueOf("0")

		+String.valueOf("0")

		+String.valueOf(new Random().nextInt(10));

		

	}

	public void printCallToNumber() {
		for(Object callTo:this.callToNumbers1) {
			System.out.println((String)callTo);
		}
		System.out.println("--------List/Set分割线---------");
		for(Object callTo:this.callToNumbers) {
			System.out.println((String)callTo);
		}
	}


	void printDetails() {

		
		Enumeration enumeration = this.communicationRecords.elements();


		SimpleDateFormat dfi = new SimpleDateFormat("yyyy年MM月dd日  HH:mm:ss");

		while(enumeration.hasMoreElements()) {

			String [] recordField = ((String)enumeration.nextElement()).split(",");

			System.out.println("主叫："+recordField[0]);

			System.out.println("被叫："+recordField[3]);

			System.out.println("通话开始时间："+dfi.format(Long.parseLong(recordField[1])));

			System.out.println("通话结束时间："+dfi.format(Long.parseLong(recordField[2])));

			System.out.println("计费："+accountFee(Long.parseLong(recordField[1]),Long.parseLong(recordField[2]))+"元");

		}

	}

	private String accountFee(long timeStart,long timeEnd) {

		double feePerMinute =0.2;

		int minutes=Math.round((timeEnd-timeStart)/60000);

		double feeTotal=feePerMinute*minutes;

		return String.format("%.4f", feeTotal);

	}

}