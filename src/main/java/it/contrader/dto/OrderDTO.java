package it.contrader.dto;

import java.time.LocalDateTime;

/**
 *
 * @author Vittorio
 *
 *Il DTO è simile al Model ma può contenere meno attributi (ad esempio d dati sensibili
 *che non devono arrivare alla View). GLi oggetti vengono trasformati da oggetti del Model
 *a oggetti del DTO tramite i Converter (chiamati dai Service).
 *Per la descrizione della classe far riferimento al Model "User".
 */
public class OrderDTO {

    private int id;

    private int user_id;

    private int product_id;
    private int center_id;
    private String title;
    private String description;
    private Float price;

    private Float discount;

    private String start_discount_date;

    private String end_discount_date;

    private String order_date;

    public OrderDTO() {

    }
    public OrderDTO(int id, int user_id, int product_id, int center_id ,String title, String description, Float price, Float discount, String start_discount_date, String end_discount_date, String order_date) {
        this.id = id;
        this.user_id = user_id;
        this.product_id = product_id;
        this.center_id = center_id;
        this.title = title;
        this.description = description;
        this.price = price;
        this.discount = discount;
        this.start_discount_date = start_discount_date;
        this.end_discount_date = end_discount_date;
        this.order_date = order_date;
    }

    public OrderDTO( int user_id, int product_id, int center_id ,String title, String description, Float price, Float discount, String start_discount_date, String end_discount_date, String order_date) {
        this.user_id = user_id;
        this.product_id = product_id;
        this.center_id = center_id;
        this.title = title;
        this.description = description;
        this.price = price;
        this.discount = discount;
        this.start_discount_date = start_discount_date;
        this.end_discount_date = end_discount_date;
        this.order_date = order_date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public int getCenter_id() {
        return center_id;
    }

    public void setCenter_id(int center_id) {
        this.center_id = center_id;
    }
    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Float getDiscount() {
        return discount;
    }

    public void setDiscount(Float discount) {
        this.discount = discount;
    }

    public String getStart_discount_date() {
        return start_discount_date;
    }

    public void setStart_discount_date(String start_discount_date) {
        this.start_discount_date = start_discount_date;
    }

    public String getEnd_discount_date() {
        return end_discount_date;
    }

    public void setEnd_discount_date(String end_discount_date) {
        this.end_discount_date = end_discount_date;
    }

    public String getOrder_date() {
        return order_date;
    }

    public void setOrder_date(String order_date) {
        this.order_date = order_date;
    }

    @Override
    public String toString() {
        return  id + "\t"  + user_id +"\t\t" +   product_id + "\t\t" + title + "\t\t" +description + "\t\t" + price+ "\t\t" +discount+ "\t\t" +start_discount_date+ "\t\t" +end_discount_date+ "\t\t" +order_date;}
}

