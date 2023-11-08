package co.yedam.reply.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import co.yedam.reply.service.ReplyVO;

public interface ReplyMapper {
	public List<ReplyVO> replyList(@Param("boardNo")int boardNo, @Param("page")int page);//목록
	public ReplyVO selectReply(int replyNo);//단건조회
	public int insertReply(ReplyVO vo);//등록
	public int updateReply(ReplyVO vo);//수정
	public int deleteReply(int replyNo);//삭제
	//댓글등록수
	public int getTotalCnt(int boardNo);
	//
	public List <Map<String, Object> > getReplyCountByWriter();
	
}
