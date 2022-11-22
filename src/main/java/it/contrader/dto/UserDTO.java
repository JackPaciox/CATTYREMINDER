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
public class UserDTO {
	
	private int id;

	private String username;
	
	private String password;
	
	private String usertype;

	private String firstname;

	private String lastname;

	private String address;

	private String zipcode;

	private String city;

	private String province;

	private String email;

	private String phone;
	
	public UserDTO() {
		
	}

	public UserDTO (String username, String password, String usertype,String firstname, String lastname, String address, String zipcode, String city, String province, String email, String phone) {
		this.username = username;
		this.password = password;
		this.usertype = usertype;
		this.firstname = firstname;
		this.lastname = lastname;
		this.address = address;
		this.zipcode = zipcode;
		this.city = city;
		this.province = province;
		this.email = email;
		this.phone = phone;
	}

	public UserDTO (int id, String username, String password, String usertype, String firstname, String lastname, String address, String zipcode, String city, String province, String email, String phone) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.usertype = usertype;
		this.firstname = firstname;
		this.lastname = lastname;
		this.address = address;
		this.zipcode = zipcode;
		this.city = city;
		this.province = province;
		this.email = email;
		this.phone = phone;

	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getUsertype() {
		return this.usertype;
	}

	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUsername() {
		return username;
	}

	@Override
	public String toString() {
			return  id + "\t"  + username +"\t\t" +   password + "\t\t" + usertype + "\t\t" + firstname + "\t\t" + lastname + "\t\t" + address + "\t\t" + zipcode + "\t\t" + city + "\t\t" + province + "\t\t" + email + "\t\t" + phone;
		}
	}
