package it.contrader.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Product {

	/**
	 * Qui sotto definisco gli attributi di Product.
	 */
	private int id;

	private int center_id;

	private String title;

	private String description;

	private float price;

	private float discount;

	private String start_discount_date;

	private String end_discount_date;

	private boolean deleted;

	private String created_at;

	private String updated_at;

	/**
	 * Definisco i due costruttori, uno vuoto e uno con tre parametri per costrire oggetti di tipo User
	 */
	public Product() {

	}

	public Product(int center_id, String title, String description, float price, float discount, String start_discount_date, String end_discount_date) {
		this.center_id = center_id;
		this.title = title;
		this.description = description;
		this.price = price;
		this.discount = discount;
		this.start_discount_date = start_discount_date;
		this.end_discount_date = end_discount_date;
	}

	public Product(int id, int center_id, String title, String description, float price, float discount, String start_discount_date, String end_discount_date) {
		this.id = id;
		this.center_id = center_id;
		this.title = title;
		this.description = description;
		this.price = price;
		this.discount = discount;
		this.start_discount_date = start_discount_date;
		this.end_discount_date = end_discount_date;
	}

	/**
	 * Getter e Setter: servono alle altre classi a recuperare e modificare gli attributi di User
	 */

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCenter_id() {
		return center_id;
	}

	public void setCenter_id(int center_id) {
		this.center_id = center_id;
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

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public float getDiscount() {
		return discount;
	}

	public void setDiscount(float discount) {
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

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public String getCreated_at() {
		return created_at;
	}

	public String getUpdated_at() {
		return updated_at;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Product product = (Product) o;

		if (id != product.id) return false;
		if (center_id != product.center_id) return false;
		if (Float.compare(product.price, price) != 0) return false;
		if (Float.compare(product.discount, discount) != 0) return false;
		if (deleted != product.deleted) return false;
		if (!title.equals(product.title)) return false;
		if (!description.equals(product.description)) return false;
		if (!start_discount_date.equals(product.start_discount_date)) return false;
		if (!end_discount_date.equals(product.end_discount_date)) return false;
		if (!created_at.equals(product.created_at)) return false;
		return updated_at.equals(product.updated_at);
	}

	/*
	@Override
	public String toString() {
		return "Product{" +
				"id=" + id +
				", center_id=" + center_id +
				'}';
	}
	 */

	public Boolean getDeleted() {
		return deleted;
	}
}
