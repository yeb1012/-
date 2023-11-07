package co.yedam.reply.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Command;
import co.yedam.reply.service.ReplyService;
import co.yedam.reply.serviceImpl.ReplyServiceImpl;

public class RemoveReplyControl implements Command {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) {
		//String bno = req.getParameter("bno");
		String rno = req.getParameter("rno");
		
		ReplyService svc = new ReplyServiceImpl();
		if(svc.delReply(Integer.parseInt(rno))) {
			try {
				req.getRequestDispatcher("WEB-INF/board/getBoard.jsp").forward(req, res);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else{
			
		}
		
		
		
	}

}
