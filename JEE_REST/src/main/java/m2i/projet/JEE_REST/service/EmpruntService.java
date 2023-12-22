package m2i.projet.JEE_REST.service;

import java.util.List;
import m2i.projet.JEE_REST.dto.EmpruntDTO;
import m2i.projet.JEE_REST.dto.EmpruntDateDTO;
import m2i.projet.JEE_REST.entity.Emprunt;

public interface EmpruntService {
	EmpruntDTO save(Emprunt emprunt);
	EmpruntDTO findById(Integer id);
	List<Emprunt> findAllWithFilter(String filter);
	void delete(Integer id);
	public void updateEmprunt(Integer empruntId ,EmpruntDateDTO date);
	public void validateEmprunt(Integer empruntId);
}
