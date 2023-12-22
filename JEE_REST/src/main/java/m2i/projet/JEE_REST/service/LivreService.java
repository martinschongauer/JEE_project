package m2i.projet.JEE_REST.service;

import java.util.List;

import m2i.projet.JEE_REST.dto.LivreDTO;
import m2i.projet.JEE_REST.entity.Livre;


public interface LivreService {

	LivreDTO remplirDTO(Livre livre);
	LivreDTO save(Livre livre);
	LivreDTO findByISBN(String ISBN);
	List<LivreDTO> findAll(String filt_titre, String filt_auteur, String filt_editeur);
	void delete(String ISBN);
	LivreDTO add(LivreDTO livre);
	LivreDTO update(String ISBN, LivreDTO livreDTO);
}
