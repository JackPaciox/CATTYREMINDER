package it.contrader.dto;

public class ProductDTO {

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

	public ProductDTO(
			int center_id,
			String title,
			String description,
			float price,
			float discount,
			String start_discount_date,
			String end_discount_date
	) {
		this.center_id = center_id;
		this.title = title;
		this.description = description;
		this.price = price;
		this.discount = discount;
		this.start_discount_date = start_discount_date;
		this.end_discount_date = end_discount_date;
	}

	public ProductDTO(
			int id,
			int center_id,
			String title,
			String description,
			float price,
			float discount,
			String start_discount_date,
			String end_discount_date
	) {
		this.id = id;
		this.center_id = center_id;
		this.title = title;
		this.description = description;
		this.price = price;
		this.discount = discount;
		this.start_discount_date = start_discount_date;
		this.end_discount_date = end_discount_date;
	}

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

	public boolean getDeleted() {
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
	public String toString() {
		return  id + "\t"  + center_id + "\t\t" + title+ "\t\t" + description+ "\t\t" + price + "\t\t" + discount + "\t\t" + start_discount_date + "\t\t" + end_discount_date+ "\t\t" + deleted+ "\t\t" + created_at+ "\t\t" + updated_at;
	}

}
