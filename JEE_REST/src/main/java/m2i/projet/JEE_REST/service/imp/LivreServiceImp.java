package m2i.projet.JEE_REST.service.imp;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import m2i.projet.JEE_REST.dto.LivreDTO;
import m2i.projet.JEE_REST.entity.Livre;
import m2i.projet.JEE_REST.entity.TypeLivre;
import m2i.projet.JEE_REST.repository.LivreRepository;
import m2i.projet.JEE_REST.repository.TypeLivreRepository;
import m2i.projet.JEE_REST.service.LivreService;


@Service
public class LivreServiceImp implements LivreService {
	
	@Autowired
	LivreRepository livreRepository;
	
	@Autowired
	TypeLivreRepository typeLivreRepository;
	
	
	// Méthode utilisée par d'autres fonctions pour remplir un DTO à renvoyer
	public LivreDTO remplirDTO(Livre livre) {
		
		LivreDTO livreDTO = new LivreDTO();
		livreDTO.setAuteur(livre.getAuteur());
		livreDTO.setEditeur(livre.getEditeur());
		livreDTO.setTitreLivre(livre.getTitreLivre());
		livreDTO.setTypeLivre(livre.getTypeLivre().getIdType());
		return livreDTO;
	}
	
	
	@Override
	public LivreDTO save(Livre livre) {
		livre = livreRepository.save(livre);
		return remplirDTO(livre);
	}

	
	@Override
	public LivreDTO findByISBN(String ISBN) {
		Livre livre = livreRepository.getReferenceById(ISBN);
		return remplirDTO(livre);
	}

	
	@Override
	public List<LivreDTO> findAll(String filt_titre, String filt_auteur, String filt_editeur) {
		
		// Retrieve all books matching filtering criteria
		List<Livre> list =  livreRepository.getLivreFiltered("%" + filt_titre + "%",
															"%" + filt_auteur + "%",
															"%" + filt_editeur + "%");
		
		// Convert the list into a list 
		List<LivreDTO> listDTO = new ArrayList<LivreDTO>();
		for (Livre l : list) {
			listDTO.add(remplirDTO(l));
		}
		
		return listDTO;
	}

	
	@Override
	public void delete(String ISBN) {
		// Livre livre = livreRepository.getReferenceById(ISBN);
		livreRepository.deleteById(ISBN);
	}
	
	
	@Override
	public LivreDTO add(LivreDTO livreDTO) {

		Livre livre = new Livre();
		
		livre.setAuteur(livreDTO.getAuteur());
		livre.setEditeur(livreDTO.getEditeur());
		livre.setTitreLivre(livreDTO.getTitreLivre());
		
		Optional<TypeLivre> typeLivre = typeLivreRepository.findById(1);
		livre.setTypeLivre(typeLivre.get());
		
		// Marche pas
		// Optional<TypeLivre> typeLivre = typeLivreRepository.findById(livreDTO.getTypeLivre());
		// livre.setTypeLivre(typeLivre.get());
		
		/* TypeLivre typeLivre = typeLivreRepository.getReferenceById(livreDTO.getTypeLivre());
		livre.setTypeLivre(typeLivre); */
		
		return save(livre);
	}
	
	
	@Override
	public LivreDTO update(String ISBN, LivreDTO livreDTO) {
		
		Optional<Livre> livreOpt = livreRepository.findById(ISBN);
		// livre.setTypeLivre(typeLivre.get());
		
		// Livre livre = livreRepository.getReferenceById(ISBN);
		Livre livre = livreOpt.get();

		livre.setAuteur(livreDTO.getAuteur());
		livre.setEditeur(livreDTO.getEditeur());
		livre.setTitreLivre(livreDTO.getTitreLivre());

		// TypeLivre typeLivre = typeLivreRepository.getReferenceById(livreDTO.getTypeLivre());
		// livre.setTypeLivre(typeLivre);

		return save(livre);
	}
}
