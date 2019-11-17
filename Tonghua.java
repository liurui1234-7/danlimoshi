import java.text.SimpleDateFormat;
import java.util.*;
public class Tonghua {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TelcomUser telcomUser = new TelcomUser("15515157782");
		telcomUser.generateCommunicateRecord();
		telcomUser.printDetails();

	}

}
class TelcomUser{
	private String phoneNumber;
	private String callTo;
	private StringBuffer communicationRecords;
	public TelcomUser(String phoneNumber) {
		this.phoneNumber =phoneNumber;
		this.communicationRecords =new StringBuffer();
		
	}
	void generateCommunicateRecord() {
		int recordNum=new Random().nextInt(10);
		for(int i=0;i<=recordNum;i++) {
			long timeStart=System.currentTimeMillis()-new Random().nextInt(36000000);
			long timeEnd=timeStart+60000+new Random().nextInt(600000);
			this.callTo = getCallToPhoneNumber();
			this.communicationRecords.append(this.phoneNumber +","+timeStart+","+timeEnd+","+this.callTo+";");
			
		}
		
	}
	private String getCallToPhoneNumber() {
		return "1380372"+String.valueOf(new Random().nextInt(10))
		+String.valueOf(new Random().nextInt(10))
		+String.valueOf(new Random().nextInt(10))
		+String.valueOf(new Random().nextInt(10));
		
	}
	
	void printDetails() {
		String allRecords=this.communicationRecords.toString();
		String [] recordArray=allRecords.split(";");
		SimpleDateFormat dfi = new SimpleDateFormat("yyyy年MM月dd日  HH:mm:ss");
		for(int i=0;i<recordArray.length;i++) {
			String [] recordField = recordArray[i].split(",");
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