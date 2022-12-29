package com.Cattyreminder.cattyreminder.controller;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import com.sun.org.apache.bcel.internal.generic.RETURN;
import com.Cattyreminder.cattyreminder.dto.ProjectDTO;
import com.Cattyreminder.cattyreminder.dto.UserDTO;

import com.Cattyreminder.cattyreminder.model.ContactSetting;
import com.Cattyreminder.cattyreminder.model.Preferences;
import com.Cattyreminder.cattyreminder.model.User;
import com.Cattyreminder.cattyreminder.model.User.Usertype;
import com.Cattyreminder.cattyreminder.service.ProjectService;
import com.Cattyreminder.cattyreminder.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.List;
import java.util.Locale;

//project/add
@Controller
@RequestMapping("/projects")
public class ProjectController extends AbstractController<ProjectDTO> {

    @Autowired
    private ProjectService service;



    @GetMapping("/add")
    public String add(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("sono passato per di qua");
        return "project/insert";
    }

//    @GetMapping("/edit/{id}")
//    public String preUpdate(HttpServletRequest request, @PathVariable("id") Long id,HttpServletResponse response) throws Exception {
//        UserDTO currentUser = (UserDTO) request.getSession().getAttribute("currentUser");
//        if (service.isSuperadmin(currentUser)|| currentUser.getId() == id){
//            request.setAttribute("dto", service.read(id));
//            return "user/update";
//        }else {
//            request.getSession().invalidate();
//            response.sendRedirect(request.getContextPath()+"/");
//            return null;
//        }
//    }

//    @PostMapping("/update/{id}")
//    public String update(HttpServletRequest request, @PathVariable("id") Long id, @RequestParam("username") String username,
//                         @RequestParam("password") String password, @RequestParam("usertype") Usertype usertype,
//                         @RequestParam("zipcode") String zipcode, @RequestParam("city") String city,
//                         @RequestParam("address")String address,
//                         @RequestParam("firstname") String firstname, @RequestParam("lastname") String lastname,
//                         @RequestParam("province") String province, @RequestParam("email") String email,
//                         @RequestParam("phone") String phone,@RequestParam(value = "back", required = false) String back,
//                         HttpServletResponse response)
//            throws Exception{
//        UserDTO dto = new UserDTO();
//        dto.setId(id);
//        dto.setUsername(username);
//        dto.setPassword(password);
//        dto.setUsertype(usertype);
//        dto.setAddress(address);
//        dto.setFirstname(firstname);
//        dto.setLastname(lastname);
//        dto.setZipcode(zipcode);
//        dto.setCity(city);
//        dto.setProvince(province);
//        dto.setEmail(email);
//        dto.setPhone(phone);
//        service.update(dto);
//        String redirectUrl = request.getContextPath()+"/users/list";
//        if (back != null)
//            redirectUrl = back;
//
//        response.sendRedirect(redirectUrl);
//        return null;
//    }

//
//    @PostMapping("/insert")
//    public String insert(HttpServletRequest request, @RequestParam("password") String password,
//                         @RequestParam("firstname") String firstname, @RequestParam("lastname") String lastname,
//                         @RequestParam("email") String email,
//                         @RequestParam("phone") String phone, @RequestParam(value = "back", required = false) String back,
//                         HttpServletResponse response) throws Exception  {
//
//        String username = firstname.charAt(0) + lastname;
//        UserDTO dto = new UserDTO();
//        dto.setUsername(username);
//        dto.setPassword(password);
//        dto.setUsertype(Usertype.USER);
//        dto.setFirstname(firstname);
//        dto.setLastname(lastname);
//        dto.setEmail(email);
//        dto.setPhone(phone);
//        dto.setDiscord("undefined");
////        ContactSetting contactSetting = new ContactSetting();
////        Preferences preferences = new Preferences();
////        dto.setContactSetting(contactSetting);
////        dto.setPreferences(preferences);
//        service.insert(dto);
//        UserDTO currentUser = (UserDTO)request.getSession().getAttribute("currentUser");
//        String redirectUrl = request.getContextPath()+"/users/list";
////        if (currentUser != null) {
////            if ( currentUser != null ) {
////                if (back != null)
////                    redirectUrl = back;
////            }
////            response.sendRedirect(redirectUrl);
////            return null;
////        }
////
////        request.getSession().invalidate();
////        response.sendRedirect(request.getContextPath()+"/?userAdded=true");
//        return "login";
//    }
//
//    @GetMapping("/read/{id}")
//    public String read(HttpServletRequest request, @PathVariable("id") Long id) {
//        //test
//        UserService userService = new UserService();
//        UserDTO currentUser = (UserDTO) request.getSession().getAttribute("currentUser");
//        request.setAttribute("dto", service.read(id));
//        return "user/read";
//    }
//
//    @GetMapping("/logout")
//    public String logout(HttpServletRequest request, HttpServletResponse response) throws Exception {
//        String urlRedirect = request.getContextPath()+"/";
//        if(request.getSession().getAttribute("errorLogin") != null){
//            request.setAttribute("errorLogin", true);
//            urlRedirect += "?errorlogin=true";
//        }
//        request.getSession().invalidate();
//        response.sendRedirect(urlRedirect);
//        return null;
//    }
//
//    private void setAll(HttpServletRequest request) {
//        request.getSession().setAttribute("list", service.getAll());
//    }
}