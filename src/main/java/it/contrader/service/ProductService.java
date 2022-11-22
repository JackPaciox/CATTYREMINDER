package it.contrader.service;

import it.contrader.converter.CenterConverter;
import it.contrader.converter.UserConverter;
import it.contrader.dao.CenterRepository;
import it.contrader.dto.CenterDTO;
import it.contrader.dto.UserDTO;
import it.contrader.model.User;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import it.contrader.converter.ProductConverter;
import it.contrader.dao.ProductRepository;
import it.contrader.dto.ProductDTO;
import it.contrader.model.Product;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductService extends AbstractService<Product, ProductDTO> {

    @Autowired
    private ProductConverter converter;
    @Autowired
    private UserConverter userConverter;
    @Autowired
    private CenterConverter centerConverter;
    @Autowired
    private ProductRepository repository;

    @Autowired
    private CenterRepository centerRepository;

    public boolean checkIfUserIsProductOwner (UserDTO user, ProductDTO productDTO) {
        List<Product> products = repository.getIfUserIsProductOwner(userConverter.toEntity(user), converter.toEntity(productDTO));
        return (products.size() > 0);
    }

    public List<ProductDTO> findByDeletedFalseAndCenterId(long centerId){
        return converter.toDTOList(repository.findByDeletedFalseAndCenterId(centerId));
    }

    public List<ProductDTO> findByDeletedFalse(){
        return converter.toDTOList(repository.findByDeletedFalse());
    }

    public List<ProductDTO> getAll(String filter){
        if(filter == null) {
            return converter.toDTOList(repository.findByDeletedFalseOrderByTitleAsc());
        } else {
            List<ProductDTO> productsList;
            switch(filter){
                case "nameAsc":
                    productsList = converter.toDTOList(repository.findByDeletedFalseOrderByTitleAsc());
                    break;
                case "nameDesc":
                    productsList = converter.toDTOList(repository.findByDeletedFalseOrderByTitleDesc());
                    break;
                case "priceAsc":
                    productsList = converter.toDTOList(repository.findByDeletedFalseOrderByPriceAsc());
                    break;
                case "priceDesc":
                    productsList = converter.toDTOList(repository.findByDeletedFalseOrderByPriceDesc());
                    break;
                case "discountAsc":
                    productsList = converter.toDTOList(repository.findByDeletedFalseOrderByDiscountAsc());
                    break;
                case "discountDesc":
                    productsList = converter.toDTOList(repository.findByDeletedFalseOrderByDiscountDesc());
                    break;
                case "startDateAsc":
                    productsList = converter.toDTOList(repository.findByDeletedFalseOrderByStartDiscountDateAsc());
                    break;
                case "startDateDesc":
                    productsList = converter.toDTOList(repository.findByDeletedFalseOrderByStartDiscountDateDesc());
                    break;
                case "endDateAsc":
                    productsList = converter.toDTOList(repository.findByDeletedFalseOrderByEndDiscountDateAsc());
                    break;
                case "endDateDesc":
                    productsList = converter.toDTOList(repository.findByDeletedFalseOrderByEndDiscountDateDesc());
                    break;
                default:
                    productsList = converter.toDTOList(repository.findByDeletedFalse());
                    break;
            }
            return productsList;
        }
    }


    public List<ProductDTO> getAllProductsByAdminNot(UserDTO userDTO, String filter){
        List<ProductDTO> productsList = null;
        if(filter == null) {
            return converter.toDTOList(repository.getAllProductsByAdminNotOrderByTitleAsc(userConverter.toEntity(userDTO)));
        } else {
            switch(filter){
                case "nameAsc":
                    productsList = converter.toDTOList(repository.getAllProductsByAdminNotOrderByTitleAsc(userConverter.toEntity(userDTO)));
                    break;
                case "nameDesc":
                    productsList = converter.toDTOList(repository.getAllProductsByAdminNotOrderByTitleDesc(userConverter.toEntity(userDTO)));
                    break;
                case "priceAsc":
                    productsList = converter.toDTOList(repository.getAllProductsByAdminNotOrderByPriceAsc(userConverter.toEntity(userDTO)));
                    break;
                case "priceDesc":
                    productsList = converter.toDTOList(repository.getAllProductsByAdminNotOrderByPriceDesc(userConverter.toEntity(userDTO)));
                    break;
                case "discountAsc":
                    productsList = converter.toDTOList(repository.getAllProductsByAdminNotOrderByDiscountAsc(userConverter.toEntity(userDTO)));
                    break;
                case "discountDesc":
                    productsList = converter.toDTOList(repository.getAllProductsByAdminNotOrderByDiscountDesc(userConverter.toEntity(userDTO)));
                    break;
                case "startDateAsc":
                    productsList = converter.toDTOList(repository.getAllProductsByAdminNotOrderByStartDiscountDateAsc(userConverter.toEntity(userDTO)));
                    break;
                case "startDateDesc":
                    productsList = converter.toDTOList(repository.getAllProductsByAdminNotOrderByStartDiscountDateDesc(userConverter.toEntity(userDTO)));
                    break;
                case "endDateAsc":
                    productsList = converter.toDTOList(repository.getAllProductsByAdminNotOrderByEndDiscountDateAsc(userConverter.toEntity(userDTO)));
                    break;
                case "endDateDesc":
                    productsList = converter.toDTOList(repository.getAllProductsByAdminNotOrderByEndDiscountDateDesc(userConverter.toEntity(userDTO)));
                    break;
                default:
                    productsList = converter.toDTOList(repository.getAllProductsByAdminNot(userConverter.toEntity(userDTO)));
                    break;
            }
        }
        return productsList;
    }

    @Override
    public void delete (long id) {
        repository.logicalDelete(id);
    }

    public void updateQtyDecreaseByOne(long id) {
        repository.updateQtyDecreaseByOne(id);
    }

}
