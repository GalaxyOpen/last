package Day20;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

	public class DTO {
		private static int number = 0;
		private final static DateTimeFormatter DTF = DateTimeFormatter.ofPattern("yy/MM/dd hh:mm:ss");
		
		private String ono;
		private String title;
		private String writer;
		private static int cnt;
		private long like;
		private long unholy;
		private String postDate;
		
		
		public DTO() {
			this.ono = "O"+number++;
			this.postDate = DTF.format(LocalDateTime.now());
		}
				
		public void setOno(String ono) {
			this.ono = ono;
		}

		public String getOno() {
			return ono;
		}
		public Long getLike() {
			return like;
		}

		public Long getUnholy() {
			return unholy;
		}

		public void setUnholy(long unholy) {
			this.unholy = unholy++;
		}

		public void setLike(long like) {
			this.like = like++;
		}

		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public String getWriter() {
			return writer;
		}
		public void setWriter(String writer) {
			this.writer = writer;
		}
		public int getCnt() {
			return cnt;
		}
		public void increaseCnt() {
			this.cnt++; 
			
		}
		public String getPostDate() {
			return postDate;
		}
		
		public void print() {
			System.out.printf("%s\t%s\t\t%s\t%d\t%d\t%d\t%s\n",ono,title,writer,cnt,like,unholy,postDate);
		}

		@Override
		public String toString() {
			return "BoardDTO [ono=" + ono + ", title=" + title + ", writer=" + writer + ", cnt=" + cnt + ", like =" +like+ ", =unholy"+ unholy + ", postDate="
					+ postDate + "]";
		}

	
	}


