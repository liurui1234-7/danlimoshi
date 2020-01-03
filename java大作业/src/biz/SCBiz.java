package biz;
import java.util.HashMap;
import java.util.Scanner;
import dao.*;
import entity.*;
import view.MainUI;
import view.MainUI2;
import view.MainUI3;
public class SCBiz {
	SCDao scdao;
	private SC sc;
	private HashMap<String, IEntity> scs;
	public void zhengxuan(String studentNo,String courseNo,int grade){
		scdao=scdao.getInstance();
		scs=scdao.getAllEntities();
		if(scs.containsKey(studentNo)&&scs.containsKey(courseNo)&&scs.containsKey(grade)) {
			System.out.println("你要选的课程已经存在");
			System.out.println("请继续你的选择");
			MainUI3.show();
		}
		else{	
			sc=new SC();
		    sc.setCourseNo(courseNo);
		    sc.setStudentNo(studentNo);
		    sc.setGrade(grade);
		    scdao.insert(sc);
		    scdao.update1();
			System.out.println("正选成功");		
			MainUI3.show();
		}
		
	}
	public void tuixuan(String studentNo,String courseNo,int grade){
		scdao=scdao.getInstance();
		scs=scdao.getAllEntities();
		sc=new SC();
	    sc.setCourseNo(courseNo);
	    sc.setStudentNo(studentNo);
	    sc.setGrade(grade);
	    scdao.delete(sc);
		System.out.println("退选成功！");
		System.out.println("退选后结果如下：");
		scdao.update(sc);	
		   MainUI3.show();	  
	}
	}