package co.yedam.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MainControl implements Command {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) {
		try {
			req.getRequestDispatcher("WEB-INF/main/main.jsp").forward(req, res);
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}

}
