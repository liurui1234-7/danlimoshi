package biz;

import dao.StudentDao;
import entity.IEntity;
import entity.Student;
import view.MainUI;

public class StudentBiz {
	StudentDao studentDao;
	private Student student;
	//��¼
	public void login(String studentNo, String studentPassword) {

		studentDao = StudentDao.getInstance();
		student = (Student) studentDao.getEntity(studentNo);
		if (student == null) {
			System.out.println("�û�������");
			return;
		} else if (student.getStudentPassword().equals(studentPassword)) {
			System.out.println("��¼�ɹ�");
			MainUI.show();
		} else {
			System.out.println("���벻��ȷ");
			MainUI.show();
		}

	}
	//ע�ᣬҵ���߼�ʵ��
	public void register(String studentNo, 
						String studentName, 
						String studentGender,
						int studentAge, 
						String studentDepartment, 
						String firstPassword, 
						String secondPassword) {
		if(firstPassword.equals(secondPassword)) {
			student = new Student();
			student.setStudentNo(studentNo);
			student.setStudentName(studentName);
			student.setStudentAge(studentAge);
			student.setStudentGender(studentGender);
			student.setStudentDepartment(studentDepartment);
			student.setStudentPassword(firstPassword);
			studentDao = StudentDao.getInstance();
			studentDao.insert(student);
			System.out.println("ע��ɹ���");
			studentDao.update1();
			MainUI.show();
		}else {
			System.out.println("�����������벻һ�£�����������");
		}
	}
	public void ModifyPassword(String studentNo,
            String oldPassword,
            String firstPassword,
            String secondPassword){
		studentDao=studentDao.getInstance();
		Student student1=(Student)studentDao.getEntity(studentNo);
		if(student1.getStudentPassword().equals(oldPassword)){
			if(firstPassword.equals(secondPassword)){
				student1.setStudentPassword(secondPassword);
				studentDao.update(student1);
			}
		}
		
		else{
			System.out.println("�����������벻һ�£�����������");
		}
		MainUI.show();
	}
	
}
