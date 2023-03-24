package Day20;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;



public class userDTO {
	private static int number = 1;
	private final static DateTimeFormatter DTF = DateTimeFormatter.ofPattern("yy/MM/dd hh:mm:ss");
	
	private String uno;      //유저 고유번호
	private String userid ;  //유저 아이디
	private String userpw ;  //유저 패스워드
	private String postDate; // 가입일
	
	public userDTO() {
		this.uno = "U"+number++;
		this.postDate = DTF.format(LocalDateTime.now());
	} 		
//	public userDTO(String userid, String userpw) {
//		this.uno = "U"+number++;
//		this.userid = userid;
//		this.userpw = userpw;
//		this.postDate = DTF.format(LocalDateTime.now());
//	} 
	
	public String getUno() {
		return uno;
	}
	public void setUno(String uno) {
		this.uno = uno;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUserpw() {
		return userpw;
	}
	public void setUserpw(String userpw) {
		this.userpw = userpw;
	}

	@Override
	public String toString() {
		return "userDTO [uno=" + uno + ", userid=" + userid + ", userpw=" + userpw + ", postDate=" + postDate + "]";
	}
	public void print() {
		System.out.printf("%s\t%s\t%s\t%s\t",uno,userid,userpw,postDate);

	}
	
}
