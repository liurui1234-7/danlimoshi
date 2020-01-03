package dao;
import entity.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class CourseDao implements IDao {
     private HashMap<String,IEntity> courses;
     private Course course;
     private static CourseDao instance;
     public CourseDao() {
 		courses = new HashMap<String, IEntity>();
 		course = new Course();
 		getCoursesFromInputStream("course.txt");
 	}
     public void processCourseString(String courseString) {
 		String [] courseFields=courseString.split(",");
 		Course c=new Course();
 		c.setCourseNo(courseFields[0]);
 		c.setCourseName(courseFields[1]);
 		c.setCourseGrade(Integer.parseInt(courseFields[2]));
 		courses.put(c.getCourseNo(),c);
 	}
   //读取文件，以InputStream的形式读取
 	private void getCoursesFromInputStream(String isName) {
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
 						this.processCourseString(new String(content,"GBK").trim());
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
     public static CourseDao getInstance() {
 		if(instance == null) {
 			synchronized(CourseDao.class) {
 				if(instance == null) {
 					instance = new CourseDao();
 					return instance;
 				}
 			}
 		}
 		return instance;
 	}
 	
	public void insert(IEntity entity) {
		// TODO Auto-generated method stub
		Course a =(Course)entity;
		courses.put(a.getCourseNo(), a);
		System.out.println("课程添加成功");
		System.out.println("添加后的显示的信息为");
		Set keySet=courses.keySet();
		Iterator it = keySet.iterator();
		while(it.hasNext()){
			String key = (String) it.next();
			Course course = (Course) courses.get(key);
			System.out.println(key+":	"+course.getCourseNo()+"	"+course.getCourseName()+"	"+course.getCourseGrade());
		}
		

	}

	@Override
	public void delete( IEntity entity) {
		// TODO Auto-generated method stub
        Course cs1 = (Course)entity;
        courses.remove(cs1.getCourseNo(), cs1);
        
        
	}

	@Override
	public void update(IEntity entity) {
		// TODO Auto-generated method stub
     Course b =(Course)entity;
     courses.put(b.getCourseNo(), b);
     System.out.println("课程修改成功！");
	 System.out.println("课程修改后的信息显示: ");
	 Set keySet=courses.keySet();
		Iterator it = keySet.iterator();
		while(it.hasNext()){
			String key = (String) it.next();
			Course course = (Course) courses.get(key);
			System.out.println(key+":	"+course.getCourseNo()+"	"+course.getCourseName()+"	"+course.getCourseGrade());
		}
		
	}

	public HashMap<String,IEntity> getAllEntities() {
		// TODO Auto-generated method stub
		
		return courses;
	}
	@Override
	public IEntity getEntity(String Id) {
		// TODO Auto-generated method stub
		return courses.get(Id);
	}

	public void printDetail(String Id){
		Course a =(Course)getEntity(Id);
		System.out.println("查询结果为: 课程编号:"+a.getCourseNo()+ "课程名称:"+a.getCourseName()+ "课程成绩:"+a.getCourseGrade());
	}
	public void update1() {
		// TODO Auto-generated method stub
		Set<String> courseSet=courses.keySet();
		 StringBuffer cStringBuffer=new StringBuffer();
		 for(String courseNo:courseSet) {
			 Course c=(Course)courses.get(courseNo);
			 String cString=c.getCourseNo()+","
					 +c.getCourseName()+","
					 +c.getCourseGrade()+"\r\n";
			 cStringBuffer.append(cString);
		 }
		 putCourseToFile(cStringBuffer.toString(),"course.txt");
	 }
	private void putCourseToFile(String cString,String osName) {
		try {
			FileOutputStream fos=new FileOutputStream(osName);
			try {
				fos.write(cString.getBytes("GBK"));
			}catch(UnsupportedEncodingException e) {
				 e.printStackTrace();
			 }	 
		}catch(IOException e) {
				 e.printStackTrace();
			 }
	}

	
	

}
