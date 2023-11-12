package co.yedam.product.service;

import java.util.List;

public interface ProductService {
	// 목록
	public List<ProductVO> productList();

	//단건 조회	
	public ProductVO getProduct(String prodCode);
	
	//별점 높은 순 조회
	public List<ProductVO> selectLikeIt();
}
