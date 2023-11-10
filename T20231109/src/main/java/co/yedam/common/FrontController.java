package co.yedam.common;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.product.web.ProductInfoControl;
import co.yedam.product.web.ProductListControl;

public class FrontController extends HttpServlet{
	Map<String, Command> map = new HashMap<>();
	@Override
	public void init(ServletConfig config) throws ServletException {
		//목록리스트
		map.put("/productList.do", new ProductListControl());
		
		//상세정보
		map.put("/productInfo.do", new ProductInfoControl());
		
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		String uri = req.getRequestURI();
		String context = req.getServletContext().getContextPath();
		String page = uri.substring(context.length());
		
		Command controller = map.get(page);
		controller.execute(req, resp);
		
	}
	
}
