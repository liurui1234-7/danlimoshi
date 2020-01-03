package dao;
import entity.IEntity;
import entity.Student;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Set;

public class StudentDao implements IDao {

	private static StudentDao instance;
	private HashMap<String, IEntity> students;
	private Student student;
	private StudentDao() {
		students = new HashMap<String,IEntity >();
		student = new Student();
		getStudentsFromInputStream("student.txt");
	}
	
	public void processStudentString(String studentString) {
		String [] studentFields=studentString.split(",");
		Student u=new Student();
		u.setStudentNo(studentFields[0]);
		u.setStudentName(studentFields[1]);
		u.setStudentAge(Integer.parseInt(studentFields[2]));
		u.setStudentDepartment(studentFields[3]);
		u.setStudentPassword(studentFields[4]);
		students.put(u.getStudentNo(),u);
	}
	
	//读取文件，以InputStream的形式读取
	private void getStudentsFromInputStream(String isName) {
		try {
			FileInputStream fs = new FileInputStream(isName);
			byte[] content=new byte[1024];
			int i=0;
			int conInteger=0;
			while(true) {
				try {
					conInteger=fs.read();
				} catch(IOException e) {
					e.printStackTrace();
				}
				if(-1==conInteger) {
					break;
				}else if('\r'==(char)conInteger||'\n'==(char)conInteger) {
					try {
						this.processStudentString(new String(content,"GBK").trim());
						i=0;
					} catch(UnsupportedEncodingException e) {
						e.printStackTrace();
					}
					continue;
				}else {
					content[i]=(byte)conInteger;
					i++;
				}
			}
			fs.close();
		} catch(Exception e) {
			
		}
	}
	
	public static StudentDao getInstance() {
		if(instance == null) {
			synchronized(StudentDao.class) {
				if(instance == null) {
					instance = new StudentDao ();
					return instance;
				}
			}
		}
		return instance;
	}
	@Override
	public void insert(IEntity entity) {
		// TODO Auto-generated method stub
		Student st = (Student)entity;
		students.put(st.getStudentNo(), st);
	}

	@Override
	public void delete(IEntity entity) {
		// TODO Auto-generated method stub
      Student st =(Student)entity;
      students.remove(st.getStudentNo(), st);
	}

	@Override
	public void update(IEntity entity) {
		// TODO Auto-generated method stub
		Student st=(Student)entity;
		students.put(st.getStudentNo(), st);

	}

	@Override
	public HashMap<String, IEntity> getAllEntities() {
		// TODO Auto-generated method stub
		return students;
	}

	@Override
	public IEntity getEntity(String Id) {
		// TODO Auto-generated method stub		
		return students.get(Id);
	}
	public void update1() {
		// TODO Auto-generated method stub
		Set<String> studentSet=students.keySet();
		 StringBuffer uStringBuffer=new StringBuffer();
		 for(String studentNo:studentSet) {
			 Student u=(Student)students.get(studentNo);
			 String uString=u.getStudentNo()+","
					 +u.getStudentName()+","
					 +u.getStudentGender()+","
					 +u.getStudentDepartment()+","
					 +u.getStudentPassword()+"\r\n";
			 uStringBuffer.append(uString);
		 }
		 putStudentToFile(uStringBuffer.toString(),"student.txt");
	 }
	private void putStudentToFile(String uString,String osName) {
		try {
			FileOutputStream fos=new FileOutputStream(osName);
			try {
				fos.write(uString.getBytes("GBK"));
			}catch(UnsupportedEncodingException e) {
				 e.printStackTrace();
			 }	 
		}catch(IOException e) {
				 e.printStackTrace();
			 }
	}


}
