package co.yedam.reply.web;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import co.yedam.common.Command;
import co.yedam.reply.service.ReplyService;
import co.yedam.reply.service.ReplyVO;
import co.yedam.reply.serviceImpl.ReplyServiceImpl;

public class RemoveReplyControl implements Command {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) {
		//String bno = req.getParameter("bno");
		String rno = req.getParameter("rno");
		
		ReplyService svc = new ReplyServiceImpl();
		ReplyVO vo = new ReplyVO();
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();

		Map<String, Object> map = new HashMap<>();
		
		if(svc.delReply(Integer.parseInt(rno))) {
			
			try {
				map.put("retCode", "OK");
				map.put("vo", vo);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			try {
				map.put("retCode", "NG");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		res.setContentType("text/json; charset=UTF-8");
		try {
			res.getWriter().print(gson.toJson(map));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
