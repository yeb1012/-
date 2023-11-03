package co.yedam.board.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.board.service.BoardService;
import co.yedam.board.service.BoardVO;
import co.yedam.board.serviceImpl.BoardServiceImpl;
import co.yedam.common.Command;

public class GetBoardControl implements Command {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) {
		//boardNO을 가져와서 그에 대한 데이터를 보여줌(jsp)
		String bno = req.getParameter("bno");
		BoardService svc = new BoardServiceImpl();
		BoardVO vo = svc.getBoard(Integer.parseInt(bno));
		req.setAttribute("bno", vo);
		
		//요청 재지정
		try {
			req.getRequestDispatcher("WEB-INF/board/getBoard.jsp").forward(req, res);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
