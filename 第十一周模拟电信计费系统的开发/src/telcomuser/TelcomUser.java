package telcomuser;
import dianxinyonghu.*;
import factory.*;
import utility.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
public class TelcomUser {
	private String phoneNumber;
	private String callTo;
	private StringBuffer communicationRecords;
	Yonghu feiyong;
	public TelcomUser(String phoneNumber) {
		this.phoneNumber =phoneNumber;
		this.communicationRecords =new StringBuffer();
		Yonghufactory yonghufactory=(Yonghufactory)YHUtility.getBean();
		 feiyong = yonghufactory.produceYonghu();
		
	}
	public void generateCommunicateRecord() {
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
	
	public void printDetails() {
		//获取全部通话记录
		String allRecords = this.communicationRecords.toString();
		//分割通话记录
		String [] recordArray = allRecords.split(";");
		//循环将分割通话记录的每一项输出
		SimpleDateFormat dfi = new SimpleDateFormat("yyyy年MM月dd日  HH:mm:ss");
		for(int i=0;i<recordArray.length;i++) {
			String[] recordField = recordArray[i].split(",");
			System.out.println("主叫：" + recordField[0]);
			System.out.println("呼叫：" + recordField[3]);
			System.out.println("通话开始时间：" + dfi.format(Long.parseLong(recordField[1])));
			System.out.println("通话结束时间：" + dfi.format(Long.parseLong(recordField[2])));
			System.out.println("计费费率："+feiyong.feePerMinute()+"元");
			System.out.println("计费："
			+accountFee(Long.parseLong(recordField[1]),Long.parseLong(recordField[2]))
					+ "元。");
		}
		}
	private String accountFee(long timeStart,long timeEnd) {
		double fee =feiyong.feePerMinute();
		int minutes=Math.round((timeEnd-timeStart)/60000);
		double feeTotal=fee*minutes;
		return String.format("%.4f", feeTotal);
	}
}
