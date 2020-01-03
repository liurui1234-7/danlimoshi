package biz;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;
import dao.*;
import entity.*;
import view.MainUI2;

public class CourseBiz {
   CourseDao courseDao;
   private Course course;
   private HashMap<String, IEntity> courses;

   public void courseAdd(String courseNo,String courseName,int courseGrade){
	   courseDao=courseDao.getInstance();
	   courses=courseDao.getAllEntities();
	   if(courses.containsKey(courseNo)){
		   System.out.println("������Ŀγ��Ѿ�����");
		   System.out.println("�����ѡ������Ҫ�ķ���");
		   MainUI2.show();
	   }
	   else{
		  course=new Course();
		   course.setCourseNo(courseNo);
		   course.setCourseName(courseName);
		   course.setCourseGrade(courseGrade);
		 courseDao.insert(course); 
		  courseDao.update1();
		   MainUI2.show();
	   }
	   
   }
   public void courseFind(String courseNo){
	   courseDao=courseDao.getInstance();
	   courses=courseDao.getAllEntities();
	   if(courses.containsKey(courseNo)){
		   System.out.println("���ҵĿγ��Ѿ�����");
		   courseDao.printDetail(courseNo);
		   
	   }else{
		   System.out.println("��Ҫ���ҵĿγ̲�����!");
	   }
	   System.out.println("�������Ҫѡ��ķ���: ");
	   MainUI2.show();
   }
   public void courseModify(String courseNo,String oldcourseName,
		                    String newcourseName,int newcourseGrade){
	   courseDao=courseDao.getInstance();
	   course=(Course)courseDao.getEntity(courseNo);
	   if(oldcourseName.equals(newcourseName)){
		   System.out.println("��Ҫ�޸ĵĿγ��뱾���γ�������ͬ!");
	  	System.out.println("�������Ҫѡ��ķ���: ");
	   }
	   else{
		   course.setCourseName(newcourseName);
		   course.setCourseGrade(newcourseGrade);
		   courseDao.update(course);
	   }
	   MainUI2.show();
   }
   public void courseRemove(String courseNo,String courseName,String courseGrade){
	   courseDao=courseDao.getInstance();
	   courses=courseDao.getAllEntities();
	   course=(Course)courseDao.getEntity(courseNo);
	   if(courses.containsKey(courseNo)){
		   courseDao.delete(course);
		   System.out.println("�ÿγ��Ѿ�ɾ��");
	   }
	   else{
		   System.out.println("�ÿγ̲����ڣ��޷�ɾ��");
	   }
	   System.out.println("�������ķ���:");
	   MainUI2.show();
	  
   }
}
