package it.contrader.controller;

import it.contrader.converter.CenterConverter;
import it.contrader.converter.ProductConverter;
import it.contrader.converter.UserConverter;
import it.contrader.dto.OrderDTO;
import it.contrader.dto.UserDTO;
import it.contrader.model.Order;
import it.contrader.service.CenterService;
import it.contrader.service.OrderService;
import it.contrader.service.ProductService;
import it.contrader.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDate;

@Controller
@RequestMapping("/orders")
public class OrdersController {
    @Autowired
    private OrderService service;

    @Autowired
    private CenterService centerService;

    @Autowired
    private UserService userService;

    @Autowired
    private ProductService productService;

    @Autowired
    private CenterConverter centerConverter;

    @Autowired
    private UserConverter userConverter;

    @Autowired
    private ProductConverter productConverter;

    @GetMapping(value="/list")
    public String getAll(HttpServletRequest request) {
        UserDTO currentUser = (UserDTO)request.getSession().getAttribute("currentUser");
        request.setAttribute("list",service.findByUser(currentUser));
        return "order/order";
    }

    @PostMapping(value="/insert")
    public String insert(
            HttpServletRequest request,
            @RequestParam("title") String title,
            @RequestParam("description") String description,
            @RequestParam("price") float price,
            @RequestParam("discount") float discount,
            @RequestParam("start_discount_date") String start_discount_date,
            @RequestParam("end_discount_date") String end_discount_date,
            @RequestParam("product_id") long productId,
            @RequestParam("center_id") long centerId,
            @RequestParam("user_id") long userId,
            HttpServletResponse response
    ) throws Exception {
        OrderDTO dto = new OrderDTO();
        dto.setTitle(title);
        dto.setDescription(description);
        dto.setPrice(price);
        dto.setDiscount(discount);
        dto.setStartDiscountDate(LocalDate.parse(start_discount_date));
        dto.setEndDiscountDate(LocalDate.parse(end_discount_date));
        dto.setCenter(centerConverter.toEntity(centerService.read(centerId)));
        dto.setProduct(productConverter.toEntity(productService.read(productId)));
        dto.setUser(userConverter.toEntity(userService.read(userId)));
        service.update(dto);
        productService.updateQtyDecreaseByOne(productId);
        response.sendRedirect(request.getContextPath() + "/orders/list");
        return null;
    }

    @GetMapping(value="read/{id}")
    public String read(HttpServletRequest request, @PathVariable("id") long id) {
        request.setAttribute("order",service.read(id));
        return "order/read";
    }
}
