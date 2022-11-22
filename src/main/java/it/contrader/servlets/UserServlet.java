package it.contrader.servlets;

import java.util.List;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.contrader.dto.UserDTO;
import it.contrader.service.Service;
import it.contrader.service.UserService;

/*
 * Per dettagli vedi Guida sez Servlet
 */
public class UserServlet extends HttpServlet implements ServletInterface{
	private static final long serialVersionUID = 1L;

	public Service<UserDTO> service = new UserService();
	public String mode;
	public UserDTO dto;
	public int id;
	public boolean ans;
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

	public UserServlet() {
	}
	
	public void list(HttpServletRequest request) {
		Service<UserDTO> service = new UserService();
		List<UserDTO>listDTO = service.getAll();
		request.setAttribute("list", listDTO);
	}

	public void insert(HttpServletRequest request) {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String usertype = request.getParameter("usertype");
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String address = request.getParameter("address");
		String zipcode = request.getParameter("zipcode");
		String city = request.getParameter("city");
		String province = request.getParameter("province");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		dto = new UserDTO (username,password,usertype, firstname, lastname, address, zipcode, city, province, email, phone);
		ans = service.insert(dto);
		request.setAttribute("ans", ans);
		list(request);
	}
	public void setAsUser(HttpServletRequest request) {
		final HttpSession session = request.getSession();
		UserDTO user = (UserDTO) session.getAttribute("dto");
		UserDTO newUser = new UserDTO(user.getId(),user.getUsername(),user.getPassword(),"USER",user.getFirstname(),user.getLastname(),user.getAddress(),user.getZipcode(),user.getCity(),user.getProvince(),user.getEmail(),user.getPhone());
		session.setAttribute("dto",newUser);
	}
	public void read(HttpServletRequest request) {

	}
	public void update(HttpServletRequest request) {
		username = request.getParameter("username");
		password = request.getParameter("password");
		usertype = request.getParameter("usertype");
		firstname = request.getParameter("firstname");
		lastname = request.getParameter("lastname");
		address = request.getParameter("address");
		zipcode = request.getParameter("zipcode");
		city = request.getParameter("city");
		province = request.getParameter("province");
		email = request.getParameter("email");
		phone = request.getParameter("phone");
		id = Integer.parseInt(request.getParameter("id"));
		dto = new UserDTO (id,username, password, usertype, firstname, lastname, address, zipcode, city,province, email,phone);
		request.setAttribute("isupdated", "yes");
		ans = service.update(dto);
	}
	public void delete(HttpServletRequest request) {}


	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		this.mode = request.getParameter("mode");

		switch (mode.toUpperCase()) {

		case "LIST":
			list(request);
			getServletContext().getRequestDispatcher("/user/usermanager.jsp").forward(request, response);
			break;

		case "READ":
			id = Integer.parseInt(request.getParameter("id"));
			dto = service.read(id);
			request.setAttribute("dto", dto);
			
			if (request.getParameter("update") == null)
				getServletContext().getRequestDispatcher("/user/readuser.jsp").forward(request, response);
			else
				getServletContext().getRequestDispatcher("/user/updateuser.jsp").forward(request, response);
			
			break;

		case"IMPOSTAUTENTE":
			setAsUser(request);
			getServletContext().getRequestDispatcher("/homeadmin.jsp").forward(request, response);

			break;
		case "INSERT":
			insert(request);
			getServletContext().getRequestDispatcher("/user/usermanager.jsp").forward(request, response);
			break;
			
		case "UPDATE":
			update(request);
			//list(request);
			getServletContext().getRequestDispatcher("/user/updateuser.jsp").forward(request, response);
			break;

		case "DELETE":
			id = Integer.parseInt(request.getParameter("id"));
			ans = service.delete(id);
			request.setAttribute("ans", ans);
			list(request);
			getServletContext().getRequestDispatcher("/user/usermanager.jsp").forward(request, response);
			break;
		}
	}
}