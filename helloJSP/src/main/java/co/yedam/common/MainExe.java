package co.yedam.common;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import co.yedam.reply.mapper.ReplyMapper;
import co.yedam.reply.service.ReplyVO;

public class MainExe {
	public static void main(String[] args) {
		//ReplyVO vo = new ReplyVO();
		SqlSession session=
				DataSourceMybatis.getInstance().openSession(true);
		ReplyMapper mapper = session.getMapper(ReplyMapper.class);
		
		List<ReplyVO> list = mapper.replyList(2, 1);
		list.forEach(vo->System.out.println(vo));
		// vo.setReplyNo(2);
		// vo.setBoardNo(1);
		 //vo.setReply("인설트 테스트중 2");
		 //vo.setReplyer("user09");
		 //mapper.insertReply(vo);
		// System.out.println(vo);
		// vo.setReply("수정 테스트 중");
		 //vo.setReplyNo(2);
		// mapper.updateReply(vo);
		
			//mapper.deleteReply(23);
		
		 List<Map<String, Object>> map = mapper.getReplyCountByWriter();
		 System.out.println(map);
		 
			
	}//
}//
