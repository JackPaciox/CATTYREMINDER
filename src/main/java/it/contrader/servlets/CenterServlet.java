package it.contrader.servlets;

import it.contrader.dto.CenterDTO;
import it.contrader.dto.UserDTO;
import it.contrader.service.CenterService;
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
public class CenterServlet extends HttpServlet implements ServletInterface{
	private static final long serialVersionUID = 1L;
	public Service<CenterDTO> service = new CenterService();

	public CenterDTO dto;

	public int id;
	public boolean ans;


	public CenterServlet() {
	}
	
	public void list(HttpServletRequest request) {
		final HttpSession session = request.getSession();
		UserDTO user = (UserDTO) session.getAttribute("dto");
		String userType = user.getUsertype().toString();
		if (userType.equals("USER")) {
			CenterService service = new CenterService();
			List<CenterDTO> listDTO = service.getAllMain(user.getId());
			request.setAttribute("list", listDTO);
			request.setAttribute("usertype", userType);
			request.setAttribute("dto",user);
		} else if (userType.equals("SUPERADMIN")) {
			CenterService service = new CenterService();
			List<CenterDTO> listDTO = service.getAll();
			request.setAttribute("list", listDTO);
			request.setAttribute("usertype", userType);
			request.setAttribute("dto",user);
		}else{
			CenterService serviceAdmin = new CenterService();
			int userid = user.getId();
			List<CenterDTO> listDTO = serviceAdmin.getAllOfCenter(userid);
			request.setAttribute("list",listDTO);
			request.setAttribute("usertype", userType);
			request.setAttribute("dto",user);
		}
	}
	public void insert(HttpServletRequest request) {
		final HttpSession session = request.getSession();
		UserDTO user = (UserDTO) session.getAttribute("dto");
		int user_id = user.getId();
		String centername = request.getParameter("centername").toString();
		String centeraddress = request.getParameter("centeraddress").toString();
		String cenercity = request.getParameter("centercity").toString();
		String centerprovince = request.getParameter("centerprovince").toString();
		dto = new CenterDTO (user_id,centername,centeraddress,cenercity,centerprovince);
		ans = service.insert(dto);
		request.setAttribute("ans", ans);
	}
	public void read(HttpServletRequest request) {
		final HttpSession session = request.getSession();
		UserDTO user = (UserDTO) session.getAttribute("dto");
		id = Integer.parseInt(request.getParameter("id"));
		Service<CenterDTO> service = new CenterService();
		dto = service.read(id);
		request.setAttribute("center", dto);
		request.setAttribute("dto", user);

	}
	public void update(HttpServletRequest request) {
		int user_id = Integer.parseInt(request.getParameter("id"));
		String centername = request.getParameter("centername").toString();
		String centeraddress = request.getParameter("centeraddress").toString();
		String cenercity = request.getParameter("centercity").toString();
		String centerprovince = request.getParameter("centerprovince").toString();
		id = Integer.parseInt(request.getParameter("center_id"));
		dto = new CenterDTO (id,user_id, centername, centeraddress,cenercity,centerprovince);
		ans = service.update(dto);
	}
	public void delete(HttpServletRequest request) {
		final HttpSession session = request.getSession();
		UserDTO user = (UserDTO) session.getAttribute("dto");
		int user_id = user.getId();
		id = Integer.parseInt(request.getParameter("id"));
		ans = service.delete(id);
		request.setAttribute("ans", ans);
	}


	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mode = request.getParameter("mode");
		switch (mode.toUpperCase()) {

		case "LIST":
			list(request);
			getServletContext().getRequestDispatcher("/center/centermanager.jsp").forward(request, response);
			break;

		case "READ":

			if (request.getParameter("update") == null) {
				read(request);
				 getServletContext().getRequestDispatcher("/center/readcenter.jsp").forward(request, response);
				
			}
			else {
				update(request);
				read(request);
				getServletContext().getRequestDispatcher("/center/updatecenter.jsp").forward(request, response);
			}
			break;

		case "INSERT":
			insert(request);
			list(request);
			getServletContext().getRequestDispatcher("/center/centermanager.jsp").forward(request, response);
			break;
			
		case "UPDATE":
			update(request);
			list(request);
			getServletContext().getRequestDispatcher("/center/centermanager.jsp").forward(request, response);
			break;

		case "DELETE":
			delete(request);
			list(request);
			getServletContext().getRequestDispatcher("/center/centermanager.jsp").forward(request, response);
			break;
		}
	}
}