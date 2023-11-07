package co.yedam.common;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.board.web.AddBoardControl;
import co.yedam.board.web.BoardListControl;
import co.yedam.board.web.GetBoardControl;
import co.yedam.board.web.ModifyBoardcontrol;
import co.yedam.board.web.ModifyControl;
import co.yedam.board.web.RemoveBoardControl;
import co.yedam.board.web.RemoveControl;
import co.yedam.board.web.boardFormControl;
import co.yedam.reply.web.AddReplyCotrol;
import co.yedam.reply.web.ReplyListControl;

//url: *.do로 끝나면 전부 여기로 들어와서 실행
public class FrontController extends HttpServlet {
	
	Map<String,Command> map = new HashMap<>();
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		//첫 페이지
		map.put("/main.do", new MainControl());
		
		//로그인
		map.put("/loginForm.do", new LoginFormControl());
		map.put("/login.do", new LoginControl());
		
		//로그아웃
		map.put("/logout.do", new LogoutControl());
		
		//상세화면
		map.put("/boardList.do", new BoardListControl());
		map.put("/getBoard.do", new GetBoardControl());
		
		//등록화면
		map.put("/boardForm.do", new boardFormControl());
		map.put("/addBoard.do", new AddBoardControl());
		
		//수정화면
		map.put("/modifyForm.do", new ModifyControl());
		map.put("/modifyBoard.do", new ModifyBoardcontrol());
		
		//삭제
		map.put("/removeForm.do", new RemoveControl());
		map.put("/removeBoard.do", new RemoveBoardControl());
		
		//회원관리
		map.put("/memberList.do", new MemberControl());
		
		
		//댓글목록
		map.put("/replyList.do", new ReplyListControl());
		map.put("/addReply.do", new AddReplyCotrol());
	}
	
	//등록 -> boardForm.do->boardForm.jsp 후에 처리는 addBoard.do->BoardList.jsp에서 처리
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//요청정보에 포함되어있는 한글을 인코딩방식 지정하기
		req.setCharacterEncoding("UTF-8");
		
		String uri = req.getRequestURI();	//사용자가 어떤 페이지를 요청했는지에 대한 정보(프로젝트 정보의 뒤쪽부터) 	//http://localhost:8080/helloJSP/??.do
		String context = req.getServletContext().getContextPath();	//어떤 프로젝트인지에 대한 정보(helloJSP)
		String page = uri.substring(context.length());
		
		//System.out.println("uri = "+uri);
		//System.out.println("page = "+page);
		
		Command controller = map.get(page);	//사용자가 요청한 페이지의 값을 맵의 값에서 찾기	
		controller.execute(req, resp);
		
	}
}
