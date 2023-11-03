package co.yedam.board.service;

import java.util.List;

public interface BoardService {
	//목록, 단건조회, 등록, 수정, 삭제
	public List<BoardVO> boradList();
	public BoardVO getBoard(int boardNo);
	public boolean addBoard(BoardVO vo);
	public boolean eidtBoard(BoardVO vo);
	public boolean removeBoard(int boardNo);
	
}
