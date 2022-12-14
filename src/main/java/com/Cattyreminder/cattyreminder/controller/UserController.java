package com.Cattyreminder.cattyreminder.controller;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import com.sun.org.apache.bcel.internal.generic.RETURN;
import com.Cattyreminder.cattyreminder.dto.*;


import com.Cattyreminder.cattyreminder.model.User;
import com.Cattyreminder.cattyreminder.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

import java.util.List;


@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping("/home")
    public String getHome(HttpServletRequest request, HttpServletResponse response) throws Exception {

        UserDTO user = (UserDTO) request.getSession().getAttribute("currentUser");
        System.out.println("bella sono nella home"+ user );

        if (service.isAdmin(user)){
            setAllAdmin(request);
            return "User/home";
        }else{
            setAllAdmin(request);
            return "User/home";
        }
    }


    @PostMapping("/login")
    public String login(HttpServletRequest request, @RequestParam(value = "username", required = true) String username,
                      @RequestParam(value = "password", required = true) String password, @RequestParam(value= "errorLogin", required = false) String error,
                      HttpServletResponse response) throws Exception {

        UserDTO userDTO = service.findByUsernameAndPassword(username, password);
        if(userDTO != null){
            System.out.println("accesso");
            System.out.println(userDTO);
            request.getSession().setAttribute("currentUser", userDTO);
            response.sendRedirect(request.getContextPath() + "/users/home");
        }else {
            System.out.println("accesso negato");
            request.getSession().setAttribute("errorLogin",true);
            response.sendRedirect(request.getContextPath() + "/users/logout");
        }
        return "index";

    }
//    @GetMapping("/list")
//    public String getAll(HttpServletRequest request, HttpServletResponse response) throws Exception {
//        UserDTO user = (UserDTO) request.getSession().getAttribute("currentUser");
//        if (service.isSuperadmin(user)){
//            setAll(request);
//            return "user/user";
//        }else{
//            request.getSession().invalidate();
//            response.sendRedirect(request.getContextPath()+"/");
//            return null;
//        }
//    }

//    @GetMapping("/delete/{id}")
//    public String delete(HttpServletRequest request, @PathVariable("id") Long id, HttpServletResponse response) throws Exception {
//        service.delete(id);
//        String urlRedirect = request.getContextPath()+"/users/logout";
//        if (service.isSuperadmin((UserDTO)request.getSession().getAttribute("currentUser"))) {
//            urlRedirect = request.getHeader("Referer");
//        }
//        response.sendRedirect(urlRedirect);
//        return null;
//    }

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

    @PostMapping("/insert")
    public String insert(HttpServletRequest request, @RequestParam("password") String password,
                         @RequestParam("firstname") String firstname, @RequestParam("lastname") String lastname,
                         @RequestParam("email") String email,
                         @RequestParam("phone") String phone, @RequestParam(value = "back", required = false) String back,
                         HttpServletResponse response) throws Exception  {

        String username = firstname.charAt(0) + lastname;
        UserDTO dto = new UserDTO();
        dto.setUsername(username);
        dto.setPassword(password);
        dto.setUsertype(User.Usertype.USER);
        dto.setFirstname(firstname);
        dto.setLastname(lastname);
        dto.setEmail(email);
        dto.setPhone(phone);
        dto.setDiscord("undefined");
//        ContactSetting contactSetting = new ContactSetting();
//        Preferences preferences = new Preferences();
//        dto.setContactSetting(contactSetting);
//        dto.setPreferences(preferences);
        service.insert(dto);
        UserDTO currentUser = (UserDTO)request.getSession().getAttribute("currentUser");
        String redirectUrl = request.getContextPath()+"/users/list";
//        if (currentUser != null) {
//            if ( currentUser != null ) {
//                if (back != null)
//                    redirectUrl = back;
//            }
//            response.sendRedirect(redirectUrl);
//            return null;
//        }
//
//        request.getSession().invalidate();
//        response.sendRedirect(request.getContextPath()+"/?userAdded=true");
        return "login";
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

    private void setAllAdmin(HttpServletRequest request) {
        System.out.println("sono nel setall");
        UserDTO user = (UserDTO) request.getSession().getAttribute("currentUser");

        LocalDate oraAttuale =  LocalDate.now();
        TaskService taskService = new TaskService();
        List<TaskDTO> todayTaskDTO = (List<TaskDTO>) taskService.findByUserAndEnd_date(user,oraAttuale);
        if (todayTaskDTO != null) {
            request.getSession().setAttribute("tasknull", Boolean.FALSE);
            request.getSession().setAttribute("todayTask", todayTaskDTO);
        }else {
            request.getSession().setAttribute("tasknull", Boolean.TRUE);
        }
        SegmentService segmentService = new SegmentService();

        System.out.println(oraAttuale);



        ProjectService projectService = new ProjectService();
        List<ProjectDTO> projectDTOS = projectService.getAllByUser(user);

        if (projectDTOS != null){
            request.getSession().setAttribute("projectnull", Boolean.FALSE);
            for (ProjectDTO p : projectDTOS ) {
            System.out.println("inizio ciclatura");
            List<SegmentDTO> segment = segmentService.getAllByProject(p);
            request.getSession().setAttribute("segment"+ p.getId(), segment);
        }
        System.out.println("fine ciclatura");
        request.getSession().setAttribute("projectList", projectDTOS);
    }
        else {
            request.getSession().setAttribute("projectnull", Boolean.TRUE);
        }
        EventService eventService = new EventService();
        List<EventDTO> eventDTOS = eventService.getAllByUser(user);
        if (eventDTOS != null) {
            request.getSession().setAttribute("eventnull", Boolean.FALSE);
            request.getSession().setAttribute("event", eventDTOS);
        }else {
            request.getSession().setAttribute("eventnull", Boolean.TRUE);
        }

    }
    private void setAll(HttpServletRequest request) {
        request.getSession().setAttribute("list", service.getAll());
    }
}