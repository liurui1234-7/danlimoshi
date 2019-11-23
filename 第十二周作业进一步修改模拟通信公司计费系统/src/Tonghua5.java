import java.text.SimpleDateFormat;

import java.util.*;

public class Tonghua5 {



	public static void main(String[] args) {

		// TODO Auto-generated method stub

		TelcomUser6 telcomUser = new TelcomUser6("15515157782");

		telcomUser.generateCommunicateRecord();

		telcomUser.printDetails();
		telcomUser.printCallToNumber();


	}



}

class TelcomUser6{

	private String phoneNumber;

	private String callTo;

	private ArrayList communicationRecords;
	private TreeSet callToNumbers;
	private ArrayList callToNumbers1;

	public TelcomUser6(String phoneNumber) {

		this.phoneNumber =phoneNumber;

		this.communicationRecords =new ArrayList();
		this.callToNumbers=new TreeSet();
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

	

	void printDetails() {

		
		int arrayListSize=this.communicationRecords.size(); 


		SimpleDateFormat dfi = new SimpleDateFormat("yyyy年MM月dd日  HH:mm:ss");

		for(int i=0;i<arrayListSize-1;i++) {

			String [] recordField = ((String)this.communicationRecords .get(i)).split(",");

			System.out.println("主叫："+recordField[0]);

			System.out.println("被叫："+recordField[3]);

			System.out.println("通话开始时间："+dfi.format(Long.parseLong(recordField[1])));

			System.out.println("通话结束时间："+dfi.format(Long.parseLong(recordField[2])));

			System.out.println("计费："+accountFee(Long.parseLong(recordField[1]),Long.parseLong(recordField[2]))+"元");

		}

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


	private String accountFee(long timeStart,long timeEnd) {

		double feePerMinute =0.2;

		int minutes=Math.round((timeEnd-timeStart)/60000);

		double feeTotal=feePerMinute*minutes;

		return String.format("%.4f", feeTotal);

	}

}