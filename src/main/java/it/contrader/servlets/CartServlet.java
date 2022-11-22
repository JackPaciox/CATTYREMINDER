package it.contrader.servlets;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Per dettagli vedi Guida sez Servlet
 */
public class CartServlet extends HttpServlet implements ServletInterface{
	private static final long serialVersionUID = 1L;

	private final int initQty = 1;
	/**
	 * product_ID
	 * 		id: ID
	 * 		name: NOME_PRODOTTO
	 * 		description: DESCRIZIONE
	 * 		qty: QTY
	 * 		unitPrice: PREZZO_PRODOTTO
	 * 		totalAmount: PREZZO_TOTALE
	 */
	private Map<String,Map<String, String>> productsCartList;

	private Float cartTotal;

	public CartServlet() {
	}
	
	public void list(HttpServletRequest request) {

	}

	public void insert(HttpServletRequest request) {}
	public void read(HttpServletRequest request) {}
	public void update(HttpServletRequest request) {}
	public void delete(HttpServletRequest request) {}


	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mode = request.getParameter("mode");
		// chiamo la sessione corrente e se non esiste ne creo una

		/**
		 * Aggiungi/diminuisci quantità con selettore più o meno
		 * @param id_product
		 * @param product_name
		 * @param action ["up","down"]
		 * @param unit_price
		 */

		final HttpSession session = request.getSession();
		if (
				session.getAttribute("totalCart") == null &&
				session.getAttribute("totalCartProducts") == null &&
				session.getAttribute("productsCartList") == null
		) {
			session.setAttribute("totalCart",this.cartTotal);
			session.setAttribute("totalCartProducts",this.cartTotal);
			session.setAttribute("productsCartList", this.productsCartList);
		}

		switch (mode.toUpperCase()) {

		case "LIST":
			list(request);
			getServletContext().getRequestDispatcher("/user/usermanager.jsp").forward(request, response);
			break;

		case "READ":

			if (request.getParameter("update") == null)
				getServletContext().getRequestDispatcher("/user/readuser.jsp").forward(request, response);
			else
				getServletContext().getRequestDispatcher("/user/updateuser.jsp").forward(request, response);
			break;

		case "INSERT":
			getServletContext().getRequestDispatcher("/user/usermanager.jsp").forward(request, response);
			break;
			
		case "UPDATE":
			getServletContext().getRequestDispatcher("/user/usermanager.jsp").forward(request, response);
			break;

		case "DELETE":
			getServletContext().getRequestDispatcher("/user/usermanager.jsp").forward(request, response);
			break;
		}
	}

			/*
		- Aggiungi prodotto al carrello
		- Sottrai prodotto al carrello
		- Elimina prodotto dal carrello
		- Mostra lista prodotti
		- Mostra totale prodotti
		- Calcola totale carrello
		- Calcola totale prodotti
		 */


	private void updateProductInCart (HttpServletRequest request, int qtyToAdd) {
		int id_product = Integer.parseInt(request.getParameter("idProduct"));
		String productName = request.getParameter("productName");
		String productDescription = request.getParameter("productDescription");
		float productPrice = Float.parseFloat(request.getParameter("productPrice"));
		float productDiscountPrice = Float.parseFloat(request.getParameter("productDiscountPrice"));
		String startDiscountAt = request.getParameter("startDiscountAt");
		String endDiscountAt = request.getParameter("endDiscountAt");

		final HttpSession session = request.getSession();
		Map productsCartList = (Map)session.getAttribute("productsCartList");
		LocalDateTime minDate,maxDate,now;

		float totalCart = Float.parseFloat(session.getAttribute("totalCart").toString());
		float totalCartProducts = Float.parseFloat(session.getAttribute("totalCartProducts").toString());

		// Verifico la presenza del prodotto da aggiungere nella lista prodotti
		if(productsCartList.containsKey("product_"+id_product)) {

		} else {
			float unitPrice;
			Map<String,String> productToAddToCart = null;
			productToAddToCart.put("id", String.valueOf(id_product));
			productToAddToCart.put("productName", productName);
			productToAddToCart.put("productDescription", productDescription);
			productToAddToCart.put("productPrice", String.valueOf(productPrice));
			productToAddToCart.put("productDiscountPrice", String.valueOf(productDiscountPrice));

			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			minDate = LocalDateTime.parse(startDiscountAt, formatter);
			maxDate = LocalDateTime.parse(endDiscountAt, formatter);
			now = LocalDateTime.parse(LocalDateTime.now().toString(), formatter);
			if ((now.isAfter(minDate) || now.isEqual(minDate)) && (now.isBefore(maxDate) || now.isEqual(maxDate))) {
				unitPrice = productDiscountPrice;
			} else {
				unitPrice = productPrice;
			}
			productToAddToCart.put("unitPrice", String.valueOf(unitPrice));

			productToAddToCart.put("totalAmount", String.valueOf(unitPrice+qtyToAdd));
		}
	}

	private void increaseProductInCart(HttpServletRequest request) {
		this.updateProductInCart(request, 1);
	}

	private void decreaseProductInCart(HttpServletRequest request) {
		this.updateProductInCart(request, -1);
	}

	private void updateTotalCart(HttpServletRequest request) {
		final HttpSession session = request.getSession();
		float totalCart = Float.parseFloat(session.getAttribute("totalCart").toString());
		float totalCartProducts = Float.parseFloat(session.getAttribute("totalCartProducts").toString());
		Map productsCartList = (Map)session.getAttribute("productsCartList");
		/**
		 * @TODO
		 * Implementare aggiornamento totale carrello e totale prodotti carrello
		 */
		productsCartList.forEach((k, v) -> System.out.println((k + ":" + v)));

	}
}