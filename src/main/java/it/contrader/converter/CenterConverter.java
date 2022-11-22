package it.contrader.converter;
import it.contrader.dto.CenterDTO;
import it.contrader.model.Product;
import it.contrader.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.contrader.dto.CenterDTO;

import it.contrader.model.Center;
@Component
public class CenterConverter extends AbstractConverter <Center,CenterDTO> {

    @Autowired
    private UserConverter converter;

    @Override
    public Center toEntity(CenterDTO centerDTO) {
        Center center = null;
        if (centerDTO != null) {
            center = new Center(centerDTO.getId(), centerDTO.getName(), centerDTO.getDescription(), centerDTO.getAddress(), centerDTO.getZipcode(), centerDTO.getCity(), centerDTO.getProvince(), centerDTO.getPhone(), centerDTO.getEmail(), centerDTO.getWebSite(), converter.toEntity( centerDTO.getUser()), centerDTO.getProducts());
        }
        return center;
    }

    @Override
    public CenterDTO toDTO(Center center) {
        CenterDTO centerDTO = null;
        if (center != null) {
            centerDTO = new CenterDTO(center.getId(), center.getName(), center.getDescription(), center.getAddress(),center.getCity(), center.getZipcode(), center.getProvince(), center.getPhone(), center.getEmail(), center.getWebSite(), converter.toEntity(center.getUser()), center.getProducts());

        }
        return centerDTO;
    }
}
