package co.yedam.common;

public class PageDTO {
	int total;//전체 건수
	int currentPage;//현제페이지
	boolean next, prev;//이전, 이후
	int startPage, endPage;//
	int boardNo;
	//이전 11p  13p(현재)  20p 다음   258건, 총 52page
	public PageDTO(int boardNo, int total, int currentPage) {
		
		int realEnd = (int) Math.ceil(total/5.0);
		
		this.boardNo = boardNo;
		this.total = total;
		this.currentPage = currentPage;
		
		this.endPage = (int) Math.ceil(currentPage / 10.0) * 10;
		this.startPage = this.endPage - 9;
		this.endPage = this.endPage > realEnd ? realEnd : this.endPage;
		this.startPage = this.startPage<1?1:this.startPage;
		this.prev = this.startPage >1; //이전페이지
		this.next = this.endPage < realEnd; //다음페이지 realEnd -> 총 52p
		
	}
		
	
}
