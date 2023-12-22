package m2i.projet.JEE_REST.service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import m2i.projet.JEE_REST.dto.ExemplaireDTO;
import m2i.projet.JEE_REST.entity.Exemplaire;
import m2i.projet.JEE_REST.repository.ExemplaireRepository;
import m2i.projet.JEE_REST.service.ExemplaireService;

@Service
public class ExemplaireServiceImp implements ExemplaireService {
	@Autowired
	ExemplaireRepository exemplaireRepository;

	@Override
	public ExemplaireDTO save(Exemplaire exemplaire) {
		exemplaire = exemplaireRepository.save(exemplaire);
		ExemplaireDTO exemplaireDTO = new ExemplaireDTO();
		exemplaireDTO.setIsbnLivre(exemplaire.getIsbnLivre());
		exemplaireDTO.setIntegriteLivre(exemplaire.getIntegriteLivre());
		return exemplaireDTO;
	}

	@Override
	public ExemplaireDTO findById(Integer id) {
		Exemplaire exemplaire = exemplaireRepository.getReferenceById(id);
		ExemplaireDTO exemplaireDTO = new ExemplaireDTO();
		exemplaireDTO.setIsbnLivre(exemplaire.getIsbnLivre());
		exemplaireDTO.setIntegriteLivre(exemplaire.getIntegriteLivre());
		return exemplaireDTO;
	}

	@Override
	public List<Exemplaire> findAll() {	
		return exemplaireRepository.findAll();
	}

	@Override
	public void deleteById(Integer id) {
		exemplaireRepository.deleteById(id);

	}

	//Liste des exemplaires disponibles
	public List<Exemplaire> findExemplairesDisponibles(String isbn) {
		return exemplaireRepository.findExemplairesDisponibles(isbn);
	}

	//Liste des exemplaires indisponibles (entrée dans la table emprunt avec ou sans date de début)
	public List<Exemplaire> findExemplairesIndisponibles(String isbn) {
		return exemplaireRepository.findExemplairesIndisponibles(isbn);
	}	

	//Nombre total d'exemplaires pour un livre
	public int countByIsbnLivre(String isbn) {
		return exemplaireRepository.countByIsbnLivre(isbn);
	}

	//Nombre d'exemplaires disponibles pour un livre
	public int countExemplairesDisponibles(String isbn) {
		return exemplaireRepository.countExemplairesDisponibles(isbn);
	}

	//Nombre d'exemplaires indisponibles pour un livre
	public int countExemplairesIndisponibles(String isbn) {
		return exemplaireRepository.countExemplairesIndisponibles(isbn);
	}

	@Override
	public void updateExemplaire(ExemplaireDTO exemplaireDTO, Integer id) {
		Exemplaire exemplaireToUpdate = new Exemplaire();
		Optional<Exemplaire> exemplaireTampon = exemplaireRepository.findById(id);
		if (exemplaireTampon.isPresent()) {
			exemplaireToUpdate = exemplaireTampon.get();
			exemplaireToUpdate.setIsbnLivre(exemplaireDTO.getIsbnLivre());;
			exemplaireToUpdate.setIntegriteLivre(exemplaireDTO.getIntegriteLivre());
			// mise a jour de l'utilisateur
			exemplaireRepository.save(exemplaireToUpdate);
		} else {
			return;
		}

	}

}
