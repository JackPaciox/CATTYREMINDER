package it.contrader.converter;

import it.contrader.dto.CenterDTO;
import it.contrader.model.Center;

import java.util.ArrayList;
import java.util.List;

public class CenterConverter implements Converter<Center,CenterDTO>{
    public CenterDTO toDTO(Center center) {
    CenterDTO centerDTO = new CenterDTO(center.getId(), center.getUser_id(), center.getCentername(), center.getCenteraddress(), center.getCentercity(), center.getCenterprovince());
    return centerDTO;
}

    /**
     * Crea un oggetto di tipo User e lo riempie con i campi del parametro user di tipo UserDTO.
     * Notare l'uso del metodo get() per ottenere il valore dell'attributo-
     */
    public Center toEntity(CenterDTO centerDTO) {
        Center center = new Center(centerDTO.getId(), centerDTO.getUser_id() , centerDTO.getCentername(), centerDTO.getCenteraddress(), centerDTO.getCentercity(), centerDTO.getCenterprovince());
        return center;
    }

    /**
     * Metodo per convertire le liste di Center.
     */
    public List<CenterDTO> toDTOList(List<Center> centerList) {
        //Crea una lista vuota.
        List<CenterDTO> centerDTOList = new ArrayList<CenterDTO>();

        //Cicla tutti gli elementi della lista e li converte uno a uno
        for(Center center : centerList) {
            //Utilizza il metodo toDTO per convertire ogni singolo elemento della lista
            //e lo aggiunge adda lista di DTO
            centerDTOList.add(toDTO(center));
        }
        return centerDTOList;
    }



}

