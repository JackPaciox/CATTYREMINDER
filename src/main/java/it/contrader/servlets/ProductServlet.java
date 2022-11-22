package it.contrader.servlets;


import it.contrader.dto.ProductDTO;
import it.contrader.dto.UserDTO;
import it.contrader.service.ProductService;
import it.contrader.service.Service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/*
 * Per dettagli vedi Guida sez Servlet
 */
public class ProductServlet extends HttpServlet implements ServletInterface{
	private static final long serialVersionUID = 1L;
	public Service<ProductDTO> service = new ProductService();

	public ProductDTO dto;
	public int id;
	public boolean ans;

	public ProductServlet() {
	}

	// ******************  METODI CRUD  **************************
	public void list(HttpServletRequest request) {
		final HttpSession session = request.getSession();
		UserDTO user = (UserDTO) session.getAttribute("dto");
		String userType = user.getUsertype();
		if (userType.equals("USER")) {
			Service<ProductDTO> service = new ProductService();
			List<ProductDTO> listDTO = ((ProductService) service).getAllProductNotDeleted();
			request.setAttribute("list", listDTO);
			request.setAttribute("usertype", userType);
			request.setAttribute("dto",user);
		}else{
			Service<ProductDTO> service = new ProductService();
			List<ProductDTO> listDTO = service.getAll();
			request.setAttribute("list", listDTO);
			request.setAttribute("usertype", userType);
			request.setAttribute("dto",user);
		}
	}

	public void insert(HttpServletRequest request) {
		final HttpSession session = request.getSession();
		UserDTO user = (UserDTO) session.getAttribute("dto");
		Service<ProductDTO> service = new ProductService();
		int center_id =  Integer.parseInt(request.getParameter("id"));
		float price = Float.parseFloat(request.getParameter("price"));
		float discount = Float.parseFloat(request.getParameter("discount"));
		String title = request.getParameter("title");
		String description = request.getParameter("description");
		String start_discount_date = request.getParameter("start-discount-date");
		String end_discount_date =request.getParameter("end-discount-date");
		dto = new ProductDTO(center_id, title,description, price,discount,start_discount_date,end_discount_date);
		ans = service.insert(dto);
		request.setAttribute("dto",user);
		request.setAttribute("ans", ans);
	}
	public void read(HttpServletRequest request) {
		final HttpSession session = request.getSession();
		UserDTO user = (UserDTO) session.getAttribute("dto");
		id = Integer.parseInt(request.getParameter("id"));
		Service<ProductDTO> service = new ProductService();
		dto = service.read(id);
		request.setAttribute("product", dto);
		request.setAttribute("userDTO",user);
	}

	public void update(HttpServletRequest request) {

		Service<ProductDTO> service = new ProductService();
		ProductDTO product = (ProductDTO) request.getAttribute("dto");
		int center_id = Integer.parseInt(request.getParameter("center_id"));
		String title = request.getParameter("title");
		String description = request.getParameter("description");
		String start_discount_date = request.getParameter("start-discount-date");
		String end_discount_date = request.getParameter("end-discount-date");
		int id = Integer.parseInt(request.getParameter("id"));
		float price = Float.parseFloat(request.getParameter("price"));
		float discount = Float.parseFloat(request.getParameter("discount"));

		dto = new ProductDTO(id,center_id, title,description, price,discount,start_discount_date,end_discount_date);
		ans = service.update(dto);

	}
	public void delete(HttpServletRequest request) {
		HttpSession session = request.getSession();
		int id = Integer.parseInt(request.getParameter("id"));
		ProductDTO product = service.read(id);
		ans = service.delete(id);
		request.setAttribute("centerid",product.getCenter_id());
		request.setAttribute("ans", ans);
	}

	public void listByCenter(HttpServletRequest request){
		final HttpSession session = request.getSession();
		UserDTO user = (UserDTO) session.getAttribute("dto");

		String userType = user.getUsertype();
		int center_id = Integer.parseInt(request.getParameter("id"));
		if (userType.equals("ADMIN")) {
			Service<ProductDTO> service = new ProductService();
			List<ProductDTO> listDTO =  ((ProductService) service).getAllProductBySelectedCenter(center_id);
			request.setAttribute("list", listDTO);
			request.setAttribute("usertype", userType);
			request.setAttribute("dto",user);
			request.setAttribute("centerid", center_id);
		}
	}

	public void filterBy(HttpServletRequest request){
		final HttpSession session = request.getSession();
		UserDTO user = (UserDTO) session.getAttribute("dto");
		String userType = user.getUsertype();

		String option = request.getParameter("options");

		if (userType.equals("USER")) {
			Service<ProductDTO> service = new ProductService();
			List<ProductDTO> listDTO = ((ProductService) service).filterBy(option);
			request.setAttribute("list", listDTO);
			request.setAttribute("usertype", userType);
			request.setAttribute("dto",user);
		}
	}
	// ******************  METODI CRUD  **************************
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mode = request.getParameter("mode");
		final HttpSession session = request.getSession();
		UserDTO user = (UserDTO) session.getAttribute("dto");
		String userType = user.getUsertype();

		switch (mode.toUpperCase()) {

			case "LIST":
				if(userType.equals("ADMIN"))
					listByCenter(request);
				else
					list(request);

				getServletContext().getRequestDispatcher("/product/productmanager.jsp").forward(request, response);
				break;

			case "READ":
				read(request);
				if (request.getParameter("update") == null)
					getServletContext().getRequestDispatcher("/product/readproduct.jsp").forward(request, response);
				else
					getServletContext().getRequestDispatcher("/product/updateproduct.jsp").forward(request, response);
				break;

			case "INSERT":
				insert(request);
				listByCenter(request);
				getServletContext().getRequestDispatcher("/product/productmanager.jsp").forward(request, response);
				break;

			case "UPDATE":
				update(request);
				response.sendRedirect(request.getContextPath() + "/ProductServlet?mode=list&id=" + request.getParameter("center_id"));
				break;
			case "FILTERBY":
				filterBy(request);
				getServletContext().getRequestDispatcher("/product/productmanager.jsp").forward(request, response);
				break;

			case "DELETE":

				delete(request);
				System.out.println(request.getAttribute("centerid"));
				response.sendRedirect(request.getContextPath() + "/ProductServlet?mode=list&id=" + request.getAttribute("centerid"));
				break;
		}
	}
}