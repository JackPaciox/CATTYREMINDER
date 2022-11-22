package it.contrader.service;

import it.contrader.converter.ProductConverter;
import it.contrader.dao.ProductDAO;
import it.contrader.dto.ProductDTO;
import it.contrader.model.Product;

import java.util.List;

public class ProductService extends AbstractService<Product, ProductDTO> {

	//Istanzio DAO  e Converter specifici.
	public ProductService(){
		this.dao = new ProductDAO();
		this.converter = new ProductConverter();
	}

	public List<ProductDTO> getAllProductNotDeleted(){
		ProductDAO productDAO = new ProductDAO();
		return converter.toDTOList(productDAO.getAllProductNotDeleted());
	}

	public List<ProductDTO> filterBy(String value){
		ProductDAO productDAO = new ProductDAO();
		switch(value.toUpperCase()){
			case "PREZZO":
				return converter.toDTOList(productDAO.getAll_By_PRICE());

			case "DATA":
				return converter.toDTOList(productDAO.getAll_By_DATA());

			case "ORDINE":
				return converter.toDTOList(productDAO.getAll_By_OFFERS());

			default:
				return converter.toDTOList(productDAO.getAllProductNotDeleted());
		}
	}
	@Override
	public boolean delete(int id) {
		ProductDAO productdao = new ProductDAO();
		return productdao.delete(id);
	}


	public List<ProductDTO> getAllProductBySelectedCenter(int center_id){
		ProductDAO productDAO = new ProductDAO();
		return converter.toDTOList(productDAO.getAllProductBySelectedCenter(center_id));
	}
}
