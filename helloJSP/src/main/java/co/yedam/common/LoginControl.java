package co.yedam.common;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.yedam.board.service.BoardService;
import co.yedam.board.serviceImpl.BoardServiceImpl;

public class LoginControl implements Command {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) {
		String id = req.getParameter("id");
		String pw = req.getParameter("pass");
		
		//session => 로그인을 하고 나면 서버를 닫을 때까지 계속 가지고 있는 클라이언트의 고유 속성
		//request는 요청 할때마다 사라지고 바뀌는데 session은 바뀌지 않음
		
		BoardService svc = new BoardServiceImpl();
		if(svc.loginCheck(id, pw)!=null) {
			HttpSession session = req.getSession();
			session.setAttribute("logId", id);
			try {
				res.sendRedirect("boardList.do");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else {
			try {
				
				res.sendRedirect("loginForm.do");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
