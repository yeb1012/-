package co.yedam.product.service;

import lombok.Data;

@Data
public class ProductVO {
	
	private int prodCode;
	private String prodName;
	private String prodDesc;
	private int price;
	private int offPrice;
	private String likeIt;
	private String prodImage;
	
}
