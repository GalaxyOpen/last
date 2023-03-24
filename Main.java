package Day20;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Service service = new Service();
		boolean loginOk = false;
		
		while(true) {
			System.out.println("\n=================================================★");
			System.out.println("=================ildrip.net=====================");
			System.out.println("=================================================☆");
			System.out.println("");
			System.out.println("=================================================★");
			
			if(loginOk) {
				System.out.println(""); 
				System.out.println("1.공지사항 2.자유게시판 3.글쓰기 4.검색 5.일드립 업 6.개소리 업 7.로그아웃 8.회원탈퇴 9.리스트 0.종료");
			}else{
			System.out.println("1.공지사항 2.자유게시판 3.글쓰기 4.검색 5.회원가입 6.로그인 0.종료");
			}
			System.out.println(">>");
			int menu = sc.nextInt();
			
			if(menu == 1) {
				service.announcement();
			}else if(menu == 2) {
				service.findAll();
			}else if(menu == 3) {
				service.save();
			}else if(menu == 4) {
			    service.findById();
			}else if(menu == 5) {
				if(loginOk) {
				service.like();					
				}else {
				service.join();
				}
			}else if(menu == 6) {
				if(loginOk) {
					service.unholy();

				}else {
					if(service.login()) {
						loginOk = true;
					}else {
						System.out.println("로그인 실패");
					}
				}
			}else if(menu == 7) {
				service.logout();
				if(loginOk) {
					service.logout();
				}
				
			}else if(menu == 8) {	
				service.delete();
				loginOk = false;
			}else if(menu == 9){ 	
				service.userlist();
			}else if(menu == 0) {
				break;
			 	
			}else {
				System.out.println("다시 입력해주세요");
			}
			
		}
        System.out.println("프로그램 종료");
	}

}
