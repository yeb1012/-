package co.yedam.reply.mapper;

import java.util.List;

import co.yedam.reply.service.ReplyVO;

public interface ReplyMapper {
	public List<ReplyVO> replyList(int boardNo);//목록
	public ReplyVO selectReply(int replyNo);//단건조회
	public int insertReply(ReplyVO vo);//등록
	public int updateReply(ReplyVO vo);//수정
	public int deleteReply(int replyNo);//삭제
	
	
}
