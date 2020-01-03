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
		   System.out.println("你输入的课程已经存在");
		   System.out.println("请继续选择你需要的服务");
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
		   System.out.println("查找的课程已经存在");
		   courseDao.printDetail(courseNo);
		   
	   }else{
		   System.out.println("你要查找的课程不存在!");
	   }
	   System.out.println("请继续你要选择的服务: ");
	   MainUI2.show();
   }
   public void courseModify(String courseNo,String oldcourseName,
		                    String newcourseName,int newcourseGrade){
	   courseDao=courseDao.getInstance();
	   course=(Course)courseDao.getEntity(courseNo);
	   if(oldcourseName.equals(newcourseName)){
		   System.out.println("你要修改的课程与本来课程名称相同!");
	  	System.out.println("请继续你要选择的服务: ");
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
		   System.out.println("该课程已经删除");
	   }
	   else{
		   System.out.println("该课程不存在，无法删除");
	   }
	   System.out.println("请继续你的服务:");
	   MainUI2.show();
	  
   }
}
