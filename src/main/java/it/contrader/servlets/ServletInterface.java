package it.contrader.servlets;

import it.contrader.dto.DTO;
import it.contrader.dto.UserDTO;
import it.contrader.service.Service;

import javax.servlet.http.HttpServletRequest;

public interface ServletInterface {

    public void list(HttpServletRequest request);

    public void insert(HttpServletRequest request);

    public void read(HttpServletRequest request);

    public void update(HttpServletRequest request);

    public void delete(HttpServletRequest request);

}
