package it.contrader.model;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Per dettagli vedi guida sez 4 Model
 */
public class Orders {

    /**
     * Qui sotto definisco gli attributi di User.
     */
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


    /**
     * Definisco i due costruttori, uno vuoto e uno con tre parametri per costrire oggetti di tipo User
     */
    public Orders() {

    }

    public Orders(int user_id, int product_id, int center_id, String title , String description, Float price, Float discount, String start_discount_date,String end_discount_date,String order_date) {
        this.user_id = user_id;
        this.product_id = product_id ;
        this.center_id = center_id;
        this.title = title;
        this.description = description;
        this.price = price;
        this.discount= discount;
        this.start_discount_date=start_discount_date;
        this.end_discount_date=end_discount_date;
        this.order_date=order_date;
    }

    public Orders(int id, int user_id, int product_id,int center_id, String title, String description, Float price, Float discount, String start_discount_date, String end_discount_date, String order_date) {
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

    public int getCenter_id() {
        return center_id;
    }

    public void setCenter_id(int center_id) {
        this.center_id = center_id;
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

    /**
     * Getter e Setter: servono alle altre classi a recuperare e modificare gli attributi di Orders
     */

    //Metodo per il confronto degli oggetti
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Orders orders = (Orders) o;
        return id == orders.id && user_id == orders.user_id && product_id == orders.product_id && title.equals(orders.title) && description.equals(orders.description) && price.equals(orders.price) && discount.equals(orders.discount) && start_discount_date.equals(orders.start_discount_date) && end_discount_date.equals(orders.end_discount_date) && order_date.equals(orders.order_date);
    }

}

