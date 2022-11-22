package it.contrader.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.contrader.dto.ProductDTO;

import it.contrader.model.Product;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductConverter extends AbstractConverter<Product, ProductDTO> {

    @Autowired
    private CenterConverter converter;
    @Override
    public Product toEntity(ProductDTO productDTO) {
        Product product = null;
        if (productDTO != null) {
            product = new Product(productDTO.getId(), productDTO.getTitle(), productDTO.getDescription(), productDTO.getPrice(), productDTO.getDiscount(), productDTO.getQty(), productDTO.getStartDiscountDate(), productDTO.getEndDiscountDate(),  converter.toEntity(productDTO.getCenter()));
        }
        return product;
    }

    @Override
    public ProductDTO toDTO(Product product) {
        ProductDTO productDTO = null;
        if (product != null) {
            productDTO = new ProductDTO(product.getId(), product.getTitle(), product.getDescription(), product.getPrice(), product.getDiscount(), product.getQty(), product.getStartDiscountDate(), product.getEndDiscountDate(), converter.toDTO(product.getCenter()) );

        }
        return productDTO;
    }

    public List<ProductDTO> toDTOList(List<Product> products){

        List<ProductDTO>productDTOList = new ArrayList<ProductDTO>();

        //Cicla tutti gli elementi della lista e li converte uno a uno
        for(Product product : products) {
            //Utilizza il metodo toDTO per convertire ogni singolo elemento della lista
            //e lo aggiunge adda lista di DTO
            productDTOList.add(toDTO(product));
        }
        return productDTOList;


    }

}
