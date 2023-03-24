package Day20;

import java.util.ArrayList;
//import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import day12.StudentDTO;

public class Service {
	Scanner sc = new Scanner(System.in);
	Repository br = new Repository();
	
	private List<DTO> list = new ArrayList<>(); // 게시판 관련 리스트
	private List<userDTO> ulist = new ArrayList<>(); // 회원 관련리스트
	// 게시판 관련 DTO
	userDTO userDTO = null; // 회원 관련 DTO

	String loginid = null;
	String loginpw = null;
	String postDate = null;
	Long like = (long) 0;
	Long unholy = (long) 0;

//	public static Repository getInstance() {
//		return br;
//	}

	public void announcement() {// 공지사항
		DTO dTO = new DTO();
		System.out.println("======================필독=======================");
		System.out.println("글번호\t공지\t\t\t작성자\t조회수\t일드립\t개소리\t업로드날짜");
		for (int i = 1; i <= 3; i++) {
			dTO.setWriter("관리자");
			if (i == 1) {
				dTO.setTitle(i + ". 한줄의 제목이 내용입니다.");
			} else if (i == 2) {
				dTO.setTitle(i + ". 욕설을 사용하지 않습니다.");
			} else {
				dTO.setTitle(i + ". 바른말 사용을 부탁드립니다.");
			}

			dTO.print();
		}

	}

	public void save() { // 게시글 업로드
        DTO dTO = new DTO();
		System.out.print("제목> ");
        dTO.setTitle(sc.next());
		System.out.print("작성자> ");
		dTO.setWriter(sc.next());

		boolean success = br.saving(dTO);
		
		if (success) {
			System.out.println("게시글 등록");
		} else {
			System.out.println("게시글 등록실패");
		}

	}

	public void findAll() { // 2. 게시판 보기

		List<DTO> list = br.findAll();
		// Collections.sort(kS, Collections.reverseOrder()); //내림차순
		// Collections.sort(kS); // 오름차순
		System.out.println("-----------------자유게시판-------------------------");
		System.out.println("글번호\t\t제목\t작성자\t조회수\t한줄명언\t개소리\t업로드날짜");

		for (DTO d : list) {
			d.print();
		}
	}

	public void findbyWriter() { // 작성자가 쓴 글 검색

		System.out.println("글 쓴 작성자 검색 >> ");
		String writer = sc.next();
		DTO dTO = br.findbyWriter(writer);
		if (dTO == null) {
			System.out.println("해당 작성자의 글을 찾을 수 없습니다.");
		} else {
			dTO.increaseCnt();
			System.out.println("=================================================");
			System.out.println("글번호\t공지\t\t작성자\t\t조회수\t한줄명언\t개소리\t업로드날짜");
			dTO.print();

		}

	}

	public void findById() { // 번호를 통해서 회원 검색
		System.out.println("조회할 회원번호>");
		String uno = sc.next();
		userDTO u = br.findById(uno);

		if (u == null) {
			System.out.println("없는 회원번호 입니다.");
		} else {
			System.out.printf("회원번호\t아이디\n");
			System.out.printf("%s\t%s\t", uno, loginid);
		}
	}

	public void join() {
		userDTO userDTO = new userDTO ();
		while (true) {
			String loginid = br.duCheckid();
			if (loginid == null) {
				System.out.println("중복된 아이디입니다.");
				
			}else {
				  userDTO.setUserid(loginid);
				  break;
			}
		}
		  
			System.out.println("비밀번호 입력>");
			String loginpw = sc.next();
			userDTO.setUserpw(loginpw);

			if (br.usaving(userDTO)) {
				System.out.println("\n회원가입 성공!");

			} else {
				System.out.println("\n회원가입 실패");

			}
		}

	

	public boolean login() {

		System.out.println("아이디> ");
		String userid = sc.next();
		System.out.println("비밀번호> ");
		String userpw = sc.next();

		if (br.login(userid, userpw)) {
			System.out.println("로그인 완료");

			loginid = userid;
			loginpw = userpw;
			return true;
		} else {
			System.out.println("아이디가 중복되었거나 로그인할 수 없습니다.");
		}
		return false;
	}

	public void like() {
		System.out.println("명언남길 제목을 입력하세요.>");
		String likeTitle = sc.next();
		if (br.like(likeTitle)) {
			System.out.println("명언!");
		} else {
			System.out.println("올바른 제목을 입력해주세요");
		}

	}

	public void unholy() {
		System.out.println("개소리남길 제목을 입력하세요");
		String unholyTitle = sc.next();
		if (br.unholy(unholyTitle)) {
			System.out.println("개소리를 남겼습니다");
		} else {
			System.out.println("올바른 제목을 입력해주세요.");
		}
	}

	public void logout() { // 로그아웃
		System.out.println("로그아웃 하시겠습니까?");
		System.out.println("1.네 / 2.아니오");
		int logoutmassage = sc.nextInt();
		if (logoutmassage == 1) {
			loginid = null;
			loginpw = null;
			System.out.println("로그아웃 완료");
		} else {
			System.out.println("로그인 유지");
		}
	}

	public void delete() { // 회원삭제

	
		
		if (br.delete(loginid)) {
			System.out.println("회원 삭제 완료");
		} else {
			System.out.println("삭제실패");

		}
	}

	public void userlist() {
		List<userDTO> ulist = br.userlist();
		System.out.println("-----------------------------가입자목록------------------------------");
		for (userDTO u : ulist) {
			System.out.println(u.toString());

		}
	}

}
