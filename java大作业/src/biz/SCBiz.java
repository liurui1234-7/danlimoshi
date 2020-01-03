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
			System.out.println("��Ҫѡ�Ŀγ��Ѿ�����");
			System.out.println("��������ѡ��");
			MainUI3.show();
		}
		else{	
			sc=new SC();
		    sc.setCourseNo(courseNo);
		    sc.setStudentNo(studentNo);
		    sc.setGrade(grade);
		    scdao.insert(sc);
		    scdao.update1();
			System.out.println("��ѡ�ɹ�");		
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
		System.out.println("��ѡ�ɹ���");
		System.out.println("��ѡ�������£�");
		scdao.update(sc);	
		   MainUI3.show();	  
	}
	}