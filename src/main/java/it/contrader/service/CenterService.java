package it.contrader.service;

import it.contrader.converter.CenterConverter;
import it.contrader.dao.CenterDAO;
import it.contrader.dto.CenterDTO;
import it.contrader.model.Center;

import java.util.List;

/**
 * 
 * @author Vittorio
 *
 *Grazie all'ereditarietà mi basta specificare i tipi di questa classe per
 *ereditare i metodi della clase AbstractService. Pertanto la classe risulta meno complicata
 *da scrivere, facendoci risparmiare tempo e fatica!
 */
public class CenterService extends AbstractService<Center, CenterDTO> {

	//Istanzio DAO  e Converter specifici.
	public CenterService(){
		this.dao = new CenterDAO();
		this.converter = new CenterConverter();
	}

	@Override
	public boolean delete(int id) {
			CenterDAO centerdao = new CenterDAO();
			return centerdao.delete(id);
	}
	public List<CenterDTO> getAllMain(int id){
		CenterDAO centerdao = new CenterDAO();
		CenterConverter centerConverter = new CenterConverter();
		return centerConverter.toDTOList(centerdao.getAllMain(id));
	}

	public List<CenterDTO> getAllOfCenter(int id){
		CenterDAO centerdao = new CenterDAO();
		CenterConverter centerConverter = new CenterConverter();
		return centerConverter.toDTOList(centerdao.getAllAdmin(id));
	}

}
