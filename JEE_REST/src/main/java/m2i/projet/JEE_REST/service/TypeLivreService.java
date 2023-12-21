package m2i.projet.JEE_REST.service;

import java.util.List;

import m2i.projet.JEE_REST.dto.TypeLivreDTO;
import m2i.projet.JEE_REST.entity.TypeLivre;

public interface TypeLivreService {
	
	TypeLivreDTO save(TypeLivre typeLivre);
	TypeLivreDTO findById(Integer id);
	List<TypeLivre> findAll();
	void delete(Integer id);
}
