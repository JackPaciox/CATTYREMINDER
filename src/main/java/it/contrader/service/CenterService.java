package it.contrader.service;

import it.contrader.converter.CenterConverter;
import it.contrader.converter.UserConverter;
import it.contrader.dao.CenterRepository;
import it.contrader.dto.CenterDTO;
import it.contrader.dto.UserDTO;
import it.contrader.model.Center;
import it.contrader.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CenterService extends AbstractService <Center, CenterDTO> {
    @Autowired
    private CenterConverter converter;
    @Autowired
    private UserConverter userConverter;
    @Autowired
    private CenterConverter centerConverter;
    @Autowired
    private CenterRepository repository;

    public List<CenterDTO> getAllByUser(UserDTO user) {
        return converter.toDTOList(repository.findByUser(userConverter.toEntity(user)));
    }

    public List<CenterDTO> getAllByUserIsNot(UserDTO user) {
        return converter.toDTOList(repository.findByUserNot(userConverter.toEntity(user)));
    }

    //public List<CenterDTO> findByCity(String city, String address) {
        //return converter.toDTOList(repository.findByCity(city, address));
}
