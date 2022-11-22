package it.contrader.servlets;

import java.time.LocalDateTime;
import java.util.List;

import java.io.IOException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.contrader.dto.OrderDTO;
import it.contrader.dto.ProductDTO;
import it.contrader.dto.UserDTO;
import it.contrader.service.Service;
import it.contrader.service.OrderService;

public class OrderServlet extends HttpServlet implements ServletInterface{
    private static final long serialVersionUID = 1L;
    public Service<OrderDTO> service= new OrderService();
    public OrderServlet() {
    }
    public String mode;
    public OrderDTO dto;
    public int id;
    public boolean ans;

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

    @Override
    public void list(HttpServletRequest request) {
        final HttpSession session =request.getSession();
        UserDTO use = (UserDTO) session.getAttribute("dto");
        Service<OrderDTO> service = (Service<OrderDTO>) new OrderService();
        List<OrderDTO>listDTO = service.getAll();
        request.setAttribute("list", listDTO);
        request.setAttribute("dto", use);
        if (use.getUsertype().equals("ADMIN")){
            int id = Integer.parseInt(request.getParameter("id"));
            OrderService serviceorder = new OrderService();
            List<OrderDTO> orderlistDTO = serviceorder.getAllOfOrder(id);
            request.setAttribute("list", orderlistDTO);
            request.setAttribute("dto", use);
        }
    }
    public void delete(HttpServletRequest request){
    }
    public void update(HttpServletRequest request){
    }

    public void insert(HttpServletRequest request) {
        final HttpSession session = request.getSession();
        UserDTO user = (UserDTO) session.getAttribute("dto");
        Service<OrderDTO> service = new OrderService();
        user_id = user.getId();
        title = request.getParameter("title");
        description = request.getParameter("description");
        price = Float.valueOf(request.getParameter("price"));
        discount = Float.valueOf(request.getParameter("discount"));
        start_discount_date = request.getParameter("start-discount-date");
        end_discount_date = request.getParameter("end-discount-date");
        String order_date = LocalDateTime.now().toString();
        product_id = Integer.parseInt(request.getParameter("product_id"));
        center_id = Integer.parseInt(request.getParameter("center_id"));
        dto = new OrderDTO (user_id, product_id,center_id,title,description,price, discount, start_discount_date, end_discount_date, order_date);
        ans = service.insert(dto);
        request.setAttribute("ans", ans);
    }
    public void read(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        Service<OrderDTO> service = new OrderService();
        OrderDTO dto = service.read(id);
        request.setAttribute("dto", dto);
    }

    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.mode = request.getParameter("mode");

        switch (mode.toUpperCase()) {

            case "LIST":
                list(request);
                getServletContext().getRequestDispatcher("/order/ordermanager.jsp").forward(request, response);
                break;

            case "READ":
                id = Integer.parseInt(request.getParameter("id"));
                dto = service.read(id);
                request.setAttribute("dto", dto);

                if (request.getParameter("update") == null)
                    getServletContext().getRequestDispatcher("/order/ordermanager.jsp").forward(request, response);
                else
                    getServletContext().getRequestDispatcher("/order/updateorder.jsp").forward(request, response);
                break;

            case "INSERT":
                insert(request);
                list(request);
                getServletContext().getRequestDispatcher("/order/ordermanager.jsp").forward(request, response);
                break;
        }
    }

}
