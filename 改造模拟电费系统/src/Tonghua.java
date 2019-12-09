import java.text.SimpleDateFormat;



import java.util.*;



public class Tonghua {

	public static void main(String[] args) {
		// ODO Auto-generated method stub
		TelcomUser telcomUser = new TelcomUser("15515157782");
		telcomUser.generateCommunicateRecord();
		telcomUser.printDetails();
	}
}
class TelcomUser{
	private String phoneNumber;
	private String callTo;

	private ArrayList communicationRecords;
    private HashMap singleRecord;
	public TelcomUser(String phoneNumber) {
		this.phoneNumber =phoneNumber;
		this.communicationRecords =new ArrayList();
		this.singleRecord=new HashMap();
	}

	void generateCommunicateRecord() {
		int recordNum=new Random().nextInt(10);
		for(int i=0;i<=recordNum;i++) {

			long timeStart=System.currentTimeMillis()-new Random().nextInt(36000000);

			long timeEnd=timeStart+60000+new Random().nextInt(600000);

			this.callTo = getCallToPhoneNumber();
			this.singleRecord.put("主叫",this.phoneNumber);
			this.singleRecord.put("开始时间",new Date(timeStart));
			this.singleRecord.put("结束时间",new Date(timeEnd));
			this.singleRecord.put("被叫号码",this.callTo);
			this.singleRecord.put("计费",this.accountFee(timeStart, timeEnd));
			this.communicationRecords.add(this.singleRecord);
		}



		



	}



	private String getCallToPhoneNumber() {



		return "1380372"+String.valueOf(new Random().nextInt(10))



		+String.valueOf(new Random().nextInt(10))



		+String.valueOf(new Random().nextInt(10))



		+String.valueOf(new Random().nextInt(10));



		



	}



	



	void printDetails() {
      Iterator itRecords=this.communicationRecords.iterator();
      while(itRecords.hasNext()) {
    	  System.out.println("--------通话记录分割线---------");
    	  this.singleRecord=((HashMap)itRecords.next());
    	  Set keySet=this.singleRecord.keySet();
    	  Iterator itKey= keySet.iterator();
    	  while(itKey.hasNext()) {
    		  Object key=itKey.next();
    		  Object value=this.singleRecord.get(key);
    		  System.out.println(key + ":" + value);
    	  }	  
      }
	}

	//void printDetails1() {
	    //  Iterator itRecords=this.communicationRecords.iterator();
	     // while(itRecords.hasNext()) {
	    	//  System.out.println("--------通话记录分割线---------");
	    	//  this.singleRecord=((HashMap)itRecords.next());
	    	//  Set entrySet=this.singleRecord.entrySet();
	    	// Iterator iterator=entrySet.iterator();
	    	//  while(iterator.hasNext()) {
	    	//	 Map.Entry entry=(Map.Entry)(iterator.next());
	    	//	 Object key=entry.getKey();
	    	//	 Object value=entry.getValue();
	    	//	 System.out.println(key + ":" + value);
	    	//  }
	    	  
	    	  
	     // }
//	}

	private String accountFee(long timeStart,long timeEnd) {



		double feePerMinute =0.2;



		int minutes=Math.round((timeEnd-timeStart)/60000);



		double feeTotal=feePerMinute*minutes;



		return String.format("%.4f", feeTotal);



	}



}