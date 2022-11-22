package it.contrader.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.contrader.dto.CenterDTO;
import it.contrader.dto.ProductDTO;
import it.contrader.dto.UserDTO;

import it.contrader.model.User;
import it.contrader.service.CenterService;
import it.contrader.service.ProductService;
import it.contrader.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;


import java.time.LocalDate;

@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService service;
    @Autowired
    private CenterService centerService;
    @Autowired
    private UserService userService;

    @GetMapping("/list")
    public String getAll(HttpServletRequest request) {
        UserDTO currentUser = (UserDTO)request.getSession().getAttribute("currentUser");
        if(!userService.isAdmin(currentUser))
            request.setAttribute("productsList", service.findByDeletedFalse());
        else
            request.setAttribute("productsList",service.getAllProductsByAdminNot(currentUser,null));

        if(userService.isSuperadmin(currentUser))
            request.setAttribute("centersList", centerService.getAll());

        request.setAttribute("isAdminCenterRequired",false);

        return "product/product";
    }

    @GetMapping("/dashboard")
    public String getAllDashboard(HttpServletRequest request, @RequestParam(value= "filter", required = false) String filter) {

        UserDTO currentUser = (UserDTO) request.getSession().getAttribute("currentUser");
        if (filter != null) {
            request.setAttribute("selectedFilters", filter);
        }
        if(!userService.isAdmin(currentUser))
            request.setAttribute("productsList", service.getAll(filter));

        else
            request.setAttribute("productsList",service.getAllProductsByAdminNot(currentUser,filter));

        if(userService.isSuperadmin(currentUser))
            request.setAttribute("centersList", centerService.getAll());

        return "homeadmin";
    }
    @GetMapping("/center/{id}")
    public String getAllByCenterId(HttpServletRequest request, @PathVariable("id")long centerId){
        request.setAttribute("productsList", service.findByDeletedFalseAndCenterId(centerId));
        return "product";
    }

    @GetMapping("/read/{id}")
    public String read(HttpServletRequest request, @PathVariable("id") Long id) {
        ProductDTO product = service.read(id);
        UserDTO currentUser = (UserDTO)request.getSession().getAttribute("currentUser");
        boolean isAdminProductOwner = service.checkIfUserIsProductOwner(currentUser,product);
        CenterDTO center = centerService.read(product.getCenter().getId());
        request.setAttribute("dto", product);
        request.setAttribute("isAdminProductOwner", isAdminProductOwner);
        this.getCentersList(request);
        return "product/read";
    }

    @PostMapping("/insert")
    public String insert(
            HttpServletRequest request,
            @RequestParam("title") String title,
            @RequestParam("description") String description,
            @RequestParam("start_discount_date") String startDiscountDate,
            @RequestParam("end_discount_date") String endDiscountDate,
            @RequestParam("price") float price,
            @RequestParam("discount")float discount,
            @RequestParam("qty") int qty,
            @RequestParam("center") int center,
            @RequestParam(value="back", required = false) String back,
            HttpServletResponse response
    ) throws Exception {
        ProductDTO dto = new ProductDTO();
        dto.setCreatedAt(LocalDate.now());
        dto.setTitle(title);
        dto.setQty(qty);
        dto.setDescription(description);
        dto.setStartDiscountDate(LocalDate.parse(startDiscountDate));
        dto.setEndDiscountDate(LocalDate.parse(endDiscountDate));
        dto.setPrice(price);
        dto.setDiscount(discount);
        dto.setCenter(centerService.read(center));
        dto.setDeleted(false);
        service.insert(dto);
        setAll(request);
        String redirectUrl = request.getContextPath()+"/products/list";
        if (back != null)
            redirectUrl = back;

        response.sendRedirect(redirectUrl);
        return null;
    }

    @GetMapping("/edit/{id}")
    public String preUpdate(HttpServletRequest request, @PathVariable("id") Long id) {
        ProductDTO product = service.read(id);
        CenterDTO center = centerService.read(product.getCenter().getId());
        this.getCentersList(request);
        request.setAttribute("dto", service.read(id));
        return "product/update";
    }

    @PostMapping("/update/{id}")
    public String update(
            HttpServletRequest request,
            @PathVariable("id") Long id,
            @RequestParam("title") String title,
            @RequestParam("description") String description,
            @RequestParam("start_discount_date") String startDiscountDate,
            @RequestParam("end_discount_date") String endDiscountDate,
            @RequestParam("price") float price,
            @RequestParam("discount")float discount,
            @RequestParam("qty") int qty,
            @RequestParam("center") int center,
            @RequestParam(value="back", required = false) String back,
            HttpServletResponse response
    ) throws Exception
    {
        ProductDTO dto = new ProductDTO();
        dto.setUpdatedAt(LocalDate.now());
        dto.setId(id);
        dto.setQty(qty);
        dto.setTitle(title);
        dto.setDescription(description);
        dto.setStartDiscountDate(LocalDate.parse(startDiscountDate));
        dto.setEndDiscountDate(LocalDate.parse(endDiscountDate));
        dto.setPrice(price);
        dto.setDiscount(discount);
        dto.setCenter(centerService.read(center));
        service.update(dto);
        String redirectUrl = request.getContextPath()+"/products/list";
        if (back != null)
            redirectUrl = back;

        response.sendRedirect(redirectUrl);
        return null;
    }

    @GetMapping("/delete/{id}")
    public String delete(HttpServletRequest request, @PathVariable("id") Long id, HttpServletResponse response) throws Exception{
        service.delete(id);
        response.sendRedirect(request.getHeader("Referer"));
        return null;
    }

    private void setAll(HttpServletRequest request) {
        request.setAttribute("productsList", service.getAll());
    }

    public void getCentersList(HttpServletRequest request) {
        UserDTO currentUser = (UserDTO)request.getSession().getAttribute("currentUser");

        if (currentUser.getUsertype().equals(User.Usertype.SUPERADMIN))
            request.setAttribute("centersList", centerService.getAll());

        if (currentUser.getUsertype().equals(User.Usertype.ADMIN)) {
            request.setAttribute("centersList", centerService.getAllByUser(currentUser));
        }
    }

}
