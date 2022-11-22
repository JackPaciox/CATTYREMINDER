package it.contrader.controller;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import com.sun.org.apache.bcel.internal.generic.RETURN;
import it.contrader.dto.ProductDTO;
import it.contrader.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import it.contrader.dto.UserDTO;
import it.contrader.model.User.Usertype;
import it.contrader.service.UserService;
import org.springframework.web.servlet.view.RedirectView;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.List;
import java.util.Locale;

@Controller
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService service;
	@Autowired
	private ProductService productService;


	@PostMapping("/login")
	public void login(HttpServletRequest request, @RequestParam(value = "username", required = true) String username,
						@RequestParam(value = "password", required = true) String password, @RequestParam(value= "errorLogin", required = false) String error,
						  HttpServletResponse response) throws Exception {

		UserDTO userDTO = service.findByUsernameAndPassword(username, password);

		if(userDTO != null){
			request.getSession().setAttribute("currentUser", userDTO);
			response.sendRedirect(request.getContextPath() + "/products/dashboard");
		}else {
			request.getSession().setAttribute("errorLogin",true);
			response.sendRedirect(request.getContextPath() + "/users/logout");
		}

	}

	@GetMapping("/list")
	public String getAll(HttpServletRequest request, HttpServletResponse response) throws Exception {
		UserDTO user = (UserDTO) request.getSession().getAttribute("currentUser");
		if (service.isSuperadmin(user)){
			setAll(request);
			return "user/user";
		}else{
			request.getSession().invalidate();
			response.sendRedirect(request.getContextPath()+"/");
			return null;
		}
	}

	@GetMapping("/delete/{id}")
	public String delete(HttpServletRequest request, @PathVariable("id") Long id, HttpServletResponse response) throws Exception {
		service.delete(id);
		String urlRedirect = request.getContextPath()+"/users/logout";
		if (service.isSuperadmin((UserDTO)request.getSession().getAttribute("currentUser"))) {
			urlRedirect = request.getHeader("Referer");
		}
		response.sendRedirect(urlRedirect);
		return null;
	}

	@GetMapping("/edit/{id}")
	public String preUpdate(HttpServletRequest request, @PathVariable("id") Long id,HttpServletResponse response) throws Exception {
		UserDTO currentUser = (UserDTO) request.getSession().getAttribute("currentUser");
		if (service.isSuperadmin(currentUser)|| currentUser.getId() == id){
		request.setAttribute("dto", service.read(id));
		return "user/update";
	}else {
			request.getSession().invalidate();
			response.sendRedirect(request.getContextPath()+"/");
			return null;
		}
	}

	@PostMapping("/update/{id}")
	public String update(HttpServletRequest request, @PathVariable("id") Long id, @RequestParam("username") String username,
						 @RequestParam("password") String password, @RequestParam("usertype") Usertype usertype,
						 @RequestParam("zipcode") String zipcode, @RequestParam("city") String city,
						 @RequestParam("address")String address,
						 @RequestParam("firstname") String firstname, @RequestParam("lastname") String lastname,
						 @RequestParam("province") String province, @RequestParam("email") String email,
						 @RequestParam("phone") String phone,@RequestParam(value = "back", required = false) String back,
						 HttpServletResponse response)
	throws Exception{
		UserDTO dto = new UserDTO();
		dto.setId(id);
		dto.setUsername(username);
		dto.setPassword(password);
		dto.setUsertype(usertype);
		dto.setAddress(address);
		dto.setFirstname(firstname);
		dto.setLastname(lastname);
		dto.setZipcode(zipcode);
		dto.setCity(city);
		dto.setProvince(province);
		dto.setEmail(email);
		dto.setPhone(phone);
		service.update(dto);
		String redirectUrl = request.getContextPath()+"/users/list";
		if (back != null)
			redirectUrl = back;

		response.sendRedirect(redirectUrl);
		return null;
	}

	@PostMapping("/insert")
	public String insert(HttpServletRequest request, @RequestParam("username") String username,
						 @RequestParam("password") String password, @RequestParam("usertype") Usertype usertype,
						 @RequestParam("zipcode") String zipcode, @RequestParam("city") String city,
						 @RequestParam("address")String address,
						 @RequestParam("firstname") String firstname, @RequestParam("lastname") String lastname,
						 @RequestParam("province") String province, @RequestParam("email") String email,
						 @RequestParam("phone") String phone, @RequestParam(value = "back", required = false) String back,
						 HttpServletResponse response) throws Exception  {
		UserDTO dto = new UserDTO();
		dto.setUsername(username);
		dto.setPassword(password);
		dto.setUsertype(usertype);
		dto.setAddress(address);
		dto.setFirstname(firstname);
		dto.setLastname(lastname);
		dto.setZipcode(zipcode);
		dto.setCity(city);
		dto.setProvince(province);
		dto.setEmail(email);
		dto.setPhone(phone);
		service.insert(dto);
		UserDTO currentUser = (UserDTO)request.getSession().getAttribute("currentUser");
		String redirectUrl = request.getContextPath()+"/users/list";
		if (currentUser != null) {
			if ( currentUser != null || service.isSuperadmin(currentUser) ) {
				if (back != null)
					redirectUrl = back;
			}
			response.sendRedirect(redirectUrl);
			return null;
		}

		request.getSession().invalidate();
		response.sendRedirect(request.getContextPath()+"/?userAdded=true");
		return null;
	}

	@GetMapping("/read/{id}")
	public String read(HttpServletRequest request, @PathVariable("id") Long id) {
		//test
		UserService userService = new UserService();
		UserDTO currentUser = (UserDTO) request.getSession().getAttribute("currentUser");
		request.setAttribute("dto", service.read(id));
		return "user/read";
	}

	@GetMapping("/logout")
	public String logout(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String urlRedirect = request.getContextPath()+"/";
		if(request.getSession().getAttribute("errorLogin") != null){
			request.setAttribute("errorLogin", true);
			urlRedirect += "?errorlogin=true";
		}
		request.getSession().invalidate();
		response.sendRedirect(urlRedirect);
		return null;
	}

	private void setAll(HttpServletRequest request) {
		request.getSession().setAttribute("list", service.getAll());
	}
}
