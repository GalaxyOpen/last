package Day20;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Repository {
	Scanner sc = new Scanner(System.in);
	private List<DTO> list = new ArrayList<>(); // 게시판 집합체
	private List<userDTO> ulist = new ArrayList<>(); // 유저 집합체

//	public boolean save() {
//	
//	}

	public boolean saving(DTO DTO) { // 게시판 저장
		boolean a = list.add(DTO);
		return a;
	}
	public boolean usaving(userDTO dTO) { // 유저 저장
		boolean b = ulist.add(dTO);
		return b;
	}
	public userDTO findById(String uno) {
		for (userDTO u : ulist) {
			if (u.getUno().equals(uno)) {
				return u;
			}
		}
		return null;
	}
	public List<DTO> findAll() {
		return list;
	}
	public DTO findbyWriter(String writer) {

		for (DTO d : list) {
			
			d.print();
			if (d.getWriter().equals(writer)) {
				return d;
			}
		}
		return null;
	}
	public boolean join(userDTO userDTO) {
		return ulist.add(userDTO);
	}
	public boolean login(String loginid, String loginpw) {
		for (userDTO d : ulist) {
			if (loginid.equals(d.getUserid()) && loginpw.equals(d.getUserpw())) {
				return true;
			}
		}
		return false;
	}
	public boolean like(String likeTitle) {
		for (DTO d : list) {
			if (likeTitle.equals(d.getTitle())) {
				d.setLike(d.getLike() + 1);
				return true;
			}
		}
		return false;
	}
	public boolean unholy(String unholyTitle) {
		for (DTO d : list) {
			if (unholyTitle.equals(d.getTitle())) {
				d.setUnholy(d.getUnholy() + 1);
				return true;
			}

		}
		return false;
	}
	public boolean delete(String loginId) {
		for (userDTO u : ulist) {
			if (loginId.equals(u.getUserid())) {
				ulist.remove(u);
				return true;
			}
		}
		return false;
	}
	public List<userDTO> userlist() {
		return ulist;
	}
	public String duCheckid() {
		System.out.print("회원가입할 ID 입력");
		String loginid = sc.next();
		for (userDTO u : ulist) {
			if (loginid.equals(u.getUserid())) {
				return null;
			}
		}
		return loginid;
	}
	// 중복체크
//		public boolean overrapCheck(List<UserDTO> ulList, String id, int memberOk) {
//			for(UserDTO u : ulList) {
//				if(id.equals(u.getId()) && memberOk == u.getManagerOk()) {
//					return true;
//				}
//			}
//			return false;
//		}
}
