package it.contrader.converter;

import it.contrader.dto.ProductDTO;
import it.contrader.dto.UserDTO;
import it.contrader.model.Product;
import it.contrader.model.User;

import java.util.ArrayList;
import java.util.List;

public class ProductConverter implements Converter<Product, ProductDTO> {
	public ProductDTO toDTO(Product product) {
		int Id = product.getId();
		int Center_id = product.getCenter_id();
		String Title = String.valueOf(product.getTitle());
		String Description = String.valueOf(product.getDescription());
		Float Price = product.getPrice();
		Float Discount= product.getDiscount();
		String Start_discount_date = product.getStart_discount_date();
		String End_discount_date = product.getEnd_discount_date();
		ProductDTO productDTO = new ProductDTO(
				Id,
				Center_id,
				Title,
				Description,
				Price,
				Discount,
				Start_discount_date,
				End_discount_date
		);

		return productDTO;
	}

	/**
	 * Crea un oggetto di tipo User e lo riempie con i campi del parametro user di tipo UserDTO.
	 * Notare l'uso del metodo get() per ottenere il valore dell'attributo-
	 */
	public Product toEntity(ProductDTO productDTO) {
		Product product = new Product(
				productDTO.getId(),
				productDTO.getCenter_id(),
				productDTO.getTitle(),
				productDTO.getDescription(),
				productDTO.getPrice(),
				productDTO.getDiscount(),
				productDTO.getStart_discount_date(),
				productDTO.getEnd_discount_date()
		);

		return product;
	}

	/**
	 * Metodo per convertire le liste di Center.
	 */
	public List<ProductDTO> toDTOList(List<Product> productList) {
		//Crea una lista vuota.
		List<ProductDTO>productDTOList = new ArrayList<ProductDTO>();

		//Cicla tutti gli elementi della lista e li converte uno a uno
		for(Product product : productList) {
			//Utilizza il metodo toDTO per convertire ogni singolo elemento della lista
			//e lo aggiunge adda lista di DTO
			productDTOList.add(toDTO(product));
		}
		return productDTOList;
	}



}