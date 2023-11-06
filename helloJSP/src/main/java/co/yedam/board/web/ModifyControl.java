package co.yedam.board.web;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.board.service.BoardService;
import co.yedam.board.service.BoardVO;
import co.yedam.board.serviceImpl.BoardServiceImpl;
import co.yedam.common.Command;

public class ModifyControl implements Command {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) {
		//수정화면 오픈
		String bno = req.getParameter("bno");
		BoardService svc = new BoardServiceImpl();
		BoardVO vo = svc.getBoard(Integer.parseInt(bno));
		req.setAttribute("vo", vo);
		try {
			req.getRequestDispatcher("WEB-INF/board/modifyForm.jsp").forward(req, res);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
