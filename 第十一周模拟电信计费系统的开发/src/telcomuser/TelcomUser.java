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
		//��ȡȫ��ͨ����¼
		String allRecords = this.communicationRecords.toString();
		//�ָ�ͨ����¼
		String [] recordArray = allRecords.split(";");
		//ѭ�����ָ�ͨ����¼��ÿһ�����
		SimpleDateFormat dfi = new SimpleDateFormat("yyyy��MM��dd��  HH:mm:ss");
		for(int i=0;i<recordArray.length;i++) {
			String[] recordField = recordArray[i].split(",");
			System.out.println("���У�" + recordField[0]);
			System.out.println("���У�" + recordField[3]);
			System.out.println("ͨ����ʼʱ�䣺" + dfi.format(Long.parseLong(recordField[1])));
			System.out.println("ͨ������ʱ�䣺" + dfi.format(Long.parseLong(recordField[2])));
			System.out.println("�Ʒѷ��ʣ�"+feiyong.feePerMinute()+"Ԫ");
			System.out.println("�Ʒѣ�"
			+accountFee(Long.parseLong(recordField[1]),Long.parseLong(recordField[2]))
					+ "Ԫ��");
		}
		}
	private String accountFee(long timeStart,long timeEnd) {
		double fee =feiyong.feePerMinute();
		int minutes=Math.round((timeEnd-timeStart)/60000);
		double feeTotal=fee*minutes;
		return String.format("%.4f", feeTotal);
	}
}
