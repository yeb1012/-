package co.yedam.board.serviceImpl;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;

import co.yedam.board.mapper.BoardMapper;
import co.yedam.board.service.BoardService;
import co.yedam.board.service.BoardVO;
import co.yedam.board.service.MemberVO;
import co.yedam.common.DataSourceMybatis;

public class BoardServiceImpl implements BoardService {
	BoardDAO dao = new BoardDAO();
	
	SqlSession sqlSession = DataSourceMybatis.getInstance().openSession(true);	//true를 넣어주면 자동 commit이 됨
	
	BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
	
	@Override
	public List<BoardVO> boradList() {
		return mapper.selectList();
		//return dao.selectList();
	}

	@Override
	public BoardVO getBoard(int boardNo) {
		mapper.updateCnt(boardNo);
		return mapper.select(boardNo);
	}

	@Override
	public boolean addBoard(BoardVO vo) {
		return mapper.insert(vo) == 1;
	}

	@Override
	public boolean editBoard(BoardVO vo) {
		return mapper.update(vo) == 1;
	}

	@Override
	public boolean removeBoard(int boardNo) {
		return mapper.delete(boardNo) == 1;
	}
	
	@Override
	public MemberVO loginCheck(@Param("id")String id, @Param("pw")String pw) {
		return mapper.getUser(id, pw);
	}
	
	@Override
	public List<MemberVO> memberList() {
		return dao.member();
	}
}
