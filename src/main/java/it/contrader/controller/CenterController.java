package it.contrader.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Path;

import it.contrader.dto.UserDTO;
import it.contrader.converter.CenterConverter;
import it.contrader.model.Center;
import it.contrader.model.User;
import it.contrader.service.ProductService;
import it.contrader.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import it.contrader.dto.CenterDTO;
import it.contrader.model.User.Usertype;
import it.contrader.service.CenterService;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/centers")
public class CenterController {
    @Autowired
    private CenterService service;

    @Autowired
    private UserService userService;
    @Autowired
    private ProductService productService;
    private UserDTO currentUser;

    @GetMapping("/list")
    public String getAll(HttpServletRequest request,HttpServletResponse response) {
        request.setAttribute("editCenters",false);
        request.setAttribute("isAdminCenterRequired",false);
        UserDTO currentUser = this.getCurrentSessionUser(request);
        if (userService.isSuperadmin(currentUser)) {
            request.setAttribute("adminUserslist", userService.getAdminUsersList());
        }
        if (userService.isAdmin(currentUser)) {
            setAllCentersByUserIsNot(request,currentUser);
        } else {
            setAll(request);
        }
        return "center/center";
    }

    @GetMapping("/admin/{id}")
    public String getAllByAdmin(HttpServletRequest request, @PathVariable("id") long id) {
        UserDTO selectedUser = userService.read(id);
        if (userService.isAdmin(selectedUser)){
            request.setAttribute("editCenters",true);
            request.setAttribute("isAdminCenterRequired",true);
            setAllCentersByUser(request,id);
        } else {
            new RedirectView(request.getContextPath()+"/centers");
            return null;
        }
        return "center/center";
    }

    @GetMapping("/delete/{id}")
    public String delete(HttpServletRequest request, @PathVariable("id") long id, HttpServletResponse response) throws Exception {
        service.delete(id);
        response.sendRedirect(request.getHeader("Referer"));
        return null;
    }

    @GetMapping("/edit/{id}")
    public String preUpdate(HttpServletRequest request, @PathVariable("id") Long id) {
        UserDTO currentUser = (UserDTO)request.getSession().getAttribute("currentUser");
        request.setAttribute("center", service.read(id));
        if (userService.isSuperadmin(currentUser)) {
            request.setAttribute("adminUserslist", userService.getAdminUsersList());
        }
        return "center/update";
    }

    @RequestMapping("/update/{id}")
    public String update(
            HttpServletRequest request,
            @PathVariable("id") long id,
            @RequestParam("user_id") long user_id,
            @RequestParam("name") String name,
            @RequestParam("description") String description,
            @RequestParam("address") String address,
            @RequestParam("zipcode") String zipcode,
            @RequestParam("city") String city,
            @RequestParam("province") String province,
            @RequestParam("phone") String phone,
            @RequestParam("email") String email,
            @RequestParam("website") String website,
            @RequestParam(value="back", required = false) String back,
            HttpServletResponse response
    ) throws Exception
    {
        CenterDTO dto = service.read(id);
        dto.setName(name);
        dto.setDescription(description);
        dto.setAddress(address);
        dto.setZipcode(zipcode);
        dto.setCity(city);
        dto.setProvince(province);
        dto.setPhone(phone);
        dto.setEmail(email);
        dto.setWebSite(website);
        dto.setUser(userService.read(user_id));
        service.update(dto);
        String redirectUrl = request.getContextPath()+"/centers/list";
        UserDTO currentUser = (UserDTO)request.getSession().getAttribute("currentUser");
        if (currentUser.getUsertype().equals(Usertype.ADMIN)) {
            redirectUrl = request.getContextPath()+"/centers/admin/"+currentUser.getId();
        }
        response.sendRedirect(redirectUrl);
        return null;
    }

    @PostMapping("/insert")
    public String insert(
            HttpServletRequest request,
            @RequestParam("user_id") long user_id,
            @RequestParam("name") String name,
            @RequestParam("description") String description,
            @RequestParam("address") String address,
            @RequestParam("zipcode") String zipcode,
            @RequestParam("city") String city,
            @RequestParam("province") String province,
            @RequestParam("phone") String phone,
            @RequestParam("email") String email,
            @RequestParam("website") String website,
            @RequestParam(value="back", required = false) String back,
            HttpServletResponse response
    ) throws Exception
    {
        CenterDTO dto = new CenterDTO();
        dto.setName(name);
        dto.setDescription(description);
        dto.setAddress(address);
        dto.setZipcode(zipcode);
        dto.setCity(city);
        dto.setProvince(province);
        dto.setPhone(phone);
        dto.setEmail(email);
        dto.setWebSite(website);
        dto.setUser(userService.read(user_id));
        service.update(dto);
        String redirectUrl = request.getContextPath()+"/centers/list";
        UserDTO currentUser = (UserDTO)request.getSession().getAttribute("currentUser");
        if (currentUser.getUsertype().equals(Usertype.ADMIN)) {
            redirectUrl = request.getContextPath()+"/centers/admin/"+currentUser.getId();
        }
        response.sendRedirect(redirectUrl);
        return null;
    }

    @GetMapping("/read/{id}")
    public String read(HttpServletRequest request, @PathVariable("id") Long id) {
        CenterDTO center = service.read(id);
        request.setAttribute("center", center);
        this.setAllCentersByUser(request, center.getUser().getId());
        request.setAttribute("productsList", productService.findByDeletedFalseAndCenterId(id));
        return "center/read";
    }

    private void setAll(HttpServletRequest request) {
        request.setAttribute("centersList", service.getAll());
    }

    private void setAllCentersByUser(HttpServletRequest request, long id_user) {
        UserDTO user = userService.read(id_user);
        List<CenterDTO> centersList = null;
        if (userService.isAdmin(user)) {
            centersList = service.getAllByUser(user);
        }
        if (userService.isSuperadmin(user)) {
            centersList = service.getAllByUserIsNot(user);
        }
        request.setAttribute("centersList", centersList);
    }

    private void setAllCentersByUserIsNot(HttpServletRequest request, UserDTO currentUser) {
        request.setAttribute("centersList", service.getAllByUserIsNot(currentUser));
    }

    private UserDTO getCurrentSessionUser(HttpServletRequest request) {
        if (request.getSession(false) == null) {
            new RedirectView(request.getContextPath());
            return null;
        }
        if (request.getSession().getAttribute("currentUser") == null) {
            new RedirectView(request.getContextPath());
            return null;
        }
        return (UserDTO)request.getSession().getAttribute("currentUser");
    }
}
