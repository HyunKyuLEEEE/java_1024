package example.db.main;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import org.apache.ibatis.session.SqlSession;

import db.day04.vo.CourseVO;
import example.db.dao.StudentDAO;
import example.db.vo.StudentVO;
import example.db.vo.StudentVO2;


public class MainController {

	private SqlSession session;
	private StudentDAO studentDao;
	private Scanner sc;
	
	public MainController(SqlSession session) {
		this.session = session;
		studentDao = session.getMapper(StudentDAO.class);
		sc = new Scanner(System.in);
		
	}

	public void run() {
		/* 학생 추가
		 * 학생 수정
		 * 학생 조회
		 * 프로그램 종료
		 */	
		int menu = -1;
		do {
			try {
				printMenu();
				menu = sc.nextInt();
				sc.nextLine();
				runMenu(menu);
			}catch(InputMismatchException e) {
				System.out.println("잘못된 타입을 입력");
				sc.nextLine();
			}catch(Exception e){
				System.out.println(e.getMessage());
			}
		}while(menu != 4);
		System.out.println("프로그램을 종료합니다.");
	}

	private void runMenu(int menu) {
		switch(menu){
			case 1:
				insertStudent();
				break;
			case 2:
				updateStudent();
				break;
			case 3:
				selectAllStudent();
				break;
			default:
				System.out.println("잘못된 메뉴입니다.");
		}
	}

	private void updateStudent() {
		System.out.println("수정할 학생 정보를 입력하세요.");
		System.out.print("학번 : ");
		String st_num = sc.nextLine();
		System.out.print("학기 : ");
		int st_semester = sc.nextInt();
		sc.nextLine();
		System.out.print("상태(재학/휴학/자퇴/퇴학/졸업/수료) : ");
		String st_state = sc.nextLine();
		
		StudentVO std = studentDao.selectStudent(st_num);
		if(std == null) {
			System.out.println("학생 수정 실패;");
			return;
		}
		std.setSt_semester(st_semester);
		std.setSt_state(st_state);
		
		if(studentDao.updateStudent(std) != 0) {
			System.out.println("학생 수정 성공");
			session.commit();
		}else {
			System.out.println("학생 수정 실패");
		}
	}

	private void selectAllStudent() {
//		 ArrayList<StudentVO> list = studentDao.selectAllStudent();
		 ArrayList<StudentVO2> list = studentDao.selectAllStudent2();
		 if(list.size() == 0) {
			 System.out.println("검색 결과가 없습니다.");
			 return;
		 }
//		 for(StudentVO temp : list) {
//			 System.out.println(temp);
//		 }
		 for(StudentVO2 temp : list) {
			 System.out.println(temp);
		 }
	}

	private void insertStudent() {
		System.out.println("학생 정보 입력");
		System.out.print("학번 : ");
		String st_num = sc.nextLine();
		System.out.print("이름 : ");
		String st_name = sc.nextLine();
		System.out.print("학기 : ");
		int st_semester = sc.nextInt();
		sc.nextLine();
		System.out.print("상태(재학/휴학/자퇴/퇴학/졸업/수료) : ");
		String st_state = sc.nextLine();
		System.out.print("교수번호 : ");
		String st_pr_num = sc.nextLine();
		
		StudentVO std = new StudentVO(st_num,st_name, st_semester, st_state, st_pr_num);
		if(studentDao.insertStudent(std) != 0) {
			System.out.println("학생 추가 성공");
			session.commit();
		}else {
			System.out.println("학생 추가 실패");
		}
		
	}

	private void printMenu() {
		System.out.println("메뉴");
		System.out.println("1. 학생 추가");
		System.out.println("2. 학생 수정");
		System.out.println("3. 학생 조회");
		System.out.println("4. 프로그램 종료");
		System.out.print("메뉴 선택 : ");
		
		
	}

}
