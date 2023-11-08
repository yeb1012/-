package co.yedam.reply.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import co.yedam.common.Command;
import co.yedam.common.PageDTO;
import co.yedam.reply.service.ReplyService;
import co.yedam.reply.service.ReplyVO;
import co.yedam.reply.serviceImpl.ReplyServiceImpl;

public class ReplyListControl implements Command {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) {
		String bno = req.getParameter("bno");
		String page = req.getParameter("page");
		page = page == null?"1":page;
		System.out.println("page = " +page );
		ReplyService svc = new ReplyServiceImpl();
		//페이지 계산하기
		PageDTO dto = 
				new PageDTO(Integer.parseInt(bno), svc.getTotalCnt(Integer.parseInt(bno)), Integer.parseInt(page));
		
		
		List<ReplyVO> list 
			=svc.replyList(Integer.parseInt(bno),Integer.parseInt(page));
		//list, dto.
		Map<String, Object> map = new HashMap<>();
		map.put("list", list);
		map.put("dto", dto);
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		String json = gson.toJson(map);
		res.setContentType("text/json;charset=utf-8");
		try {
			res.getWriter().print(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
