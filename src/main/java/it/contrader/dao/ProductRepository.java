package it.contrader.dao;

import it.contrader.model.Center;
import it.contrader.model.Product;
import it.contrader.model.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface ProductRepository extends CrudRepository<Product, Long> {

    Product findById(long id);

    @Query("SELECT p " +
            "FROM Product p " +
            "INNER JOIN Center AS c ON p.center = c " +
            "INNER JOIN User AS u ON c.user = u " +
            "WHERE u <> :user AND p.deleted = false ORDER BY :sort")
    List<Product> getAllProductsByAdminNot(@Param("user") User user, @Param("sort") String sort);

    List<Product> findByDeletedFalse();
    List<Product> findByDeletedFalseOrderByTitleAsc();
    List<Product> findByDeletedFalseOrderByTitleDesc();
    List<Product> findByDeletedFalseOrderByPriceAsc();
    List<Product> findByDeletedFalseOrderByPriceDesc();
    List<Product> findByDeletedFalseOrderByDiscountAsc();
    List<Product> findByDeletedFalseOrderByDiscountDesc();
    List<Product> findByDeletedFalseOrderByStartDiscountDateAsc();
    List<Product> findByDeletedFalseOrderByStartDiscountDateDesc();
    List<Product> findByDeletedFalseOrderByEndDiscountDateAsc();
    List<Product> findByDeletedFalseOrderByEndDiscountDateDesc();

    @Query("SELECT p FROM Product p INNER JOIN Center AS c ON p.center = c INNER JOIN User AS u ON c.user = u WHERE u <> :user AND p.deleted = false")
    List<Product> getAllProductsByAdminNot(@Param(value="user") User user);
    @Query("SELECT p FROM Product p INNER JOIN Center AS c ON p.center = c INNER JOIN User AS u ON c.user = u WHERE u <> :user AND p.deleted = false " +
            "ORDER BY p.title ASC")
    List<Product> getAllProductsByAdminNotOrderByTitleAsc(@Param(value="user") User user);
    @Query("SELECT p FROM Product p INNER JOIN Center AS c ON p.center = c INNER JOIN User AS u ON c.user = u WHERE u <> :user AND p.deleted = false " +
            "ORDER BY p.title DESC")
    List<Product> getAllProductsByAdminNotOrderByTitleDesc(@Param(value="user") User user);
    @Query("SELECT p FROM Product p INNER JOIN Center AS c ON p.center = c INNER JOIN User AS u ON c.user = u WHERE u <> :user AND p.deleted = false " +
            "ORDER BY p.price ASC")
    List<Product> getAllProductsByAdminNotOrderByPriceAsc(@Param(value="user") User user);
    @Query("SELECT p FROM Product p INNER JOIN Center AS c ON p.center = c INNER JOIN User AS u ON c.user = u WHERE u <> :user AND p.deleted = false " +
            "ORDER BY p.price DESC")
    List<Product> getAllProductsByAdminNotOrderByPriceDesc(@Param(value="user") User user);
    @Query("SELECT p FROM Product p INNER JOIN Center AS c ON p.center = c INNER JOIN User AS u ON c.user = u WHERE u <> :user AND p.deleted = false " +
            "ORDER BY p.discount ASC")
    List<Product> getAllProductsByAdminNotOrderByDiscountAsc(@Param(value="user") User user);
    @Query("SELECT p FROM Product p INNER JOIN Center AS c ON p.center = c INNER JOIN User AS u ON c.user = u WHERE u <> :user AND p.deleted = false " +
            "ORDER BY p.discount DESC")
    List<Product> getAllProductsByAdminNotOrderByDiscountDesc(@Param(value="user") User user);
    @Query("SELECT p FROM Product p INNER JOIN Center AS c ON p.center = c INNER JOIN User AS u ON c.user = u WHERE u <> :user AND p.deleted = false " +
            "ORDER BY p.startDiscountDate ASC")
    List<Product> getAllProductsByAdminNotOrderByStartDiscountDateAsc(@Param(value="user") User user);
    @Query("SELECT p FROM Product p INNER JOIN Center AS c ON p.center = c INNER JOIN User AS u ON c.user = u WHERE u <> :user AND p.deleted = false " +
            "ORDER BY p.startDiscountDate DESC")
    List<Product> getAllProductsByAdminNotOrderByStartDiscountDateDesc(@Param(value="user") User user);
    @Query("SELECT p FROM Product p INNER JOIN Center AS c ON p.center = c INNER JOIN User AS u ON c.user = u WHERE u <> :user AND p.deleted = false " +
            "ORDER BY p.endDiscountDate ASC")
    List<Product> getAllProductsByAdminNotOrderByEndDiscountDateAsc(@Param(value="user") User user);
    @Query("SELECT p FROM Product p INNER JOIN Center AS c ON p.center = c INNER JOIN User AS u ON c.user = u WHERE u <> :user AND p.deleted = false " +
            "ORDER BY p.endDiscountDate DESC")
    List<Product> getAllProductsByAdminNotOrderByEndDiscountDateDesc(@Param(value="user") User user);

    @Query("SELECT p FROM Product p INNER JOIN Center AS c ON p.center = c INNER JOIN User AS u ON c.user = u WHERE u = :user AND p = :product")
    List<Product> getIfUserIsProductOwner(@Param(value="user") User user, @Param(value="product") Product product);


    @Transactional
    @Modifying
    @Query("UPDATE Product p SET p.deleted = 1 WHERE p.id = :id")
    void logicalDelete(@Param("id") long id);

    List<Product> findByDeletedFalseAndCenterId(long id);

    @Transactional
    @Modifying
    @Query("UPDATE Product p SET p.qty = p.qty-1 WHERE p.id = :id")
    void updateQtyDecreaseByOne(@Param("id") long id);

}
