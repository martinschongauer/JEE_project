package m2i.projet.JEE_REST.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import m2i.projet.JEE_REST.dto.TypeLivreDTO;
import m2i.projet.JEE_REST.entity.TypeLivre;
import m2i.projet.JEE_REST.repository.TypeLivreRepository;
import m2i.projet.JEE_REST.service.TypeLivreService;

public class TypeLivreServiceImp implements TypeLivreService {
	@Autowired
	TypeLivreRepository typeLivreRepository;
	
	@Override
	public TypeLivreDTO save(TypeLivre typeLivre) {
		typeLivre = typeLivreRepository.save(typeLivre);
		TypeLivreDTO typeLivreDTO = new TypeLivreDTO();
		typeLivreDTO.setNomType(typeLivre.getNomType());
		return typeLivreDTO;
	}

	@Override
	public TypeLivreDTO findById(Integer id) {
		TypeLivre typeLivre = typeLivreRepository.getReferenceById(id);
		TypeLivreDTO typeLivreDTO = new TypeLivreDTO();
		typeLivreDTO.setNomType(typeLivre.getNomType());
		return typeLivreDTO;
	}

	@Override
	public List<TypeLivre> findAll() {
		return typeLivreRepository.findAll();
	}

	@Override
	public void delete(Integer id) {
		typeLivreRepository.deleteById(id);	
	}
}
