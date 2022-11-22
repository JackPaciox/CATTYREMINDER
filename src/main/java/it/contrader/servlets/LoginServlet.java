package it.contrader.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.contrader.dto.ProductDTO;
import it.contrader.dto.UserDTO;
import it.contrader.service.LoginService;
import it.contrader.service.ProductService;
import it.contrader.service.Service;
import it.contrader.service.UserService;


/*
 * Login Servlet
 */
public class LoginServlet extends HttpServlet {
	// UID della servlet
	private static final long serialVersionUID = 1L;

	/**
	 * @param request  request
	 * @param response response
	 *                 <p>
	 *                 Metodo che gestisce le request che arrivano dalla JSP.
	 */
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		final HttpSession session = request.getSession();
		session.setAttribute("dto", null);
		String mode = request.getParameter("mode");
		if(mode.equals("signup")){
			Service<UserDTO> service = new UserService();
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
			UserDTO user = new UserDTO(username,password,usertype,firstname,lastname,address,zipcode,city,province,email,phone);
			service.insert(user);
		}
		/**
		 * @Per Michele
		 */
		// UserDTO user = (UserDTO)session.getAttribute("user");
		// String userType = user.getUsertype();

		LoginService service = new LoginService();

		if (request != null) {
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			//come nei vecchi controller, invoca il service
			UserDTO dto = service.login(username, password);
			if (dto != null)
				//se il login ha funzionato, salva l'utente nella sessione
				session.setAttribute("dto", dto);

			else
				//altrimenti torna alla pagina di login
				getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);

			List<String> roles = new ArrayList<String>();
			roles.add("USER");
			roles.add("ADMIN");
			roles.add("SUPERADMIN");

			//esegue un if else in base allo usertype per il reindirizzamento
			if (dto.getUsertype().toUpperCase() != null && roles.contains(dto.getUsertype().toUpperCase())) {
				session.setAttribute("currentSection", "home");
				getServletContext().getRequestDispatcher("/homeadmin.jsp").forward(request, response);
			} else {
				getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);

				//esegue una switch cae in base allo usertype per il reindirizzamento
				switch (dto.getUsertype().toUpperCase()) {
					case "SUPERADMIN":
						//questo metodo reindirizza alla JSP tramite URL con una request e una response
						getServletContext().getRequestDispatcher("/homeadmin.jsp").forward(request, response);
						break;
					case "ADMIN":
						//questo metodo reindirizza alla JSP tramite URL con una request e una response
						getServletContext().getRequestDispatcher("/homeadmin.jsp").forward(request, response);
						break;

					case "USER":
						getServletContext().getRequestDispatcher("/homeadmin.jsp").forward(request, response);
						break;

					default:
						//di default rimanda al login
						getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
						break;
				}
			}
		}
	}
}