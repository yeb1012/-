package co.yedam.product.web;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Command;
import co.yedam.product.service.ProductService;
import co.yedam.product.service.ProductVO;
import co.yedam.product.serviceImpl.ProductServiceImpl;

public class ProductListControl implements Command {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) {
	ProductService svc = new ProductServiceImpl();
	List<ProductVO> list = svc.productList();
	
	req.setAttribute("list", list);
	
	RequestDispatcher rd = req.getRequestDispatcher("product/productList.tiles");
	
	try {
		rd.forward(req, res);
	} catch (Exception e) {
		e.printStackTrace();
	} 
	

	}

}
