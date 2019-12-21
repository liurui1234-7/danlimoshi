package dbutils;
import java.io.*;
import java.util.HashMap;
import java.util.Set;

import user.*;
public class DBUtils {
private static DBUtils instance = null;
private HashMap<String,User> users = new HashMap<String,User>();
private DBUtils() throws FileNotFoundException{
	getUsersFromInputStream("user.txt");
}
private void getUsersFromInputStream(String isName) throws FileNotFoundException {
	
		FileInputStream fs = new FileInputStream(isName);
		byte[] content=new byte[1024];
		int i=0;
		int conInteger=0;
		while(true) {
			try {
				conInteger=fs.read();
			}catch(IOException e) {
				e.printStackTrace();
			}
			if(-1==conInteger) {
				break;
			}else if('\r'==(char)conInteger||'\n'==(char)conInteger) {
				try {
					this.processUserString(new String(content,"GBK").trim());
					i=0;
				}catch(UnsupportedEncodingException e) {
					e.printStackTrace();
				}
				continue;
			}else {
				content[i]=(byte)conInteger;
				i++;
			}
		}
	
	
}
public void processUserString(String userString) {
	String [] userFileds=userString.split(",");
	User u =new User();
	u.setCardId(userFileds[0]);
	u.setCardPwd(userFileds[1]);
	u.setUserName(userFileds[2]);
	u.setCall(userFileds[3]);
	u.setAccount(Integer.parseInt(userFileds[4]));
	users.put(u.getCardId(),u);
	
}
//懒汉式单例模式
public static DBUtils getInstance() throws FileNotFoundException{
	if(instance == null){
		synchronized(DBUtils.class){
			if(instance == null){
				instance = new DBUtils();
			}
		}
	}
	return instance;
}

public User getUser(String cardId){
	User user = (User)users.get(cardId);
	return user;
}

public HashMap<String,User> getUsers(){
	return users;
}
public void addUser(User u) {
	users.put(u.getCardId(),u);
}
public void update() throws IOException {
	Set<String> userSet =users.keySet();
	StringBuffer uStringBuffer = new StringBuffer();
	for(String cardId:userSet) {
		User u =(User)users.get(cardId);
		String uString =u.getCardId()+","
				+u.getCardPwd()+","
				+u.getUserName()+","
				+u.getCall()+","
				+u.getAccount()+"\r\n";
		uStringBuffer.append(uString);		
	}
	putUsersToFile(uStringBuffer.toString(),"user.txt");
}
private void putUsersToFile(String uString,String osName) throws IOException {
	
		FileOutputStream fos = new FileOutputStream(osName);
		try {
			fos.write(uString.getBytes("GBK"));
			
		}catch(UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	
}
}
